package Module1Exam.inventory;

import Module1Exam.exceptions.FileIOException;
import Module1Exam.exceptions.InvalidDataException;
import Module1Exam.exceptions.ItemNotFoundException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
//    FILE_NAME(local file location),
//    List<InventoryItem> readInventoryItems(),
//    void writeInventoryItems(List<InventoryItem> items),
//    void addItem(InventoryItem item),
//    InventoryItem findItem(int itemId),
//    void updateItem(InventoryItem newItem),
//    void deleteItem(int itemId)

//    Implement methods in the InventoryManager class to read inventory items from a file,
//    add a new inventory item,
//    search for an inventory item by ID,
//    update inventory items,
//    and delete inventory items.

    private static final String FILE_NAME = "C:\\Users\\User\\Desktop\\revan.txt";

    public List<InventoryItem> readInventoryItems() throws FileIOException{
        List<InventoryItem> items = new ArrayList<>();
        try(BufferedReader br  =  new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(",");
                int itemId = Integer.parseInt(parts[0]);
                String name = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                int price = Integer.parseInt(parts[3]);
            }
        }catch (Exception e){
            throw new FileIOException("reading error");
        }
        return items;
    }


    public void writeInventoryItems(List<InventoryItem> items) throws FileIOException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))){
            for(InventoryItem item : items){
                bw.write(item.getItemId() + " - " +  item.getName() + " - " + item.getQuantity() + " - " + item.getPrice());
                bw.newLine();
            }
        }catch (Exception e){
            throw new FileIOException("writing error");
        }
    }

    public void addItem(InventoryItem item) throws FileIOException{
        List<InventoryItem> items = readInventoryItems();
        items.add(item);
        writeInventoryItems(items);
    }

    public InventoryItem findItem(int itemId) throws FileIOException, ItemNotFoundException{
        List<InventoryItem> items = readInventoryItems();
        for(InventoryItem item : items){
            if(item.getItemId() == itemId){
                return item;
            }
        }
        throw new ItemNotFoundException("item not found");
    }

    public void updateItem(InventoryItem nItem) throws FileIOException, ItemNotFoundException{
        List<InventoryItem> items = readInventoryItems();
        boolean founded = false;
        for(int i = 0; i < items.size(); i++){
            InventoryItem item = items.get(i);
            if(item.getItemId() == nItem.getItemId()){
                items.set(i, nItem);
                founded = true;
                break;
            }
        }
        if(!founded){
            throw new ItemNotFoundException("item not found");
        }
        writeInventoryItems(items);
    }

    public void deleteItem(int itemId) throws FileIOException, ItemNotFoundException{
        List<InventoryItem> items = readInventoryItems();
        boolean founded = false;
        for(int i = 0; i < items.size(); i++){
            InventoryItem item = items.get(i);
            if(item.getItemId() == itemId){
                items.remove(i);
                founded = true;
                break;
            }
        }
        if(!founded){
            throw new ItemNotFoundException("item cant be deleted because of finding error");
        }
        writeInventoryItems(items);
    }
}
