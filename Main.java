import Controller.ControllerMalhaRodoviaria;
import View.ViewMalhaRodoviaria;

/**
 * Classe principal do istema
 * @author Jean Poffo
 * @since 02/09/2018
 */
public class Main {
    
    public static void main(String[] args) {
        ControllerMalhaRodoviaria controllerSistema = new ControllerMalhaRodoviaria();
        ViewMalhaRodoviaria       viewSistema       = new ViewMalhaRodoviaria(controllerSistema);
        
        viewSistema.setVisible(true);
    }
}