/**@author Joseph Manno AKA OblativeShielding */
package com.oblativeshielding.pizzanburgers.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;

/*
 * Controller for the menu between meal orders.
 */
public class MainMenu {

    // Error message
    private final String UNASSIGNED_ROOT_MESSAGE = "Error: MainMenu root unassigned.";

    // Instantiating root scene
    private RootScene root;

    /*
     * Tells root to make a new burger.
     */
    @FXML @SuppressWarnings("unused")
    private void newBurger() {
        if(root != null) {
            root.newBurger();
        } else {
            System.out.println(UNASSIGNED_ROOT_MESSAGE);
        }
    }

    /*
     * Tells root to make a new pizza.
     */
    @FXML @SuppressWarnings("unused")
    private void newPizza() {
        if(root != null) {
            root.newPizza();
        } else {
            System.out.println(UNASSIGNED_ROOT_MESSAGE);
        }
    }

    /*
     * Tells root to clear the receipt.
     */
    @FXML @SuppressWarnings("unused")
    private void clear() {
        if(root != null) {
            root.clearReceipt();
        } else {
            System.out.println(UNASSIGNED_ROOT_MESSAGE);
        }
    }

    /*
     * Exits the application.
     * 
     * Called by exit button.
     */
    @FXML @SuppressWarnings("unused")
    private void exit() {
        Platform.exit();
    }

    /*
     * Sets the root scene so MainMenu can call its functions.
     */
    public void setRoot(RootScene r) {
        root = r;
    }
    
}
