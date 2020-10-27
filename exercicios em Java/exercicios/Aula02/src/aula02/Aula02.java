/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula02;

/**
 *
 * @author a
 */
public class Aula02 {

    public static void main(String[] args) {
    
       /* Caneta c1 = new Caneta();
     
        c1.cor="Azul";
        c1.ponta=0.5f;
        c1.tampar();
        c1.rabiscar();
        
        
        Caneta c2 = new Caneta();
        c2.modelo= "BIC";
        c2.cor ="vermelha";
        c2.ponta =1.0f;
        c2.carga = 50;
        c2.destampar();
        c2.rabiscar();*/
       
       Aula a1 = new Aula();
       a1.hora = 1;
       a1.duracao =1;
       a1.materia="programação";
       
       a1.cancelar();
       a1.marcar();
       
       Controle c1 = new Controle();
       
       c1.marca="PS3";
       c1.cor="Preto";
       c1.ligar();
    }
}