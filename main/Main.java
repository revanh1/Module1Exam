package Module1Exam.main;

import Module1Exam.exceptions.FileIOException;
import Module1Exam.exceptions.InvalidDataException;
import Module1Exam.exceptions.ItemNotFoundException;
import Module1Exam.inventory.InventoryItem;
import Module1Exam.inventory.InventoryManager;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        try {
            InventoryManager inventoryManager = new InventoryManager();

            InventoryItem inventoryItem = new InventoryItem(3, "computer", 56, 1000);

            inventoryManager.addItem(inventoryItem);

            System.out.println(inventoryItem.getItemId() + " - " +
                    inventoryItem.getName() + " - " +
                    inventoryItem.getQuantity() + " - " +
                    inventoryItem.getPrice());



            InventoryItem forFoundingItem = inventoryManager.findItem(3);
            System.out.println(forFoundingItem.getItemId() + " - " +
                    forFoundingItem.getName() + " - " +
                    forFoundingItem.getQuantity() + " - " +
                    forFoundingItem.getPrice());



            InventoryItem findItem = inventoryManager.findItem(1);
            System.out.println("founded item : " + findItem.getName() + " " + findItem.getQuantity() + " " + findItem.getPrice());

            //update
            inventoryItem.setQuantity(90);
            inventoryManager.updateItem(inventoryItem);

            //delete
            inventoryManager.deleteItem(1);

        }catch (FileIOException | InvalidDataException | ItemNotFoundException e){
            e.getMessage();
        }
    }
}
