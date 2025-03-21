/** @author Joseph Manno AKA OblativeShielding */
package com.oblativeshielding.pizzanburgers;

/**
 * Abstract class encompassing all components of meals.
 * 
 * <p>Each component added to a meal, such as the bun for a hamburger or pepperoni on a pizza,
 * is an instance of MealComponent.
 */
public class MealComponent implements Comparable<MealComponent> {
    
  // Price formatting string
  private static final String PRICE_FORMAT = "$%d.%02d";
  // Receipt formatting string
  private static final String RECEIPT_FORMAT = "    %-26.26s %9s";

  // MealComponent attributes
  private final String name;
  private final int price;

  /**
   * MealComponent constructor using an existing MenuItem instance to fill its attributes.
   */
  public MealComponent(MenuItem m) {
    name = m.getName();
    price = m.getPrice();
  }

  /**
   * Returns the name of the component.
   * 
   * @return A string containing the name of the component
   */
  public String getName() {
    return name;
  }

  /**
   * Returns price as an integer number of cents.
   * 
   * @return An integer denoting the price of the component in cents
   */
  public int getPrice() {
    return price;
  }

  /**
   * Returns price as a nicely formatted string.
   * 
   * @return A string displaying the price of the component with a dollar sign and decimal point
   */
  public String getPriceFormatted() {
    return String.format(PRICE_FORMAT, price/100, price%100);
  }

  /**
   * Returns the component's info formatted to look nice on a receipt.
   * 
   * @return a string displaying the name and price of the component
   */
  public String getReceiptString() {
    return String.format(RECEIPT_FORMAT, name, getPriceFormatted());
  }

  /**
   * Overrides equals.
   * 
   * @return true if name and price are equal, otherwise false.
   */
  @Override
  public boolean equals(Object other) {
    if (other instanceof MealComponent) {
      MealComponent m = (MealComponent) other;
      return ((this.price == m.getPrice()) && (this.name.equals(m.getName())));
    } else {
      return false;
    }
  }

  /**
   * Overrides hashCode() to suppress warning.
   * 
   * Just calls super hashCode.
   * 
   * @return the int returned by super.hashCode()
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * Overrides compareTo from Comparable.
   * 
   * Checks for equality first, then compares prices, then names.
   * 
   * @return an int whose relationship to 0 reflects the relationship of this item to the param
   */
  @Override
  public int compareTo(MealComponent other) {
    if (this.equals(other)) {
      return 0;
    } else {
      int priceDiff = this.price - other.getPrice();
      if (priceDiff != 0) {
        return priceDiff;
      } else {
        return this.name.compareTo(other.getName());
      }
    }
  }

}
