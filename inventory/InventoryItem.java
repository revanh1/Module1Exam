package Module1Exam.inventory;

import Module1Exam.exceptions.InvalidDataException;

public class InventoryItem {
    private int itemId;
    private  String name;
    private int quantity;
    private int price;

    public InventoryItem(int itemId, String name, int quantity, int price) throws InvalidDataException {
        if(quantity < 0 || price < 0){
            throw new InvalidDataException("invalid data");
        }
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "InventoryItem{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    // methods - i yazmaq qalib
}
