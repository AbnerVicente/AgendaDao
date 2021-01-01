/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

    //import static Dao.ConexionBd.get_connection;
import Form.AgendaController;
import Services.Agenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AgendaDao {
    AgendaDao(){
    
}
    public static int id;
    public  static String respuesta;
 public static void crearMensajeBD(Agenda mensaje){
     
        ConexionBd db_connect = new ConexionBd();
        
        try(Connection conexion = db_connect.get_connection()){
             PreparedStatement ps = null;
        
            try{
              // String query= "INSERT INTO table_agenda(id, descripcion, ingreso, fecha_Ingreso) VALUES (?,?,?,?)";
                String query = "INSERT INTO table_agenda (descripcion,ingreso) VALUES(?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getDescripcion());
                ps.setString(2, mensaje.getIngreso());
                ps.executeUpdate(); //ejecutando
                    //System.out.println();
                   // System.out.println("mensaje creado!");
                
                  
                   respuesta="registro creado! ";
                  
            }
                catch(SQLException ex){
                    System.out.println(ex);
                    respuesta="Error no se guardo el registro";
                }
        
        }
        catch(SQLException e){
            System.out.println(e);}
    }
 public static void listarAgenda(){
     ConexionBd conexion = new ConexionBd();
//para preparar la sentencia
PreparedStatement ps = null;
//para traer los datos en filas y poderlos procesar vamos a crear Resulset
ResultSet rs = null;

try(Connection conex = conexion.get_connection()){
String query ="SELECT * FROM table_agenda"; 
ps = conex.prepareStatement(query);
rs = ps.executeQuery();
Agenda agenda = new Agenda();
    //vamos a leer los datos
    //el while significa que se repitira mientras tenga datos
    while(rs.next()){
        System.out.println("ID: "+rs.getInt("id"));
       
       agenda.setId(rs.getInt("id"));
        System.out.println("id----: "+agenda.getId());
        System.out.println("DESCRIPCION: "+rs.getString("descripcion"));
       agenda.setDescripcion(rs.getString("descripcion"));
        System.out.println("INGRESO: "+rs.getString("ingreso"));
        agenda.setFecha(rs.getString("ingreso"));
        System.out.println("FECHA: "+rs.getString("fecha_Ingreso"));
        agenda.setFecha("fecha_Ingreso");
    }
}catch(SQLException e){
    System.out.println("Mensaje no recuperado"); 
    System.out.println(e);
        }
 }
    
 public static ObservableList<Agenda>  getDataAgenda(){
  ResultSet rs = null;
   // Connection conn = get_connection();
    ConexionBd conn = new ConexionBd();
  // Connection conn = ConnectDb();
  PreparedStatement ps = null;
    ObservableList <Agenda> list = FXCollections.observableArrayList();
try(Connection conexion = conn.get_connection()){
    String query="SELECT * FROM table_agenda";
   ps = conexion.prepareStatement(query);
    rs = ps.executeQuery();
    while(rs.next()){
        list.add(new Agenda(Integer.parseInt(rs.getString("id")),rs.getString("descripcion"),rs.getString("ingreso"),rs.getString("fecha_Ingreso") ));
        id = Integer.parseInt(rs.getString("id"));
    }
}   catch(Exception e){
    
} 
    
    
    
    return list;
}
 
 public static void ActualizarBd(Agenda actualizar){
     
      ConexionBd db_connect = new ConexionBd();
      try(Connection conexion = db_connect.get_connection()){
           PreparedStatement ps = null;
           try{
               String query= "UPDATE table_agenda SET descripcion = ?, ingreso=? Where id = ? ";
               ps = conexion.prepareStatement(query);
               ps.setString(1, actualizar.getDescripcion());
               ps.setString(2, actualizar.getIngreso());
               ps.setInt(3, actualizar.getId());
               
               ps.executeUpdate();
               respuesta="Registro Acualizado correctamente";
           }catch(SQLException e){
               respuesta="No se guardaron los cambios";
               System.out.println(e);
           }
      }catch(SQLException e){
          System.out.println(e);
      }
 }
 public static void EliminarRegistro(int id){
      ConexionBd db_connect = new ConexionBd();
        
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            try{
                String query= "DELETE FROM table_agenda WHERE id = ?";
                ps=conexion.prepareStatement(query);
                ps.setInt(1, id);
                ps.executeUpdate();
                respuesta="El Mensaje ha sido borrado";
                
            }catch(SQLException ex){
                System.out.println(ex);
                respuesta= "No se pudo borrar el mensaje";
            }
        }catch(SQLException e){
            System.out.println(e);
        }
 }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        AgendaDao.id = id;
    }
   
}
