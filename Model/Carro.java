package Model;

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
    
    @Override
    public void run() {
        
    }
}