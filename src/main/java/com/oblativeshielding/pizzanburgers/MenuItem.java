/** @author Joseph Manno AKA OblativeShielding */
package com.oblativeshielding.pizzanburgers;

/**
 * Contains information for the menu to utilize when displaying and ordering items.
 * 
 * <p>One MenuItem for each possible menu item should be initialized on startup. The menu GUI
 * displays information contained in these instances, and new items use the same information
 * to initialize.
 */
public class MenuItem {

  private static final String PRICE_FORMAT = "$%d.%02d";
    
  private final String name;
  private final int price;

  /**
   * Constructs a new menu item with the specified information.
   */
  public MenuItem(String name, int price) {
    this.name = name;
    this.price = price;
  }

  /**
   * Returns the price formatted nicely.
   * 
   * @return a string displaying the price with a dollar sign and decimal point
   */
  public String getPriceFormatted() {
    return String.format(PRICE_FORMAT, price/100, price%100);
  }

  /**
   * Returns the name of the menu item.
   * 
   * @return a string containing the name of the item.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the item's price.
   * 
   * @return an int storing the price of the item (in cents)
   */
  public int getPrice() {
    return price;
  }

}