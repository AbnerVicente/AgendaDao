/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import Services.Agenda;
import Services.Prueba;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Aguilar
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try{
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = loader.load(getClass().getResourceAsStream("/Form/FormAgenda.fxml"));
            
            Scene scene = new Scene(root);
           // primaryStage.heightProperty();
            primaryStage.setTitle("Aplicación de Agenda");
            primaryStage.setScene(scene);
            primaryStage.show();
            
            
            
            
        }catch(IOException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null, ex);
        }
        
    }
    /*
public ObservableList<Agenda>getAgenda(){
    ObservableList<Agenda> Agenda= FXCollections.observableArrayList();
    Agenda.add(new Agenda(1,"25/12/20","hola","500"));
    return Agenda;
}
public ObservableList<Prueba>getPrueba(){
    ObservableList<Prueba> Prueba= FXCollections.observableArrayList();
    Prueba.add(new Prueba(1,"Laptop"));
    return Prueba;
}*/
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      launch(args);
     
    }
    
}
