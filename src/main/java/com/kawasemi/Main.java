package main.java.com.kawasemi;


import main.java.com.kawasemi.HTTP.HTTPConnector;
import main.java.com.kawasemi.REST.statuses.Update;

/**
 * Created by suzuno on 6/26/17.
 */
public class Main {
    public static void main(String[] args) {
        Update ud = new Update();
        ud.setStatus("foo bar baz");
        ud.send();
        System.out.println(ud.connector.response.getCode());
        System.out.println(ud.connector.response.getMassage());
        System.out.println(ud.connector.response.getBody());
    }
}
