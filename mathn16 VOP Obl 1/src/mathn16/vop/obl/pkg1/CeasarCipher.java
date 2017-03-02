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
        }
    }

    @Override
    public String encrypt(String original) {
        String encryptedMessage = "";
        for(int i = 0; i < original.length()-1; i++){
            int j = findCharIndex(original.charAt(i));            
            if(j > 0 && j + rotFactor < CipherInterface.ALPHABETH.length-1){    //Prøv uden check om de bliver mindre end
                encryptedMessage += CipherInterface.ALPHABETH[j + rotFactor];
            }else if(j > 0 && j + rotFactor > CipherInterface.ALPHABETH.length-1) {
                encryptedMessage += CipherInterface.ALPHABETH[j+rotFactor - CipherInterface.ALPHABETH.length-1];
            }
        }return encryptedMessage;
    }

    @Override
    public String decrypt(String encrypted) {
        String decryptedMessage = "";
        for(int i = 0; i < encrypted.length()-1; i++){
            int j = findCharIndex(encrypted.charAt(i));            
            if(j > 0 && j - rotFactor > CipherInterface.ALPHABETH.length-1){    //prøv uden første check om den er større end
                decryptedMessage += CipherInterface.ALPHABETH[j - rotFactor];
            }else if(j > 0 && j - rotFactor < 0) {
                decryptedMessage += CipherInterface.ALPHABETH[j-rotFactor + CipherInterface.ALPHABETH.length-1];
            }
        }return decryptedMessage;

        
    }
    
}