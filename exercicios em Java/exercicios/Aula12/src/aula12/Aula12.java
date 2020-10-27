/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula12;

/**
 *
 * @author a
 */
public class Aula12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
    Mamifero m= new Mamifero();
    m.setPeso(35.3f);
    m.setCorPelo("Marrom");
    m.setMembros(4);
    m.locomover();
    m.alimentar();
    m.emetirSom();
    }
    
}
