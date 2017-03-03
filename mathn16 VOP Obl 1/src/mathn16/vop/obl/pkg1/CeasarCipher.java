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
        if(_rotFactor >= 0 || _rotFactor < CipherInterface.ALPHABETH.length){
            this.rotFactor = _rotFactor;
            //System.out.println("rot" + rotFactor);
        }
    }

    @Override
    public String encrypt(String original) {
        String encryptedMessage = "";
        for(int i = 0; i < original.length(); i++){
            int j = findCharIndex(original.charAt(i));
            //System.out.println(j);          
            if(j >= 0 && j + rotFactor < CipherInterface.ALPHABETH.length){
                encryptedMessage += CipherInterface.ALPHABETH[j + rotFactor];
            }else if(j >= 0 && j + rotFactor > CipherInterface.ALPHABETH.length) {
                encryptedMessage += CipherInterface.ALPHABETH[j+rotFactor - CipherInterface.ALPHABETH.length];
            }else if(j == -1){
                encryptedMessage += original.charAt(i);
            }
        }return encryptedMessage;
    }

    @Override
    public String decrypt(String encrypted) {
        String decryptedMessage = "";
        for(int i = 0; i < encrypted.length(); i++){
            int j = findCharIndex(encrypted.charAt(i));
            if(j >= 0 && j - rotFactor >= 0){
                decryptedMessage += CipherInterface.ALPHABETH[j - rotFactor];
            }else if(j >= 0 && j - rotFactor < 0) {
                decryptedMessage += CipherInterface.ALPHABETH[j-rotFactor + CipherInterface.ALPHABETH.length];
            }else if(j == -1){
                decryptedMessage += encrypted.charAt(i);
            }
        }return decryptedMessage;

        
    }
    
}
