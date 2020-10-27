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
public class Cachorro extends Mamifero {
    
    public void enterrarOsso(){
        System.out.println("Enterrando o osso");
    }
   
    public void abanarRabo(){
        System.out.println("Abanando rabo");
    }
    public void reagir(String frase){
        if (frase=="toma comida"||frase=="Olá") {
            System.out.println("Abanar e latir");
        }
        else{
            System.out.println("Rosnar");
        }
    
    }
    public void reagir(int hr){
        if (hr<12) {
            System.out.println("Abanar");
        }
        else if(hr>=18){
            System.out.println("Ignorar");
        }
        else{
            System.out.println("Abanar e latir");
        }
        
    }
    public void reagir(boolean dono){
        if (dono) {
            System.out.println("Abanar");
        }
        else{
            System.out.println("Rosnar e latir");
        }
        
    }
    public void reagir(int idade,float peso){
        if (idade<5) {
            if (peso<10) {
                System.out.println("Abanar");
            }
            else{
                System.out.println("Latir");
            }
        }
        else{
            if (peso<10) {
                
                System.out.println("Rosnar");
            }
            System.out.println("ignorar");
        }
    }
}
