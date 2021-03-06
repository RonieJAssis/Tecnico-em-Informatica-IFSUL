/*
 * 
 */
package br.edu.ifsul.dabd.gui.funcionario;

import br.edu.ifsul.dabd.controle.Controle;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Telmo Junior
 */
public class JPanelFuncionario extends JPanel{
    //esse contrutor devera receber também a instancia de Controle
    
    private Controle controle; 
    private CardLayout cardLayout; 
    private JPanelListagemFuncionario listagem;
    private JPanelEdicaoFuncionario edicao;
    
    public JPanelFuncionario(Controle c){
        this.controle = c;
        initComponents();
    }
    private void initComponents(){
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        listagem = new JPanelListagemFuncionario(this);
        edicao = new JPanelEdicaoFuncionario(this);
        //adicionar as cartas nesse baralho.
        this.add(listagem, "tela_listagem");
        this.add(edicao, "tela_edicao");
        
        //mostra uma determinada carta
        showTela("tela_listagem");
    }
    
    //muda a carta, esse metodo será acessado pelas classes JPanelListagemFuncionario e JPanelEdicaoFuncionario
    public void showTela(String carta){
        cardLayout.show(this, carta);
    }
   //libera acesso ao Controle para o JPanelListagemFuncionario e JPanelEdicaoFuncionario
   public Controle getControle(){
       return this.controle;
   }
   //retorna o JPanelListagemFuncionario para a tela de edição poder atualizar a tabela.
   public JPanelListagemFuncionario getListagem(){
       return listagem;
   }
   //para o JPanelListagemFuncionario setar os dados do funcionario
   public JPanelEdicaoFuncionario getEdicao(){
       return edicao;
   }
    
    
}
