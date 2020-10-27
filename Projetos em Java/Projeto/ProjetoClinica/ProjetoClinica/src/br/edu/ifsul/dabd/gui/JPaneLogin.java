/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dabd.gui;

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
 *
 * @author 20172210032
 */
public class JPaneLogin extends JPanel implements ActionListener{
    //duas caixas de textos
    //um botão
    //dois rotulos
    private JTextField txtLogin;
    private JTextField txtSenha;
    private JButton btnLogar;
    private JLabel lblLogin;
    private JLabel lblSenha;
    //irá organizar o posicionamento dos componentes baseando-se em uma matriz,onde a posição 0,0 fica no meio do painel
    private GridBagLayout layoutGridBag;
    private Controle controle;
    
    //inicializar os atributos globais
    public JPaneLogin(Controle c) {
      this.controle = c;  
      this.initComponents();//chama o metodo para iniciar os componentes e posiciona-los no painel (this)
    }
    public void initComponents(){
        this.layoutGridBag = new GridBagLayout();
        this.setLayout(layoutGridBag);//seta o gerenciador no painel
        //inicializar e posicionar
        this.txtLogin = new JTextField(20);
        this.txtSenha = new JTextField(20);
        this.btnLogar = new JButton("Logar");
        this.lblLogin = new JLabel("Login:");
        this.lblSenha = new JLabel("Senha:");
        this.btnLogar.addActionListener(this);//adiciona o listnner para escutar o evento
        this.btnLogar.setActionCommand("logar");//defini o comando de acao,para filtrar
        
        
        GridBagConstraints gbc= new GridBagConstraints();
        gbc.gridx = 0;//coluna
        gbc.gridy = 0;//linha
        this.add(lblLogin,gbc);
        
        gbc= new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(txtLogin,gbc);
        
        gbc= new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(lblSenha,gbc);
        
        gbc= new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(txtSenha,gbc);
        
        gbc= new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(btnLogar,gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(btnLogar.getActionCommand())){
            String au = txtLogin.getText().trim();
            String as = txtSenha.getText().trim();
            if ("".equals(au) || "".equals(as)) {//valida o preenchimento de usuario e a senha
               JOptionPane.showMessageDialog(this,"preencha todos os campos","mensagem",JOptionPane.INFORMATION_MESSAGE); 
            }
            else{
                Funcionario f = this.controle.getConexao().getLogin(au, as);
                if (f!=null) {
                  JOptionPane.showMessageDialog(this,"conectou","mensagem",JOptionPane.INFORMATION_MESSAGE);   
                }
                else{
                    
                }
               JOptionPane.showMessageDialog(this,"não conectou","mensagem",JOptionPane.INFORMATION_MESSAGE);  
            }
            
        }
    }
    
}
