/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dabd.gui.pacientes;
import br.edu.ifsul.dabd.model.Funcionario;
import br.edu.ifsul.dabd.model.Paciente;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 20172210032
 */
public class JPanelListagemPaciente extends javax.swing.JPanel {
    
    private JPanelPaciente pnlPaciente;
    /**
     * Creates new form JPanelListagemPaciente
     */
    public JPanelListagemPaciente() {
        initComponents();
    }
    
    public JPanelListagemPaciente(JPanelPaciente p) {
        this.pnlPaciente = p;
        initComponents();
        populaTabela();
    }
    public void populaTabela(){
        //recuperar a lista de objetos do tipo Funcionario, a partir do BD
        List<Paciente> lista = pnlPaciente.getControle().getConexao().listPacientes();
        //recupera o modelo da tabela
        DefaultTableModel modeloTabela =  (DefaultTableModel) tblListagem.getModel();
        modeloTabela.setNumRows(0);//remove as linhas da tabela
        for(Paciente p: lista){
            //adiciona linhas na tabela
            modeloTabela.addRow(new Object[]{p.getCodigo(), p.getNome(), p.getCpf(),p.getTelefone(),p.getCep()});
        }
        
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSuperior = new javax.swing.JPanel();
        lblFiltrarNome = new javax.swing.JLabel();
        txfFiltrar = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JToggleButton();
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
                "Codigo", "Nome", "CPF", "Telefone", "Cep"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scpRolagem.setViewportView(tblListagem);

        add(scpRolagem, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
             Integer linhaSelecionada = tblListagem.getSelectedRow();
           if(linhaSelecionada > -1){
             Integer codigoUsuario = Integer.parseInt(tblListagem.getValueAt(linhaSelecionada, 0).toString());
             //chamar o metodo da classe conexao para remover
             //atualizar a tabela.
             Paciente p = new Paciente();
             p.setCodigo(codigoUsuario);
             String ret = pnlPaciente.getControle().getConexao().deletePaciente(p);
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

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
            Integer linhaSelecionada = tblListagem.getSelectedRow();
           if(linhaSelecionada > -1){
            Integer codigoUsuario = Integer.parseInt(tblListagem.getValueAt(linhaSelecionada, 0).toString());
              Paciente p = pnlPaciente.getControle().getConexao().selectPaciente(codigoUsuario);
              //setar os dados na tela de edicao!!!!!!!
              pnlPaciente.getEdicao().setDadosFormulario(p);
              
              pnlPaciente.showTela("tela_edicao");
           }else{
               JOptionPane.showMessageDialog(this, "Selecione linha !!", "Selecionar", JOptionPane.INFORMATION_MESSAGE);
           }
                  // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
            pnlPaciente.getEdicao().setDadosFormulario(null);//limpa o formulário
            pnlPaciente.showTela("tela_edicao");        // TODO add your handling code here:
    }//GEN-LAST:event_btnNovoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JToggleButton btnFiltrar;
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
