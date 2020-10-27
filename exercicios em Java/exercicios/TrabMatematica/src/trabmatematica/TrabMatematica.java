/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabmatematica;

import java.util.Scanner;
import static javafx.scene.input.KeyCode.Z;

/**
 *
 * @author a
 */
public class TrabMatematica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner tec = new Scanner(System.in);
        System.out.println("Qual a quantidade de caracteres da senha a ser digitada?");
        int q = tec.nextInt();
        String s [] = new String[q];
        int c = 1;
        boolean t = false;
        for(int p = 0;p<q;p++){
            while(t==false){
            System.out.println("Digite o "+c+"º digito da senha(lembrando que caracteres especiais não são validos,nem caracteres reptidos)");
            s[p] = tec.next(); 
                if (s[p].) {
                t=true;    
                }
                else {
                System.out.println("Caracter invalido,digite novamente!");
                }
            }
            c++;
        }
    }
    
}
