/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj3;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author rafiu
 */
public class MovieFX extends Application{
    

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MovieFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Movie List");
        stage.setScene(scene);
        stage.show();
       
    }
    
    
    public static void main (String[] args){
        launch(args);
        
    }
    
}
