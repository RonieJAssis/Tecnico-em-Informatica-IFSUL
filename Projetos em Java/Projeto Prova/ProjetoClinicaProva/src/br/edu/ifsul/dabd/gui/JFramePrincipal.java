
package br.edu.ifsul.dabd.gui;

import br.edu.ifsul.dabd.controle.Controle;
import br.edu.ifsul.dabd.gui.login.JPanelLogin;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Telmo Junior
 */
public class JFramePrincipal extends JFrame{
    //essa classe será um Formulário (JFrame). O único no projeto.
    
    private CardLayout cardLayout;
    private JPanel pnlCard;
    private Controle controle;
    
    
    public JFramePrincipal(Controle c){//recebe um parametro
        this.controle = c;
        initComponents();
    }
    //esse método irá inicializar os componentes para o JFrame
    public void initComponents(){
        //irá setar o titulo do Formulário
        this.setTitle("Sisteminha para o Hospital");
        
        //irá abrir o Formulário (JFrame) em modo maximizado.
        //o padrão é abrir minimizado, por isso precisamos maximizar
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        
        //fecha a interface grafica e finaliza o processo
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        cardLayout = new CardLayout();
        pnlCard = new JPanel();
        pnlCard.setLayout(cardLayout);//o pnlCard agora será um "baralho"
        this.add(pnlCard);//adiciona no frame o pnlCard
        
      
    }
    
    public void addCartaBaralho(JPanel painel, String n){
        pnlCard.add(painel, n);
    }
    public void mostraCartaBaralho(String nome){
        cardLayout.show(this.pnlCard, nome);
    }
    
    
}
