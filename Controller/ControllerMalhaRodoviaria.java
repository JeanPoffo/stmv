package Controller;

import Model.Carro;
import Model.Pista;
import View.InterfaceViewObserver;
import View.TableModelMalhaRodoviaria;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 * Controller principal do sistema
 * @author Jean Poffo
 * @since 02/08/2018
 */
public class ControllerMalhaRodoviaria implements InterfaceControllerObserved {

    private Pista[][] matrizRodoviaria;
    
    private ArrayList<Pista> pistasEntrada;

    private ArrayList<Carro> carros;
    
    private List<InterfaceViewObserver> observers;
    
    private static ControllerMalhaRodoviaria instancia;
    
    private ControllerMalhaRodoviaria() {
        this.observers     = new ArrayList();
        this.carros        = new ArrayList();
        this.pistasEntrada = new ArrayList();
    }
    
    @Override
    public void addObserver(InterfaceViewObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(InterfaceViewObserver observer) {
        this.observers.remove(observer);
    }

    public static ControllerMalhaRodoviaria getInstancia() {
        if(instancia == null) {
            instancia = new ControllerMalhaRodoviaria();
        }
        
        return instancia;
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
    
    public synchronized void notifyTableModelChanged() {
        for (InterfaceViewObserver observer : this.observers) {
            observer.updateTableChanged();
        }
    }
    
    @Override
    public Pista[][] getMatrizRodoviaria() {
        return this.matrizRodoviaria;
    }

    public List<Pista> getPistasEntrada() {
        return pistasEntrada;
    }

    public void addPistasEntrada(Pista pista) {
        this.pistasEntrada.add(pista);
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void addCarro(Carro carro) {
        this.carros.add(carro);
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
            
            this.carregaMatrizModelPistas();
            
            while(scanner.hasNext()) {
                int inicioX = scanner.nextInt();
                int inicioY = scanner.nextInt();
                int fimX    = scanner.nextInt();
                int fimY    = scanner.nextInt();
                
                this.carregaMatrizModelPistasTransitavel(inicioX, inicioY, fimX, fimY);
            }
            
            this.notifyTableModel(new TableModelMalhaRodoviaria(this));
        } 
        catch (FileNotFoundException | ArrayIndexOutOfBoundsException ex) {
            this.notifyShowException(ex);
        }
    }
    
    private void carregaMatrizModelPistas() {
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
        return (x >= 0 && x < this.matrizRodoviaria.length) && (y >= 0 && y < this.matrizRodoviaria[0].length);
    }
    
    private void carregaMatrizModelPistasTransitavel(int inicioX, int inicioY, int fimX, int fimY) throws ArrayIndexOutOfBoundsException {
        Pista pista = null;
        
        boolean temEntradaX = false;
        boolean temEntradaY = false;
        boolean temSaidaX   = false;
        boolean temSaidaY   = false;
        
        if(inicioY == (this.matrizRodoviaria[0].length - 1) || inicioY == 0) {
            temEntradaY = true;
        }
        
        if(fimY == (this.matrizRodoviaria[0].length - 1) || fimY == 0) {
            temSaidaY = true;
        }
        
        if(inicioX == (this.matrizRodoviaria.length - 1) || inicioX == 0) {
            temEntradaX = true;
        }
        if(fimX == (this.matrizRodoviaria.length - 1) || fimX == 0) {
            temSaidaX = true;
        }
        
        if (inicioY == fimY) {
            if (inicioX < fimX) {
                if(temEntradaX) {
                    pista = matrizRodoviaria[fimY][inicioX];
                    pista.setEntrada(true);
                    this.addPistasEntrada(pista);
                }
                
                for (int i = inicioX; i <= fimX; i++) {
                    pista = matrizRodoviaria[fimY][i];
                    pista.setIcone(new ImageIcon(getClass().getResource(Pista.IMAGEM_DIREITA)));
                    pista.setTransitavel(true);
                    
                    if(i != inicioX) {
                        pista.setPistaEsquerda(null);
                    }
                    
                    if (i == fimX) {
                        if(this.verificaIndiceExisteArray(i + 1, fimY)) {
                            Pista pistaAdjacente = matrizRodoviaria[fimY][i + 1];
                            pistaAdjacente.setPistaEsquerda(null);
                        }
                    }
                    
                    pista.setCor(new Color(146, 143, 138));
                }
                
                if(temSaidaX) {
                    pista.setCor(new Color(255, 0, 0));
                    pista.setSaida(true);
                }
            } 
            else {
                if(temEntradaX) {
                    pista = matrizRodoviaria[fimY][inicioX];
                    pista.setEntrada(true);
                    this.addPistasEntrada(pista);
                }
                
                for (int i = inicioX; i >= fimX; i--) {
                    pista = matrizRodoviaria[fimY][i];
                    pista.setIcone(new ImageIcon(getClass().getResource(Pista.IMAGEM_ESQUERDA)));
                    pista.setTransitavel(true);
                    
                    if(i != inicioY) {
                        pista.setPistaDireita(null);
                    } 
                    
                    if (i == fimX) {
                        if(this.verificaIndiceExisteArray(i + 1, fimY)) {
                            Pista pistaAdjacente = matrizRodoviaria[fimY][i + 1];
                            pistaAdjacente.setPistaDireita(null);
                        }
                    }
                    
                    pista.setCor(new Color(146, 143, 138));
                }
                
                if(temSaidaX) {
                    pista.setCor(new Color(255, 0, 0));
                    pista.setSaida(true);
                }
            }
        } 
        else {
            if (inicioY < fimY) {
                if(temEntradaY) {
                    pista = matrizRodoviaria[inicioY][fimX];
                    pista.setEntrada(true);
                    this.addPistasEntrada(pista);
                }
                
                for (int i = inicioY; i <= fimY; i++) {
                    pista = matrizRodoviaria[i][fimX];
                    pista.setIcone(new ImageIcon(getClass().getResource(Pista.IMAGEM_ABAIXO)));
                    pista.setTransitavel(true);
                    
                    if(i != inicioY) {
                        pista.setPistaSuperior(null);
                    }
                    
                    if (i == fimY) {
                        if(this.verificaIndiceExisteArray(fimX, i + 1)) {
                            Pista pistaAdjacente = matrizRodoviaria[i + 1][fimX];
                            pistaAdjacente.setPistaSuperior(null);
                        }
                    }
                    
                    pista.setCor(new Color(146, 143, 138));
                }
                
                if(temSaidaY) {
                    pista.setCor(new Color(255, 0, 0));
                    pista.setSaida(true);
                }
            } 
            else {
                if(temEntradaX) {
                    pista = matrizRodoviaria[inicioY][fimX];
                    pista.setEntrada(true);
                    this.addPistasEntrada(pista);
                }
                
                for (int i = inicioY; i >= fimY; i--) {
                    pista = matrizRodoviaria[i][fimX];
                    pista.setIcone(new ImageIcon(getClass().getResource(Pista.IMAGEM_ACIMA)));
                    pista.setTransitavel(true);
                    
                    if(i != inicioY) {
                        pista.setPistaInferior(null);
                    }
                    
                    if (i == fimY) {
                        if(this.verificaIndiceExisteArray(fimX, i + 1)) {
                            Pista pistaAdjacente = matrizRodoviaria[i + 1][fimX];
                            pistaAdjacente.setPistaInferior(null);
                        }
                    }
                    
                    pista.setCor(new Color(146, 143, 138));
                }
                
                if(temSaidaY) {
                    pista.setCor(new Color(255, 0, 0));
                    pista.setEntrada(true);
                }
            }
        }
    }

    @Override
    public void iniciaSimulacao(int quantidadeCarro, boolean usaSemafaro, boolean usaMonitor) {
        new Thread(() -> {
            Random random = new Random();
            
            while(this.carros.size() < quantidadeCarro) {
                Pista pista = this.pistasEntrada.get(random.nextInt(this.pistasEntrada.size()));

                Carro carro = new Carro();
                
                this.addCarro(carro);
                
                pista.setCarro(carro);
                carro.setPista(pista);
                
                this.notifyTableModelChanged();
                
                new Thread(() -> {
                    carro.start();
                }).start();
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ControllerMalhaRodoviaria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
}