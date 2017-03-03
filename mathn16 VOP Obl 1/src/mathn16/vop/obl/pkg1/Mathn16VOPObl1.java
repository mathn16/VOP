/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathn16.vop.obl.pkg1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Mathias
 */
public class Mathn16VOPObl1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        RadioButton rdbAtbash = new RadioButton();
        RadioButton rdbCeasar = new RadioButton();
        Label lblAtbash = new Label("Atbash");
        Label lblCeasar = new Label("Ceasar");
        Label lblwrittenMessage = new Label("Write your message for encryption here:");
        TextField writtenMessage = new TextField();
        
        rdbCeasar.setLayoutX(40);
        rdbCeasar.setLayoutY(100);
        rdbAtbash.setLayoutX(300);
        rdbAtbash.setLayoutY(100);
        
        lblwrittenMessage.setLayoutX(40);
        lblwrittenMessage.setLayoutY(10);
        lblAtbash.setLayoutX(60);
        lblAtbash.setLayoutY(100);
        lblCeasar.setLayoutX(320);
        lblCeasar.setLayoutY(100);
        
        writtenMessage.setPrefSize(400, 30);
        writtenMessage.setLayoutX(40);
        writtenMessage.setLayoutY(30);
                
        TabPane tabPane = new TabPane();
        AnchorPane root = new AnchorPane();
        root.prefWidth(640);
        root.prefHeight(400);
        root.getChildren().addAll(tabPane, rdbAtbash, rdbCeasar, lblAtbash, lblCeasar, writtenMessage, lblwrittenMessage);
        
        Scene scene = new Scene(root, 640, 400);
        
        primaryStage.setTitle("Cipher GUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
