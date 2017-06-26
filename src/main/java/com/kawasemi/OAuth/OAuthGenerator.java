package main.java.com.kawasemi.OAuth;

import main.java.com.kawasemi.Utility;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by suzuno on 6/26/17.
 */
public class OAuthGenerator extends Utility{
    private Map oauthParams;
    private boolean firstInit = true;

    private String consumerKey;
    private String consumerSecret;
    private String accessToken;
    private String accessTokenSecret;

    private String url;
    private String method;

    /**
     * Set OAuth base params
     */
    public OAuthGenerator(String url, String method) {
        if(firstInit) {
            readKeys();
            initOAuthParams();
        }

        this.url = url;
        this.method = method;
    }

    /**
     * Set OAuth params(static params)
     */
    private void initOAuthParams() {
        oauthParams = new HashMap();
        oauthParams.put("oauth_consumer_key", consumerKey);
        oauthParams.put("oauth_token", accessToken);
        oauthParams.put("oauth_version", "1.0");
        oauthParams.put("oauth_signature_method", "HMAC-SHA1");
    }

    /**
     * Read "oauthkeys.txt" and get keys
     */
    private void readKeys() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("oauthkeys.txt"));
            consumerKey = br.readLine();
            consumerSecret = br.readLine();
            accessToken = br.readLine();
            accessTokenSecret = br.readLine();
            br.close();
        } catch(Exception e) {
            printException(e);
        }
    }

    public String getAuthorizationValue(Map bodyParams) {
        generateStamps();
        String authValue = generateSignature(bodyParams);
        return "OAuth " + authValue;
    }

    private void generateStamps() {
        oauthParams.put("oauth_timestamp", String.valueOf((int)System.currentTimeMillis() / 1000L));
        oauthParams.put("oauth_nonce", String.valueOf(Math.random()));
    }

    private String generateSignature(Map bodyParams) {
        // oauthParamsとbodyParamsをマージ
        Map<String, String> mergedParams = new TreeMap();

        mergedParams.putAll(oauthParams);
        mergedParams.putAll(bodyParams);

        String str = "";
        boolean first = true;
        for (Map.Entry<String, String> entry : mergedParams.entrySet()) {
            if (first) {
                str += entry.getKey() + "=" + entry.getValue();
                first = false;
            } else {
                str += "&" + entry.getKey() + "=" + entry.getValue();
            }
        }

        str = method + "&" + urlEncode(url) + "&" + urlEncode(str);
        String key = urlEncode(consumerSecret) + "&" + urlEncode(accessTokenSecret);

        String signature = "";
        try {
            SecretKeySpec sigKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
            Mac mac = Mac.getInstance(sigKey.getAlgorithm());
            mac.init(sigKey);
            byte[] hmac = mac.doFinal(str.getBytes());
            signature = Base64.getEncoder().encodeToString(hmac);
        } catch (Exception e) {
            printException(e);
        }
        return signature;
    }

    /**
     * URL Encode for UTF-8
     *
     * @param text Target text
     * @return Encoded text
     */
    private String urlEncode(String text) {
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
