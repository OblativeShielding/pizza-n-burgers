/** @author Joseph Manno AKA OblativeShielding */
package com.oblativeshielding.pizzanburgers.meal;

import com.oblativeshielding.pizzanburgers.Meal;
import com.oblativeshielding.pizzanburgers.MenuItem;
import com.oblativeshielding.pizzanburgers.MenuItemCategory;

/**
 * Class containing information for burger orders.
 */
public class Burger extends Meal {

  /** Static list of all menu item categories for Burger. */
  private final static MenuItemCategory[] CATEGORIES = {
    new MenuItemCategory("Bun", 1, 1, new MenuItem[]{
      new MenuItem("Sesame Seed Bun", 50),
      new MenuItem("Brioche Bun", 99),
      new MenuItem("Potato Bread", 89),
      new MenuItem("Pretzel Bun", 129)
    }),
    new MenuItemCategory("Patty", 0, 4, new MenuItem[]{
      new MenuItem("Beef Patty", 75),
      new MenuItem("Fried Chicken", 99),
      new MenuItem("Prawn Burger", 199),
      new MenuItem("Soy-based Burger Substitute", 249)
    }),
    new MenuItemCategory("Cheese", 0, 4, new MenuItem[]{
      new MenuItem("American Cheese", 39),
      new MenuItem("Colby Jack", 59),
      new MenuItem("Swiss", 65),
      new MenuItem("Pepperjack", 99),
      new MenuItem("Provolone", 69)
    }),
    new MenuItemCategory("Garnish", 0, 4, new MenuItem[]{
      new MenuItem("Pickles", 25),
      new MenuItem("Mustard", 19),
      new MenuItem("Tomato", 24),
      new MenuItem("Bacon", 129),
      new MenuItem("Onion", 15),
      new MenuItem("Lettuce", 5)
    })
  };

  /**
   * Constructor for burger.
   * 
   * <p>Simply calls super().
   */
  public Burger(String orderName, MenuItem[] menuItems) {
    super(orderName, menuItems);
  }

  /**
   * Returns the type of this meal (Burger).
   * 
   * @return A string containing "Burger".
   */
  @Override
  public String getMealType() {
    return "Burger";
  }

  /**
   * Returns menu item categories for Burger.
   * 
   * @return The static list of MenuItemCategory object defined for Pizza.
   */
  public static MenuItemCategory[] getCategories() {
    return CATEGORIES;
  }
    
}
