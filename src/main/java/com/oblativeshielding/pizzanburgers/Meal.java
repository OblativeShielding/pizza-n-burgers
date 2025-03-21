/** @author Joseph Manno AKA OblativeShielding */
package com.oblativeshielding.pizzanburgers;

/**
 * Abstract class defining general behavior for meal orders.
 */
public abstract class Meal implements Comparable<Meal> {

  /** List of all components in meal */
  private final MealComponent[] components;
  /** Name on order */
  private final String orderName;
    
  /**
   * Abstract constructor for meals.
   */
  public Meal(String orderName, MenuItem[] menuItems) {
    this.orderName = orderName;
    components = new MealComponent[menuItems.length];
    for (int i = 0; i < components.length; i++) {
      components[i] = new MealComponent(menuItems[i]);
    }
  }

  /**
   * Returns total price of meal as an integer.
   * 
   * @return An integer that is the sum of this meal's components' prices in cents.
   */
  public int getPrice() {
    int price = 0;
    for (MealComponent m : components) {
      price += m.getPrice();
    }
    return price;
  }

  /**
   * Returns orderName.
   * 
   * @return A string containing the name assigned to this order.
   */
  public String getOrderName() {
    return orderName;
  }

  /**
   * Returns a reference to the array of components.
   * 
   * @return The array of MealComponent objects contained in this meal.
   */
  public MealComponent[] getComponents() {
    return components;
  }

  /**
   * Returns total price of meal formatted into a nice dollar amount string.
   * 
   * @return A string displaying the price of the meal with dollar sign and decimal.
   */
  public String getPriceFormatted() {
    int p = getPrice();
    return String.format("$%d.%02d", p/100, p%100);
  }

  /**
   * Returns the meal's detailed info as a string.
   * 
   * @return A string listing the components and prices nicely formatted.
   */
  public String getReceipt() {
    // Header
    String r = getMealType() + (orderName.equals("") ? "" : " - " + orderName);
    // Components
    for (MealComponent m : components) {
      r += "\n" + m.getReceiptString();
    }
    // Total
    r += "\nTotal: " + String.format("%33s", getPriceFormatted());
      
    return r;
  }
    
  /**
   * Implements compare function for meals.
   * 
   * <p>Consistent with equals. Compares prices first, then order names, meal types,
   * component counts, and components as needed to break ties.
   * 
   * @returns An integer whose relationship to 0 indicates this objects comparison to the parameter
   */
  @Override
  public int compareTo(Meal otherMeal) {
    // Compare price first
    int diff = this.getPrice() - otherMeal.getPrice();
    if (diff != 0) {
      return diff;
    } else {
      // Compare order names if tied in price
      // diff is just for comparison storage, and is used multiple times
      diff = this.orderName.compareTo(otherMeal.getOrderName());
      if (diff != 0) {
        return diff;
      } else {
        // Compare meal types if names are equal
        diff = this.getMealType().compareTo(otherMeal.getMealType());
        if (diff != 0) {
          return diff;
        } else {
          // Compare component list sizes if types are equal
          MealComponent[] otherComponents = otherMeal.getComponents();
          diff = components.length - otherComponents.length;
          if (diff != 0) {
            return diff;
          } else {
            // Compare individual components if number of components is equal
            try {
              for (int i = 0; i < components.length; i++) {
                diff = components[i].compareTo(otherComponents[i]);
                if (diff != 0) {
                  return diff;
                }
              }
              // All items are equal
              return 0;
            } catch (ArrayIndexOutOfBoundsException e) {
              System.out.println("Error encountered during sort.");
              return 1;
            }
          }
        }
      }
    }
  }

  /**
   * Overrides equals method from Object.
   * 
   * Uses Meal's implementation of compareTo to check equality.
   * 
   * @return true if all fields are equal (theoretically) and false otherwise.
   */
  @Override
  public boolean equals(Object other) {
    if (other instanceof Meal) {
      return (this.compareTo((Meal) other) == 0);
    } else {
      return false;
    }
  }

  /**
   * Overrides hashCode to suppress warning for equals.
   * 
   * Simply calls super.
   * 
   * @return the integer provided by super.hashCode()
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /** Returns the type of meal as a string. */
  public abstract String getMealType();

}
