
package br.edu.ifsul.dabd.teste;

import br.edu.ifsul.dabd.model.dao.Conexao;
import br.edu.ifsul.dabd.model.Funcionario;
import br.edu.ifsul.dabd.model.dao.Conexao2;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author Telmo Júnior
 * @obs: Classe para a execução de testes
 */
public class TestePersistencia {
    
    @Test//essa anotação inidica que o método poderá ser executado de forma isolada, para simular um teste unitário
    //a biblioteca de testes utilizada nesse projeto é a JUnit
    public void testarConexaoFunc(){
        
        Conexao2 cnx = new Conexao2();
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
                //aqui iremos inserir um novo registro na tabela funcionario
                Funcionario func = new Funcionario();
                func.setNome("João Silva");//vai para a coluna nome na tabela
                func.setLogin("Joaozin");
                func.setSenha("12345678");
                
                String retornoInsertFunc = cnx.insertFuncionario(func);
                System.out.println(retornoInsertFunc);
                //chama o metodo insertfuncionario para crair um registro na tabela funcionario
                func.setNome("João Silva Jr");
                func.setLogin("JoanzinJr");
                func.setSenha("1234");
                String retornoUpadteFunc = cnx.updateFuncionario(func);
                System.out.println(retornoUpadteFunc);
                
                String retornoDeleteFunc = cnx.deleteFuncionario(func);
                System.out.println(retornoDeleteFunc);
                
                }else{
                System.out.println("Erro!");
               }
            }else{
            System.out.println("Não conectou no BD!");
        }               
    }
  
}
