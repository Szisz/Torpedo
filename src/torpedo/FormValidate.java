/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package torpedo;

/**
 *
 * @author latyak1
 */
public class FormValidate {
    
    public static boolean required(String ... str){
       byte error=0;
        for (int i = 0; i < str.length && error==0; i++) {
             if(str[i].isEmpty()){
                 error=1;
             }
        }

        if (error==0)
            return true;
        else 
            return false;
           
        
    }
    
   
    
}
