/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula10_11_12;

/**
 *
 * @author a
 */
public class Funcionario extends Pessoa {
    
    private String setor;
    private boolean trab;

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public boolean getTrab() {
        return trab;
    }

    public void setTrab(boolean trab) {
        this.trab = trab;
    }
    
    public void mudarTrabalho(boolean trab){
        
        this.trab = trab;
    }
    
}
