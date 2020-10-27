/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula11;

/**
 *
 * @author a
 */
public class Tecnico extends Aluno {
    
    private String registroProficional;

    public String getRegistroProficional() {
        return registroProficional;
    }

    public void setRegistroProficional(String registroProficional) {
        this.registroProficional = registroProficional;
    }
    
    
    public void praticar(){
        System.out.println("Praticando");
    }
    
}
