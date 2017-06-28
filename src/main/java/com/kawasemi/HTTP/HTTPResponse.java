package main.java.com.kawasemi.HTTP;

import main.java.com.kawasemi.AbstractUtility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * HTTP Responce Manager
 */
public class HTTPResponse extends AbstractUtility {

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
}