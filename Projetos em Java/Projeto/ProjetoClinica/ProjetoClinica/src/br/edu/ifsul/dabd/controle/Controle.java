/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dabd.controle;

import br.edu.ifsul.dabd.gui.JFramePrincipal;
import br.edu.ifsul.dabd.model.dao.Conexao2;
import javax.swing.JOptionPane;

/**
 *
 * @author 20172210032
 */
public class Controle {

    private  Conexao2 conexao;
    private JFramePrincipal frame;
    //private JPaneLogin
    
    public Controle() {
      this.conexao =  new Conexao2();
      String ret = conexao.abreConexao();
        if (ret==null) {
            //conectou ao BD
            this.frame = new JFramePrincipal(this);
        }
        else{
            //não conectou no BD
            JOptionPane.showMessageDialog(null,"Não conectou: "+ret,"Conexão",JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public Conexao2 getConexao() {
        return conexao;
    }
    
}
