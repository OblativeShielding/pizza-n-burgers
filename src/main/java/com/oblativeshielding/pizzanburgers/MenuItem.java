/**@author Joseph Manno AKA OblativeShielding */
package com.oblativeshielding.pizzanburgers;

/*
 * Contains information for the menu to utilize when displaying and ordering items.
 * 
 * One MenuItem for each possible menu item should be initialized on startup. The menu GUI
 * displays information contained in these instances, and new items use the same information
 * to initialize.
 */
public class MenuItem {

    private static final String PRICE_FORMAT = "$%d.%02d";
    
    private final String name;
    private final int price;

    /*
     * Constructs a new menu item with the specified information.
     */
    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }
    /** Returns the price formatted nicely. */
    public String getPriceFormatted() {
        return String.format(PRICE_FORMAT, price/100, price%100);
    }

    /** Returns name. */
    public String getName() {
        return name;
    }
    /** Returns price. */
    public int getPrice() {
        return price;
    }

}