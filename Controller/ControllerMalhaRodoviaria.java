package Controller;

import Model.Pista;
import View.InterfaceViewObserver;
import View.TableModelMalhaRodoviaria;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * Controller principal do sistema
 * @author Jean Poffo
 * @since 02/08/2018
 */
public class ControllerMalhaRodoviaria implements InterfaceControllerObserved {

    private Pista[][] matrizRodoviaria;
    
    private List<InterfaceViewObserver> observers;

    public ControllerMalhaRodoviaria() {
        this.observers = new ArrayList();
    }
    
    @Override
    public void addObserver(InterfaceViewObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(InterfaceViewObserver observer) {
        this.observers.remove(observer);
    }

    /**
     * 
     * @param exception 
     */
    private void notifyShowException(Exception exception) {
        for (InterfaceViewObserver observer : this.observers) {
            observer.updateShowException(exception);
        }
    }
    
    /**
     * 
     * @param tableModelMalhaRodoviaria 
     */
    private void notifyTableModel(TableModelMalhaRodoviaria tableModelMalhaRodoviaria) {
        for (InterfaceViewObserver observer : this.observers) {
            observer.updateTableModel(tableModelMalhaRodoviaria);
        }
    }
    
    @Override
    public Pista[][] getMatrizRodoviaria() {
        return this.matrizRodoviaria;
    }

    /**
     * @todo Finalizar Leitura arquivo
     * @param arquivoImportacao
     */
    @Override
    public void carregaMatrizRodoviaria(File arquivoImportacao) {
        BufferedReader bufferedReader;
        int linhas;
        int colunas;
        
        try {
            bufferedReader = new BufferedReader(new FileReader(arquivoImportacao));
            
            linhas  = Integer.getInteger(bufferedReader.readLine());
            colunas = Integer.getInteger(bufferedReader.readLine());
        } 
        catch (FileNotFoundException ex) {
            this.notifyShowException(ex);
        } 
        catch (IOException ex) {
            this.notifyShowException(ex);
        }
    }
}