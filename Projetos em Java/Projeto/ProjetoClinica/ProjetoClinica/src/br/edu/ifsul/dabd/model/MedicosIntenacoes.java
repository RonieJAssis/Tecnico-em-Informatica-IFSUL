package br.edu.ifsul.dabd.model;
import java.util.Calendar;

public class MedicosIntenacoes {
  private Internacoes intenacao;
  private Medicos medico;
  private Calendar data_alta;
  private boolean responsavel;

    public MedicosIntenacoes() {  
    }

    public Internacoes getIntenacao() {
        return intenacao;
    }

    public void setIntenacao(Internacoes intenacao) {
        this.intenacao = intenacao;
    }

    public Medicos getMedico() {
        return medico;
    }

    public void setMedico(Medicos medico) {
        this.medico = medico;
    }

    public Calendar getData_alta() {
        return data_alta;
    }

    public void setData_alta(Calendar data_alta) {
        this.data_alta = data_alta;
    }

    public boolean isResponsavel() {
        return responsavel;
    }

    public void setResponsavel(boolean responsavel) {
        this.responsavel = responsavel;
    }
  
  
}
