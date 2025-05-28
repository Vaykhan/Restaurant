import Utils.ScUtil;
import imp.RestaurantImplementation;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        RestaurantImplementation rt = new RestaurantImplementation();
        ScUtil sc = new ScUtil();

        System.out.println("""
                
                ================================================
                ===========Welcome to our Restaurant============
                ================================================
                             Come, Take a seat!
                
                """);
        while(true) {
            System.out.print("""
                
                What would like to do?
                1 - See the menu;
                2 - See your order;
                3 - Add an item to your order;
                4 - Remove an item from your order;
                5 - Display the total price of your order;
                6 - Order the food;
                7 - Exit
                >>>""");
            String choice = sc.GetString();

            switch (choice) {
                case "1":
                    RestaurantImplementation.listMenu();
                    break;
                case "2":
                    rt.listOrder();
                    break;
                case "3":
                    rt.addItemToOrder();
                    break;
                case "4":
                    rt.removeItemFromOrder();
                    break;
                case "5":
                    System.out.println("The total price is: " + rt.calculatePrice());
                    break;
                case "6":
                    System.out.println("*Cash register sounds*,*Ka-ching* \"-" + rt.calculatePrice() + "$\" ,Your order will be ready in 15 minutes, Sir!");
                    rt.clearOrder();

                    System.out.println("Thank you for choosing us");
                    break;


                case "7":
                    System.out.print("Were you content with our services? [Y/N]\n>>>");
                    String isContent = sc.GetString();
                    if (isContent.equalsIgnoreCase("yes") || isContent.equalsIgnoreCase("ye") || isContent.equalsIgnoreCase("y")) {
                    System.out.println("Thank you for using our service");
                    return;}
                    else{
                    System.out.println("Sorry, Your opinion is not correct, Now go back to ordering!!🤬");
                }
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                }

            }
        }
    }

