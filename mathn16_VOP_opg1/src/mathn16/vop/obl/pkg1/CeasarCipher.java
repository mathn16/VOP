/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathn16.vop.obl.pkg1;

import ancient_encryption.CipherInterface;

/**
 *
 * @author Thisen
 */
public class CeasarCipher extends AbstractCipher{
    
    int rotFactor;
    
    public CeasarCipher(int _rotFactor){
        if(_rotFactor >= 0 || _rotFactor < ALPHABETH.length){
            this.rotFactor = _rotFactor;
        }
    }

    @Override
    public String encrypt(String original) {
        String encryptedMessage = "";
        for(int i = 0; i < original.length(); i++){
            int index = findCharIndex(original.charAt(i));
            if(index >= 0 && index + rotFactor < ALPHABETH.length){
                encryptedMessage += ALPHABETH[index + rotFactor];
            }else if(index >= 0 && index + rotFactor > ALPHABETH.length) {
                encryptedMessage += ALPHABETH[index+rotFactor - ALPHABETH.length];
            }else if(index == -1){
                encryptedMessage += original.charAt(i);
            }
        }return encryptedMessage;
    }

    @Override
    public String decrypt(String encrypted) {
        String decryptedMessage = "";
        for(int i = 0; i < encrypted.length(); i++){
            int index = findCharIndex(encrypted.charAt(i));
            if(index >= 0 && index - rotFactor >= 0){
                decryptedMessage += ALPHABETH[index - rotFactor];
            }else if(index >= 0 && index - rotFactor < 0) {
                decryptedMessage += ALPHABETH[index-rotFactor + ALPHABETH.length];
            }else if(index == -1){
                decryptedMessage += encrypted.charAt(i);
            }
        }return decryptedMessage;
    }
}
