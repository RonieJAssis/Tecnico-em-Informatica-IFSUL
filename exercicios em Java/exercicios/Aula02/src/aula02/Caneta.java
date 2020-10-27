/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula02;

/**
 *
 * @author a
 * 
 */
public class Caneta {
    
    String modelo;
    String cor;
    float ponta;
    int carga;
    boolean tampada;
    
    void rabiscar(){
        if (this.tampada==true) {
            System.out.println("é preciso destampar a caneta!");
        }
        else{
            System.out.println("Rabiscando");
        }
        
    }
    
    void status(){
        System.out.println("Modelo "+this.modelo);
        System.out.println("Ponta "+this.ponta);
        System.out.println("Uma caneta "+this.cor);
        System.out.println("tem "+this.carga + " de carga");
        System.out.println("Ela esta tampada? "+this.tampada);
    }
    
   void tampar(){
       
       this.tampada=true;
       
   }
  
   void destampar(){
       
       this.tampada=false;
   }
}

