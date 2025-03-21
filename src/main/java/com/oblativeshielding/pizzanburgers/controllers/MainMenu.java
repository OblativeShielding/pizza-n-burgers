/** @author Joseph Manno AKA OblativeShielding */
package com.oblativeshielding.pizzanburgers.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;

/**
 * Controller for the menu between meal orders.
 */
public class MainMenu {

  /** Error message */
  private static final String UNASSIGNED_ROOT_MESSAGE = "Error: MainMenu root unassigned.";

  /** Instantiating root scene */
  private RootScene root;

  /**
   * Sets the root scene so MainMenu can call its functions.
   */
  public void setRoot(RootScene r) {
    root = r;
  }

  /**
   * Tells root to open the menu for a new burger.
   * 
   * <p>Called by burger button.
   */
  @FXML
  @SuppressWarnings("unused")
  private void startBurger() {
    if (root != null) {
      root.startBurger();
    } else {
      System.out.println(UNASSIGNED_ROOT_MESSAGE);
    }
  }

  /**
   * Tells root to open the menu for a new pizza.
   * 
   * <p>Called by pizza button.
   */
  @FXML
  @SuppressWarnings("unused")
  private void startPizza() {
    if (root != null) {
      root.startPizza();
    } else {
      System.out.println(UNASSIGNED_ROOT_MESSAGE);
    }
  }

  /**
   * Tells root to clear the receipt.
   * 
   * <p>Called by clear button.
   */
  @FXML
  @SuppressWarnings("unused")
  private void clear() {
    if (root != null) {
      root.clearReceipt();
    } else {
      System.out.println(UNASSIGNED_ROOT_MESSAGE);
    }
  }

  /**
   * Exits the application.
   * 
   * <p>Called by exit button.
   */
  @FXML
  @SuppressWarnings("unused")
  private void exit() {
    Platform.exit();
  }
    
}
