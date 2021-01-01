/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaapp;

import Dao.ConexionBd;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AgendaController implements Initializable {
@FXML DatePicker fecha;
@FXML TextField hora;
@FXML TextField descripcion;
@FXML TextField ingreso;
@FXML Label labelError;
@FXML Button btnAgregar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void Agregar(ActionEvent evtd){
       labelError.setText("hola");
    
        System.out.println(fecha.getEditor().textProperty());
        System.out.println(hora.getText().trim());
        System.out.println(descripcion.getText().trim());
        System.out.println(ingreso.getText().trim());
    }
    @FXML
    void Modificar(ActionEvent evt){
          ConexionBd bd_conexion = new ConexionBd();
       

            try(Connection conexion = bd_conexion.get_connection()){
        
             PreparedStatement ps = null;
                 labelError.setText(bd_conexion.mensaje); 
          
          
           
        }
        catch(SQLException e){
            System.out.println(e);
            
        labelError.setText("Error");
        }
    }
}
