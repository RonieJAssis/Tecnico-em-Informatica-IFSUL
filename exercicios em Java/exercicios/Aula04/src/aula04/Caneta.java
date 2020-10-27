/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula04;

public class Caneta {
public String modelo;
private float ponta;
private boolean tampada;
private String cor;

public Caneta(String m,String c,float p){
    this.tampar();
    this.modelo = m;
    this.cor = c;
    this.setPonta(p);
}

public String getModelo(){
    return this.modelo;
}
public void setModelo(String m){
    this.modelo = m;
}
public float getPonta(){
    return this.ponta;
}
public void setPonta(float p){
    this.ponta = p;
}
public void tampar(){
    this.tampada=true;
}
public void destampar(){
    this.tampada = false;
}
public void Status(){
    System.out.println("Sobre a Caneta:");
    System.out.println("Modelo: "+ this.getModelo());
    System.out.println("Ponta: " + this.getPonta());
    System.out.println("Cor: " + this.cor);
    System.out.println("No momento a caneta esta tampada? "+this.tampada );
}
}
