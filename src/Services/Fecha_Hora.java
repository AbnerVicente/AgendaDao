/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Fecha_Hora {

     Date objDate = new Date();
     String fecha;
      // El formato de fecha está especificado 
     String strDateFormat = "  dd-MMM hh: mm  aaaa";   
    
     // La cadena de formato de fecha se pasa como un argumento al objeto de formato de fecha  
     
 public void mostrarHora(String formato){
      Date objDate = new Date();
     SimpleDateFormat objSDF = new SimpleDateFormat(formato);
        //este sera el resultado de la fechas
       fecha=objSDF.format(objDate);
 }

       public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
}
