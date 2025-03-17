/**@author Joseph Manno AKA OblativeShielding */
package com.oblativeshielding.pizzanburgers;

/*
 * Category class for menu items.
 * 
 * This class exists to help items within the menu based on the meal that creates it.
 */
public class MenuItemCategory {
    
    // attributes
    public final String categoryName;
    public final int max;
    public final int min;
    public final MenuItem[] components;

    /*
     * Constructor for MenuItemCategory.
     */
    public MenuItemCategory(String categoryName, int min, int max, MenuItem[] components) {
        this.categoryName = categoryName;
        this.min = min;
        this.max = max;
        this.components = components;
    }

}
