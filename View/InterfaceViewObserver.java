package View;

/**
 * Interface Observer da View
 * @author Jean Poffo
 * @since 02/09/2018
 */
public interface InterfaceViewObserver {
    
    public void updateTableChanged();
    
    public void updateTableModel(TableModelMalhaRodoviaria tableModelMalhaRodiviaria);
    
    public void updateShowException(Exception exception);
}