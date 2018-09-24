package Controller;

import Model.Pista;
import View.InterfaceViewObserver;
import View.TableModelMalhaRodoviaria;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;

/**
 * Controller principal do sistema
 * @author Jean Poffo
 * @since 02/08/2018
 */
public class ControllerMalhaRodoviaria implements InterfaceControllerObserved {

    private Pista[][] matrizRodoviaria;
    
    private ArrayList<Pista> pistasEntrada;
    
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

    public ArrayList<Pista> getPistasEntrada() {
        return pistasEntrada;
    }

    public void addPistasEntrada(Pista pista) {
        this.pistasEntrada.add(pista);
    }
    
    /**
     * @todo Finalizar Leitura arquivo
     * @param arquivoImportacao
     */
    @Override
    public void carregaMatrizRodoviaria(File arquivoImportacao) {
        int linhas;
        int colunas;
        
        try { 
            Scanner scanner = new Scanner(arquivoImportacao);
            
            linhas  = scanner.nextInt();
            colunas = scanner.nextInt();
            
            this.matrizRodoviaria = new Pista[linhas][colunas];
            
            this.carregaPistaMatriz();
            
            while(scanner.hasNext()) {
                int inicioX = scanner.nextInt();
                int inicioY = scanner.nextInt();
                int fimX    = scanner.nextInt();
                int fimY    = scanner.nextInt();
                
                this.carregaPistaMatrizTransitavel(inicioX, inicioY, fimX, fimY);
            }
            
            this.notifyTableModel(new TableModelMalhaRodoviaria(this));
        } 
        catch (FileNotFoundException | ArrayIndexOutOfBoundsException ex) {
            this.notifyShowException(ex);
        }
    }
    
    private void carregaPistaMatriz() {
        /** Preenche a malha com as Pistas */
        for (int x = 0; x < matrizRodoviaria.length; x++) {
            for (int y = 0; y < matrizRodoviaria[x].length; y++) {
                matrizRodoviaria[x][y] = new Pista(new Color(233, 224, 207));
            }
        }
        
        /** Cria a relacao de nos entre as pistas */
        for (int x = 0; x < matrizRodoviaria.length; x++) {
            for (int y = 0; y < matrizRodoviaria[x].length; y++) {
                Pista pista = matrizRodoviaria[x][y];
                
                if(this.verificaIndiceExisteArray(x, y - 1)) {
                    pista.setPistaSuperior(matrizRodoviaria[x][y - 1]);
                }
                
                if(this.verificaIndiceExisteArray(x, y + 1)) {
                    pista.setPistaInferior(matrizRodoviaria[x][y + 1]);
                }
                
                if(this.verificaIndiceExisteArray(x + 1, y)) {
                    pista.setPistaDireita(matrizRodoviaria[x + 1][y]);
                }
                
                if(this.verificaIndiceExisteArray(x - 1, y)) {
                    pista.setPistaEsquerda(matrizRodoviaria[x - 1][y]);
                }
            }
        }
    }
    
    private boolean verificaIndiceExisteArray(int x, int y) {
        return this.matrizRodoviaria.length <= x && this.matrizRodoviaria[0].length <= y;
    }
    
    private void carregaPistaMatrizTransitavel(int inicioX, int inicioY, int fimX, int fimY) throws ArrayIndexOutOfBoundsException {
        
        Pista ultimaPista = new Pista();
        
        if (inicioY == fimY) {    
            if (inicioX < fimX) {
                for (int i = inicioX; i <= fimX; i++) {
                    Pista pista = matrizRodoviaria[fimY][i];
                    pista.setIcone(new ImageIcon(getClass().getResource(Pista.IMAGEM_DIREITA)));
                    pista.setTransitavel(true);
                    pista.setCor(new Color(146, 143, 138));

                    ultimaPista = pista;
                }
            } 
            else {
                for (int i = inicioX; i >= fimX; i--) {
                    Pista pista = matrizRodoviaria[fimY][i];
                    pista.setIcone(new ImageIcon(getClass().getResource(Pista.IMAGEM_ESQUERDA)));
                    pista.setTransitavel(true);
                    pista.setCor(new Color(146, 143, 138));
                    
                    ultimaPista = pista;
                }
            }
            
            if((fimX + 1) == matrizRodoviaria.length || fimX == 0) {
                //Vermelho
                ultimaPista.setCor(new Color(255, 0, 0));
            }
        } 
        else {
            if (inicioY < fimY) {
                for (int i = inicioY; i <= fimY; i++) {
                    Pista pista = matrizRodoviaria[i][fimX];
                    pista.setIcone(new ImageIcon(getClass().getResource(Pista.IMAGEM_ABAIXO)));
                    pista.setTransitavel(true);
                    pista.setCor(new Color(146, 143, 138));
                    
                    ultimaPista = pista;
                }
            } 
            else {
                for (int i = inicioY; i >= fimY; i--) {
                    Pista pista = matrizRodoviaria[i][fimX];
                    pista.setIcone(new ImageIcon(getClass().getResource(Pista.IMAGEM_ACIMA)));
                    pista.setTransitavel(true);
                    pista.setCor(new Color(146, 143, 138));
                    
                    ultimaPista = pista;
                }
            }
            
            if((fimY + 1) == matrizRodoviaria.length || fimY == 0) {
                //Vermelho
                ultimaPista.setCor(new Color(255, 0, 0));
            }
        }
    }
}