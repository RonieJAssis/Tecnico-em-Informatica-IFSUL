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
public class Partida {

    private Time tc;
    private Time tf;
    private int gc = 0, gf = 0;
    private Campeonato campeonato;

    public Partida(Campeonato c, Time tc, Time tf) {
        this.tc = tc;
        this.tf = tf;
        this.campeonato = c;
    }

    public Time getTc() {
        return tc;
    }

    public Time getTf() {
        return tf;
    }

    public int getGc() {
        return gc;
    }

    public int getGf() {
        return gf;
    }

    public void tocarHino() {
        JOptionPane.showMessageDialog(null, "Agora vai tocar o hino de " + tc.getRegiao());
    }

    public void apresentacaop() {
        JOptionPane.showMessageDialog(null, "Jogando em casa nos temos o " + tc.getNome() + ", com pontuação igual a " + tc.getOverwall()
                + " e como visitante temos o " + tf.getNome() + " com " + tf.getOverwall() + " pontos de habilidade");
    }

    public int probabilidade() {
        int ptc = tc.getOverwall(), ptf = tf.getOverwall(), p;
        if (ptc > 30 + ptf) {
            p = 90;
        } else if (ptc + 30 < ptf) {
            p = 60;
        } else if (ptc > 15 + ptf) {
            p = 85;
        } else if (ptc + 15 < ptf) {
            p = 65;
        } else if (ptc > 7 + ptf) {
            p = 80;
        } else if (ptc + 7 < ptf) {
            p = 70;
        }    
          else{
           p=75;         
        }
        return p;
    }
    public void resultado(){
        if (gc>gf) {
            JOptionPane.showMessageDialog(null,"O time "+tc.getNome()+" que jogou em casa ganhou a partida!");
            tc.ganhar();
            tf.perder();
        }
        else if(gf>gc) {
            JOptionPane.showMessageDialog(null,"O time "+tf.getNome()+" que jogou fora de casa ganhou a partida!");
            tf.ganhar();
            tc.perder();
        }
        else{
           JOptionPane.showMessageDialog(null,"Os times "+tc.getNome()+" e "+tf.getNome()+" empataram!");
           tc.empatar();
           tf.empatar();
        }
        
    }
    public void comecar(){
    
        this.apresentacaop();
        this.tocarHino();
        int p =this.probabilidade();
        
        for (int i = 0; i < 5; i++) {
             Random r = new Random();
             int t = r.nextInt(100);
             if (t < 11) {
                 JOptionPane.showMessageDialog(null,"Jogador expulso,perda de pontos na partida para o time...");
                int tt = r.nextInt(2);
                 if (tt==0) {
                     p-=5;
                   JOptionPane.showMessageDialog(null,tc.getNome());
                 }
                 if (tt==1) {
                     p+=5;
                   JOptionPane.showMessageDialog(null,tf.getNome());  
                 }               
            }
             else if(t<61){
                 
             } 
             else if(t<p+1){
                 gc++;
             }
             else{
                 gf++;
             }
        }
        JOptionPane.showMessageDialog(null,"O resultado da parida foi:"+
                "\n"+tc.getNome()+" "+gc+"x"+gf+" "+tf.getNome());
        
        this.resultado();
        
}

    @Override
    public String toString() {
        return this.tc+"X"+this.tf;
    }
    
}

