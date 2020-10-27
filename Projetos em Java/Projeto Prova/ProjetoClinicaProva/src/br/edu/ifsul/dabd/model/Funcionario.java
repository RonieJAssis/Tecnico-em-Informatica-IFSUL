
package br.edu.ifsul.dabd.model;

/**
 *
 * @author Telmo
 */

public class Funcionario {

    private Integer codigo;
    private String login;
    private String senha;
    private String nome;
    
    //construtor da classe Funcionario
    //nesse caso nao recebe parâmetros
    
    public Funcionario(){
        
    }
    

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
