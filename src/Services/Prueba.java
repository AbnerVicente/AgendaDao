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
public class Prueba {
     int id;
    String producto;
Prueba(){
}
   
    
 public   Prueba(int id, String producto){
      this.id = id;
      this.producto = producto;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
    
}
