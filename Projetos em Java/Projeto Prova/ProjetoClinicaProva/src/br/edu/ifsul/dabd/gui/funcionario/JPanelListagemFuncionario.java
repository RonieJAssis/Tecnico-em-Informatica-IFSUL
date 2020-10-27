/*
 * 
 */
package br.edu.ifsul.dabd.gui.funcionario;

import br.edu.ifsul.dabd.model.Funcionario;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Telmo
 */
public class JPanelListagemFuncionario extends javax.swing.JPanel {

    private JPanelFuncionario pnlFuncionario;
    /**
     * Creates new form JPanelListagemFuncionario
     */
    public JPanelListagemFuncionario() {
        initComponents();
    }

    //esse construtor é o que está sendo utilizado.
    public JPanelListagemFuncionario(JPanelFuncionario f) {
        this.pnlFuncionario = f;
        initComponents();
        populaTabela();
    }
    public void populaTabela(){
        //recuperar a lista de objetos do tipo Funcionario, a partir do BD
        List<Funcionario> lista = pnlFuncionario.getControle().getConexao().listFuncionarios();
        //recupera o modelo da tabela
        DefaultTableModel modeloTabela =  (DefaultTableModel) tblListagem.getModel();
        modeloTabela.setNumRows(0);//remove as linhas da tabela
        for(Funcionario f: lista){
            //adiciona linhas na tabela
            modeloTabela.addRow(new Object[]{f.getCodigo(), f.getNome(), f.getLogin()});
        }
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSuperior = new javax.swing.JPanel();
        lblFiltrarNome = new javax.swing.JLabel();
        txfFiltrar = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();
        pnlInferior = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        scpRolagem = new javax.swing.JScrollPane();
        tblListagem = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        lblFiltrarNome.setText("Filtrar por Nome:");
        pnlSuperior.add(lblFiltrarNome);

        txfFiltrar.setColumns(20);
        pnlSuperior.add(txfFiltrar);

        btnFiltrar.setText("Filtrar");
        pnlSuperior.add(btnFiltrar);

        add(pnlSuperior, java.awt.BorderLayout.PAGE_START);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        pnlInferior.add(btnNovo);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        pnlInferior.add(btnEditar);

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        pnlInferior.add(btnRemover);

        add(pnlInferior, java.awt.BorderLayout.PAGE_END);

        tblListagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Usuário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scpRolagem.setViewportView(tblListagem);

        add(scpRolagem, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        pnlFuncionario.getEdicao().setDadosFormulario(null);//limpa o formulário
        pnlFuncionario.showTela("tela_edicao");
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
          Integer linhaSelecionada = tblListagem.getSelectedRow();
           if(linhaSelecionada > -1){
            Integer codigoUsuario = Integer.parseInt(tblListagem.getValueAt(linhaSelecionada, 0).toString());
              Funcionario f = pnlFuncionario.getControle().getConexao().getFuncionario(codigoUsuario);
              //setar os dados na tela de edicao!!!!!!!
              pnlFuncionario.getEdicao().setDadosFormulario(f);
              
              pnlFuncionario.showTela("tela_edicao");
           }else{
               JOptionPane.showMessageDialog(this, "Selecione linha !!", "Selecionar", JOptionPane.INFORMATION_MESSAGE);
           }
          
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
           Integer linhaSelecionada = tblListagem.getSelectedRow();
           if(linhaSelecionada > -1){
             Integer codigoUsuario = Integer.parseInt(tblListagem.getValueAt(linhaSelecionada, 0).toString());
             //chamar o metodo da classe conexao para remover o Funcionario
             //atualizar a tabela.
             Funcionario f = new Funcionario();
             f.setCodigo(codigoUsuario);
             String ret = pnlFuncionario.getControle().getConexao().deleteFuncionario(f);
               if(ret == null){
                   JOptionPane.showMessageDialog(this, "Removeu com sucesso", "Remoção", JOptionPane.INFORMATION_MESSAGE);
                   populaTabela();
               }else{
                   JOptionPane.showMessageDialog(this, "Erro ao remover: "+ret, "Remoção", JOptionPane.INFORMATION_MESSAGE);
               }               
           }else{
               JOptionPane.showMessageDialog(this, "Selecione linha !!", "Selecionar", JOptionPane.INFORMATION_MESSAGE);
           }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel lblFiltrarNome;
    private javax.swing.JPanel pnlInferior;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JScrollPane scpRolagem;
    private javax.swing.JTable tblListagem;
    private javax.swing.JTextField txfFiltrar;
    // End of variables declaration//GEN-END:variables
}
