/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repeticao01;

import java.util.Scanner;

/**
 *
 * @author a
 */
public class Repeticao01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n,s=0;
        String resp;
        Scanner Tec= new Scanner(System.in); 
        do{
            System.out.println("Digite um numero?");
            n=Tec.nextInt();
            s+=n;
            System.out.println("Quer continuar?[S/N]");
            resp = Tec.next();
            
        }while(resp.equals("S"));
        System.out.println("A soma de todos os valores é :"+s);
    
}
}    
