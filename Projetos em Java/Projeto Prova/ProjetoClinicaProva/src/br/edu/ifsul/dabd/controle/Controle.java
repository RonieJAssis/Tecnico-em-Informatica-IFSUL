
package br.edu.ifsul.dabd.controle;

import br.edu.ifsul.dabd.model.dao.Conexao;
import br.edu.ifsul.dabd.gui.JFramePrincipal;
import br.edu.ifsul.dabd.gui.JMenuBarPrincipal;
import br.edu.ifsul.dabd.gui.JPanelHome;
import br.edu.ifsul.dabd.gui.funcionario.JPanelFuncionario;
import br.edu.ifsul.dabd.gui.login.JPanelLogin;
import br.edu.ifsul.dabd.gui.pacientes.JPanelPaciente;
import javax.swing.JOptionPane;

/**
 *
 * @author Telmo Junior
 */
public class Controle {
    
    private Conexao conexao;
    private JFramePrincipal frame; 
    private JPanelLogin login;
    private JPanelHome home;
    private JMenuBarPrincipal menu;
    private JPanelFuncionario funcionario;
    private JPanelPaciente paciente;
    
    
    public Controle(){
        this.conexao = new Conexao();
        String ret = conexao.abreConexao();
        if(ret == null){
            //conectou no banco de dados
            this.frame = new JFramePrincipal(this);
            
            this.login = new JPanelLogin(this);//passando como parametro
           //a instancia de Controle
           
           this.home = new JPanelHome(this);
           
           this.funcionario = new JPanelFuncionario(this);
           this.paciente = new JPanelPaciente(this);
           
           frame.addCartaBaralho(home, "tela_home");
           frame.addCartaBaralho(login, "tela_login");
           frame.addCartaBaralho(funcionario, "tela_funcionario");
           frame.addCartaBaralho(paciente, "tela_paciente");
           
           frame.mostraCartaBaralho("tela_login");//mostra a carta "painel"
           
           menu = new JMenuBarPrincipal(this);//inicializa o menu principal
           
           
           
           
           frame.setVisible(true);//torna visível o JFrame
     
        }else{
            //não conectou no Banco de Dados
            JOptionPane.showMessageDialog(null, "Não conectou: "+ret, "Conexão", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Conexao getConexao(){
        return this.conexao;
    }
    
    public void showTela(String nomeTela){
        frame.mostraCartaBaralho(nomeTela);
    }
    
    public void addMenuBar(){
        frame.setJMenuBar(menu);
    }
    
}
