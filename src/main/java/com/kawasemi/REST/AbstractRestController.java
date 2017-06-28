package main.java.com.kawasemi.REST;

import main.java.com.kawasemi.AbstractUtility;
import main.java.com.kawasemi.HTTP.HTTPConnector;
import main.java.com.kawasemi.OAuth.OAuthGenerator;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by suzuno on 6/26/17.
 */
public class AbstractRestController extends AbstractUtility{
    private String url;
    private String method;

    public HTTPConnector connector;
    private OAuthGenerator oauthGenerator;

    protected Map<String, String> params = new HashMap();

    public void send() {
        connector = new HTTPConnector();
        connector.setAction(url + generateQuery(), method);
        oauthGenerator = new OAuthGenerator(url, method);

        String authstr = oauthGenerator.getAuthorizationValue(params);
        System.out.println(authstr);
        connector.setAuthorization(authstr);
        connector.connection();
    }

    protected void setActions(String url, String method) {
        this.url = url;
        this.method = method;
    }

    /**
     * Generate url query
     * @return
     */
    protected String generateQuery() {
        String str = "";

        for(Map.Entry<String, String> entry : params.entrySet()) {
            str += "&" + entry.getKey() + "=" + urlEncode(entry.getValue());
        }
        str = str.substring(1);
        return "?" + str;
    }

    /**
     * URL encoder for UTF-8
     * @param text Target text
     * @return Encoded text
     */
    protected String urlEncode(String text) {
        String str = "";
        try {
            str = URLEncoder.encode(text, "UTF-8");
            str = str.replace("+", "%20");
        } catch (Exception e) {
            printException(e);
        }
        return str;
    }

}