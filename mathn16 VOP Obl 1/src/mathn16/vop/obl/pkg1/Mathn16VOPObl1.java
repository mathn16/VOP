/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathn16.vop.obl.pkg1;

import ancient_encryption.CipherInterface;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Thisen
 */
public class Mathn16VOPObl1 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        

    }
    public String atbashEncryptMode(String message){
        AtbashCipher cipher = new AtbashCipher();
        String enc = cipher.encrypt(message);
        return enc;
    }
    public String ceasarEncryptMode(int n, String message){
        CeasarCipher cipher = new CeasarCipher(n);
        String enc = cipher.encrypt(message);
        return enc;
    }
    
}
