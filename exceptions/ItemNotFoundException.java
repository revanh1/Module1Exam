package Module1Exam.exceptions;

public class ItemNotFoundException extends Exception {
    //for when an item is not found in the inventory

    public ItemNotFoundException(String message){
        super(message);
    }
}
