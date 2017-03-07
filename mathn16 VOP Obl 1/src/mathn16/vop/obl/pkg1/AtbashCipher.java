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
            int index = findCharIndex(original.charAt(i));                      //Tager char ved det aktuelle index.
            if(index >= 0){
                encryptedMessage += ALPHABETH[ALPHABETH.length-index-1];
            }else{
                encryptedMessage += original.charAt(i);
            }
        }return encryptedMessage;
    }

    @Override
    public String decrypt(String encrypted) {
        return encrypt(encrypted);
    }
}
