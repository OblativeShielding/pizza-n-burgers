/**@author Joseph Manno AKA OblativeShielding */
package com.oblativeshielding.pizzanburgers.controllers;

import java.util.ArrayList;

import com.oblativeshielding.pizzanburgers.Meal;
import com.oblativeshielding.pizzanburgers.MenuItem;
import com.oblativeshielding.pizzanburgers.meal.Burger;
import com.oblativeshielding.pizzanburgers.meal.Pizza;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/*
 * Root scene for PizzaNBurgers.
 * 
 * This class mediates interaction between GUI elements
 * and handles most of the backend processing as well.
 */
public class RootScene {

    // List of all ordered meals
    private final ArrayList<Meal> meals = new ArrayList<>();

    // Nodes
    @FXML private HBox rootHBox;
    @FXML private VBox mainMenu;
    @FXML private MainMenu mainMenuController;
    @FXML private TextArea receiptArea;
    private MealMenu burgerMenu;
    private MealMenu pizzaMenu;

    /*
     * Sets up the scene and its children on startup.
     */
    public void initialize() {

        mainMenuController.setRoot(this);
        receiptArea.setFont(Font.font("Monospace", 12));
        // add meal menus here
        burgerMenu = new MealMenu(Burger.getCategories(), this);
        pizzaMenu = new MealMenu(Pizza.getCategories(), this);
        displayReceipt();

    }

    /*
     * Opens the menu to create a new burger.
     */
    public void newBurger() {
        rootHBox.getChildren().set(0, burgerMenu);
    }

    /*
     * Opens the menu to create a new pizza.
     */
    public void newPizza() {
        rootHBox.getChildren().set(0, pizzaMenu);
    }

    /*
     * Clears all meals on the receipt, resetting it to empty.
     */
    public void clearReceipt() {
        meals.clear();
        displayReceipt();
    }

    /*
     * Order a meal with the given menu items.
     */
    public void orderMeal(String orderName, MenuItem[] items) {
        // verify that currently on meal menu
        if(rootHBox.getChildren().get(0) instanceof MealMenu) {
            MealMenu currentMenu = (MealMenu) rootHBox.getChildren().get(0);
            // create meal based on menu
            if(currentMenu == burgerMenu) {
                meals.add(new Burger(orderName, items));
            } else if(currentMenu == pizzaMenu) {
                meals.add(new Pizza(orderName, items));
            } else {
                System.out.println("ERROR: Unknown meal menu. Order failed.");
            }
            // clear meal menu
            currentMenu.reset();
            // update receipt
            displayReceipt();
            // return to main menu
            cancelOrder();
        } else {
            System.out.println("ERROR: Not currently on a meal menu. Order Failed.");
        }
    }

    /*
     * Cancel meal order and return to main menu.
     */
    public void cancelOrder() {
        rootHBox.getChildren().set(0, mainMenu);
    }

    // print receipt to text area
    private void displayReceipt() {
        // sort meals in ascending order of price
        meals.sort(null);
        // prep receipt string
        String s = "";
        int total = 0;
        for(Meal m : meals) {
            s += m.getReceipt() + "\n\n";
            total += m.getPrice();
        }
        String totalFormatted = String.format("$%d.%02d", total/100, total%100);
        s += "Grand Total: " + String.format("%27s", totalFormatted);

        receiptArea.setText(s);
    }

}
