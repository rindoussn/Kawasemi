package main.java.com.kawasemi;

/**
 * Created by suzuno on 6/26/17.
 */
public class Utility {
    public void printException (Exception e) {
        String str = Thread.currentThread().getStackTrace()[2].getClassName();
        System.out.println("[" + str + "] Error : "+ e);
    }
}
