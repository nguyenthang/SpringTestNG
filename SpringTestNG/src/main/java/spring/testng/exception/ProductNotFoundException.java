package spring.testng.exception;

/**
 * Created by ThangN on 8/8/2016.
 */
public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(String message){
        super(message);
    }
}
