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
public class Caneta {
    
    public String modelo;
    public String cor;
    private float ponta;
    protected int carga;
    protected boolean tampada;
    
    public void rabiscar(){
        if (this.tampada==true) {
            System.out.println("é preciso destampar a caneta!");
        }
        else{
            System.out.println("Rabiscando");
        }
        
    }
    
    public void status(){
        System.out.println("Modelo "+this.modelo);
        System.out.println("Ponta "+this.ponta);
        System.out.println("Uma caneta "+this.cor);
        System.out.println("tem "+this.carga + " de carga");
        System.out.println("Ela esta tampada? "+this.tampada);
    }
    
   protected void tampar(){
       
       this.tampada=true;
       
   }
  
   protected void destampar(){
       
       this.tampada=false;
   }
}
