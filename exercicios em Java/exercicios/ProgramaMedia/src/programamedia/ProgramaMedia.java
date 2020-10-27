/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programamedia;

import java.util.Scanner;

/**
 *
 * @author a
 */
public class ProgramaMedia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner Teclado = new Scanner(System.in);
        System.out.print("Seu ano de nascimento:");
        int n1 = Teclado.nextInt();
        int m =2018-n1;
        System.out.println("Sua idade é :"+m);
        if (m>=18){
            System.out.println("Você é maior de idade!");
        }
        else{
            System.out.println("Você é menor de idade!");
    }
    
}
}
