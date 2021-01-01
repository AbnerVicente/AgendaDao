/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Agenda {
    int id;
    String descripcion;
   String ingreso;
  String fecha;
   public Agenda(){
        
    }

    public Agenda(int id, String descripcion, String ingreso, String fecha) {
        this.id = id;
        this.descripcion = descripcion;
        this.ingreso = ingreso;
        this.fecha = fecha;
    }

    public  int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public  String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public  String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
   
}
