package View;

import Controller.InterfaceControllerObserved;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * View principal da sistema
 * @author Jean Poffo
 * @since 02/09/2018
 */
public class ViewMalhaRodoviaria extends JFrame implements InterfaceViewObserver {

    private JButton                   botaoStart;
    private JButton                   botaoStop;
    private JButton                   botaoStopNow;
    private JLabel                    labelNumeroCarros;
    private JTextField                numeroCarros;
    private JRadioButton              opcaoSemaforo;
    private JRadioButton              opcaoMonitor;
    private JMenuItem                 itemMenuCarregarMalha;
    private JMenuBar                  menuBar;
    private JMenuItem                 itemMenuSair;
    private JMenu                     menuArquivo;
    private JPanel                    panelBotoes;
    private JScrollPane               scrollPaneTable;
    private JTable                    tableMalhaRodoviaria;
    private TableModelMalhaRodoviaria tableModel;
    
    /** Controller */
    private InterfaceControllerObserved controller;
    
    /**
     * Construtor
     * @param controller
     */
    public ViewMalhaRodoviaria(InterfaceControllerObserved controller) throws HeadlessException {
        this.controller = controller;
        this.controller.addObserver(this);
        
        this.initComponents();
        this.addListerners();
        this.changeEnableComponente(true);
    }
    
    /**
     * Inicia os Componentes da View
     */
    private void initComponents() {
        botaoStop             = new JButton();
        botaoStart            = new JButton();
        botaoStopNow          = new JButton();
        labelNumeroCarros     = new JLabel();
        numeroCarros          = new JTextField();
        opcaoSemaforo         = new JRadioButton();
        opcaoMonitor          = new JRadioButton();
        menuBar               = new JMenuBar();
        menuArquivo           = new JMenu();
        itemMenuCarregarMalha = new JMenuItem();
        itemMenuSair          = new JMenuItem();
        scrollPaneTable       = new JScrollPane();
        panelBotoes           = new JPanel();
        tableMalhaRodoviaria  = new JTable();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
                
        botaoStop.setIcon(new ImageIcon(getClass().getResource("/View/Icons/error.png")));
        botaoStop.setText("Stop");

        botaoStart.setIcon(new ImageIcon(getClass().getResource("/View/Icons/bullet_go.png")));
        botaoStart.setText("Start");

        botaoStopNow.setIcon(new ImageIcon(getClass().getResource("/View/Icons/error_delete.png")));
        botaoStopNow.setText("Stop Now");        

        opcaoSemaforo.setText("Opção Semáforo");
        opcaoSemaforo.setSelected(true);
        
        opcaoMonitor.setText("Opção Monitor");
        
        tableMalhaRodoviaria.setAutoscrolls(false);
        tableMalhaRodoviaria.setEnabled(false);
        tableMalhaRodoviaria.setRowHeight(35);
        tableMalhaRodoviaria.setShowGrid(true);
        tableMalhaRodoviaria.setDefaultRenderer(Object.class, new DefaultTableCellRendererMalhaRodoviaria());	
        tableMalhaRodoviaria.setGridColor(Color.BLACK);
        scrollPaneTable.setViewportView(tableMalhaRodoviaria);

        getContentPane().add(scrollPaneTable, java.awt.BorderLayout.CENTER);

        panelBotoes.setPreferredSize(new java.awt.Dimension(500, 40));
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panelBotoes);
        panelBotoes.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoStart, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                /** @todo
                .addComponent(labelNumeroCarros, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(numeroCarros, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                */
                .addComponent(opcaoSemaforo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(opcaoMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)    
                .addComponent(botaoStop, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoStopNow, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoStart)
                    .addComponent(opcaoSemaforo)
                    .addComponent(opcaoMonitor)
                    .addComponent(botaoStopNow)
                    .addComponent(botaoStop))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelBotoes, java.awt.BorderLayout.PAGE_END);
        
        menuArquivo.setText("Arquivo");

        itemMenuCarregarMalha.setText("Carregar Malha");
        itemMenuCarregarMalha.setIcon(new ImageIcon(getClass().getResource("/View/Icons/table_add.png")));
        menuArquivo.add(itemMenuCarregarMalha);

        itemMenuSair.setText("Sair");
        itemMenuSair.setIcon(new ImageIcon(getClass().getResource("/View/Icons/cancel.png")));
        menuArquivo.add(itemMenuSair);

        menuBar.add(menuArquivo);

        setJMenuBar(menuBar);

        pack();
    }
    
    private void changeEnableComponente(boolean enable) {
        this.opcaoMonitor.setEnabled(enable);
        this.opcaoSemaforo.setEnabled(enable);
        this.botaoStart.setEnabled(enable);
        this.botaoStop.setEnabled(!enable);
        this.botaoStopNow.setEnabled(!enable);
    }
    
    /**
     * @todo
     */
    private void addListerners() {
        this.itemMenuCarregarMalha.addActionListener((ActionEvent e) -> {
            this.controller.carregaMatrizRodoviaria(this.callFileChooser());
        });
        
        this.opcaoMonitor.addActionListener((ActionEvent e) -> {
            this.opcaoSemaforo.setSelected(false);
        });
        
        this.opcaoSemaforo.addActionListener((ActionEvent e) -> {
            this.opcaoMonitor.setSelected(false);
        });
        
        this.botaoStart.addActionListener((ActionEvent e) -> {
            this.changeEnableComponente(false);
        });
        
        this.botaoStop.addActionListener((ActionEvent e) -> {
            
        });
        
        this.botaoStopNow.addActionListener((ActionEvent e) -> {
            this.changeEnableComponente(true);
        });
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
}