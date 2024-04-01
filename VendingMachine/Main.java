import java.util.*;

public class Main {
    public static void main(String[] args) {
        Item dasani = new Item("Dasani", 1.25, 101);
        Item monster = new Item("Monster", 2.3, 102);
        Item pepsi = new Item("Pepsi", 1.1, 103);
        Item cocaCola = new Item("Coca-Cola", 2.45, 104);

        Map<Item, Integer> initialInventory = new HashMap<>(); // Item, quantity

        initialInventory.put(dasani, 3);
        initialInventory.put(monster, 5);
        initialInventory.put(pepsi, 6);
        initialInventory.put(cocaCola, 5);

        VendingMachine seventhCollegeVendingMachine = new VendingMachine(initialInventory, 200.00);

        seventhCollegeVendingMachine.printInventory();

        seventhCollegeVendingMachine.addToInventory(101, 4);

        seventhCollegeVendingMachine.printInventory();

        Item milk = new Item("Alta Dena", 3.0, 105);
        seventhCollegeVendingMachine.addToInventory(milk, 3);
        seventhCollegeVendingMachine.printInventory();

        seventhCollegeVendingMachine.order(105);
        seventhCollegeVendingMachine.order(105);
        seventhCollegeVendingMachine.order(105);

        seventhCollegeVendingMachine.order(105);
    }
}