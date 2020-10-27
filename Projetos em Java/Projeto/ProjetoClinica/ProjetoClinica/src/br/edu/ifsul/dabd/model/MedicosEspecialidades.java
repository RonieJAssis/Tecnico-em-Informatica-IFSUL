package br.edu.ifsul.dabd.model;
public class MedicosEspecialidades {
    private Medicos medico;
    private Especialidades especialidade;
    private Boolean exerce;

    public MedicosEspecialidades() {
    }
  
    public Medicos getMedico() {
        return medico;
    }

    public void setMedico(Medicos medico) {
        this.medico = medico;
    }

    public Especialidades getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidades especialidade) {
        this.especialidade = especialidade;
    }

    public Boolean getExerce() {
        return exerce;
    }

    public void setExerce(Boolean exerce) {
        this.exerce = exerce;
    }
    
    
}
