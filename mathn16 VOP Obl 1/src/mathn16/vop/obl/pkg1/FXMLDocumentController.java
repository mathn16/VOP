/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathn16.vop.obl.pkg1;

import ancient_encryption.CipherInterface;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Thisen
 */
public class FXMLDocumentController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private Label messageFieldLabel;

    @FXML
    private TextField messageField;

    @FXML
    private RadioButton atbashBtn;

    @FXML
    private ToggleGroup encryptionButtons;

    @FXML
    private RadioButton ceasarBtn;

    @FXML
    private Spinner<Integer> ceasarSpinner;

    @FXML
    private Button encryptButton;

    @FXML
    private Button decryptButton;

    @FXML
    private TextField encryptedField;

    @FXML
    private TextField decryptedField;

    @FXML
    void decryptMessage(ActionEvent event) {
        if(ceasarBtn.isSelected()){
            CeasarCipher cipher = new CeasarCipher((int)ceasarSpinner.getValueFactory().getValue());
            decryptedField.setText(cipher.decrypt(cipher.encrypt(messageField.getText())));
        }else if(atbashBtn.isSelected()){
            AtbashCipher cipher = new AtbashCipher();
            decryptedField.setText(cipher.decrypt(cipher.encrypt(messageField.getText())));
        }
    }

    @FXML
    void encryptMessage(ActionEvent event) {
        if(atbashBtn.isSelected()){
            AtbashCipher cipher = new AtbashCipher();
            encryptedField.setText(cipher.encrypt(messageField.getText()));
        }else if(ceasarBtn.isSelected()){
            CeasarCipher cipher = new CeasarCipher((int)ceasarSpinner.getValueFactory().getValue());
            encryptedField.setText(cipher.encrypt(messageField.getText()));
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        encryptedField.setEditable(false);
        decryptedField.setEditable(false);
        ceasarSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, CipherInterface.ALPHABETH.length - 1, CipherInterface.ALPHABETH.length / 2));
    }
}
