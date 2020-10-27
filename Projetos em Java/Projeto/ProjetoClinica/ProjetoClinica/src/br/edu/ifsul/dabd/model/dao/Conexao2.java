/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dabd.model.dao;

import br.edu.ifsul.dabd.model.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 20172210032
 */
public class Conexao2 extends Conexao {
        //METODOS PARA FUNCIONARIO
    //método quer irá receber um objeto por parâmetro e inserir um registro na tabela funcionario
    //se não ocorrer erro esse metodo irá retornar uma string nula
    //em caso do erro, retorna uma string com a mensagem detalhando o erro.
    public String insertFuncionario(Funcionario f) {
        String retorno = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("insert into funcionarios (nome, login, senha) values (?,?,?)");
            //Parâmetros: cada ? indica um parâmetro. O indicativo de cada parâmetro inicia em 1
            //setString é para parâmetro do tipo String
            //setInt é para parâmetro do tipo Int            
            ps.setString(1, f.getNome());
            ps.setString(2, f.getLogin());
            ps.setString(3, f.getSenha());
            //executa no banco de dados a instrução sql
            ps.execute();
            ps = conexao.prepareStatement("select max(codigo) as codigo from funcionarios");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                f.setCodigo(rs.getInt("codigo"));
            }
        } catch (Exception e) {
            retorno = e.getLocalizedMessage();
        }
        return retorno;
    }

    public String updateFuncionario(Funcionario f) {
        String retorno = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("update funcionarios set nome = ? ,login = ? , senha = ? where codigo =  ?");
            //Parâmetros: cada ? indica um parâmetro. O indicativo de cada parâmetro inicia em 1
            //setString é para parâmetro do tipo String
            //setInt é para parâmetro do tipo Int            
            ps.setString(1, f.getNome());
            ps.setString(2, f.getLogin());
            ps.setString(3, f.getSenha());
            ps.setInt(4, f.getCodigo());
            //executa no banco de dados a instrução sql
            ps.execute();

        } catch (Exception e) {
            retorno = e.getLocalizedMessage();
        }
        return retorno;
    }

    public String deleteFuncionario(Funcionario f) {
        String retorno = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("delete from funcionarios where codigo= ?");
            //executa no banco de dados a instrução sql
            ps.setInt(1, f.getCodigo());
            ps.execute();

        } catch (Exception e) {
            retorno = e.getLocalizedMessage();
        }
        return retorno;
    }
    //método que irá retornar uma lista de objetos do tipo funcionario.

    public List<Funcionario> listFuncionarios() {
        //esse método irá retornar todos os
        //registros da tabela funcionario
        List<Funcionario> list = null;
        try {
            //java.sql
            PreparedStatement ps = conexao.prepareStatement("select codigo, nome, login, senha from funcionarios order by codigo asc");
            //ao executar a query o metodo executeQuery retorna um objeto do tipo ResultSet
            //o ResultSet é como se fosse uma tabela com um ponteiro, que inicialmente está apontando para a posição -1
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                //a partir do ResultSet é possível obter a informação de uma determinada celula.
                //para recuperar uma célula e necessário indicar o nome da coluna e o ponteiro aportar para uma determinada linha, através da função next()
                f.setCodigo(rs.getInt("codigo"));
                f.setNome(rs.getString("nome"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));
                //adiciona o objeto na lista
                list.add(f);
            }

        } catch (Exception e) {
            //imprimi na saida padrão o stack trace (detalhamento completo do erro)
            e.printStackTrace();
        }
        return list;
    }
    public Funcionario getLogin(String l,String s) {//metodo para selecionar um registro

        Funcionario f1 = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("select codigo, nome, login, senha from funcionarios where login= ? and senha = ?");//comando SQL              
            ps.setString(1, l);
            ps.setString(2, s);
            //ao executar a query o metodo executeQuery retorna um objeto do tipo ResultSet
            //o ResultSet é como se fosse uma tabela com um ponteiro, que inicialmente está apontando para a posição -1
            ResultSet rs = ps.executeQuery();//executa a pesquisa

            if (rs.next()) {//se achar algum resultado
                f1 = new Funcionario();
                f1.setCodigo(rs.getInt("codigo"));
                f1.setNome(rs.getString("nome"));
                f1.setLogin(rs.getString("login"));
                f1.setSenha(rs.getString("senha"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f1;
    }

}
