package Controller;

import View.InterfaceViewObserver;

/**
 * Interface Observed do Controller
 * @author Jean Poffo
 * @since 02/09/2018
 */
public interface InterfaceControllerObserved {
    
    public void addObserver(InterfaceViewObserver observer);
    
    public void removeObserver(InterfaceViewObserver observer);   
}