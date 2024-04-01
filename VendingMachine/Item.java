public class Item {
    private final String itemName;
    private final double itemPrice;
    private final int inputCode;

    public Item(String itemName, double pricePerItem, int inputCode) {
        this.itemName = itemName;
        this.itemPrice = pricePerItem;
        this.inputCode = inputCode;
    }

    public String getItemName() {
        return this.itemName;
    }

    public double getItemPrice() {
        return this.itemPrice;
    }

    public int getInputCode() {return this.inputCode; }
}
