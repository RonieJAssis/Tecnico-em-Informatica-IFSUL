/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetor01;

import java.util.Arrays;

/**
 *
 * @author a
 */
public class Vetor01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*int tot []={31,29,31,30,31,30,31,31,30,31,30,31};
        String mes[] ={"Jan","Fev","Mar","Abr","Mai","Jun","Jul","Ago","Set","Out","Nov","Dez",} ;
        for(int c =0;c<tot.length;c++){
            System.out.println("o mes  "+mes[c]+" tem "+tot[c]+" dias");*/
          /*double v[]={3.5,2.75,9,-4.5};
          for(double valor:v){
              System.out.println(valor);*/
         int n[]={3,5,1,8,4};
          /*Arrays.sort(n);*/
          Arrays.fill(n, 6);
        for(int v:n){
             System.out.println(v);
        }
        /*int p = Arrays.binarySearch(n,8);
          System.out.println(p);*/
    }
    
}
