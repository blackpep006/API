package common;
import java.lang.Exception;
import java.lang.Throwable;
public class CustomException extends Exception{
    public CustomException(String string,Throwable cause){
        super(string,cause);
    }
    public CustomException(String string){
        super(string);
    }
}
