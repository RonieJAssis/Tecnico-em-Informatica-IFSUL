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
public class Gafanhoto extends Pessoa {
    
    private String login;
    private int totAssistido;

    public Gafanhoto(String nome, String sexo, int idade, float exp, String login) {
        super(nome, sexo, idade, exp);
        this.login = login;
        this.totAssistido = 0;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getTotAssistido() {
        return totAssistido;
    }

    public void setTotAssistido(int totAssistido) {
        this.totAssistido = totAssistido;
    }
    
    public void viuMaisUm(){
        
    }

    @Override
    public String toString() {
        return "Gafanhoto{" +super.toString() + "login=" + login + ", totAssistido=" + totAssistido + '}';
    }
    
    
    
}
