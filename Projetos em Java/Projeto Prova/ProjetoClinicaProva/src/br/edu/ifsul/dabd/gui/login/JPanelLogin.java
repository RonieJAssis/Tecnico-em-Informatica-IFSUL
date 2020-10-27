
package br.edu.ifsul.dabd.gui.login;

import br.edu.ifsul.dabd.controle.Controle;
import br.edu.ifsul.dabd.model.Funcionario;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Telmo Júnior
 */
public class JPanelLogin extends JPanel implements ActionListener{
    //duas caixas de texto
    //um botão
    //dois rótulos
    private JTextField txfLogin;
    private JTextField txfSenha;
    private JButton btnLogar;
    private JLabel lblLogin;
    private JLabel lblSenha;
    //irá organizar o posicionamento do componentos baseando-se
    //em uma matriz, onde a posição 0,0 fica no meio do painel.
    private GridBagLayout layoutGridBag;
    //inicializar os atributos globais!!!
    
    private Controle controle;//atributo global que irá receber uma instancia
    //quando o construtor for chamado.
    
    public JPanelLogin(Controle c){ 
        this.controle = c;
        initComponents();//chama o metódo para iniciar os componentes
        //e posiciona-los no painel (this)
    }
    private void initComponents(){
        layoutGridBag = new GridBagLayout();
        this.setLayout(layoutGridBag);//seta o gerenciador no painel
        //iniciar e posicionar
        this.txfLogin = new JTextField(20);
        this.txfSenha = new JTextField(20);
        this.lblLogin = new JLabel("Login:");
        this.lblSenha = new JLabel("Senha:");
        this.btnLogar = new JButton("Logar");
        
        this.btnLogar.addActionListener(this);//adiciona o Listnner para escutar os eventos
        this.btnLogar.setActionCommand("logar");//defini o comando de acao, para filtrar
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;//linha
        gbc.gridx = 0;//coluna
        this.add(lblLogin, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridy = 0;//linha
        gbc.gridx = 1;//coluna
        this.add(txfLogin, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridy = 1;//linha
        gbc.gridx = 0;//coluna
        this.add(lblSenha, gbc); 
        
        gbc = new GridBagConstraints();
        gbc.gridy = 1;//linha
        gbc.gridx = 1;//coluna
        this.add(txfSenha, gbc); 
        
        gbc = new GridBagConstraints();
        gbc.gridy = 2;//linha
        gbc.gridx = 1;//coluna
        this.add(btnLogar, gbc); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals(btnLogar.getActionCommand())){
        
            String auxUsuario = txfLogin.getText().trim();
            String auxSenha = txfSenha.getText().trim();
            //validar o preenchimento do Usuario e a Senha
            if(!auxUsuario.equals("") && !auxSenha.equals("")){
                
              Funcionario f =  controle.getConexao().doLogin(txfLogin.getText().trim(), txfSenha.getText().trim());
              if(f != null){
                  //autenticou com sucesso
                  controle.showTela("tela_home");
                  controle.addMenuBar();//adiciona o menu principal
              }else{
                //não encontrou usuario
                JOptionPane.showMessageDialog(this, "Usuário e/ou Senha inválidos!", "Informe", JOptionPane.WARNING_MESSAGE);
              }
              
                //Tema de Casa
                //acessar o metodo doLogin da classe Conexao
                //então o método JPanelLogin deverá receber no seu construtor
                //a instancia de controle..
                //controle, por sua vez, deverá ter um metodo que retorne a instancia de
                //conexao.
            }else{
            JOptionPane.showMessageDialog(this, "Informe Usuário e/ou Senha", "Informe", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        
    }
}









