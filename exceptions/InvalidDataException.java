package Module1Exam.exceptions;

public class InvalidDataException extends Exception{

    //bura inventory item dan olan exceptionlari gondereceyik
    //hansi ki invalid inventory itemlardir

    public InvalidDataException(String message){
        super(message);
    }
}
