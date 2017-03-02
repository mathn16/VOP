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
        int k = 0;
        String encrypted = "";
        for(int i = 0; i<original.length()-1; i++){                         //Itererer hver char i stringen
            for(int j = 0; j<CipherInterface.ALPHABETH.length-1; j++){      //Itererer alfabetet
                if(original.charAt(i) == CipherInterface.ALPHABETH[j]){     //Hvis char i string er lig med char i alfabet
                    if(j < CipherInterface.ALPHABETH.length/2){             //Hvis alfabetet er i første halvdel
                        k += CipherInterface.ALPHABETH.length - j;
                    }else if(j > CipherInterface.ALPHABETH.length/2){
                        k += j - CipherInterface.ALPHABETH.length;
                    }
                }else if(original.charAt(i) != CipherInterface.ALPHABETH[j]){
                    k += -1;
                }
            }encrypted += (char)k;
        }
        return encrypted;
    }

    @Override
    public String decrypt(String encrypted) {
        
    }
    
}
