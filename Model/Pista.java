package Model;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * Classe modelo da Pista
 * @author Jean Poffo
 * @since 02/09/2018
 */
public class Pista {
    
    public static final String IMAGEM_ACIMA    = "/View/Icons/acima.png";
    public static final String IMAGEM_ABAIXO   = "/View/Icons/abaixo.png";
    public static final String IMAGEM_DIREITA  = "/View/Icons/direita.png";
    public static final String IMAGEM_ESQUERDA = "/View/Icons/esquerda.png";
    
    private int id;
    
    private boolean transitavel;
    
    private boolean saida;
    
    private boolean entrada;
    
    private Pista pistaEsquerda; 
    
    private Pista pistaDireita; 
    
    private Pista pistaSuperior; 
    
    private Pista pistaInferior; 
    
    private Carro carro;
    
    private Color cor;
    
    private ImageIcon icone;

    public Pista() {}

    public Pista(Color cor) {
        this.cor = cor;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTransitavel() {
        return transitavel;
    }

    public void setTransitavel(boolean transitavel) {
        this.transitavel = transitavel;
    }

    public boolean isSaida() {
        return saida;
    }

    public void setSaida(boolean saida) {
        this.saida = saida;
    }

    public boolean isEntrada() {
        return entrada;
    }

    public void setEntrada(boolean entrada) {
        this.entrada = entrada;
    }    
    
    public Pista getPistaEsquerda() {
        return pistaEsquerda;
    }

    public void setPistaEsquerda(Pista pistaEsquerda) {
        this.pistaEsquerda = pistaEsquerda;
    }

    public Pista getPistaDireita() {
        return pistaDireita;
    }

    public void setPistaDireita(Pista pistaDireita) {
        this.pistaDireita = pistaDireita;
    }

    public Pista getPistaSuperior() {
        return pistaSuperior;
    }

    public void setPistaSuperior(Pista pistaSuperior) {
        this.pistaSuperior = pistaSuperior;
    }

    public Pista getPistaInferior() {
        return pistaInferior;
    }

    public void setPistaInferior(Pista pistaInferior) {
        this.pistaInferior = pistaInferior;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    
    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }    

    public ImageIcon getIcone() {
        return icone;
    }

    public void setIcone(ImageIcon icone) {
        this.icone = icone;
    }
}