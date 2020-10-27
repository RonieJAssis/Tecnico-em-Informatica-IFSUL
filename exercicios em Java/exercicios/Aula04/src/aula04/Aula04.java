/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula04;

/**
 *
 * @author a
 */
public class Aula04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Caneta c1 = new Caneta("NIC","Azulado",0.4f);
        //c1.setModelo("BIC");
        //c1.setPonta(0.5f);
        c1.Status();
        System.out.println(" ");
        Caneta c3= new Caneta("kkk","Laranja",0.5f);
        c3.Status();
    }
    
}
