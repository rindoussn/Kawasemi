package main.java.com.kawasemi.HTTP;

import main.java.com.kawasemi.Utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * HTTP Responce Manager
 */
public class HTTPResponse extends Utility {

    private Map header;
    private int code;
    private String message;
    private ArrayList<String> bodys;

    /**
     * Constructor - Read response header and body data.
     *
     * @param connection HTTPUrlConnection
     */
    public HTTPResponse(HttpURLConnection connection) {
        try {
            header = connection.getHeaderFields();
            code = connection.getResponseCode();
            message = connection.getResponseMessage();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while (true) {
                String line = br.readLine();
                if (line != null) bodys.add(line);
                else break;
            }
            br.close();

        } catch (Exception e) {
            printException(e);
        }
    }

    /**
     * Return header fields
     *
     * @return Response header fields
     */
    public Map getHeaderFields() {
        return header;
    }

    /**
     * Return Response Code
     *
     * @return HTTP response code
     */
    public int getCode() {
        return code;
    }

    /**
     * Return Response Message
     *
     * @return HTTP response message
     */
    public String getMassage() {
        return message;
    }

    /**
     * Return Body
     *
     * @return body(Arraylist)
     */
    public ArrayList getBody() {
        return bodys;
    }

    /**
     * Print HTTP response header fields
     */
    public void printHeaderFields() {
        Iterator i = header.keySet().iterator();
        while (true) {
            String key = (String) i.next();
            System.out.println(key + " : " + header.get(key));
            if (!i.hasNext()) break;
        }
    }

    /**
     * Print HTTP response code
     */
    public void printCode() {
        System.out.println(code);
    }

    /**
     * Print HTTP response massage
     */
    public void printMessage() {
        System.out.println(code);
    }
}
