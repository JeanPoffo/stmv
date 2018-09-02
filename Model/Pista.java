package Model;

import java.awt.Color;

/**
 * Classe modelo da Pista
 * @author Jean Poffo
 * @since 02/09/2018
 */
public class Pista {
    
    private int id;
    
    private boolean isTransitavel;
    
    private Pista pistaEsquerda; 
    
    private Pista pistaDireita; 
    
    private Pista pistaSuperior; 
    
    private Pista pistaInferior; 
    
    private Color cor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsTransitavel() {
        return isTransitavel;
    }

    public void setIsTransitavel(boolean isTransitavel) {
        this.isTransitavel = isTransitavel;
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

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }    
}