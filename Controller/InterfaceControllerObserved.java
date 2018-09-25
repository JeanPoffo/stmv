package Controller;

import Model.Pista;
import View.InterfaceViewObserver;
import java.io.File;

/**
 * Interface Observed do Controller
 * @author Jean Poffo
 * @since 02/09/2018
 */
public interface InterfaceControllerObserved {
    
    public void addObserver(InterfaceViewObserver observer);
    
    public void removeObserver(InterfaceViewObserver observer);
    
    public Pista[][] getMatrizRodoviaria();
    
    public void carregaMatrizRodoviaria(File arquivoImportacao);
    
    public void iniciaSimulacao();
}