package View;

import Controller.InterfaceControllerObserved;
import javax.swing.table.AbstractTableModel;

/**
 * Classe que implementa o Model de JTable para a Malha Rodoviaria
 * @author Jean Poffo
 * @since 02/09/2018
 */
public class TableModelMalhaRodoviaria extends AbstractTableModel {
    
    private InterfaceControllerObserved controller;
    
    public TableModelMalhaRodoviaria(InterfaceControllerObserved controller) {
        this.controller = controller;
    }
    
    /**
     * @return 
     */
    @Override
    public int getRowCount() {
        return this.controller.getMatrizRodoviaria().length;
    }

    /**
     * @return 
     */
    @Override
    public int getColumnCount() {
        return this.controller.getMatrizRodoviaria()[0].length;
    }

    /**
     * @param rowIndex
     * @param columnIndex
     * @return 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.controller.getMatrizRodoviaria()[rowIndex][columnIndex];
    }
}