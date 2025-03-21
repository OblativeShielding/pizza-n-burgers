# pizza-n-burgers
Pizza'N'Burgers is a simple application to simulate an online ordering system for a restaurant selling pizza and burgers.

## Starting the Application
To run the application, you must invoke the main method within the PizzaNBurgers class. Using the command prompt to run com.oblativeshielding.pizzanburgers.PizzaNBurgers within the target/classes folder should suffice, though it can also be opened within an IDE.

## The Main Menu
The program opens displaying the main menu, as seen below.

![An image of the main menu screen of PizzaNBurgers.](/readme/MainMenu.png)

This menu contains, at this time, four buttons and a large text area. The "Add a Burger" and "Add a Pizza" buttons begin the process of ordering a burger or pizza, respectively. The "Clear Orders" button will remove all ordered meals. The "Exit" button closes the application. The large text area displays a receipt of all orders so far.

## The Ordering Menu
If you choose to add an item, you will be directed to another menu. This is what the burger menu looks like, for example:

![The freshly opened burger menu.](/readme/EmptyBurger.png)

This menu provides you with a list of options for customizing your meal. The topmost field is an optional entry for a name related to the order (such as "Franz", or "Jalapenos"), to help differentate it from others. Beneath it is a list of drop down boxes which can be used to select meal components. Even though every component is empty to begin with, some (such as a burger bun) must be selected before the meal can be ordered, while others are optional.

Lastly, at the very bottom are the "Cancel" and "Order" buttons. As you might expect, "Cancel" clears the selections and returns you to the main menu while "Order" confirms your selections and submits the order. If you attempt to submit an order without selecting all the necessary components, the program will let you know what you must do next.

![The program noticing the lack of a bun](/readme/NeedsBun.png)

Once you have successfully ordered a meal, you wil be returned to the main menu and the details of your order will appear in the receipt on the right. The receipt also includes a running total so you don't go over budget.

![A successful order](/readme/OrderSuccess.png)

## Additional Information

From here, you can order more meals if you wish. Once the receipt exceeds the screen size, the receipt pane can scroll to accommodate further orders. Meals in the receipt will not be in chronological order, but will instead be in ascending order of price, with equal prices having further tiebreakers to keep them organized. If you decide there are just too many orders, you can always click the "Clear Orders" button to reset the receipt and start again.

And, of course, when you are done ordering imaginary food with imaginary money, you can either click the exit button or the normal "X" button to close the application.

Thanks for eating at Joe's!