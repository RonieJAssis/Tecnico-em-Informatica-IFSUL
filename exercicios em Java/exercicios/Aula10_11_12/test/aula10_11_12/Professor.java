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
public class Professor extends Pessoa {

    private String espec;
    private float salario;

    public String getEspec() {
        return espec;
    }

    public void setEspec(String espec) {
        this.espec = espec;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void receberAum(float aum) {
        
      this.setSalario(this.salario+ aum );
    }

}
