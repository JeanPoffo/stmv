package View;

import Controller.InterfaceControllerObserved;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Dimension;
import static java.awt.Event.CTRL_MASK;
import static java.awt.event.KeyEvent.VK_E;
import static java.awt.event.KeyEvent.VK_N;
import static java.lang.Short.MAX_VALUE;
import static javax.swing.KeyStroke.getKeyStroke;
import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.io.File;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * View principal da sistema
 * @author Jean Poffo
 * @since 02/09/2018
 */
public class ViewMalhaRodoviaria extends JFrame implements InterfaceViewObserver {

    private JButton                   botaoStart;
    private JButton                   botaoStop;
    private JButton                   botaoStopNow;
    private JMenuItem                 itemMenuCarregarMalha;
    private JMenuBar                  menuBar;
    private JMenuItem                 itemMenuSair;
    private JMenu                     menuArquivo;
    private JMenu                     menuSobre;
    private JPanel                    panelTable;
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
    }
    
    /**
     * Inicia os Componentes da View
     */
    private void initComponents() {
        this.panelTable            = new JPanel();
        this.botaoStop             = new JButton();
        this.botaoStart            = new JButton();
        this.botaoStopNow          = new JButton();
        this.menuBar               = new JMenuBar();
        this.menuArquivo           = new JMenu();
        this.itemMenuCarregarMalha = new JMenuItem();
        this.itemMenuSair          = new JMenuItem();
        this.menuSobre             = new JMenu();
        this.tableMalhaRodoviaria  = new JTable();
        
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setResizable(false);
        
        this.panelTable.setMinimumSize(new Dimension(600, 400));
        this.panelTable.setPreferredSize(new Dimension(600, 400));
        
        this.botaoStop.setIcon(new ImageIcon(getClass().getResource("/View/Icons/error.png")));
        this.botaoStop.setText("Stop");

        this.botaoStart.setIcon(new ImageIcon(getClass().getResource("/View/Icons/bullet_go.png")));
        this.botaoStart.setText("Start");

        this.botaoStopNow.setIcon(new ImageIcon(getClass().getResource("/View/Icons/error_delete.png")));
        this.botaoStopNow.setText("Stop Now");

        this.itemMenuCarregarMalha.setAccelerator(getKeyStroke(VK_N, CTRL_MASK));
        this.itemMenuCarregarMalha.setIcon(new ImageIcon(getClass().getResource("/View/Icons/table_add.png")));
        this.itemMenuCarregarMalha.setText("Carregar Malha");

        this.itemMenuSair.setAccelerator(getKeyStroke(VK_E, CTRL_MASK));
        this.itemMenuSair.setIcon(new ImageIcon(getClass().getResource("/View/Icons/cancel.png")));
        this.itemMenuSair.setText("Sair");
        
        this.menuArquivo.setText("Arquivo");
        this.menuArquivo.add(this.itemMenuCarregarMalha);
        this.menuArquivo.add(this.itemMenuSair);

        this.menuSobre.setText("Sobre");
        
        this.menuBar.add(this.menuArquivo);
        this.menuBar.add(this.menuSobre);

        super.setJMenuBar(this.menuBar);

        GroupLayout layoutView = new GroupLayout(getContentPane());
        
        super.getContentPane().setLayout(layoutView);
        
        layoutView.setHorizontalGroup(
            layoutView.createParallelGroup(LEADING)
            .addGroup(layoutView.createSequentialGroup()
                .addContainerGap()
                .addGroup(layoutView.createParallelGroup(LEADING)
                    .addComponent(this.panelTable, DEFAULT_SIZE, 803, MAX_VALUE)
                    .addGroup(TRAILING, layoutView.createSequentialGroup()
                        .addComponent(this.botaoStart, PREFERRED_SIZE, 100, PREFERRED_SIZE)
                        .addPreferredGap(RELATED, DEFAULT_SIZE, MAX_VALUE)
                        .addComponent(this.botaoStop, PREFERRED_SIZE, 125, PREFERRED_SIZE)
                        .addPreferredGap(RELATED)
                        .addComponent(this.botaoStopNow, PREFERRED_SIZE, 125, PREFERRED_SIZE)))
                .addContainerGap())
        );
        
        layoutView.setVerticalGroup(
            layoutView.createParallelGroup(LEADING)
            .addGroup(layoutView.createSequentialGroup()
                .addPreferredGap(RELATED)
                .addComponent(this.panelTable, PREFERRED_SIZE, 467, PREFERRED_SIZE)
                .addPreferredGap(RELATED, 12, MAX_VALUE)
                .addGroup(layoutView.createParallelGroup(BASELINE)
                    .addComponent(this.botaoStop)
                    .addComponent(this.botaoStopNow)
                    .addComponent(this.botaoStart))
                .addContainerGap())
        );
        
        pack();
    }
    
    /**
     * @todo
     */
    private void addListerners() {
        this.itemMenuCarregarMalha.addActionListener((ActionEvent e) -> {
            this.controller.carregaMatrizRodoviaria(this.callFileChooser());
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