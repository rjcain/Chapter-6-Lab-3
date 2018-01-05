// ***************************************************************
//   Item.java
//
//   Represents an item in a shopping cart.
// ***************************************************************
import java.text.NumberFormat;
public class Item
{
    NumberFormat money = NumberFormat.getCurrencyInstance();
    public String name;
    public double price;
    public int quantity;
    public static int index = 0;
    public int itemIndex;
    // -------------------------------------------------------
    //  Create a new item with the given attributes.
    // -------------------------------------------------------
    public Item (String itemName, double itemPrice, int numPurchased)
    {
        name = itemName;
        price = itemPrice;
        quantity = numPurchased;
        index++;
        itemIndex = index;
    }
    // -------------------------------------------------------
    //   Return a string with the information about the item
    // -------------------------------------------------------
    public String toString ()
    {
        return "\nItem " + itemIndex + ": " + this.name + ": " 
        + money.format(price) + "  Quantity: " + this.quantity;
    }
 } 