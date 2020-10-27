package br.edu.ifsul.dabd.teste;

import br.edu.ifsul.dabd.model.Andares;
import br.edu.ifsul.dabd.model.Funcionario;
import br.edu.ifsul.dabd.model.Internacoes;
import br.edu.ifsul.dabd.model.Leitos;
import br.edu.ifsul.dabd.model.Pacientes;
import br.edu.ifsul.dabd.model.dao.Conexao;
import org.junit.Test;

public class TestePersistenciaTrabalho {

    //Classe para realziar os Teste 1-----------------------------------------------------------------------------------------------------------------
    @Test//essa anotação inidica que o método poderá ser executado de forma isolada, para simular um teste unitário
    //a biblioteca de testes utilizada nesse projeto é a JUnit
    public void testar1() {
        Conexao cnx = new Conexao();//cria um objeto do tipo Conexão
        TesteClasses tc = new TesteClasses();//Cria um objeto do tipo TesteClasses(classe que contem os testes)
        String retorno = cnx.abreConexao();//Faz a conexão com o BD
        Andares a = null;//crai um objeto mas n inicializa
        Leitos le = null;
        Pacientes p = null;
        Internacoes i = null;
        Funcionario func = new Funcionario();
        func.setCodigo(1);
        
        System.out.println("Tentando abrir conexao: " + retorno);
        if (retorno == null) {//se conectou
            System.out.println("Conectou no BD");
            String c = "codigo";
            a = tc.test1Andar(a, cnx);  
            le = tc.test1Leito(le, cnx, a);
            p = tc.test1Paciente(p, cnx);
            i = tc.test1Internacao(i, cnx, le, p, func);
            System.out.println("Fechando conexão:"+cnx.fecharConexao());//fecha a conexão
        } else {
            System.out.println("Não conectou no BD!");
        }
        System.out.println("Teste feito por Roniê Julian de Assis");
    }

    //Classe para realziar os Teste 2-----------------------------------------------------------------------------------------------------------------
    //@Test//essa anotação inidica que o método poderá ser executado de forma isolada, para simular um teste unitário
    //a biblioteca de testes utilizada nesse projeto é a JUnit    
    public void testar2() {
        Conexao cnx = new Conexao();//cria um objeto do tipo Conexão
        TesteClasses tc = new TesteClasses();//Cria um objeto do tipo TesteClasses(classe que contem os testes)
        String retorno = cnx.abreConexao();//Faz a conexão com o BD
        Andares a = null;//crai um objeto mas n inicializa
        Leitos le = null;
        Pacientes p = null;
        Internacoes i = null;
        Funcionario func = new Funcionario();
        func.setCodigo(1);
        System.out.println("Tentando abrir conexao: " + retorno);
        if (retorno == null) {//se conectou
            System.out.println("Conectou no BD");
            String c = "codigo";
            tc.test2Andar(cnx, c);
            tc.test2Leito(cnx, c);
            tc.test2Paciente(cnx, c);
            tc.test2Internacao(cnx, c);
            System.out.println("Fechando conexão:"+cnx.fecharConexao());//fecha a conexão
        } else {
            System.out.println("Não conectou no BD!");
        }
        System.out.println("Teste feito por Roniê Julian de Assis");
    }

    //Classe para realziar os Teste 3-----------------------------------------------------------------------------------------------------------------
    //@Test//essa anotação inidica que o método poderá ser executado de forma isolada, para simular um teste unitário
    //a biblioteca de testes utilizada nesse projeto é a JUnit    
    public void testar3() {
        Conexao cnx = new Conexao();//cria um objeto do tipo Conexão
        TesteClasses tc = new TesteClasses();//Cria um objeto do tipo TesteClasses(classe que contem os testes)
        String retorno = cnx.abreConexao();//Faz a conexão com o BD
        Andares a = null;//crai um objeto mas n inicializa
        Leitos le = null;
        Pacientes p = null;
        Internacoes i = null;
        Funcionario func = new Funcionario();
        func.setCodigo(1);
        System.out.println("Tentando abrir conexao: " + retorno);
        if (retorno == null) {//se conectou
            System.out.println("Conectou no BD");
            String c = "codigo";
            tc.test3Internacao(cnx, c);
            tc.test3Paciente(cnx, c);
            tc.test3Leito(cnx, c);
            tc.test3Andar(cnx, c);
            System.out.println("Fechando conexão:"+cnx.fecharConexao());//fecha a conexão
        } else {
            System.out.println("Não conectou no BD!");
        }
        System.out.println("Teste feito por Roniê Julian de Assis");
    }
}
