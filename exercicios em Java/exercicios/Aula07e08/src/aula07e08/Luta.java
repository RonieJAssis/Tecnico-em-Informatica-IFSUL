package aula07e08;

import java.util.Random;

public class Luta {
    
    private Lutador Desafiado;
    private Lutador Desafiante;
    private int Rounds;
    private boolean Aprovada;

    public Lutador getDesafiado() {
        return Desafiado;
    }

    public Lutador getDesafiante() {
        return Desafiante;
    }

    public void setDesafiado(Lutador Desafiado) {
        this.Desafiado = Desafiado;
    }

    public void setDesafiante(Lutador Desafiante) {
        this.Desafiante = Desafiante;
    }
    
    public void setRounds(int Rounds) {
        this.Rounds = Rounds;
    }

    public void setAprovada(boolean Aprovada) {
        this.Aprovada = Aprovada;
    }
    

    public int getRounds() {
        return Rounds;
    }

    public boolean getAprovada() {
        return Aprovada;
    }
    
    
    
    public void marcarLuta(Lutador l1,Lutador l2){
        if (l1.getCategoria().equals (l2.getCategoria())) {
            if (l1!=l2) {
             this.setAprovada(true);
             this.Desafiado=l1;
             this.Desafiante=l2;
            }
            else{
             this.setAprovada(false);
             this.Desafiado=null;
             this.Desafiante=null;
                System.out.println("Lutadores iguais!!");
            }  
        }
         else {
            System.out.println("Categorias diferentes");
            this.setAprovada(false);
             this.Desafiado=null;
             this.Desafiante=null;
        }  
    }
    public void Lutar(){
      
        if (this.Aprovada) {
           this.Desafiado.apresentar();
            System.out.println(" ");
            System.out.println("EEEE DO OUTRO LADO! ");
            System.out.println(" ");
           this.Desafiante.apresentar();
            System.out.println("----------------------------------");
           //criar numero aleatorio
           
           Random ale = new Random();
           int vencedor = ale.nextInt(3);
           switch(vencedor){
               case 0:
                   System.out.println("Empatou!!");
                   this.Desafiado.empatarLuta();
                   this.Desafiante.empatarLuta();
               break;    
               case 1:
                   System.out.println("Venceu "+this.Desafiado.getNome());
                   this.Desafiado.ganharLuta();
                   this.Desafiante.perderLuta();
               break;    
               case 2:
                   System.out.println("Venceu "+this.Desafiante.getNome());
                   this.Desafiado.perderLuta();
                   this.Desafiante.ganharLuta();
               break;    
           }
        }
        else{
            System.out.println("Luta não pode acontecer");
        }
        
    }
    
    
}
