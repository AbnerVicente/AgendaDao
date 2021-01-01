/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;
import java.net.URL;
import Dao.AgendaDao;
import Dao.ConexionBd;
import Services.Agenda;
import Services.AgendaServices;
import Services.Fecha_Hora;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
/**
 * FXML Controller class
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */



public class FormAgendaController implements Initializable {
    @FXML
    private AnchorPane Anchorpane;
    @FXML
    private TextField textId;

    @FXML
    private TextField textFecha;

    @FXML
    private TextArea textDescripcion;

    @FXML
    private TextField textIngreso;
    @FXML
    private Label labelMensaje;

    @FXML
    private Button Agregar;

        @FXML
    private TableView<Agenda> tabla;

    @FXML
    private TableColumn<Agenda, Integer> colId;

    @FXML
    private TableColumn<Agenda, String> colDescripcion;

    @FXML
    private TableColumn<Agenda, String> colIngreso;

    @FXML
    private TableColumn<Agenda, String> colFecha;

    /**
     * Initializes the controller class.
     */
     ObservableList<Agenda> listM;
     // VARIABLES
       int index = -1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ConexionBd bd_conexion = new ConexionBd();
      try(Connection conexion = bd_conexion.get_connection()){
         //mostramos el mensaje de conexion exitosa
          labelMensaje.setText(bd_conexion.mensaje);
      }catch(SQLException e){
            System.out.println(e);
           //mostramos el mensaje de error 
        labelMensaje.setText(bd_conexion.mensaje);
        }
      // iniciamos las propiedades de la tabla      
      colId.setCellValueFactory(new PropertyValueFactory<Agenda,Integer>("Id"));
      colDescripcion.setCellValueFactory(new PropertyValueFactory<Agenda,String>("Descripcion"));
      colIngreso.setCellValueFactory(new PropertyValueFactory<Agenda,String>("Ingreso"));
     colFecha.setCellValueFactory(new PropertyValueFactory<Agenda,String>("Fecha"));
    listM = AgendaDao.getDataAgenda();
     tabla.setItems(listM);
    }    
     @FXML
    void Agregar(ActionEvent evt){
        
        AgendaServices registro = new AgendaServices();
         
         //Le enviamos los datos de la descripcion y el ingreso
        registro.GuardarAgenda(textDescripcion.getText().trim(), textIngreso.getText().trim());
        labelMensaje.setText(AgendaDao.respuesta);
        Actualizar();
        NuevoRegistro();
      
    }
    
Fecha_Hora fecha = new Fecha_Hora();

     @FXML
  void Nuevo(ActionEvent evt){
     NuevoRegistro();
     textId.setText((AgendaDao.id+1)+"");
     
     //textDescripcion.setCursor(Cursor.WAIT);
     textDescripcion.requestFocus();
     //                 hh: mm: ss a dd-MMM-aaaa
     String formato="dd-MMM hh: mm ss  aaaa";
     fecha.mostrarHora(formato);
    textFecha.setText(fecha.getFecha());
    labelMensaje.setText("");
  }
  void NuevoRegistro(){
      
      textId.clear();
      textDescripcion.clear();
      textIngreso.clear();
      textFecha.clear();
      labelMensaje.setText("");
      
      Actualizar();
  }
      Connection conn =null;
      Connection rs = null;
   PreparedStatement pst = null;
   @FXML
  void Editar(ActionEvent evt){
      ConexionBd conexion = new ConexionBd();
      PreparedStatement ps = null;
      String value1 = textId.getText();
      String value2 = textDescripcion.getText();
      String value3 = textIngreso.getText();
      String value4 = textFecha.getText();
     
       /* Agenda actualizar = new Agenda();
        actualizar.setId(Integer.parseInt(value1));
        actualizar.setDescripcion(value2);*/
        AgendaServices actualizar = new AgendaServices();
        actualizar.ActualizarRegistros(Integer.parseInt(value1), value2, value3,value4);
      labelMensaje.setText(AgendaDao.respuesta) ;
      Actualizar();
      NuevoRegistro();
              
      
  
     //String sql="UPDATE table_agenda SET id= '"+value1+"',descripcion= '"+value2+"',ingreso='"+value3+"',fecha_Ingreso='"+value4+"' where id ='"+value1+"' ";
   //  pst = conn.prepareStatement(sql);
      
      
  }

   @FXML
    void getSelected(MouseEvent event){
        index = tabla.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            return;
        }
        textId.setText(colId.getCellData(index).toString());
       textFecha.setText(colFecha.getCellData(index));
        textDescripcion.setText(colDescripcion.getCellData(index).toString());
        textIngreso.setText(colIngreso.getCellData(index).toString());
        labelMensaje.setText("");
    }
 public void Actualizar(){
       AgendaDao.getDataAgenda();
         listM = AgendaDao.getDataAgenda();
     tabla.setItems(listM);
     labelMensaje.setText(AgendaDao.respuesta);
  }
 @FXML
  void Eliminar(){
   int id = Integer.parseInt(textId.getText());
   AgendaServices.ElimiarRegistro(id);

   labelMensaje.setText(AgendaDao.respuesta);
 
   Actualizar();
   NuevoRegistro();
   
 }
}
