import Controller.ControllerMalhaRodoviaria;
import View.ViewMalhaRodoviaria;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Classe principal do istema
 * @author Jean Poffo
 * @since 02/09/2018
 */
public class Main {
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ControllerMalhaRodoviaria controllerSistema = ControllerMalhaRodoviaria.getInstancia();
        ViewMalhaRodoviaria viewSistema = new ViewMalhaRodoviaria(controllerSistema);
        viewSistema.setVisible(true);
    }
}