package br.edu.utfpr.views;

//import br.edu.utfpr.dao.CarroDao
import br.edu.utfpr.entidades.Carro;
import br.edu.utfpr.models.CarroListModel;
import java.util.List;
import javax.swing.JOptionPane;

public class FrmPesquisaCarro extends javax.swing.JInternalFrame {

    private CarroListModel carroListModel;
    private List<Carro> listaCarro;
    private boolean edit = false;

    public FrmPesquisaCarro() {
        initComponents();
        super.setTitle("Tela de Clientes");
        //CarroDao carroDao = new CarroDao();
        //listaCarro = carroDao.findAll();
        carroListModel = new CarroListModel(listaCarro);
        tblCarros.setModel(carroListModel);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarros = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnIncluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("..:: Pesquisa de Carro ::..");

        jLabel1.setText("Modelo :");

        btnPesquisar.setText("Pesquisar");
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
                .addComponent(txtModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
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
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        tblCarros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Modelo", "Marca", "Ano Fabricação", "Ano Modelo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCarros);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btnIncluir.setText("Novo");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });
        jPanel2.add(btnIncluir);

        btnAlterar.setText("Editar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAlterar);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(btnExcluir);

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel2.add(btnImprimir);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        FrmCarro frmCarro = new FrmCarro(null, true, carroListModel);
        frmCarro.setLocationRelativeTo(null);
        frmCarro.setVisible(true);
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
       // editar();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
      //  excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

    }//GEN-LAST:event_btnPesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCarros;
    private javax.swing.JTextField txtModelo;
    // End of variables declaration//GEN-END:variables

    /*private void excluir() {
        int linhaSelecionada = tblCarros.getSelectedRow(); //pega a linha selecionada na JTable
        if (linhaSelecionada >= 0) { // se uma linha foi selecionada
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o carro selecionado?",
                    "Exclusão",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcao == JOptionPane.YES_OPTION) {
                int idCarro = (int) tblCarros.getValueAt(linhaSelecionada, 0);
                CarroDao carroDao = new CarroDao();
                if (carroDao.delete(idCarro)) {
                    JOptionPane.showMessageDialog(null, "Carro excluído com sucesso!");
                    carroListModel.removeModel(linhaSelecionada);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE UM REGISTRO!");
        }
    }

    private void editar() {
        edit = true;
        int linhaSelecionada = tblCarros.getSelectedRow();
        if (linhaSelecionada >= 0) {
            int idCarro = (int) tblCarros.getValueAt(linhaSelecionada, 0);
            System.out.println(idCarro);
            FrmCarro frmCarro = new FrmCarro(carroListModel, linhaSelecionada, idCarro, edit);
            frmCarro.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE UM REGISTRO!");
        }
    }*/
}
