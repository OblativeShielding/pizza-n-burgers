/** @author Joseph Manno AKA OblativeShielding */
package com.oblativeshielding.pizzanburgers.controllers;

import javafx.scene.control.Alert.AlertType;

import com.oblativeshielding.pizzanburgers.MenuItem;
import com.oblativeshielding.pizzanburgers.MenuItemCategory;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

/**
 * JavaFX-based class generating menus for meal orders.
 */
public class MealMenu extends GridPane {

  private RootScene root;
  private final MenuItemCategory[] categories;
  private TextField orderName;
  private ArrayList<ArrayList<ChoiceBox<MenuItem>>> choices = new ArrayList<>();
    
  /**
   * Constructor class to build a new menu from an array of MenuItemCategory objects.
   */
  public MealMenu(MenuItemCategory[] categoryArray, RootScene root) {

    this.root = root;
    categories = categoryArray;

    this.setHgap(5);
    this.setVgap(5);

    // Add order name field
    this.add(new Label("Order Name:"), 0, 0);
    orderName = new TextField();
    this.add(orderName, 1, 0);

    /** keeps track of gridpane rows */
    int rowCounter = 1;

    // iterate through categories
    for (int i = 0; i < categories.length; i++) {

      MenuItemCategory c = categories[i];
      // add new list for category
      choices.add(new ArrayList<>());
      // add new choice box(es) for category
      for (int j = 0; j < c.max; j++) {
        // label (with number if more than one)
        Label l = new Label(c.categoryName + (c.max == 1 ? "" : " #" + (j+1)) + ": ");
        // add label
        this.add(l, 0, rowCounter);
        // set up choice box
        ChoiceBox<MenuItem> choice = new ChoiceBox<>();
        // add string converter
        choice.setConverter(new StringConverter<MenuItem>(){
        
          @Override
          public String toString(MenuItem m) {
            if (m == null) {
              return "<None>";
            } else {
              return m.getName() + " - " + m.getPriceFormatted();
            }
          }
            
          @Override
            public MenuItem fromString(String s) {
              return null;
            }
            
        });
        // add choices to choicebox
        choice.getItems().addAll(Arrays.asList(c.items));
        if (c.min < c.max) {
          choice.getItems().add(null);
        }
        // add choicebox to list
        choices.get(i).add(choice);
        // add choicebox to gridpane
        this.add(choice, 1, rowCounter);
                
        rowCounter++;
      }

    } // end of category for loop

    // add cancel button
    Button cancelButton = new Button("Cancel");
    cancelButton.setOnAction((ActionEvent e) -> {
      cancel();
    });
    this.add(cancelButton, 0, rowCounter);

    // add order button
    Button orderButton = new Button("Order");
    orderButton.setOnAction((ActionEvent e) -> {
      order();
    });
    this.add(orderButton, 1, rowCounter);

  } // end of constructor

  /**
   * Resets the menu so it will be ready for the next order.
   */
  public void reset() {
    orderName.setText("");
    for (ArrayList<ChoiceBox<MenuItem>> list : choices) {
      for (ChoiceBox<MenuItem> box : list) {
        box.setValue(null);
      }
    }
  }

  /** Called on Cancel button click. */
  private void cancel() {
    reset();
    root.cancelOrder();
  }

  /** Called on Order button click. */
  private void order() {
    // create MenuItem list
    ArrayList<MenuItem> components = new ArrayList<>();
    // add selections
    for (int i = 0; i < categories.length; i++) {
      MenuItemCategory c = categories[i];
      int minCounter = c.min;
      for (ChoiceBox<MenuItem> b : choices.get(i)) {
        if (b.getValue() != null) {
          components.add(b.getValue());
          minCounter--;
        }
      }
      // stop here if insufficient selections
      if (minCounter > 0) {
        Alert a = new Alert(AlertType.INFORMATION,
            "Please select " + minCounter + " more " + c.categoryName);
        a.showAndWait();
        return;
      }
    }

    // have root order meal based on components
    MenuItem[] componentArray = new MenuItem[components.size()];
    for (int i = 0; i < components.size(); i++) {
      componentArray[i] = components.get(i);
    }
    root.orderMeal(orderName.getText(), componentArray);

  }

}
