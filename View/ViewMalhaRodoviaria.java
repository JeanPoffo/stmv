package View;

import Controller.InterfaceControllerObserved;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 * View da Aplicacao
 * @author Jean Poffo
 */
public class ViewMalhaRodoviaria extends javax.swing.JFrame implements InterfaceViewObserver{

    /* Table Model */
    private TableModelMalhaRodoviaria tableModel;
   
    /** Controller */
    private InterfaceControllerObserved controller;
    
    public ViewMalhaRodoviaria(InterfaceControllerObserved controller) throws HeadlessException {
        this.controller = controller;
        this.controller.addObserver(this);
        
        this.initComponents();
        
        this.changeEnableComponente(true);
        
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        opcaoMonitor = new javax.swing.JRadioButton();
        opcaoSemaforo = new javax.swing.JRadioButton();
        labelNumeroCarros = new javax.swing.JLabel();
        campoNumeroCarros = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        botaoIniciar = new javax.swing.JButton();
        botaoPararAgora = new javax.swing.JButton();
        botaoParar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMalhaRodoviaria = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        itemMenuNovo = new javax.swing.JMenuItem();
        itemMenuSair = new javax.swing.JMenuItem();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Opções"));

        opcaoMonitor.setText("Monitor");
        opcaoMonitor.addActionListener(formListener);

        opcaoSemaforo.setText("Semafaro");
        opcaoSemaforo.addActionListener(formListener);

        labelNumeroCarros.setText("Número de Carros:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNumeroCarros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNumeroCarros, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(opcaoSemaforo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opcaoMonitor)
                .addContainerGap(258, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opcaoSemaforo)
                    .addComponent(opcaoMonitor)
                    .addComponent(labelNumeroCarros)
                    .addComponent(campoNumeroCarros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Controles"));

        botaoIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icons/bullet_go.png"))); // NOI18N
        botaoIniciar.setText("Iniciar");
        botaoIniciar.setMaximumSize(new java.awt.Dimension(100, 32));
        botaoIniciar.setMinimumSize(new java.awt.Dimension(100, 32));
        botaoIniciar.addActionListener(formListener);

        botaoPararAgora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icons/error_delete.png"))); // NOI18N
        botaoPararAgora.setText("Parar Agora");
        botaoPararAgora.addActionListener(formListener);

        botaoParar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icons/error.png"))); // NOI18N
        botaoParar.setText("Parar");
        botaoParar.addActionListener(formListener);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoPararAgora, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoParar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPararAgora)
                    .addComponent(botaoParar))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        tableMalhaRodoviaria.setAutoscrolls(false);
        tableMalhaRodoviaria.setEnabled(false);
        tableMalhaRodoviaria.setRowHeight(35);
        tableMalhaRodoviaria.setShowGrid(true);
        tableMalhaRodoviaria.setDefaultRenderer(Object.class, new DefaultTableCellRendererMalhaRodoviaria());	
        tableMalhaRodoviaria.setGridColor(Color.BLACK);
        jScrollPane1.setViewportView(tableMalhaRodoviaria);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        menuArquivo.setText("Arquivo");

        itemMenuNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icons/table_add.png"))); // NOI18N
        itemMenuNovo.setText("Nova Malha");
        itemMenuNovo.addActionListener(formListener);
        menuArquivo.add(itemMenuNovo);

        itemMenuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icons/cancel.png"))); // NOI18N
        itemMenuSair.setText("Sair");
        itemMenuSair.addActionListener(formListener);
        menuArquivo.add(itemMenuSair);

        jMenuBar1.add(menuArquivo);

        setJMenuBar(jMenuBar1);

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == itemMenuSair) {
                ViewMalhaRodoviaria.this.itemMenuSairActionPerformed(evt);
            }
            else if (evt.getSource() == opcaoSemaforo) {
                ViewMalhaRodoviaria.this.opcaoSemaforoActionPerformed(evt);
            }
            else if (evt.getSource() == opcaoMonitor) {
                ViewMalhaRodoviaria.this.opcaoMonitorActionPerformed(evt);
            }
            else if (evt.getSource() == botaoPararAgora) {
                ViewMalhaRodoviaria.this.botaoPararAgoraActionPerformed(evt);
            }
            else if (evt.getSource() == botaoParar) {
                ViewMalhaRodoviaria.this.botaoPararActionPerformed(evt);
            }
            else if (evt.getSource() == botaoIniciar) {
                ViewMalhaRodoviaria.this.botaoIniciarActionPerformed(evt);
            }
            else if (evt.getSource() == itemMenuNovo) {
                ViewMalhaRodoviaria.this.itemMenuNovoActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void itemMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itemMenuSairActionPerformed

    private void opcaoSemaforoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcaoSemaforoActionPerformed
        this.opcaoMonitor.setSelected(false);
    }//GEN-LAST:event_opcaoSemaforoActionPerformed

    private void opcaoMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcaoMonitorActionPerformed
        this.opcaoSemaforo.setSelected(false);
    }//GEN-LAST:event_opcaoMonitorActionPerformed

    private void botaoPararAgoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPararAgoraActionPerformed
        this.changeEnableComponente(true);
    }//GEN-LAST:event_botaoPararAgoraActionPerformed

    private void botaoPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPararActionPerformed
        //@todo
    }//GEN-LAST:event_botaoPararActionPerformed

    private void botaoIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoIniciarActionPerformed
        this.changeEnableComponente(false);
        this.controller.iniciaSimulacao();
    }//GEN-LAST:event_botaoIniciarActionPerformed

    private void itemMenuNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuNovoActionPerformed
        this.controller.carregaMatrizRodoviaria(this.callFileChooser());
    }//GEN-LAST:event_itemMenuNovoActionPerformed

    private void changeEnableComponente(boolean enable) {
        this.opcaoMonitor.setEnabled(enable);
        this.opcaoSemaforo.setEnabled(enable);
        this.botaoIniciar.setEnabled(enable);
        this.campoNumeroCarros.setEnabled(enable);
        this.botaoParar.setEnabled(!enable);
        this.botaoPararAgora.setEnabled(!enable);
    }
    
    /**
     * Implementa o update do Observer
     */
    @Override
    public void updateTableChanged() {
        this.tableModel.fireTableDataChanged();
    }

    @Override
    public void updateTableModel(TableModelMalhaRodoviaria tableModelMalhaRodiviaria) {
        this.tableModel = tableModelMalhaRodiviaria;
        this.tableMalhaRodoviaria.setModel(this.tableModel);
    }

    @Override
    public void updateShowException(Exception exception) {
        JOptionPane.showMessageDialog(this, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public File callFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        File file                = null;
        
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
        
        return file;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoIniciar;
    private javax.swing.JButton botaoParar;
    private javax.swing.JButton botaoPararAgora;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField campoNumeroCarros;
    private javax.swing.JMenuItem itemMenuNovo;
    private javax.swing.JMenuItem itemMenuSair;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelNumeroCarros;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JRadioButton opcaoMonitor;
    private javax.swing.JRadioButton opcaoSemaforo;
    private javax.swing.JTable tableMalhaRodoviaria;
    // End of variables declaration//GEN-END:variables
}
