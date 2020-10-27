package br.edu.ifsul.dabd.model.dao;

import br.edu.ifsul.dabd.model.Andares;
import br.edu.ifsul.dabd.model.Funcionario;
import br.edu.ifsul.dabd.model.Internacoes;
import br.edu.ifsul.dabd.model.Leitos;
import br.edu.ifsul.dabd.model.Pacientes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    //---------------------------------------------------------------------------------------------------------------------------------------------------
    //ATRIBUTOS
    //camopos estáticos (visíveis para todas as classes do projeto). final: não pode ser alterado.
    public static final String DRIVER = "org.postgresql.Driver";
    public static final String USER = "postgres";
    public static final String SENHA = "postgres";
    public static final String URL = "jdbc:postgresql://localhost:5432/db_clinica";
    Connection conexao;

    //------------------------------------------------------------------------------------------------------------------------------------------------------- 
    //CONSTRUTOR
    public Conexao() {

    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------- 
    //METODO PARA ABRIR CONEXÃO
    public String abreConexao() {
        String retorno = null;
        try {
            //irá carregar o Driver do PostgreSQL
            Class.forName(DRIVER);

            //tenta abrir a conexao com o banco de dados. Se ocorrer erro o fluxo de execução é desviado para o catch
            conexao = DriverManager.getConnection(URL, USER, SENHA);

        } catch (Exception e) {
            retorno = e.getLocalizedMessage();
        }

        //Possibilidades de retorno
        //Conexão estabelecida com sucesso: retorna null.
        //Conexão não estabelecida: retorna mensagem de erro.
        return retorno;
    }

    //METODO PARA FECHAR CONEXÃO
    public String fecharConexao() {//Metodo para fechar Conexão
        String s = null;
        try {
            conexao.close();//fecha a conexão
        } catch (SQLException e) {
            s = e.getLocalizedMessage();
        }
        return s;
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------- 
    //METODOS PARA ANDARES
    //****INSERT***************************
    public String insertAndar(Andares a) {//metodo para inserir um registro
        String retorno = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("insert into andares (numero) values (?)");//comando SQL                    
            ps.setString(1, a.getNumero());
            ps.execute();//executa o comando SQL
            ps = conexao.prepareStatement("select max(codigo) as codigo from andares");//comando SQL para pegar o codigo gerado no BD
            ResultSet rs = ps.executeQuery();//executa a pesquisa
            if (rs.next()) {//se achar algum resultado
                a.setCodigo(rs.getInt("codigo")); //classe recebe o codigo               
            }
        } catch (Exception e) {
            retorno = e.getLocalizedMessage();
        }
        return retorno;
    }

    //****UPDATE***************************
    public String updateAndar(Andares a) {//metodo para realizar alterações em registros
        String retorno = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("update andares set numero = ?  where codigo =  ?");//comando SQL          
            ps.setString(1, a.getNumero());
            ps.setInt(2, a.getCodigo());
            ps.execute();//executa o comando SQL

        } catch (Exception e) {
            retorno = e.getLocalizedMessage();
        }
        return retorno;
    }

    //****DELETE***********************************
    public String deleteAndar(Andares a) {//metodo para deletar registro
        String retorno = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("delete from andares where codigo= ?");//comando SQL              
            ps.setInt(1, a.getCodigo());
            ps.execute();//executa o comando SQL

        } catch (Exception e) {
            retorno = e.getLocalizedMessage();
        }
        return retorno;
    }

    //****SELECT ALL*******************
    public List<Andares> listAndares(String o) {//metodo para selecionar todos registros
        List<Andares> list = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("select codigo,numero from andares order by " + o + " asc");//comando SQL
            //o ResultSet é como se fosse uma tabela com um ponteiro, que inicialmente está apontando para a posição -1
            ResultSet rs = ps.executeQuery();//executa a pesquisa
            list = new ArrayList();//inicializa a lista
            while (rs.next()) {//para cada resultado que achou...
                //a partir do ResultSet é possível obter a informação de uma determinada celula.
                //para recuperar uma célula e necessário indicar o nome da coluna e o ponteiro aportar para uma determinada linha, através da função next()
                Andares a1 = new Andares();
                a1.setCodigo(rs.getInt("codigo"));
                a1.setNumero(rs.getString("numero"));

                list.add(a1);//adiciona a lista
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //****SELECT ONE*******************
    public Andares selectAndar(int c) {//metodo para selecionar um registro

        Andares a1 = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("select codigo,numero from andares where codigo= ?");//comando SQL              
            ps.setInt(1, c);
            //ao executar a query o metodo executeQuery retorna um objeto do tipo ResultSet
            //o ResultSet é como se fosse uma tabela com um ponteiro, que inicialmente está apontando para a posição -1
            ResultSet rs = ps.executeQuery();//executa a pesquisa

            if (rs.next()) {//se achar algum resultado
                a1 = new Andares();
                a1.setCodigo(rs.getInt("codigo"));
                a1.setNumero(rs.getString("numero"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return a1;
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------- 
    //METODOS PARA LEITOS
    //****INSERT***************************
    public String insertLeito(Leitos l) {//metodo para inserir um registro
        String retorno = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("insert into leitos (numero,descricao,andar) values (?,?,?)");//comando SQL                   
            ps.setString(1, l.getNumero());
            ps.setString(2, l.getDescricao());
            ps.setInt(2, l.getAndar().getCodigo());
            ps.execute();//executa o comando SQL
            ps = conexao.prepareStatement("select max(codigo) as codigo from leitos");//comando SQL para pegar o codigo gerado no BD
            ResultSet rs = ps.executeQuery();//executa a pesquisa
            if (rs.next()) {//se achar algum resultado
                l.setCodigo(rs.getInt("codigo"));//classe recebe codigo                
            }
        } catch (Exception e) {
            retorno = e.getLocalizedMessage();
        }
        return retorno;
    }

    //****UPDATE***************************
    public String updateLeito(Leitos l) {//metodo para alterar registros
        String retorno = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("update leitos set numero = ?, descricao = ? , andar = ?  where codigo =  ?");//comando SQL          
            ps.setString(1, l.getNumero());
            ps.setString(2, l.getDescricao());
            ps.setInt(3, l.getAndar().getCodigo());
            ps.setInt(4, l.getCodigo());
            System.out.println(retorno);
            ps.execute();//executa o comando SQL

        } catch (Exception e) {
            e.printStackTrace();
            retorno = e.getLocalizedMessage();
        }
        return retorno;
    }

    //****DELETE***********************************
    public String deleteLeito(Leitos l) {//Metodo para deletar registro
        String retorno = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("delete from leitos where codigo= ?");//comando SQL              
            ps.setInt(1, l.getCodigo());
            ps.execute();//executa o comando SQL

        } catch (Exception e) {
            retorno = e.getLocalizedMessage();
        }
        return retorno;
    }

    //****SELECT ALL*******************
    public List<Leitos> listLeitos(String o) {//Metodo para listar todos os registros
        List<Leitos> list = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("select codigo,numero,descricao,andar from leitos order by " + o + " asc");//Comando SQL
            //ao executar a query o metodo executeQuery retorna um objeto do tipo ResultSet
            //o ResultSet é como se fosse uma tabela com um ponteiro, que inicialmente está apontando para a posição -1
            ResultSet rs = ps.executeQuery();//executa a pesquisa
            list = new ArrayList();//inicializa a lista
            while (rs.next()) {//para cada resultado que achou...
                //a partir do ResultSet é possível obter a informação de uma determinada celula.
                //para recuperar uma célula e necessário indicar o nome da coluna e o ponteiro aportar para uma determinada linha, através da função next()
                Leitos l1 = new Leitos();
                l1.setCodigo(rs.getInt("codigo"));
                l1.setNumero(rs.getString("numero"));
                l1.setDescricao(rs.getString("descricao"));
                Andares a1 = new Andares();
                a1.setCodigo(rs.getInt("andar"));
                l1.setAndar(a1);
                list.add(l1);//adiciona a lista
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //****SELECT ONE*******************
    public Leitos selectLeito(int c) {//seleciona um registro 

        Leitos l1 = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("select codigo,numero,descricao,andar from leitos where codigo= ?");//comando SQL              
            ps.setInt(1, c);
            //ao executar a query o metodo executeQuery retorna um objeto do tipo ResultSet
            //o ResultSet é como se fosse uma tabela com um ponteiro, que inicialmente está apontando para a posição -1
            ResultSet rs = ps.executeQuery();//executa a pesquisa
            if (rs.next()) {//se achar algum resultado
                l1 = new Leitos();
                l1.setCodigo(rs.getInt("codigo"));
                l1.setNumero(rs.getString("numero"));
                l1.setDescricao(rs.getString("descricao"));
                Andares a1 = new Andares();
                a1.setCodigo(rs.getInt("andar"));
                l1.setAndar(a1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return l1;
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------- 
    //METODOS PARA PACIENTES
    //****INSERT***************************
    public String insertPaciente(Pacientes p) {//metodo para inserir um registro
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
    public String updatePaciente(Pacientes p) {//metodo para atualizar registros
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

    //****DELETE***********************************
    public String deletePaceintes(Pacientes p) {//metodo para deletar registro
        String retorno = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("delete from pacientes where codigo= ?");//comando SQL              
            ps.setInt(1, p.getCodigo());
            ps.execute();//executa o comando SQL

        } catch (Exception e) {
            retorno = e.getLocalizedMessage();
        }
        return retorno;
    }

    //****SELECT ALL*******************
    public List<Pacientes> listPacientes(String o) {//metodo que seleciona todos os registros
        List<Pacientes> list = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("select codigo,nome,cpf,rg,telefone,celular,endereco,complemento,cep from pacientes order by " + o + " asc");//comando sql
            //ao executar a query o metodo executeQuery retorna um objeto do tipo ResultSet
            //o ResultSet é como se fosse uma tabela com um ponteiro, que inicialmente está apontando para a posição -1
            ResultSet rs = ps.executeQuery();//executa a pesquisa
            list = new ArrayList();//inicializa a lista
            while (rs.next()) {//para cada resultado que achou...
                //a partir do ResultSet é possível obter a informação de uma determinada celula.
                //para recuperar uma célula e necessário indicar o nome da coluna e o ponteiro aportar para uma determinada linha, através da função next()
                Pacientes p1 = new Pacientes();
                p1.setCodigo(rs.getInt("codigo"));
                p1.setNome(rs.getString("nome"));
                p1.setCpf(rs.getString("cpf"));
                p1.setRg(rs.getString("rg"));
                p1.setTelefone(rs.getString("telefone"));
                p1.setCelular(rs.getString("celular"));
                p1.setEndereco(rs.getString("endereco"));
                p1.setComplemento(rs.getString("complemento"));
                p1.setCep(rs.getString("cep"));
                list.add(p1);//adiciona a lista
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //****SELECT ONE*******************
    public Pacientes selectPaciente(int c) {//seleciona um registro

        Pacientes p1 = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("select codigo,nome,cpf,rg,telefone,celular,endereco,complemento,cep from pacientes where codigo= ?");//comando SQL              
            ps.setInt(1, c);
            //ao executar a query o metodo executeQuery retorna um objeto do tipo ResultSet
            //o ResultSet é como se fosse uma tabela com um ponteiro, que inicialmente está apontando para a posição -1
            ResultSet rs = ps.executeQuery();//executa a pesquisa

            if (rs.next()) {//se achar algum resultado
                p1 = new Pacientes();
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

    //------------------------------------------------------------------------------------------------------------------------------------------------------- 
    //METODOS PARA INTERNACOES
    //****INSERT***************************
    public String insertInternacao(Internacoes i) {//metodo para inserir um registro
        String retorno = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("insert into internacoes (motivo,data_baixa,data_alta,paciente,leito,funcionario) values (?,?,?,?,?,?)");
            ps.setString(1, i.getMotivo());
            ps.setDate(2, new java.sql.Date(i.getData_baixa().getTimeInMillis()));
            ps.setDate(3, new java.sql.Date(i.getData_alta().getTimeInMillis()));
            ps.setInt(4, i.getPaciente().getCodigo());
            ps.setInt(5, i.getLeito().getCodigo());
            ps.setInt(6, i.getFuncionario().getCodigo());
            ps.execute();//executa o comando SQL
            ps = conexao.prepareStatement("select max(codigo) as codigo from internacoes");//comando SQL para pegar o codigo gerado no BD
            ResultSet rs = ps.executeQuery();//executa a pesquisa
            if (rs.next()) {//se achar algum resultado
                i.setCodigo(rs.getInt("codigo"));//classe recebe codigo                
            }
        } catch (Exception e) {
            retorno = e.getLocalizedMessage();
        }
        return retorno;
    }

    //****UPDATE***************************
    public String updateInternacao(Internacoes i) {//metodo que atualzia registro
        String retorno = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("update internacoes set motivo=?,data_baixa=?,data_alta=?,paciente=?,leito=?,funcionario=?  where codigo =  ?");//comando SQL          
            ps.setString(1, i.getMotivo());
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            ps.setDate(2, new java.sql.Date(i.getData_baixa().getTimeInMillis()));
            ps.setDate(3, new java.sql.Date(i.getData_alta().getTimeInMillis()));
            ps.setInt(4, i.getPaciente().getCodigo());
            ps.setInt(5, i.getLeito().getCodigo());
            ps.setInt(6, i.getFuncionario().getCodigo());
            ps.setInt(7, i.getCodigo());
            ps.execute();//executa o comando SQL

        } catch (Exception e) {
            retorno = e.getLocalizedMessage();
        }
        return retorno;
    }

    //****DELETE***********************************
    public String deleteInternacao(Internacoes i) {//metodo de deletar registro
        String retorno = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("delete from internacoes where codigo= ?");//comando SQL              
            ps.setInt(1, i.getCodigo());
            ps.execute();//executa o comando SQL

        } catch (Exception e) {
            retorno = e.getLocalizedMessage();
        }
        return retorno;
    }

    //****SELECT ALL*******************
    public List<Internacoes> listInternacoes(String o) {//metodo para selecionar todos os registros
        List<Internacoes> list = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("select codigo,motivo,data_baixa,data_alta,paciente,leito,funcionario from internacoes order by " + o + " asc");//comando SQL
            //ao executar a query o metodo executeQuery retorna um objeto do tipo ResultSet
            //o ResultSet é como se fosse uma tabela com um ponteiro, que inicialmente está apontando para a posição -1
            ResultSet rs = ps.executeQuery();//executa a pesquisa
            list = new ArrayList();//inicializa a lista
            while (rs.next()) {//para cada resultado que achou...
                //a partir do ResultSet é possível obter a informação de uma determinada celula.
                //para recuperar uma célula e necessário indicar o nome da coluna e o ponteiro aportar para uma determinada linha, através da função next()
                Internacoes i1 = new Internacoes();
                i1.setCodigo(rs.getInt("codigo"));
                i1.setMotivo(rs.getString("motivo"));

                if (rs.getDate("data_baixa") != null) {
                    Calendar ca = Calendar.getInstance();//cria um objeto do tipo calendario
                    ca.setTime(rs.getDate("data_baixa"));//calendario recebe o objeto tipo Date     
                    i1.setData_baixa(ca);//classe recebe o objeto tipo calendario
                }
                if (rs.getDate("data_alta") != null) {
                    Calendar ca = Calendar.getInstance();//cria um objeto do tipo calendario
                    ca.setTime(rs.getDate("data_alta"));//calendario recebe o objeto tipo Date     
                    i1.setData_alta(ca);//classe recebe o objeto tipo calendario
                }
                Pacientes p1 = new Pacientes();
                p1.setCodigo(rs.getInt("paciente"));
                i1.setPaciente(p1);

                Leitos l1 = new Leitos();
                l1.setCodigo(rs.getInt("leito"));
                i1.setLeito(l1);

                Funcionario f1 = new Funcionario();
                f1.setCodigo(rs.getInt("funcionario"));
                i1.setFuncionario(f1);

                list.add(i1);//adiciona a lista
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //****SELECT ONE*******************
    public Internacoes selectInternacao(int c) {//metodo de seleção de um registro

        Internacoes i1 = null;
        try {
            PreparedStatement ps = conexao.prepareStatement("select codigo,motivo,data_baixa,data_alta,paciente,leito,funcionario from internacoes where codigo= ?");//comando SQL              
            ps.setInt(1, c);
            //ao executar a query o metodo executeQuery retorna um objeto do tipo ResultSet
            //o ResultSet é como se fosse uma tabela com um ponteiro, que inicialmente está apontando para a posição -1
            ResultSet rs = ps.executeQuery();//executa a pesquisa

            if (rs.next()) {//se achar algum resultado
                i1 = new Internacoes();
                i1.setCodigo(rs.getInt("codigo"));
                i1.setMotivo(rs.getString("motivo"));
                
                
                if (rs.getDate("data_baixa") != null) {
                    Calendar ca = Calendar.getInstance();//cria um objeto do tipo calendario
                    ca.setTime(rs.getDate("data_baixa"));//calendario recebe o objeto tipo Date     
                    i1.setData_baixa(ca);//classe recebe o objeto tipo calendario
                }
                if (rs.getDate("data_alta") != null) {
                    Calendar ca = Calendar.getInstance();//cria um objeto do tipo calendario
                    ca.setTime(rs.getDate("data_alta"));//calendario recebe o objeto tipo Date     
                    i1.setData_alta(ca);//classe recebe o objeto tipo calendario
                }
                
     
                Pacientes p1 = new Pacientes();
                p1.setCodigo(rs.getInt("paciente"));
                i1.setPaciente(p1);

                Leitos l1 = new Leitos();
                l1.setCodigo(rs.getInt("leito"));
                i1.setLeito(l1);

                Funcionario f1 = new Funcionario();
                f1.setCodigo(rs.getInt("funcionario"));
                i1.setFuncionario(f1);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return i1;
    }

}
