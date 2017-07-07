package com.kawasemi;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kawasemi.HTTP.HTTPConnector;
import com.kawasemi.Object.Tweet;
import com.kawasemi.REST.statuses.Update;
import com.kawasemi.REST.statuses.UserTimeline;

/**
 * Created by suzuno on 6/26/17.
 */
public class Main {
    public static void main(String[] args) {
        UserTimeline ut = new UserTimeline();
        try {
            ut.setScreenName("");
            ut.send();

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        String str = ut.connector.response.getBody();
        Gson gson = new Gson();
        Tweet[] tweet = gson.fromJson(str, Tweet[].class);
        System.out.println(tweet[0].getText());
    }
}
