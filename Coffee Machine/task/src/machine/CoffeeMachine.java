package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private int water, milk, coffeeBeans, disposableCups, money;

    public CoffeeMachine() {
        water = 400;
        milk = 540;
        coffeeBeans = 120;
        disposableCups = 9;
        money = 550;
    }

    private void printInventory() {
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }

    private void depleteIngredients(int coffeeType) {

        if (coffeeType == 1) {
            water -= 250;
            coffeeBeans -= 16;
            money += 4;
        }
        else if (coffeeType == 2) {
            water -= 350;
            milk -= 75;
            coffeeBeans -= 20;
            money += 7;
        }
        else if (coffeeType == 3) {
            water -= 200;
            milk -= 100;
            coffeeBeans -= 12;
            money += 6;
        }
        disposableCups--;
        printInventory();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        System.out.println("The coffee machine has:");
        coffeeMachine.printInventory();

        System.out.println("Write action (buy, fill, take):");
        String choice = scanner.next();

        switch (choice) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                int coffeeType = scanner.nextInt();
                coffeeMachine.depleteIngredients(coffeeType);
                break;
            case "fill":
                System.out.println("Write how many ml of water do you want to add:");
                coffeeMachine.water += scanner.nextInt();
                System.out.println("Write how many ml of milk do you want to add:");
                coffeeMachine.milk += scanner.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add:");
                coffeeMachine.coffeeBeans += scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                coffeeMachine.disposableCups += scanner.nextInt();
                coffeeMachine.printInventory();
                break;
            case "take":
                System.out.println("I gave you $" + coffeeMachine.money);
                coffeeMachine.money = 0;
                coffeeMachine.printInventory();
            default:
                System.out.print("There was something wrong with your choice..");
        }
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
