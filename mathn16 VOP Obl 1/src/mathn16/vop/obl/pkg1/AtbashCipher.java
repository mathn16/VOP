/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathn16.vop.obl.pkg1;

import ancient_encryption.CipherInterface;

/**
 *
 * @author Mathias
 */
public class AtbashCipher extends AbstractCipher {
    
    
    @Override
    public String encrypt(String original) {
        String encryptedMessage = "";
        for(int i = 0; i < original.length(); i++){                         //Iterere hver char i strengen
            int j = findCharIndex(original.charAt(i));                      //Tager char ved det aktuelle index.
            if(j > ALPHABETH.length/2){
                int l = 0;
                for(int k = ALPHABETH.length/2; k < j; k++){
                    l++;
                }
                encryptedMessage += ALPHABETH[ALPHABETH.length/2-l -1];
            }else if(j >= 0 && j <= ALPHABETH.length/2){
                encryptedMessage += ALPHABETH[ALPHABETH.length - j -1];
            }else{
                encryptedMessage += original.charAt(i);
            }
        }return encryptedMessage;
    }

    @Override
    public String decrypt(String encrypted) {                               //Kører her bare samme metode som encrypt
        String decryptedMessage = encrypt(encrypted);                       //da det er det samme der skal gøres.
        
        return decryptedMessage;
    }
    
}
