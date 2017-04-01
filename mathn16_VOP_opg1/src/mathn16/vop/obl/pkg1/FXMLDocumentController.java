/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathn16.vop.obl.pkg1;

import ancient_encryption.CipherInterface;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import rock_scissors_paper.RockScissorsPaper;

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
    private Label computerMoveLabel;

    @FXML
    private Label winnerLabel;
    
    @FXML
    private Button stoneBtn;

    @FXML
    private Button scissorsBtn;

    @FXML
    private Button paperBtn;

    @FXML
    private ImageView playerPic;

    @FXML
    private ImageView computerPic;
    
    private RockScissorsPaper rSP;
    
    private Map<String, Image> picMap = new HashMap<>();

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
        rSP = new RockScissorsPaper();
        picMap.put(rSP.HANDS[0],  new Image(new File("Rock.png").toURI().toString()));
        picMap.put(rSP.HANDS[1],  new Image(new File("Scissors.png").toURI().toString())); 
        picMap.put(rSP.HANDS[2],  new Image(new File("Paper.png").toURI().toString()));
    }
    
    @FXML
    void actionHandler(ActionEvent event) {
        for(int i = 0; i < rSP.HANDS.length; i++){
            if(event.getSource().equals(stoneBtn)){
                rSP.play(rSP.HANDS[0]);
                computerPic.setImage((Image)picMap.get(rSP.getComputer()));
                playerPic.setImage((Image)picMap.get(rSP.getPlayer())); 
            }else if(event.getSource().equals(scissorsBtn)){
                rSP.play(rSP.HANDS[1]);
                computerPic.setImage((Image)picMap.get(rSP.getComputer())); 
                playerPic.setImage((Image)picMap.get(rSP.getPlayer())); 
            }else if(event.getSource().equals(paperBtn)){
                rSP.play(rSP.HANDS[2]);
                computerPic.setImage((Image)picMap.get(rSP.getComputer())); 
                playerPic.setImage((Image)picMap.get(rSP.getPlayer())); 
            }
        }computerMoveLabel.setText("Computer: " + rSP.getComputer());
        winnerLabel.setText(rSP.getWinner());
    }
}
