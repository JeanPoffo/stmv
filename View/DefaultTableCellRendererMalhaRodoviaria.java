package View;

import Model.Pista;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Classe que implementa o CellRenderer da tabela
 * @author Jean Poffo
 * @since 21/09/2018
 */
public class DefaultTableCellRendererMalhaRodoviaria extends DefaultTableCellRenderer{
     
    @Override
    public Component getTableCellRendererComponent(JTable table, Object pista, boolean isSelected, boolean hasFocus, int row, int column) {
        if(pista != null) {
            Pista pistaAtual = (Pista) pista;    
            
            super.setBackground(pistaAtual.getCor());
            
            if(pistaAtual.getCarro() != null) {
                super.setIcon(pistaAtual.getCarro().getIcone());    
            }
            else {
                super.setIcon(pistaAtual.getIcone());
            }
        }
        else {
            throw new Error("CABACO");
        }
        
        super.setHorizontalAlignment(CENTER);
        super.setVerticalAlignment(CENTER);
        super.repaint();
        
        return this;
    }
}