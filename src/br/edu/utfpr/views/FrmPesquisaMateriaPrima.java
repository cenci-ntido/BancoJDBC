package br.edu.utfpr.views;

import br.edu.utfpr.dao.ClassesDao.MateriaPrimaDao;
import br.edu.utfpr.entidades.MateriaPrima;
import br.edu.utfpr.models.MateriaPrimaListModel;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class FrmPesquisaMateriaPrima extends javax.swing.JInternalFrame {

    private MateriaPrimaListModel materiaPrimaListModel;
    private List<MateriaPrima> listaMateriaPrima;
    private boolean edit = false;

    public FrmPesquisaMateriaPrima() {
        initComponents();
        super.setTitle("Tela de Matéria Prima");
        MateriaPrimaDao materiaPrimaDao = new MateriaPrimaDao();
        listaMateriaPrima = materiaPrimaDao.findAll();
        materiaPrimaListModel = new MateriaPrimaListModel(listaMateriaPrima);
        tbMp.setModel(materiaPrimaListModel);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfFiltro = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMp = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnIncluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pesquisa de Matérias Primas");

        jLabel1.setText("Filtrar por descrição:");

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/icons/arquivo-de-documento.png"))); // NOI18N
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        tbMp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbMp);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/icons/document-add.png"))); // NOI18N
        btnIncluir.setText("Novo");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });
        jPanel2.add(btnIncluir);

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/icons/editar.png"))); // NOI18N
        btnAlterar.setText("Editar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAlterar);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/icons/lixo.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(btnExcluir);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        FrmMateriaPrima frmMateriaPrima = new FrmMateriaPrima(null, true, materiaPrimaListModel);
        frmMateriaPrima.setLocationRelativeTo(null);
        frmMateriaPrima.setVisible(true);
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        editar();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        filtro();
    }//GEN-LAST:event_btnPesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbMp;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables

    private void excluir() {
        int linhaSelecionada = tbMp.getSelectedRow(); //pega a linha selecionada na JTable
        if (linhaSelecionada >= 0) { // se uma linha foi selecionada
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir a MP selecionada?",
                    "Exclusão",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcao == JOptionPane.YES_OPTION) {
                int idMp = (int) tbMp.getValueAt(linhaSelecionada, 0);
                MateriaPrimaDao materiaPrimaDao = new MateriaPrimaDao();
                if (materiaPrimaDao.delete(idMp)) {
                    JOptionPane.showMessageDialog(null, "MP excluído com sucesso!");
                    materiaPrimaListModel.removeModel(linhaSelecionada);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma MP para excluir!");
        }
    }

    private void editar() {
        edit = true;
        int linhaSelecionada = tbMp.getSelectedRow();
        if (linhaSelecionada >= 0) {
            int idMp = (int) tbMp.getValueAt(linhaSelecionada, 0);
            MateriaPrimaDao materiaPrimaDao = new MateriaPrimaDao();
            MateriaPrima mp = materiaPrimaDao.findById(idMp);
            FrmMateriaPrima frmMateriaPrima = new FrmMateriaPrima(null, edit, materiaPrimaListModel, mp, linhaSelecionada);
            frmMateriaPrima.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Selecione a compra que deseja editar!");
        }
    }

    private void filtro() {
        List<MateriaPrima> listaFiltrada = listaMateriaPrima.stream().map(mp
                -> mp.getDescricao()== tfFiltro.getText());
       

        System.out.println(listaFiltrada.toString());
    }
}
