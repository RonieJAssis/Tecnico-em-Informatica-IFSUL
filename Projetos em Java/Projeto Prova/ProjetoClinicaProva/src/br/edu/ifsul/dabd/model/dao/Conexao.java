
package br.edu.ifsul.dabd.model.dao;

import br.edu.ifsul.dabd.model.Funcionario;
import br.edu.ifsul.dabd.model.Paciente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Telmo Júnior
 */
public class Conexao {
    //camopos estáticos (visíveis para todas as classes do projeto). final: não pode ser alterado.
    public static final String DRIVER = "org.postgresql.Driver";
    public static final String USER = "postgres";
    public static final String SENHA = "postgres";
    public static final String URL = "jdbc:postgresql://localhost:5432/db_clinica";
    private Connection conexao;
    
    public Conexao(){        
    }
    public Funcionario getFuncionario(Integer codigo){
         Funcionario f = null;
        try{
            PreparedStatement ps = conexao.prepareStatement("select codigo, nome, login, senha "
            + "from funcionarios "
            + "where codigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                f = new Funcionario();
                f.setCodigo(rs.getInt("codigo"));//seta as informacoes
                f.setNome(rs.getString("nome"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return f;
    }
    
    public Funcionario doLogin(String usuario, String senha){
        Funcionario f = null;
        try{
            PreparedStatement ps = conexao.prepareStatement("select                codigo, nome, login, senha "
            + "from funcionarios "
            + "where login = ? and senha = ?");
            ps.setString(1, usuario);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                f = new Funcionario();
                f.setCodigo(rs.getInt("codigo"));//seta as informacoes
                f.setNome(rs.getString("nome"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return f;
    }    
    
    
    //remove um registo da tabela, com base na chave primária
    public String deleteFuncionario(Funcionario f){
        String erro = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("delete from funcionarios where codigo = ? ");
            ps.setInt(1, f.getCodigo());
            
            //executa o comando delete no banco de dados
            ps.execute();
            
        } catch (Exception e) {
            erro = e.getLocalizedMessage();
        }
        return erro;
    }
    //recebe um objeto do tipo Funcionario, recupera
    //as informações através dos métodos get e depois
    //altera um registro na tabela do BD
    public String updateFuncionario(Funcionario f){
        String erro = null;
        try{
            PreparedStatement ps = conexao.prepareStatement("update funcionarios set nome=?, login=?, senha=? where codigo = ?");
            ps.setString(1, f.getNome());
            ps.setString(2, f.getLogin());
            ps.setString(3, f.getSenha());
            ps.setInt(4, f.getCodigo());
            
            //executa o comando update no banco de dados
            ps.execute();
            
        }catch(Exception e){
            erro = e.getLocalizedMessage();
        }
        return erro;
    }
    
    
    
    //método quer irá receber um objeto por parâmetro e inserir um registro na tabela funcionario
    //se não ocorrer erro esse metodo irá retornar uma string nula
    //em caso do erro, retorna uma string com a mensagem detalhando o erro.
     public String insertFuncionario(Funcionario f){
        String retorno = null;
        try{
            PreparedStatement ps = conexao.prepareStatement("insert into funcionarios (nome, login, senha) values (?,?,?)");
            //Parâmetros: cada ? indica um parâmetro. O indicativo de cada parâmetro inicia em 1
            //setString é para parâmetro do tipo String
            //setInt é para parâmetro do tipo Int            
            ps.setString(1, f.getNome());
            ps.setString(2, f.getLogin());
            ps.setString(3, f.getSenha());
            
            //executa no banco de dados a instrução sql
            ps.execute();           
            
        }catch(Exception e){
            retorno = e.getLocalizedMessage();
        }
        return retorno;
    }
    //método que irá retornar uma lista de objetos do tipo funcionario.
     
    public List<Funcionario> listFuncionarios(){
        //esse método irá retornar todos os
        //registros da tabela funcionario
        List<Funcionario>  list = null;
        try {
            //java.sql
            PreparedStatement ps = conexao.prepareStatement("select codigo, nome, login, senha from funcionarios order by codigo asc");
            //ao executar a query o metodo executeQuery retorna um objeto do tipo ResultSet
            //o ResultSet é como se fosse uma tabela com um ponteiro, que inicialmente está apontando para a posição -1
            ResultSet rs = ps.executeQuery();
            list = new ArrayList();
            while(rs.next()){
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
    
    public List<Paciente> listPacientes(){
        //esse método irá retornar todos os
        //registros da tabela pacientes
        List<Paciente>  list = null;
        try {
            //java.sql
            PreparedStatement ps = conexao.prepareStatement("select codigo, nome, cpf, rg, telefone, celular, endereco, complemento, cep from pacientes order by codigo asc");
            //ao executar a query o metodo executeQuery retorna um objeto do tipo ResultSet
            //o ResultSet é como se fosse uma tabela com um ponteiro, que inicialmente está apontando para a posição -1
            ResultSet rs = ps.executeQuery();
            list = new ArrayList();
            while(rs.next()){
                Paciente p = new Paciente();
                //a partir do ResultSet é possível obter a informação de uma determinada celula.
                //para recuperar uma célula e necessário indicar o nome da coluna e o ponteiro aportar para uma determinada linha, através da função next()
                p.setCodigo(rs.getInt("codigo"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setRg(rs.getString("rg"));
                p.setTelefone(rs.getString("telefone"));
                p.setCelular(rs.getString("celular"));
                p.setEndereco(rs.getString("endereco"));
                p.setComplemento(rs.getString("complemento"));
                p.setCep(rs.getString("cep"));
                //adiciona o objeto na lista
                list.add(p);
            }
            
        } catch (Exception e) {
            //imprimi na saida padrão o stack trace (detalhamento completo do erro)
            e.printStackTrace();
        }
        return list;
    }
    
    //remove um registo da tabela, com base na chave primária
    public String deletePaciente(Paciente p){
        String erro = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("delete from pacientes where codigo = ? ");
            ps.setInt(1, p.getCodigo());
            
            //executa o comando delete no banco de dados
            ps.execute();
            
        } catch (Exception e) {
            erro = e.getLocalizedMessage();
        }
        return erro;
    }
    public String insertPaciente(Paciente p) {//metodo para inserir um registro
        String retorno = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("insert into pacientes (nome,cpf,rg,telefone,celular,endereco,complemento,cep) values (?,?,?,?,?,?,?,?)");//comando SQL                    
            ps.setString(1, p.getNome());
            ps.setString(2, p.getCpf());
            ps.setString(3, p.getRg());
            ps.setString(4, p.getTelefone());
            ps.setString(5, p.getCelular());
            ps.setString(6, p.getEndereco());
            ps.setString(7, p.getComplemento());
            ps.setString(8, p.getCep());
            ps.execute();//executa o comando SQL
            ps = conexao.prepareStatement("select max(codigo) as codigo from pacientes");//comando SQL para pegar o codigo gerado no BD
            ResultSet rs = ps.executeQuery();//executa a pesquisa
            if (rs.next()) {//se achar algum resultado
                p.setCodigo(rs.getInt("codigo"));//classe recebe codigo                
            }
        } catch (Exception e) {
            retorno = e.getLocalizedMessage();
        }
        return retorno;
    }

    //****UPDATE***************************
    public String updatePaciente(Paciente p) {//metodo para atualizar registros
        String retorno = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("update pacientes set nome=?, cpf= ?, rg= ?,telefone= ?, celular= ?, endereco= ?, complemento= ?,cep= ?  where codigo =  ?");//comando SQL          
            ps.setString(1, p.getNome());
            ps.setString(2, p.getCpf());
            ps.setString(3, p.getRg());
            ps.setString(4, p.getTelefone());
            ps.setString(5, p.getCelular());
            ps.setString(6, p.getEndereco());
            ps.setString(7, p.getComplemento());
            ps.setString(8, p.getCep());
            ps.setInt(9, p.getCodigo());
            ps.execute();//executa o comando SQL

        } catch (Exception e) {
            retorno = e.getLocalizedMessage();
        }
        return retorno;
    }
    
    public Paciente selectPaciente(int c) {//seleciona um registro

        Paciente p1 = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("select codigo,nome,cpf,rg,telefone,celular,endereco,complemento,cep from pacientes where codigo= ?");//comando SQL              
            ps.setInt(1, c);
            //ao executar a query o metodo executeQuery retorna um objeto do tipo ResultSet
            //o ResultSet é como se fosse uma tabela com um ponteiro, que inicialmente está apontando para a posição -1
            ResultSet rs = ps.executeQuery();//executa a pesquisa

            if (rs.next()) {//se achar algum resultado
                p1 = new Paciente();
                p1.setCodigo(rs.getInt("codigo"));
                p1.setNome(rs.getString("nome"));
                p1.setCpf(rs.getString("cpf"));
                p1.setRg(rs.getString("rg"));
                p1.setTelefone(rs.getString("telefone"));
                p1.setCelular(rs.getString("celular"));
                p1.setEndereco(rs.getString("endereco"));
                p1.setComplemento(rs.getString("complemento"));
                p1.setCep(rs.getString("cep"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return p1;
    }
    
    public String abreConexao(){
        String retorno = null;
        try{
            //irá carregar o Driver do PostgreSQL
            Class.forName(DRIVER);
            
            //tenta abrir a conexao com o banco de dados. Se ocorrer erro o fluxo de execução é desviado para o catch
            conexao = DriverManager.getConnection(URL, USER, SENHA);
        
        }catch(Exception e){
            retorno = e.getLocalizedMessage();
        }
        
        //Possibilidades de retorno
        //Conexão estabelecida com sucesso: retorna null.
        //Conexão não estabelecida: retorna mensagem de erro.
        return retorno;
    }
    
    
}
