/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifmg.edu.trabalho_java_avancado.util;

/**
 *
 * @author Vitor
 */
public class Strings {
    public static String removeCaracteresFromString(String str, String charsRemove, String delimiter) {
         
            if (charsRemove!=null && charsRemove.length()>0 && str!=null) {
             
            String[] remover = charsRemove.split(delimiter);
             
            for(int i =0; i < remover.length ; i++) {
                //System.out.println("i: " + i + " ["+ remover[i]+"]");
                if (str.indexOf(remover[i]) != -1){
                    str = str.replace(remover[i], "");
                }
            }
        }
         
        return str;
    }
}
