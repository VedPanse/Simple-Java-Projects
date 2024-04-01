import java.util.*;

public class VendingMachine {
    int inputCode;
    Map<Item, Integer> inventory;

    double balance;

    public VendingMachine(Map<Item, Integer> initialInventory, double balance) {
        this.inventory = initialInventory;
        this.balance = balance;
    }

    public void printInventory() {
        for (Map.Entry<Item, Integer> entry: this.inventory.entrySet()) {
            System.out.println(String.format(
                    "%d. %s for %.2f - %d remaining in the inventory", entry.getKey().getInputCode(),
                    entry.getKey().getItemName(), entry.getKey().getItemPrice(),
                    entry.getValue()));
        }
        System.out.println("_______________");
        System.out.println("Balance in vending machine: " + this.balance);
    }

    public int addToInventory(int inputCode, int quantity) {
        for (Map.Entry<Item, Integer> entry: this.inventory.entrySet()) {
            if (entry.getKey().getInputCode() == inputCode) {
                int newQuantity = entry.getValue() + quantity;
                entry.setValue(newQuantity);
                return 1;
            }
        }

        System.out.printf("ERROR: Item with input code %d not found%n", inputCode);
        return -1;
    }

    public int addToInventory(Item item, int quantity) {
        for (Map.Entry<Item, Integer> entry : this.inventory.entrySet()) {
            if (entry.getKey().getInputCode() == item.getInputCode()) {
                System.out.println("ERROR: An item with this input code already exists.");
                return -1;
            }
        }
        this.inventory.put(item, quantity);
        return 0;
    }

    public int order(int inputCode) {
        for (Map.Entry<Item, Integer> entry : this.inventory.entrySet()) {
            if (entry.getKey().getInputCode() == inputCode) {
                if (entry.getValue() == 0) {
                    System.out.printf("Sorry, we're out of %d. %s%n", entry.getKey().getInputCode(),
                            entry.getKey().getItemName());
                    return -1;
                }

                entry.setValue(entry.getValue() - 1);

                this.balance += entry.getKey().getItemPrice();

                System.out.printf("You have successfully purchased a %s for %.2f. Thank you!%n",
                        entry.getKey().getItemName(), entry.getKey().getItemPrice());
                printInventory();

                return 0;
            }
        }

        System.out.printf("ERROR: Item with input code %d not found%n", inputCode);
        return -1;
    }
}