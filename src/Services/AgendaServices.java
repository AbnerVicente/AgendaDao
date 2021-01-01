/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Dao.AgendaDao;
import Dao.ConexionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AgendaServices {
    Date fecha;
    int idDescripcion;
    String descripcion;
     String ingreso;
    
 public AgendaServices(){
        
    }
   public void GuardarAgenda(String descripcion,String ingreso){
        Agenda registro = new Agenda();
        registro.setDescripcion(descripcion);
        registro.setIngreso(ingreso);
        //mandamos el registro para ser guardado
       AgendaDao.crearMensajeBD(registro);
    }
   public static void ListarRegistros(){
       AgendaDao.getDataAgenda();
   }
  
   public static void ActualizarRegistros(int id, String descripcion,String ingreso, String fecha){
      Agenda actualizar = new Agenda();
      actualizar.setId(id);
      actualizar.setDescripcion(descripcion);
      actualizar.setIngreso(ingreso);
      actualizar.setFecha(fecha);
      AgendaDao.ActualizarBd(actualizar);
   }
   public  static void ElimiarRegistro(int id){
       AgendaDao.EliminarRegistro(id);
   }
  

   
}
