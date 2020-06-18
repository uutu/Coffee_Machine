package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeBeans = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        checkInventory(water, milk, coffeeBeans, cups);

    }

    private static void checkInventory(int water, int milk, int coffeeBeans, int cups) {

        int amountOfCups = 0;

        do {
            water -= 200;
            milk -= 50;
            coffeeBeans -= 15;
            ++amountOfCups;
        }
        while (water >= 200 && milk >= 50 && coffeeBeans >= 15);

        if (amountOfCups == cups) {
            System.out.println("Yes, I can make that amount of coffee");
        }
        else if (amountOfCups > cups) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (amountOfCups - cups) + " more than that)");
        }
        else if (amountOfCups == 0) {
            System.out.println("No, I can make only 0 cup(s) of coffee");
        }
        else {
            System.out.println("No, I can make only " + amountOfCups + " cup(s) of coffee");
        }
    }

    private static void countIngredients(int cups) {

        System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(cups * 200 + " ml of water");
        System.out.println(cups * 50 + " ml of milk");
        System.out.println(cups * 15 + " g of coffee beans");
    }
}
