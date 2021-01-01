/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Services.Agenda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ConexionBd {
   public static String mensaje;
    Connection conn = null;
   //creamos un objeto llamado Conextion
    public  Connection get_connection(){
        //definimos un objetio de tipo conection
        Connection conection = null;
        try{
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agendaapp","root","");
            if(conection != null){
             mensaje=" Conexión exitosa con la base de datos"+
                     "\n Puede guardar sus registros";
            }
        }catch(SQLException e){
            mensaje = e +""
                    + "\n Error de conexión a la base de datos";
           // System.out.println(mensaje);
        }
        return conection;
    }
    
    public static Connection ConnectDb(){
       try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agendaapp", "root","");
           JOptionPane.showMessageDialog(null, "Connection establecida" );
          return conn;
       }catch(Exception e){
           return null;
       }
    }
    
 
   
}
