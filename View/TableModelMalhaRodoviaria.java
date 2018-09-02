package View;

import javax.swing.table.AbstractTableModel;

/**
 * Classe que implementa o Model de JTable para a Malha Rodoviaria
 * @author Jean Poffo
 * @since 02/09/2018
 */
public class TableModelMalhaRodoviaria extends AbstractTableModel {

    /**
     * @todo
     * @return 
     */
    @Override
    public int getRowCount() {
        return 20;
    }

    /**
     * @todo
     * @return 
     */
    @Override
    public int getColumnCount() {
        return 20;
    }

    /**
     * @todo
     * @param rowIndex
     * @param columnIndex
     * @return 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return "Batata";
    }
}