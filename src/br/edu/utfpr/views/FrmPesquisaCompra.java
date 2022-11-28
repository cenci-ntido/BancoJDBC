package br.edu.utfpr.views;

import br.edu.utfpr.dao.ClassesDao.CompraDao;
import br.edu.utfpr.dao.ClassesDao.MateriaPrimaDao;
import br.edu.utfpr.entidades.Compra;
import br.edu.utfpr.entidades.MateriaPrima;
import br.edu.utfpr.formataData.FormataData;
import br.edu.utfpr.models.CompraListModel;
import br.edu.utfpr.models.MateriaPrimaListModel;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class FrmPesquisaCompra extends javax.swing.JInternalFrame {

    private CompraListModel compraListModel;
    private List<Compra> listaCompras;
    private Compra compra;

    private boolean edit = false;

    public FrmPesquisaCompra() {
        initComponents();
        super.setTitle("Tela de Compras");
        CompraDao compraDao = new CompraDao();
        MateriaPrimaDao materiaPrimaDao = new MateriaPrimaDao();
        listaCompras = compraDao.findAll();
        listaCompras.forEach(compra -> compra.setMateriasPrima(
                materiaPrimaDao.findById(compra.getMateriasPrima().getId())));
        compraListModel = new CompraListModel(listaCompras);
        tbCompras.setModel(compraListModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfFiltro = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCompras = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnIncluir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pesquisa de Compras ");

        jLabel1.setText("Filtar por data:");

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
                .addComponent(tfFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
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

        tbCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbCompras);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/icons/document-add.png"))); // NOI18N
        btnIncluir.setText("Inlcuir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });
        jPanel2.add(btnIncluir);

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/icons/editar.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });
        jPanel2.add(btEditar);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/icons/lixo.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(btExcluir);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        FrmCompra frmCompra = new FrmCompra(null, true, compraListModel);
        frmCompra.setLocationRelativeTo(null);
        frmCompra.setVisible(true);
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        editar();
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        excluir();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        filtro();
    }//GEN-LAST:event_btnPesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCompras;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables

    private void excluir() {
        int linhaSelecionada = tbCompras.getSelectedRow();
        if (linhaSelecionada >= 0) {
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir a compra selecionada?",
                    "Exclusão",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcao == JOptionPane.YES_OPTION) {
                int idCompra = (int) tbCompras.getValueAt(linhaSelecionada, 0);
                CompraDao compraDao = new CompraDao();
                if (compraDao.delete(idCompra)) {
                    JOptionPane.showMessageDialog(null, "Compra excluída com sucesso!");
                    compraListModel.removeModel(linhaSelecionada);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione a compra que deseja excluir!");
        }
    }

    private void editar() {
//        edit=true;
        int linhaSelecionada = tbCompras.getSelectedRow();
        if (linhaSelecionada >= 0) {
            int idCompra = (int) tbCompras.getValueAt(linhaSelecionada, 0);
            CompraDao compraDao = new CompraDao();
            Compra compra = compraDao.findById(idCompra);
            FrmCompra frmCompra = new FrmCompra(null, true, compraListModel, compra, linhaSelecionada);
            frmCompra.setVisible(true);
            frmCompra.setLocationRelativeTo(null);
        }
    }

    private void filtro() {
        List<Compra> listaCompraFiltrada = listaCompras.stream().filter(compra
                -> compra.getData() == FormataData.stringToLocalDate(tfFiltro.getText()))
                .collect(Collectors.toList());

        System.out.println(listaCompraFiltrada.toString());
    }

}
