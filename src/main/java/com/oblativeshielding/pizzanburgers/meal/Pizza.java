/** @author Joseph Manno AKA OblativeShielding */
package com.oblativeshielding.pizzanburgers.meal;

import com.oblativeshielding.pizzanburgers.Meal;
import com.oblativeshielding.pizzanburgers.MenuItem;
import com.oblativeshielding.pizzanburgers.MenuItemCategory;

/**
 * Class containing infromation for pizza orders.
 */
public class Pizza extends Meal {

  /** Static list of all menu item categories for Pizza. */
  private final static MenuItemCategory[] CATEGORIES = {
    new MenuItemCategory("Crust", 1, 1, new MenuItem[]{
      new MenuItem("Thin Crust", 250),
      new MenuItem("Puffy Crust", 299),
      new MenuItem("Thick Crust", 299),
      new MenuItem("Cheesy Crust", 349)
    }),
    new MenuItemCategory("Crust Ingredient", 1, 1, new MenuItem[]{
      new MenuItem("White Flour", 0),
      new MenuItem("Wheat Flour", 25),
      new MenuItem("Potato Flour", 75),
      new MenuItem("Cauliflower", 150)
    }),
    new MenuItemCategory("Sauce", 1, 1, new MenuItem[]{
      new MenuItem("Tomato Sauce", 69),
      new MenuItem("Alfredo Sauce", 99),
      new MenuItem("Buffalo Sauce", 129)
    }),
    new MenuItemCategory("Toppings", 0, 4, new MenuItem[]{
      new MenuItem("Anchovies", 87),
      new MenuItem("Asiago", 99),
      new MenuItem("Bacon", 139),
      new MenuItem("Bell Pepper", 66),
      new MenuItem("Jalapeno", 72),
      new MenuItem("Mozzarella", 89),
      new MenuItem("Parmesan", 115),
      new MenuItem("Pepperoni", 99),
      new MenuItem("Red Onion", 75),
      new MenuItem("Sausage", 119),
      new MenuItem("Tomatoes", 49)
    })
  };

  /**
   * Constructor for pizza.
   * 
   * <p>Simply calls super().
   */
  public Pizza(String orderName, MenuItem[] menuItems) {
    super(orderName, menuItems);
  }

  /**
   * Returns the type of meal (Pizza).
   * 
   * @return A string containing "Pizza".
   */
  @Override
  public String getMealType() {
    return "Pizza";
  }

  /**
   * Returns menu item categories for Pizza.
   * @return The static list of MenuItemCategory objects defined for Pizza.
   */
  public static MenuItemCategory[] getCategories() {
    return CATEGORIES;
  }

}
