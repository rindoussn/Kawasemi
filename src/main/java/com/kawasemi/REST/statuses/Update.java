package main.java.com.kawasemi.REST.statuses;

import main.java.com.kawasemi.REST.AbstractRestController;

/**
 * POST - statuses/update
 */
public class Update extends AbstractRestController {

    public Update() {
        setActions("https://api.twitter.com/1.1/statuses/update.json","POST");
    }

    public void setStatus(String text) {
        params.put("status", text);
    }
}
