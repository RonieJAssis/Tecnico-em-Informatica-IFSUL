
package br.edu.ifsul.dabd.teste;

import br.edu.ifsul.dabd.model.dao.Conexao;
import br.edu.ifsul.dabd.model.Funcionario;
import br.edu.ifsul.dabd.model.Paciente;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

/**
 *
 * @author Telmo Júnior
 * @obs: Classe para a execução de testes
 */
public class TestePersistencia {
    
    @Test//essa anotação inidica que o método poderá ser executado de forma isolada, para simular um teste unitário
    //a biblioteca de testes utilizada nesse projeto é a JUnit
    public void testarConexao(){
        
        Conexao cnx = new Conexao();
        String retorno = cnx.abreConexao();
        System.out.println("Tentando abrir conexao: "+retorno);
        //testando a abertura da conexao.
        if(retorno == null){
            
            System.out.println("Conectou no BD");
            List<Funcionario> lst = cnx.listFuncionarios();
            //percorrer a list e imprimir e imprimir
            //os dados da propriedade de Funcionario
            if(lst != null){//verifica erro
                //percorer a lista
                //a cada interação, f recebe um registro da tabela Funcionario
                for(Funcionario f : lst){
                    System.out.println("Codigo: "+f.getCodigo()+"  Nome: "+f.getNome());                  
                }
                
            }else{
                System.out.println("Erro ao listar usuários!!");
            }
                
        //aqui iremos inserir um novo registro na tabela funcionario
        Funcionario func = new Funcionario();
        func.setNome("Telmo Júnior");//vai para coluna nome na tabela
        func.setLogin("telmo.jr");
        func.setSenha("12345678");
        
        //Teste para inserir um registro na tabela do BD
        //chama o método insertFuncionario para criar um registro
        //na tabela funcionario
        //String retornoInsertFunc = cnx.insertFuncionario(func);
        //System.out.println("Retorno da inserção: "+retornoInsertFunc );
        
        //Teste para alterar registro na tabela
        func.setCodigo(2);
        func.setNome("Nome alterado");
        func.setLogin("alterado");
        func.setSenha("novasenha");
        //String retornoUpdate = cnx.updateFuncionario(func);
        //System.out.println("Retorno do update: "+retornoUpdate); 
        
        //Teste para remover registro da tabela
        func.setCodigo(3);
        //String retornoDelecao = cnx.deleteFuncionario(func);
        //System.out.println("Retorno do delete: "+retornoDelecao);
                
        
        List<Paciente> list = cnx.listPacientes();
        for(Paciente p: list){
            System.out.println("Codigo do Paciente : "+p.getCodigo()+" com o nome : "+p.getNome());
            System.out.println("retorno da remocao do paciente : "+cnx.deletePaciente(p));
        }

    }else{
        System.out.println("Não conectou no BD!");
    }
        
        
    }
    
   
}
