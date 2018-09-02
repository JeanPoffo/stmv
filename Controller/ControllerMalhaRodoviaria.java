package Controller;

import View.InterfaceViewObserver;
import java.util.List;
import java.util.ArrayList;

/**
 * Controller principal do sistema
 * @author Jean Poffo
 * @since 02/08/2018
 */
public class ControllerMalhaRodoviaria implements InterfaceControllerObserved {

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
}