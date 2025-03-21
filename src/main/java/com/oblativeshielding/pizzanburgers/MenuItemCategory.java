/** @author Joseph Manno AKA OblativeShielding */
package com.oblativeshielding.pizzanburgers;

/**
 * Category class for menu items.
 * 
 * <p>This class exists to help sort items within the menu based on the meal that creates it.
 * Fields are public since they cannot be changed once instantiated.
 */
public class MenuItemCategory {
    
  /** The name of the category. */
  public final String categoryName;
  /** The maximum number of items that can be selected from this category. */
  public final int max;
  /** The minimum number of items that must be selected from this category. */
  public final int min;
  /** A list of all the menu items within this category. */
  public final MenuItem[] items;

  /*
   * Constructor for MenuItemCategory.
   */
  public MenuItemCategory(String categoryName, int min, int max, MenuItem[] items) {
    this.categoryName = categoryName;
    this.min = min;
    this.max = max;
    this.items = items;
  }

}
