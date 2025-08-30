package imp;

import Utils.ScUtil;
import imp.ImpInterface;
import ordertypes.Appetizer;
import ordertypes.BasicItem;
import ordertypes.Drink;
import ordertypes.MainCourse;
import java.util.HashMap;

public class RestaurantImplementation implements ImpInterface {
    HashMap<BasicItem, Integer> Order = new HashMap<>();
    static BasicItem[] Menu = {
            new Appetizer("Spicy Nugs", "Deep-fried chicken nuggets with some heat", 2.50, (byte) 8),
            new Appetizer("Lentil Soup", "A Turkish Delicacy", 2.0, (byte) 2),
            new Drink("Ayran", "A salty but refreshing yogurt drink", 0.8, false),
            new Drink("Cola", "Classic and refreshing", 0.8, true),
            new MainCourse("Piti", "Lamb, chickpeas cooked in special pot for hours", 8.0, "Dried Plums"),
            new MainCourse("Shah Plov", "No need for explanation, just try it", 12.2, "Saffron")

    };
    ScUtil Scan = new ScUtil();


    @Override
    public void addItemToOrder() {
        try {
            System.out.print("What would you like to add to your order?: ");
            String userinput = Scan.GetString();
            System.out.print("How many?: ");
            int quantity = Scan.GetInt();
            Scan.GetString();

            if (quantity <= 0) {
                System.out.println("Invalid quantity!");
                return;
            }

            boolean itemFound = false;
            for (BasicItem item : Order.keySet()) {
                if (item.getItemName().equalsIgnoreCase(userinput)) {
                    Order.put(item, Order.get(item) + quantity);
                    itemFound = true;
                    System.out.println("Added!");
                    break;
                }
            }

            if (!itemFound) {
                boolean itemExistsInMenu = false;
                for (BasicItem item : Menu) {
                    if (item.getItemName().equalsIgnoreCase(userinput)) {
                        Order.put(item, quantity);
                        itemExistsInMenu = true;
                        System.out.println("Added!");
                        break;
                    }
                }

                if (!itemExistsInMenu) {
                    System.out.println("Sorry, that item does not exist in the menu.");
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }
    public void clearOrder() {
        Order.clear();
    }





    @Override
    public void listOrder() {
        if (Order.size() == 0) {
            System.out.println("There are no items in your Order!");
            return;
        }
        System.out.printf("%-12s %-10s %-10s\n", "Name", "Price", "Quantity");
        System.out.println("====================================================");

        for(BasicItem item : Order.keySet()) {
            System.out.printf("%-12s $%-9.2f %-10d\n", item.getItemName(), item.getItemPrice(), Order.get(item));
            System.out.println("====================================================");
        }
    }
    @Override
    public void removeItemFromOrder() {
        System.out.print("What would you like to remove from your order?: ");
        String userinput = Scan.GetString();

        try{
            for(BasicItem item : Order.keySet()) {
                if (item.getItemName().equalsIgnoreCase(userinput)) {
                    Order.remove(item);
                }
            }
        }
        catch(Exception e){
            System.out.println("Sorry, that item does not exist in your order");
        }
        checkFor0s();

    }

    @Override
    public Double calculatePrice() {
        Double FinalPrice = 0.0;
        for(BasicItem MenuItem : Order.keySet()) {
            Integer quantity = Order.get(MenuItem);
            Double ItemsPrice = MenuItem.getItemPrice()*quantity;
            FinalPrice += ItemsPrice;
        }
        return FinalPrice;
    }

    @Override
    public void checkFor0s() {
    for(BasicItem OrderItem : Order.keySet()) {
        if (!(Order.get(OrderItem)>0)) {
            Order.remove(OrderItem);
        }
    }
    }


    public static void listMenu() {
        System.out.println("Menu:");
        for (BasicItem basicItem : Menu) {
            System.out.println(basicItem);
            System.out.println("=======================================================");
        }
    }
}





