/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula11;

/**
 *
 * @author a
 */
public class Aula11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Visitante p1 = new Visitante();
        p1.setNome("Juvenal");
        p1.setIdade(22);
        p1.setSexo("M");
        System.out.println(p1.toString());*/
        
        Aluno p2 = new Aluno();
        p2.setNome("Claudio");
        p2.setMatricula(1111);
        p2.setCurso("Informatica");
        p2.setSexo("M");
        p2.setIdade(16);
        p2.pagarMen();
        
        Bolsista p3 = new Bolsista();
        p3.setNome("Maria");
        p3.setMatricula(1112);
        p3.setSexo("F");
        p3.setBolsa(12.5f);
        p3.setIdade(15);
        p3.pagarMen();
        
        
// TODO code application logic here
    }
    
}
