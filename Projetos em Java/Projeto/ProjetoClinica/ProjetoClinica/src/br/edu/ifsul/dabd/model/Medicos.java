package br.edu.ifsul.dabd.model;

import java.util.List;

public class Medicos {
    private String crm,nome;
    private float salario;
    private List<MedicosEspecialidades> especialidades;

    public Medicos() {
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public List<MedicosEspecialidades> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<MedicosEspecialidades> especialidades) {
        this.especialidades = especialidades;
    }
    
    
}
