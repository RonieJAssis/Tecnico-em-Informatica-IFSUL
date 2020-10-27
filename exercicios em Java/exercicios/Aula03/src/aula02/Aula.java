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
public class Aula {
    int hora;
    int duracao;
    String materia;
    boolean marcada;
    
    void cancelar(){
        
        if (this.marcada == false){
            System.out.println("A aula ja esta desmarcada");
            
        }
        else{
            System.out.println("A aula foi desmarca");
            this.marcada=false;
        }
        
    }
    void marcar(){
        if(this.marcada==true){
            System.out.println("Aula ja esta marcada!");
        }
        else{
            System.out.println("Aula marcada");
            this.marcada = true;
        }
    }
}
