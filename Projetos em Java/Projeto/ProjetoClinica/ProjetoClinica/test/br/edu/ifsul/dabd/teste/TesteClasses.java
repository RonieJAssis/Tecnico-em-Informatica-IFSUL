package br.edu.ifsul.dabd.teste;

import br.edu.ifsul.dabd.model.Andares;
import br.edu.ifsul.dabd.model.Funcionario;
import br.edu.ifsul.dabd.model.Internacoes;
import br.edu.ifsul.dabd.model.Leitos;
import br.edu.ifsul.dabd.model.Pacientes;
import br.edu.ifsul.dabd.model.dao.Conexao;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class TesteClasses {
    
    //Primeiro Teste-----------------------------------------------------------------------------

    //Andar****************************************
    public Andares test1Andar(Andares a, Conexao cnx) {
        a = cnx.selectAndar(1);//verefica se a um registro com codigo 1
        if (a != null) {
            a.setNumero("6");
            System.out.println("retorno update Andar: "+cnx.updateAndar(a));//faz o comando para atualziar o registro
        } else {
            System.out.println("Nenhum registro de andar encontrado com o codigo 1!");
            a = new Andares();//inicializa o objeto
            a.setNumero("6");
            System.out.println("retorno insert Andar: "+cnx.insertAndar(a));//cria um registro
        }
       return a;
    }

    //Leito****************************************
    public Leitos test1Leito(Leitos l, Conexao cnx, Andares a) {
        l = cnx.selectLeito(1);//verefica se a um registro com codigo 1
        if (l != null) {
            l.setNumero("5");
            l.setDescricao("Legal");
            l.setAndar(a);
           
            System.out.println("retorno update Leito: "+cnx.updateLeito(l));//faz o comando para atualziar o registro
        } else {
            System.out.println("Nenhum registro de leito encontrado com o codigo 1!");
            l = new Leitos();//inicializa o objeto
            l.setNumero("5");
            l.setDescricao("Legal");
            l.setAndar(a);
            System.out.println("retorno insert Leito: "+cnx.insertLeito(l));//cria um registro
        }
        return l;
    }

    //Paciente****************************************
    public Pacientes test1Paciente(Pacientes p, Conexao cnx) {
        p = cnx.selectPaciente(1);//verefica se a um registro com codigo 1
        if (p != null) {
            p.setCelular("9999999");
            p.setCep("99999999");
            p.setComplemento("casa");
            p.setCpf("99999999999");
            p.setEndereco("Rua aaaa");
            p.setNome("João Andrade");
            p.setRg("999999999999");
            p.setTelefone("99999999");
            System.out.println("retorno update Paciente: "+cnx.updatePaciente(p));//faz o comando para atualziar o registro
        } else {
            System.out.println("Nenhum registro de paciente encontrado com o codigo 1!");
            p = new Pacientes();//inicializa o objeto
            p.setCelular("9999999");
            p.setCep("99999999");
            p.setComplemento("casa");
            p.setCpf("99999999999");
            p.setEndereco("Rua aaaa");
            p.setNome("João Andrade");
            p.setRg("999999999999");
            p.setTelefone("99999999");
            System.out.println("retorno insert Paciente: "+cnx.insertPaciente(p));//cria um registro
        }
        return p;
    }

    //Internacao****************************************
    public Internacoes test1Internacao(Internacoes i, Conexao cnx, Leitos l, Pacientes p, Funcionario f) {
        i = cnx.selectInternacao(1);//verefica se a um registro com codigo 1
        if (i != null) {
            i.setMotivo("Dor de barriga");
            i.setPaciente(p);
            i.setLeito(l);
            i.setFuncionario(f);
            Calendar ca = Calendar.getInstance();//cria um objeto do tipo calendario e da a data do sistema
            i.setData_baixa(ca);
            i.setData_alta(ca);
            System.out.println("retorno update Internacão: "+cnx.updateInternacao(i));//faz o comando para atualziar o registro
        } else {
            System.out.println("Nenhum registro de internacao encontrado com o codigo 1!");
            i = new Internacoes();//inicializa o objeto
            i.setMotivo("Dor de barriga");
            i.setPaciente(p);
            i.setLeito(l);
            i.setFuncionario(f);
            Calendar ca = Calendar.getInstance();
            i.setData_baixa(ca);
            i.setData_alta(ca);
            System.out.println("retorno insert Internação: "+cnx.insertInternacao(i));//cria um registro
        }
        return i;
    }

    //Segundo teste----------------------------------------------------------------------------------------------------------------- 
    
    //Teste Andar**************************************************************************************************************
    public void test2Andar(Conexao cnx, String c) {

        List<Andares> lst = cnx.listAndares(c);//cria uma lista que receba os registros
        if (lst != null) {//se encontrar registros
            for (Andares a : lst) {//mostrar e alterar os registros
                System.out.println("Lista de andares: "+"\nCodigo: " + a.getCodigo() + "  Numero: " + a.getNumero()+"\n-----------------------------");
                a.setNumero("10");
                System.out.println("retorno update andar:"+cnx.updateAndar(a));//comando para realizar o update no BD
            }
        } else {//caso não encontre registros
            System.out.println("Nenhum registro de andar encontrado!");
        }
    }

    //Teste Leito**************************************************************************************************************
    public void test2Leito(Conexao cnx, String c) {

        List<Leitos> lst = cnx.listLeitos(c);//cria uma lista que receba os registros
        if (lst != null) {//se encontrar registros
            for (Leitos l : lst) {//mostrar e alterar os registros
                System.out.println("Lista de leitos: "+"\nCodigo: " + l.getCodigo() + " Numero: " + l.getNumero() + " Descrição" + l.getDescricao() + " Andar:" + l.getAndar().getCodigo()+"\n-----------------------------");
                l.setNumero("10");
                l.setDescricao("Bem show");
                System.out.println("retorno update leito:"+cnx.updateLeito(l));//comando para realizar o update no BD
            }
        } else {//caso não encontre registros
            System.out.println("Nenhum registro de leito encontrado!");
        }
    }

    //Teste Paciente**************************************************************************************************************
    public void test2Paciente(Conexao cnx, String c) {

        List<Pacientes> lst = cnx.listPacientes(c);//cria uma lista que receba os registros
        if (lst != null) {//se encontrar registros
            for (Pacientes p : lst) {//mostrar e alterar os registros
                System.out.println("Lista de pacientes: "+"\nCodigo:" + p.getCodigo() + " Celular:" + p.getCelular() + " Cep:" + p.getCep() + " Complemento:" + p.getComplemento() + " CPF:" + p.getCpf() + " Endereço:" + p.getEndereco() + " Nome:" + p.getNome() + " RG:" + p.getRg() + " Telefone:" + p.getTelefone()+"\n-----------------------------");
               p.setCelular("9999999");
            p.setCep("99999999");
            p.setComplemento("casa");
            p.setCpf("99999999999");
            p.setEndereco("Rua aaaa");
            p.setNome("João Andrade");
            p.setRg("999999999999");
            p.setTelefone("99999999");
                System.out.println("retorno update paciente:"+cnx.updatePaciente(p));//comando para realizar o update no BD
            }
        } else {//caso não encontre registros
            System.out.println("Nenhum registro de paciente encontrado!");
        }
    }

    //Teste Internacçao**************************************************************************************************************
    public void test2Internacao(Conexao cnx, String c) {

        List<Internacoes> lst = cnx.listInternacoes(c);//cria uma lista que receba os registros
        if (lst != null) {//se encontrar registros
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            for (Internacoes i : lst) {//mostrar e alterar os registros
                System.out.println("Lista de internaçoes: "+"\nCodigo:" + i.getCodigo() + " Motivo:" + i.getMotivo() + " data da baixa: " + s.format(i.getData_baixa().getTime()) + " data alta:" + s.format(i.getData_alta().getTime()) + " Funcionario:" + i.getFuncionario().getCodigo() + " Paciente:" + i.getPaciente().getCodigo() + " Leito:" + i.getLeito().getCodigo()+"\n-----------------------------");
                i.setMotivo("Dor na unha");

                Calendar ca = Calendar.getInstance();//cria um objeto do tipo calendar que receba a data atual
                i.setData_alta(ca);
                i.setData_baixa(ca);

                System.out.println("retorno update internação:"+cnx.updateInternacao(i));//comando para realizar o update no BD
            }
        } else {//caso não encontre registros
            System.out.println("Nenhum registro de internacao encontrado!");
        }
    }
    
    //Terceiro teste-----------------------------------------------------------------------------------------------------------------
    
    //Teste Andar**************************************************************************************************************
    public void test3Andar(Conexao cnx,String c) {
        List<Andares> lst = cnx.listAndares(c);//cria uma lista que receba os registros
        if (lst != null) {
            for (Andares a : lst) {//mostrar e deletar os registros
                System.out.println("Lista de andares: "+"\nCodigo: " + a.getCodigo() + "  Numero: " + a.getNumero()+"\n-----------------------------");
                System.out.println("retorno delete andar:"+cnx.deleteAndar(a));//deletar os registros
            }
        } else {//caso não encontre registros
            System.out.println("Nenhum registro de andar encontrado!");
        }
    }
    
    //Teste Leito**************************************************************************************************************
    public void test3Leito(Conexao cnx,String c) {
        List<Leitos> lst = cnx.listLeitos(c);//cria uma lista que receba os registros
        if (lst != null) {
            for (Leitos l : lst) {//mostrar e deletar os registros
                System.out.println("Lista de leitos: "+"\nCodigo: " + l.getCodigo() + " Numero: " + l.getNumero() + " Descrição" + l.getDescricao() + " Andar:" + l.getAndar().getCodigo()+"\n-----------------------------");
                System.out.println("retorno delete leito:"+cnx.deleteLeito(l));//deletar os registros
            }
        } else {//caso não encontre registros
            System.out.println("Nenhum registro de leito encontrado!");
        }
    }
    
    //Teste Paciente**************************************************************************************************************
    public void test3Paciente(Conexao cnx,String c) {
        List<Pacientes> lst = cnx.listPacientes(c);//cria uma lista que receba os registros
        if (lst != null) {
            for (Pacientes p : lst) {//mostrar e deletar os registros
                System.out.println("Lista de pacientes: "+"\nCodigo:"  + p.getCodigo() + " Celular:" + p.getCelular() + " Cep:" + p.getCep() + " Complemento:" + p.getComplemento() + " CPF:" + p.getCpf() + " Endereço:" + p.getEndereco() + " Nome:" + p.getNome() + " RG:" + p.getRg() + " Telefone:" + p.getTelefone()+"\n-----------------------------");
                System.out.println("retorno delete paciente:"+cnx.deletePaceintes(p));//deletar os registros
            }
        } else {//caso não encontre registros
            System.out.println("Nenhum registro de paciente encontrado!");
        }
    }
    
    //Teste Internacao**************************************************************************************************************
    public void test3Internacao(Conexao cnx,String c) {
        List<Internacoes> lst = cnx.listInternacoes(c);//cria uma lista que receba os registros
        if (lst != null) {
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            for (Internacoes i : lst) {//mostrar e deletar os registros
                System.out.println("Lista de internaçoes: "+"\nCodigo:" + i.getCodigo() + " Motivo:" + i.getMotivo() +  " data da baixa: " + s.format(i.getData_baixa().getTime()) + " data alta:" + s.format(i.getData_alta().getTime()) + " Funcionario:" + i.getFuncionario().getCodigo() + " Paciente:" + i.getPaciente().getCodigo() + " Leito:" + i.getLeito().getCodigo()+"\n-----------------------------");
                System.out.println("retorno delete internacao:"+cnx.deleteInternacao(i));//deletar os registros
            }
        } else {//caso não encontre registros
            System.out.println("Nenhum registro de nternacao encontrado!");
        }
    }
}
