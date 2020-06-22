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
        System.out.println("The coffee machine has:");
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
    }

    private boolean checkInventory(int coffeeType) {

        if (coffeeType == 1) {
            if (water - 250 >= 0 && coffeeBeans - 16 >= 0 && disposableCups > 0) {
                return true;
            }
        }
        else if (coffeeType == 2) {
            if (water - 350 >= 0 && milk - 75 >= 0 && coffeeBeans - 20 >= 0 && disposableCups > 0) {
                return true;
            }
        }
        else if (coffeeType == 3) {
            if (water - 200 >= 0 && milk - 100 >= 0 && coffeeBeans - 12 >= 0 && disposableCups > 0) {
                return true;
            }
        }
        System.out.println("Sorry, not enough ingredients!");
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        boolean keepOperating = true;

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String choice = scanner.next();
            String coffeeType;
            switch (choice) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino," +
                            " back - to main menu:");
                    coffeeType = scanner.next();
                    if (!coffeeType.equals("back") && coffeeMachine.checkInventory(Integer.parseInt(coffeeType))) {
                        System.out.println("I have enough resources, making you a coffee!");
                        coffeeMachine.depleteIngredients(Integer.parseInt(coffeeType));
                        break;
                    }
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
                    break;
                case "take":
                    System.out.println("I gave you $" + coffeeMachine.money);
                    coffeeMachine.money = 0;
                    break;
                case "remaining":
                    coffeeMachine.printInventory();
                    break;
                case "exit":
                    keepOperating = false;
                    break;
                default:
                    System.out.print("There was something wrong with your choice..");
                    break;
            }
        }
        while (keepOperating);
    }
}
