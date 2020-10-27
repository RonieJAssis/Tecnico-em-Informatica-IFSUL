/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinal;

/**
 *
 * @author a
 */
public class Visualizacao {
    
    private Gafanhoto espcteador;
    private Video filme;

    public Visualizacao(Gafanhoto espcteador, Video filme) {
        this.espcteador = espcteador;
        this.filme = filme;
        this.espcteador.setTotAssistido(this.espcteador.getTotAssistido()+1);
        this.filme.setViews(this.filme.getViews()+1);
        
    }

    public Gafanhoto getEspcteador() {
        return espcteador;
    }

    public void setEspcteador(Gafanhoto espcteador) {
        this.espcteador = espcteador;
    }

    public Video getFilme() {
        return filme;
    }

    public void setFilme(Video filme) {
        this.filme = filme;
    }

    @Override
    public String toString() {
        return "Visualizacao{" + "espcteador=" + espcteador + ", filme=" + filme + '}';
    }
    
    public void avaliar(){
     this.filme.setAvaliacao(5);
    }
    public void avaliar(int nota){
        this.filme.setAvaliacao(nota);
    }
    public void avaliar(float porc){
        int tot=0;
        if (porc<=20) {
            tot=3;
        }
        else if (porc<=50){
            tot=5;
        }
        else if(porc<=90){
            tot=8;
        }
        else{
            tot=10;
        }
        this.filme.setAvaliacao(tot);
    }   
}
