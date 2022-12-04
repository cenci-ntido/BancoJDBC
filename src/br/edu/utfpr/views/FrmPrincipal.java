package br.edu.utfpr.views;

import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.io.File;

import javax.swing.JFrame;

import br.edu.utfpr.arquivos.GravaErroArquivo;

public class FrmPrincipal extends javax.swing.JFrame {

    public FrmPrincipal() {
        initComponents();
        super.setTitle("Controle de Produções");
        super.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        mnSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuSobre = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
        );

        jMenu1.setText("Cadastros");
        jMenu1.add(jSeparator1);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/icons/fornecem.png"))); // NOI18N
        jMenuItem4.setText("Matéria Prima");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        mnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/icons/sair.png"))); // NOI18N
        mnSair.setText("Sair");
        mnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSairActionPerformed(evt);
            }
        });
        jMenu1.add(mnSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Processos");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/icons/carrinho-de-compras.png"))); // NOI18N
        jMenuItem2.setText("Compra");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/icons/producao.png"))); // NOI18N
        jMenuItem3.setText("Produção");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        menuSobre.setText("Sobre");
        menuSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSobreMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuSobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSobreMouseClicked
        FrmSobre frmSobre = new FrmSobre(this, true);
        frmSobre.setLocationRelativeTo(null);
        frmSobre.setVisible(true);
        frmSobre.focus();
    }//GEN-LAST:event_menuSobreMouseClicked

    private void mnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSairActionPerformed
        super.dispose();
    }//GEN-LAST:event_mnSairActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        FrmPesquisaMateriaPrima frmPesquisaMateriaPrima = new FrmPesquisaMateriaPrima();
        desktop.add(frmPesquisaMateriaPrima);
        frmPesquisaMateriaPrima.setVisible(true);
        try {
            frmPesquisaMateriaPrima.setMaximum(true);
        } catch (PropertyVetoException ex) {
            ex.printStackTrace();
            GravaErroArquivo g = new GravaErroArquivo();
            File file = new File(System.getProperty("user.dir") + "/src/log.txt");           
            g.gravar(file, ex.toString());
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        FrmPesquisaCompra frmPesquisaCompra = new FrmPesquisaCompra();
        desktop.add(frmPesquisaCompra);
        frmPesquisaCompra.setVisible(true);
        try {
            frmPesquisaCompra.setMaximum(true);
        } catch (PropertyVetoException ex) {
            GravaErroArquivo g = new GravaErroArquivo();
            File file = new File(System.getProperty("user.dir") + "/src/log.txt");           
            g.gravar(file, ex.toString());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        FrmPesquisaProducao frmPesquisaProducao = new FrmPesquisaProducao();
        desktop.add(frmPesquisaProducao);
        frmPesquisaProducao.setVisible(true);
        try {
            frmPesquisaProducao.setMaximum(true);
        } catch (PropertyVetoException ex) {
            GravaErroArquivo g = new GravaErroArquivo();
            File file = new File(System.getProperty("user.dir") + "/src/log.txt");           
            g.gravar(file, ex.toString());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            GravaErroArquivo g = new GravaErroArquivo();
            File file = new File(System.getProperty("user.dir") + "/src/log.txt");           
            g.gravar(file, ex.toString());
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            GravaErroArquivo g = new GravaErroArquivo();
            File file = new File(System.getProperty("user.dir") + "/src/log.txt");           
            g.gravar(file, ex.toString());
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            GravaErroArquivo g = new GravaErroArquivo();
            File file = new File(System.getProperty("user.dir") + "/src/log.txt");           
            g.gravar(file, ex.toString());
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            GravaErroArquivo g = new GravaErroArquivo();
            File file = new File(System.getProperty("user.dir") + "/src/log.txt");           
            g.gravar(file, ex.toString());
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu menuSobre;
    private javax.swing.JMenuItem mnSair;
    // End of variables declaration//GEN-END:variables
}
