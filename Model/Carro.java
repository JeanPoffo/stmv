package Model;

import Controller.ControllerMalhaRodoviaria;
import java.util.Random;
import java.util.concurrent.Semaphore;
import javax.swing.ImageIcon;

/**
 * Classe modelo de Carro
 * @author Jean Poffo
 * @since 21/09/2018
 */
public class Carro extends Thread {

    private String nome;
    
    private ImageIcon icone;
    
    private Pista pista;
    
    private Pista pistaAnterior;

    private Semaphore mutex = new Semaphore(1);
    
    public Carro() {
        this.icone = new ImageIcon(getClass().getResource("/View/Icons/car.png"));
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ImageIcon getIcone() {
        return icone;
    }

    public void setIcone(ImageIcon icone) {
        this.icone = icone;
    }
    
    public Pista getPista() {
        return pista;
    }

    public void setPista(Pista pista) {
        this.pista = pista;
    }

    public Pista getPistaAnterior() {
        return pistaAnterior;
    }

    public void setPistaAnterior(Pista pistaAnterior) {
        this.pistaAnterior = pistaAnterior;
    }
    
    @Override
    public void start() {
        while(true) {
            try {
                //this.mutex.acquire();
                
                if(this.pista.isSaida()) {
                    this.pista.setCarro(null);
                    ControllerMalhaRodoviaria.getInstancia().notifyTableModelChanged();
                    
                    this.finalize();
                }
                
                Pista proximaPista = this.getProximaPistaRandom();
                
                this.pistaAnterior = this.pista;
                this.pistaAnterior.setCarro(null);
                
                this.pista = proximaPista;
                this.pista.setCarro(this);
                
                ControllerMalhaRodoviaria.getInstancia().notifyTableModelChanged();
                
                sleep(1000);
            } 
            catch (InterruptedException ex) {} 
            catch (Throwable ex) {}
            finally {
                //this.mutex.release();
            }
        }
    }
    
    /** Busca uma proxima pista aleatoria */
    private synchronized Pista getProximaPistaRandom() {
        Pista pista = null;
        
        Random random       = new Random();
        int numeroAleatorio = random.nextInt(4) + 1;
        
        switch(numeroAleatorio) {
            case 1:
                pista = this.pista.getPistaEsquerda();
                break;
            case 2:
                pista = this.pista.getPistaSuperior();
                break;
            case 3:
                pista = this.pista.getPistaDireita();
                break;
            case 4:
                pista = this.pista.getPistaInferior();
                break;
        }
        
        if(this.pistaAnterior != null && pista.equals(this.pistaAnterior)) {
            pista = this.getProximaPistaRandom();
        }
        else if(!pista.isTransitavel()) {
            pista = this.getProximaPistaRandom();
        }
        
        return pista;
    }
}