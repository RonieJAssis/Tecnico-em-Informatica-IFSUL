package br.edu.ifsul.dabd.model;
import java.util.Calendar;
import java.util.List;

public class Internacoes {
   private int codigo;
   private String motivo;
   private Calendar data_baixa,data_alta;
   private Pacientes paciente;
   private Leitos leito;
   private Funcionario funcionario;
   private List<MedicosIntenacoes> medicos;

    public Internacoes() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Calendar getData_baixa() {
        return data_baixa;
    }

    public void setData_baixa(Calendar data_baixa) {
        this.data_baixa = data_baixa;
    }

    public Calendar getData_alta() {
        return data_alta;
    }

    public void setData_alta(Calendar data_alta) {
        this.data_alta = data_alta;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    public Leitos getLeito() {
        return leito;
    }

    public void setLeito(Leitos leito) {
        this.leito = leito;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<MedicosIntenacoes> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<MedicosIntenacoes> medicos) {
        this.medicos = medicos;
    }
   
   
}
