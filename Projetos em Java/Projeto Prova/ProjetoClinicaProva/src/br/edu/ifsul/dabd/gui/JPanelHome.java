/*
 * 
 */
package br.edu.ifsul.dabd.gui;

import br.edu.ifsul.dabd.controle.Controle;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Telmo Junior
 */
public class JPanelHome extends JPanel{
    
    private Controle controle;
    private JLabel lblImage;
    private BorderLayout border;
    
    public JPanelHome(Controle c){
        
        this.controle = c;
        initComponents();
                
        
    }
    private void initComponents(){
        lblImage = new JLabel("Boas Festas !!! Feliz Natal !!");
        this.add(lblImage);
        
    }
}
