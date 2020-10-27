/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dabd.gui;
import br.edu.ifsul.dabd.controle.Controle;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 20172210032
 */
public class JFramePrincipal extends JFrame{

    private CardLayout layoutCard;
    private Controle controle;
    private JPanel pnlCard;
    private JPaneLogin login;
   //essa classe será um formulario (JFrame). O unico no projeto
    public JFramePrincipal(Controle c) {//recebe um apramentro do tipo controle
        this.initComponent();
        this.controle = c ;
    }
    //esse método ira incializar os componentes para o JFrame
    public void initComponent(){
        //irá setar o titulo do formulario
        this.setTitle("Sisteminha para o Hospital");
        
        //irá abrir o Formulario(JFrame) em modo maximizado
        //padrão é minimizado,por isso usamos este metodo
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Ao fechar o JFrame finaliza o processo
        
        this.pnlCard = new JPanel();//inicia pnlCard
                
        this.layoutCard = new CardLayout();//inicia layoutCard
        
        this.pnlCard.setLayout(layoutCard);//pnlCard agora será um "baralho"
        
        this.add(pnlCard);//adiciona o pnlCard na propia classe
        
        this.login = new JPaneLogin(this.controle);
        
        addCartaBaralho(login,"tela_login");
        
        mostraCartaBaralho("tela_login");
        
        this.setVisible(true);//torna visivel
    }
    private void addCartaBaralho(JPanel p, String n){//adiciona uma carta ao baralho
        pnlCard.add(p,n);
    }
    private void mostraCartaBaralho(String n){//vai mostrar uma determinada carta do baralho
       layoutCard.show(this.pnlCard,n);        
    }
      
}
