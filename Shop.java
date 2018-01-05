// ***************************************************************
//   Shop.java
//
//   Uses the Item class to create items and add them to a shopping
//   cart stored in an ArrayList.
// ***************************************************************
import java.util.ArrayList;
import java.util.Scanner;
import java.text.NumberFormat;
public class Shop
{
    public static void main (String[] args) {
        ArrayList<Item> cart = new ArrayList<Item>();
        Item item;
        String itemName;
        double itemPrice;
        int quantity;
        double totalPrice = 0;
        Scanner scan = new Scanner(System.in);
        String keepShopping = "y";
        while (keepShopping.equals("y")) 
            {
                System.out.print ("Enter the name of the item: ");
                itemName = scan.next();
                
                System.out.print ("Enter the unit price: ");
                itemPrice = scan.nextDouble();
                
                System.out.print ("Enter the quantity: ");
                quantity = scan.nextInt();
                
                totalPrice += itemPrice*quantity;
                // *** create a new item and add it to the cart
                
                Item thing = new Item(itemName, itemPrice, quantity);
                cart.add(thing);
                
                // *** print the contents of the cart object using println
                System.out.print ("Continue shopping (y/n)? ");
                keepShopping = scan.next();
            }
        checkOut(cart, totalPrice);
   }
   public static void checkOut(ArrayList<Item> yourCart, double total) {
       NumberFormat money = NumberFormat.getCurrencyInstance();
       Scanner scan = new Scanner(System.in);
       String answer = "y";
       
       System.out.print("YOUR CART: ");
       for(int i = 0; i < yourCart.size(); i++) {
           System.out.print(yourCart.get(i));
        }
       System.out.println();
       System.out.println("Total: " + money.format(total));
       while(true) {
           System.out.println();
           System.out.println("Remove an item (y/n)?");
           if(scan.next().equals("y")) {
                System.out.println("Input item number to be removed: ");
                int itemIndex = scan.nextInt()-1;
                System.out.println("How many would you like to remove?");
                int removalQuantity = scan.nextInt();
                if(yourCart.get(itemIndex).quantity > removalQuantity) {
                    yourCart.get(itemIndex).quantity -= removalQuantity;
                }
                else {
                    yourCart.remove(itemIndex);
                }
                
                total -= yourCart.get(itemIndex).price;
                
                System.out.print("YOUR CART: ");
                for(int i = 0; i < yourCart.size(); i++) {
                    System.out.print(yourCart.get(i));
                }
                System.out.println();
                System.out.println("Total: " + money.format(total));
            }
            else {
                break;
            }
       }
       System.out.println("Total: " + money.format(total));
       
   }
}
