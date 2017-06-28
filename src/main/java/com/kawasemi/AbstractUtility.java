package main.java.com.kawasemi;

/**
 * Created by suzuno on 6/26/17.
 */
abstract public class AbstractUtility {

    /**
     * Exception Printer
     * @param e
     */
    public void printException (Exception e) {
        String str = Thread.currentThread().getStackTrace()[2].getClassName();
        System.out.println("[" + str + "] Error : "+ e);
    }
}
