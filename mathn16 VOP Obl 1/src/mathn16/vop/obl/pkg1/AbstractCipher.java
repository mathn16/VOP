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
public abstract class AbstractCipher implements CipherInterface {
    
    
    protected int findCharIndex(char ch){
        int chIndex = -1;
        for(int i = 0; i < ALPHABETH.length; i++){
            if(ch == ALPHABETH[i]){
                chIndex = i;
            }
        }return chIndex;
    }
    
}
