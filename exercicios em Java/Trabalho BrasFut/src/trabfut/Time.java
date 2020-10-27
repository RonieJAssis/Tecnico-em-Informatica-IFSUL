/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfut;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author a
 */
public class Time {
   private String nome;
   private int overwall;
   private String cor1=null;
   private String cor2=null;
   private String cor3=null;
   private String regiao;

    public Time(String nome, String cor1, String regiao) {
        this.nome = nome;
        this.cor1 = cor1;
        this.regiao = regiao;
        this.overwall = 30;
    }

    public String getNome() {
        return nome;
    }

    public int getOverwall() {
        return overwall;
    }

    public String getCor1() {
        return cor1;
    }

    public String getCor2() {
        return cor2;
    }

    public String getCor3() {
        return cor3;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setCor2(String cor2) {
        this.cor2 = cor2;
    }

    public void setCor3(String cor3) {
        this.cor3 = cor3;
    }
   
   public void apresentacao(){
       
       if (this.cor2 == null && this.cor3 == null) {
            JOptionPane.showMessageDialog(null,"O time "+this.nome+" representado pela cor "
            +this.cor1+ " do estado de "+regiao +" e com o nivel de habilidade de "+overwall );
       }else if(this.cor2 != null && this.cor3 == null){
           JOptionPane.showMessageDialog(null,"O time "+this.nome+" representado pelas cores "
            +this.cor1+" e "+this.cor2 + " do estado de "+regiao +" e com o nivel de habilidade de "+overwall );
       }else if(this.cor2 == null && this.cor3 != null){
           JOptionPane.showMessageDialog(null,"O time "+this.nome+" representado pelas cores "
            +this.cor1+" e "+this.cor3 + " do estado de "+regiao +" e com o nivel de habilidade de "+overwall );
       }else{
           JOptionPane.showMessageDialog(null,"O time "+this.nome+" tricolor representado pelas cores "
            +this.cor1+", "+this.cor2 +" e "+this.cor3+ " do estado de "+regiao +" e com o nivel de habilidade de "+overwall );
       }
   }
   public void treinar(){
       Random r = new Random();
       int t = r.nextInt(100);
       if (t<= 70) {
         JOptionPane.showMessageDialog(null,"O treino foi realizado com sucesso, o time recebeu +1 ponto de habilidade! ");
         this.overwall++;
       }
       else{
           JOptionPane.showMessageDialog(null,"Infelizmente um jogador se machucou,o time perdeu -2 pontos de habilidade! ");
         this.overwall-=2;
       }
   }
   public void ganhar(){
       overwall +=5;
   }
     public void perder(){
       overwall -=5;
   }
     public void empatar(){
       overwall ++;
   } 

    @Override
    public String toString() {
        return this.getNome();
    }
   
  
       
}
