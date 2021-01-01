/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;
/*
import Dao.AgendaDao;
import Dao.ConexionBd;
import Services.Agenda;
import Services.AgendaServices;
import Services.Fecha_Hora;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;*/


import Dao.AgendaDao;
import Services.Fecha_Hora;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import Dao.ConexionBd;

import Services.Agenda;
import Services.AgendaServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javax.swing.table.DefaultTableModel;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AgendaController implements Initializable {
    

public AgendaController(){
    
}

@FXML TextArea textDescripcion;
@FXML TextField textIngreso;
@FXML TextField textId;
@FXML Label labelFecha;
@FXML Label labelMensaje;


    

    @FXML private TableView<Agenda> tabla;

    @FXML private TableColumn<Agenda, Integer>id;

    @FXML  private TableColumn<Agenda, String> rDescripcion;

    @FXML private TableColumn<Agenda, String> rIngreso;

    @FXML private TableColumn<Agenda, String> rFecha;
       
       
    
   Fecha_Hora date = new Fecha_Hora();
   int index = -1;
   Connection rs = null;
   PreparedStatement pst = null;
   ObservableList<Agenda> listM;
   /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     //mostrando fecha
     labelFecha.setText(date.getFecha()+"");
     
//Comprobamos la conexion con la base de datos 
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
      id.setCellValueFactory(new PropertyValueFactory<Agenda,Integer>("Id"));
      rDescripcion.setCellValueFactory(new PropertyValueFactory<Agenda,String>("Descripcion"));
      rIngreso.setCellValueFactory(new PropertyValueFactory<Agenda,String>("Ingreso"));
     rFecha.setCellValueFactory(new PropertyValueFactory<Agenda,String>("Fecha"));
    listM = AgendaDao.getDataAgenda();
     tabla.setItems(listM);
   
     
   
    }  
    
    @FXML
    void Agregar(ActionEvent evt){
        
        AgendaServices registro = new AgendaServices();
        //Le enviamos los datos de la descripcion y el ingreso
        registro.GuardarAgenda(textDescripcion.getText().trim(), textIngreso.getText().trim());
        labelMensaje.setText(AgendaDao.respuesta);
      AgendaServices.ListarRegistros();
    }
  
  @FXML
  void Nuevo(ActionEvent evt){
      textId.clear();
      textDescripcion.clear();
      textIngreso.clear();
      labelMensaje.setText("");
      
           
      //descripcion.caretPositionProperty();
      
  }
       @FXML
  void Mostrar(ActionEvent evt){
      AgendaServices.ListarRegistros();
     // ListarRegistros();
}
   /* @FXML
    void getSelected(MouseEvent event){
        index = tabla.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            return;
        }
        textId.setText(id.getCellData(index).toString());
       // labelFecha.setText(rFecha.getCellData(index));
        textDescripcion.setText(rDescripcion.getCellData(index).toString());
       // textIngreso.setText(rIngreso.getCellData(index).toString());
    }
     @FXML
    void getSelected (MouseEvent event){
    index = tabla.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
    
   // textId.setText(value);
   // textId.setText(id.getCellData(index).toString());
   // textDescripcion.setText(rDescripcion.getCellData(index).toString());
    //textIngreso.setText(rIngreso.getCellData(index).toString());
    //labelFecha.setText(rFecha.getCellData(index).toString());
   // txt_type.setText(col_type.getCellData(index).toString());
    
    }*/
  }

