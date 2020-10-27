/*
 * 
 */
package br.edu.ifsul.dabd.gui.funcionario;

import br.edu.ifsul.dabd.model.Funcionario;
import javax.swing.JOptionPane;

/**
 *
 * @author Telmo
 */
public class JPanelEdicaoFuncionario extends javax.swing.JPanel {

    private JPanelFuncionario pnlFuncionario;
    /**
     * Creates new form JPanelEdicaoFuncionario
     */
    public JPanelEdicaoFuncionario() {
        initComponents();
    }
    
    public JPanelEdicaoFuncionario(JPanelFuncionario f) {
        this.pnlFuncionario = f;
        initComponents();
    }
    
    public void  setDadosFormulario(Funcionario f){
        if(f == null){
            txfCodigo.setText("");
            txfNome.setText("");
            txfUsuario.setText("");
            psfSenha.setText("");
        }else{
            txfCodigo.setText(f.getCodigo().toString());
            txfNome.setText(f.getNome());
            txfUsuario.setText(f.getLogin());
            psfSenha.setText(f.getSenha());
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
        java.awt.GridBagConstraints gridBagConstraints;

        pnlInferior = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        bntCancelar = new javax.swing.JButton();
        pnlCentro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txfNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txfUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        psfSenha = new javax.swing.JPasswordField();

        setLayout(new java.awt.BorderLayout());

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        pnlInferior.add(btnSalvar);

        bntCancelar.setText("Cancelar");
        bntCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCancelarActionPerformed(evt);
            }
        });
        pnlInferior.add(bntCancelar);

        add(pnlInferior, java.awt.BorderLayout.PAGE_END);

        pnlCentro.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Código");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 2);
        pnlCentro.add(jLabel1, gridBagConstraints);

        txfCodigo.setEditable(false);
        txfCodigo.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        pnlCentro.add(txfCodigo, gridBagConstraints);

        jLabel2.setText("Nome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        pnlCentro.add(jLabel2, gridBagConstraints);

        txfNome.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        pnlCentro.add(txfNome, gridBagConstraints);

        jLabel3.setText("Usuário");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 7);
        pnlCentro.add(jLabel3, gridBagConstraints);

        txfUsuario.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        pnlCentro.add(txfUsuario, gridBagConstraints);

        jLabel4.setText("Senha");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        pnlCentro.add(jLabel4, gridBagConstraints);

        psfSenha.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlCentro.add(psfSenha, gridBagConstraints);

        add(pnlCentro, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String nome = txfNome.getText().trim();
        String login = txfUsuario.getText().trim();
        String senha = psfSenha.getText().trim();
         //criar um objeto do tipo Funcionario
            //setar as informações nos seus atributos
            //chamar o metodo insertFuncionario da classe Conexao
            //verificar e inseriu e atualizar a listagem
        if(nome.length() > 0 && login.length() > 0 && senha.length() > 0){
            Funcionario f = new Funcionario();
            f.setNome(nome);
            f.setLogin(login);
            f.setSenha(senha);
            //testar a acao: inserir novo ou editar existente
            String ret;
            String acao;
            if(txfCodigo.getText().trim().length() > 0){
                f.setCodigo(Integer.parseInt(txfCodigo.getText().trim()));//adiciona o codigo do funcionario
                ret = pnlFuncionario.getControle().getConexao().updateFuncionario(f);
                acao = "Editou";
            }else{
                ret = pnlFuncionario.getControle().getConexao().insertFuncionario(f);
                acao = "Inseriu";
            }
            if(ret == null){
                JOptionPane.showMessageDialog(this, acao+" Funcionario!", acao, JOptionPane.INFORMATION_MESSAGE);
                //atualiza a listagem
                pnlFuncionario.getListagem().populaTabela();
                pnlFuncionario.showTela("tela_listagem");
                
            }else{
                JOptionPane.showMessageDialog(this, "Erro ao inserior Funcionario :"+ret, "Inserção", JOptionPane.ERROR_MESSAGE);
            }
           
            
        }else{
            JOptionPane.showMessageDialog(this, "Preencha o formulário!!", "Formulário", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void bntCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCancelarActionPerformed
        pnlFuncionario.showTela("tela_listagem");
    }//GEN-LAST:event_bntCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlInferior;
    private javax.swing.JPasswordField psfSenha;
    private javax.swing.JTextField txfCodigo;
    private javax.swing.JTextField txfNome;
    private javax.swing.JTextField txfUsuario;
    // End of variables declaration//GEN-END:variables
}
