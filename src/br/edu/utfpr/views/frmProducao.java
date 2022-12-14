package br.edu.utfpr.views;

import br.edu.utfpr.arquivos.GravaErroArquivo;
import br.edu.utfpr.dao.ClassesDao.MateriaPrimaDao;
import br.edu.utfpr.dao.ClassesDao.ProducaoDao;
import br.edu.utfpr.entidades.MateriaPrima;
import br.edu.utfpr.entidades.Producao;
import br.edu.utfpr.formataData.FormataData;
import br.edu.utfpr.models.ProducaoListModel;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.LocalDate;

public class FrmProducao extends javax.swing.JDialog {

    private ProducaoListModel producaoListModel;
    private ProducaoDao producaoDao;
    private MateriaPrimaDao materiaPrimaDao;
    private boolean edit = false;
    private int linhaSelecionada;
    private Producao producao;
    private Float quantidadeAnt;

    public FrmProducao(java.awt.Frame parent, boolean modal, ProducaoListModel producaoListModel) {
        super(parent, modal);
        initComponents();
        materiaPrimaDao = new MateriaPrimaDao();
        materiaPrimaDao.findAll().forEach(fds -> cbMatPrima.addItem(fds));
        this.producaoListModel = producaoListModel;
    }

    public FrmProducao(java.awt.Frame parent, boolean modal, ProducaoListModel producaoListModel, Producao producao, int linhaSelecionada) {
        super(parent, modal);
        initComponents();
        edit = true;
        this.producaoListModel = producaoListModel;
        this.linhaSelecionada = linhaSelecionada;
        materiaPrimaDao = new MateriaPrimaDao();
        materiaPrimaDao.findAll().forEach(fds -> cbMatPrima.addItem(fds));
        tfCodigo.setText(producao.getId().toString());
        tfData.setText(FormataData.localDateToString(producao.getData()));
        tfQuantidade.setText(producao.getQuantidade().toString());
        cbMatPrima.getModel().setSelectedItem(materiaPrimaDao.findById(producao.getMateriaPrima().getId()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbCompras = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        tfData = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        cbMatPrima = new javax.swing.JComboBox<>();
        tfQuantidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        tbCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbCompras);

        setTitle("Produ????o");

        jLabel1.setText("C??digo:");

        jLabel2.setText("Data:");

        tfCodigo.setForeground(new java.awt.Color(153, 153, 153));
        tfCodigo.setEnabled(false);

        try {
            tfData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            GravaErroArquivo g = new GravaErroArquivo();
            File file = new File(System.getProperty("user.dir") + "/src/log.txt");           
            g.gravar(file, ex.toString());
            ex.printStackTrace();
        }
        tfData.setToolTipText("Pressione espa??o!");
        tfData.setPreferredSize(new java.awt.Dimension(20, 24));
        tfData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfDataKeyPressed(evt);
            }
        });

        jLabel3.setText("Mat??ria Prima");

        jLabel4.setText("Quantidade");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMatPrima, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbMatPrima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/icons/save.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel2.add(btSalvar);

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/icons/cancel.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btCancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDataKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            LocalDate dataAtual = LocalDate.now();
            tfData.setText(FormataData.localDateToString(dataAtual));
        }
    }//GEN-LAST:event_tfDataKeyPressed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        save();
    }//GEN-LAST:event_btSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<MateriaPrima> cbMatPrima;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCompras;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JFormattedTextField tfData;
    private javax.swing.JTextField tfQuantidade;
    // End of variables declaration//GEN-END:variables
     private Producao getProducao() {
        if (producao == null) {
            producao = new Producao();
            producao.setMateriaPrima((MateriaPrima) cbMatPrima.getSelectedItem());
            producao.setData(FormataData.stringToLocalDate(tfData.getText()));
            producao.setQuantidade(Float.valueOf(tfQuantidade.getText()));
        }
        return producao;
    }

    private void save() {
        Producao producao = getProducao();
        producaoDao = new ProducaoDao();
        if (!edit) {
            producaoDao.insert(producao);
            producaoListModel.insertModel(producao);
            producaoListModel.insertModel(producao);
            producao.getMateriaPrima().atualizarSaldo(producao.getQuantidade(), "DIMINUI");
            materiaPrimaDao.update(producao.getMateriaPrima());
            this.dispose();
        } else {
            producao.setId(Integer.parseInt(tfCodigo.getText()));
            producaoDao.update(producao);
            producaoListModel.atualizarModel(linhaSelecionada, producao);
            Float quantidade;
            if (producao.getQuantidade() > quantidadeAnt) {//Aumentando a quantidade
                quantidade = producao.getQuantidade() - quantidadeAnt;
                producao.getMateriaPrima().atualizarSaldo(quantidade, "AUMENTA");
            } else {
                quantidade = quantidadeAnt - producao.getQuantidade();
                producao.getMateriaPrima().atualizarSaldo(quantidade, "DIMINUI");
            }
            materiaPrimaDao.update(producao.getMateriaPrima());
            this.dispose();
        }
    }

}
