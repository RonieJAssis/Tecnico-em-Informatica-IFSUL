/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciorepita;
import javax.swing.JOptionPane;

/**
 *
 * @author a
 */
public class ExercicioRepita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n,s=0,p = 0,i = 0,t = 0,c = 0;
        float m=0;
     do{
         n = Integer.parseInt(JOptionPane.showInputDialog(null,"<html>Informe um número: <br><em>(Valor 0 Interrompe!)</em></html>"));
         s+=n;
         if(n!=0){
             t++;
             if(n>100){
                 c++;
             }
          if(n%2==0){
             p++; 
          }
          else{
             i++;
          }
         }
     }while(n!=0);
     
     
     m = s/t;
     

     JOptionPane.showMessageDialog(null,"<html>Resultado final<hr>"+"<br>Total de números: "+t+"<br>Somatório vale: "+s+"<br>Total de números pares: "+p+"<br>Total de números ímpares: "+i+"<br>Números maiores que cem: "+c+ "<br>A média dos numeros foi: "+m+"</html>");
    }
    
}
