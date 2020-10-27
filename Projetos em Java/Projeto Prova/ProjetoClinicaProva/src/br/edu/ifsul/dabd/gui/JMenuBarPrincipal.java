/*
 * 
 */
package br.edu.ifsul.dabd.gui;

import br.edu.ifsul.dabd.controle.Controle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author Telmo Junior
 */
public class JMenuBarPrincipal extends JMenuBar implements ActionListener{
    
    private JMenu menuArquivo;
    private JMenu menuCadastro;
    private JMenu menuRelatorios;
    private JMenuItem menuItemSair;
    private JMenuItem menuItemFuncionario;
    private JMenuItem menuItemPaciente;
    private Controle controle;
    public JMenuBarPrincipal(Controle c){
        this.controle = c;
        initComponents();
    }
    private void initComponents(){
        this.menuArquivo = new JMenu("Arquivo");
        this.menuCadastro = new JMenu("Cadastros");
        this.menuRelatorios = new JMenu("Relatórios");
        this.menuItemSair = new JMenuItem("Sair");//inicializando
        this.menuItemSair.addActionListener(this);
        this.menuItemSair.setActionCommand("comando_sair");
        this.menuArquivo.add(menuItemSair);//adicionando o Sair no Arquivo
        this.add(menuArquivo);//adiciona o menu Arquivo na barra
        
        this.menuItemFuncionario = new JMenuItem("Funcionários");
        this.menuCadastro.add(menuItemFuncionario);
        //adicionar o Listener e o comando de ação
        
        this.menuItemPaciente = new JMenuItem("Pacientes");
        this.menuCadastro.add(menuItemPaciente);
        
        this.menuItemFuncionario.addActionListener(this);
        this.menuItemFuncionario.setActionCommand("comando_funcionario");
        
        this.menuItemPaciente.addActionListener(this);
        this.menuItemPaciente.setActionCommand("comando_paciente");
        
        this.add(menuCadastro);
        this.add(menuRelatorios);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
       //Tema
       //filtrar o evento do menuItemFuncionario
       //mostrar a tela JPanelFuncionario atraves do Controle
       //o construtor dessa classe deverá receber uma instancia de Controle
       
       if(e.getActionCommand().equals(menuItemSair.getActionCommand())){
           //DEVERÁ FECHAR A CONEXAO COM O BANCO DE DADOS
           //FECHAR O PROCESSO.
           
       }else if(e.getActionCommand().equals(menuItemFuncionario.getActionCommand())){
           
           //CHAMAR O METODO SHOWTELA DA CLASSE CONTROLE
           //E PASSAR O NOME DA CARTA
           this.controle.showTela("tela_funcionario");
       }else if(e.getActionCommand().equals(menuItemPaciente.getActionCommand())){
           
           //CHAMAR O METODO SHOWTELA DA CLASSE CONTROLE
           //E PASSAR O NOME DA CARTA
           this.controle.showTela("tela_paciente");
       }
        
        
    }
}
