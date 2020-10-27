/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfut;

/**
 *
 * @author a
 */
public class TrabFut {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Time a = new Time("Gremio","Azul","RS");
      
      a.apresentacao();
      a.setCor2("Preto");
      a.apresentacao();
      a.setCor3("Branco");
      a.apresentacao();
      

    
    Time b = new Time("Inter","Vermelho","RS");
      
      b.setCor3("Branco");
      b.apresentacao();
      
        System.out.println(b);
      
    Time c = new Time("Palmeiras","Verde","SP");
    Time d = new Time("Santos","Branco","SP");
    
    Campeonato camp = new Campeonato(a,b,c,d);
    
    camp.começar();
}
}    

