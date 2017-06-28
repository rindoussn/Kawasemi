package main.java.com.kawasemi.HTTP;

import main.java.com.kawasemi.AbstractUtility;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Wrapper of java.netHttpURLConnection
 */
public class HTTPConnector extends AbstractUtility {

    private HttpURLConnection connect;
    public HTTPResponse response;

    /**
     * Set URL and Request Method
     *
     * @param url    URL
     * @param method Method(GET, POST)
     */
    public void setAction(String url, String method) {
        try {
            connect = null;
            response = null;

            URL connectURL = new URL(url);
            connect = (HttpURLConnection) connectURL.openConnection();
            connect.setRequestMethod(method);
        } catch (Exception e) {
            printException(e);
        }
    }

    /**
     * Set header fields
     *
     * @param value field value
     */
    public void setAuthorization(String value) {
        connect.setRequestProperty("Authorization", value);
    }

    /**
     * Start Connection
     */
    public void connection() {
        try {
            connect.connect();
            response = new HTTPResponse(connect);
            connect.disconnect();
        } catch (Exception e) {
            printException(e);
        }
    }

}
