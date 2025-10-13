import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        String[] shoppingList = {"Biscuits", "Noodles", "Milk", "Cheese", "Shampoo"};

       
        System.out.println("Your shopping list:");
        for (int i = 0; i < shoppingList.length; i++) {
            System.out.print(shoppingList[i]);
            if (i < shoppingList.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("\n\nYou entered " + shoppingList.length + " items.");

        
        System.out.print("\nSearch for an item: ");
        String searchItem = input.nextLine();

        
        boolean found = false;
        for (String item : shoppingList) {
            if (item.equalsIgnoreCase(searchItem)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("✓ " + searchItem + " is in your shopping list!");
        } else {
            System.out.println("X " + searchItem + " is not in your shopping list.");
        }

        input.close();
    }
                           }
