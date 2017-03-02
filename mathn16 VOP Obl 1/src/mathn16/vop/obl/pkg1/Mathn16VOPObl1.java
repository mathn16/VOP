/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathn16.vop.obl.pkg1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Mathias
 */
public class Mathn16VOPObl1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        TabPane tabPane = new TabPane();
        AnchorPane root = new AnchorPane();
        root.prefWidth(640);
        root.prefHeight(400);
        root.getChildren().add(tabPane);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {
        launch(args);
    }
    */
}
