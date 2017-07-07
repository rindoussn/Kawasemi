package com.kawasemi.Object;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by suzuno on 7/6/17.
 */
public class Tweet {
    // contributors is Deprecated
    private Coordinates coordinate;
    private String created_at;
    private Map<String, Object> current_user_retweet;
    // private Entity entities; // not completed
    private int favorite_count;
    private boolean favorited;
    private String filter_level;
    private long id;
    private String id_str;
    private String in_reply_screen_name;
    private long in_reply_status_id;
    private String in_reply_status_id_str;
    private long in_reply_to_user_id;
    private String in_reply_to_user_id_str;
    private String lang;
    // private Place place; // not completed
    private boolean possibly_sensitive;
    private long quoted_status_id;
    private String quoted_status_id_str;
    private Tweet quoted_status;
    private int retweet_count;
    private boolean retweeted;
    private Tweet retweeted_status;
    private String source;
    private String text;
    private boolean truncated;
    //private User user; // not completed
    private boolean withheld_copyright;
    private String[] withheld_in_countries;
    private String withheld_scope;

    public Coordinates getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinates coordinate) {
        this.coordinate = coordinate;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Map<String, Object> getCurrent_user_retweet() {
        return current_user_retweet;
    }

    public void setCurrent_user_retweet(Map<String, Object> current_user_retweet) {
        this.current_user_retweet = current_user_retweet;
    }

    public int getFavorite_count() {
        return favorite_count;
    }

    public void setFavorite_count(int favorite_count) {
        this.favorite_count = favorite_count;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public String getFilter_level() {
        return filter_level;
    }

    public void setFilter_level(String filter_level) {
        this.filter_level = filter_level;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getId_str() {
        return id_str;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }

    public String getIn_reply_screen_name() {
        return in_reply_screen_name;
    }

    public void setIn_reply_screen_name(String in_reply_screen_name) {
        this.in_reply_screen_name = in_reply_screen_name;
    }

    public long getIn_reply_status_id() {
        return in_reply_status_id;
    }

    public void setIn_reply_status_id(long in_reply_status_id) {
        this.in_reply_status_id = in_reply_status_id;
    }

    public String getIn_reply_status_id_str() {
        return in_reply_status_id_str;
    }

    public void setIn_reply_status_id_str(String in_reply_status_id_str) {
        this.in_reply_status_id_str = in_reply_status_id_str;
    }

    public long getIn_reply_to_user_id() {
        return in_reply_to_user_id;
    }

    public void setIn_reply_to_user_id(long in_reply_to_user_id) {
        this.in_reply_to_user_id = in_reply_to_user_id;
    }

    public String getIn_reply_to_user_id_str() {
        return in_reply_to_user_id_str;
    }

    public void setIn_reply_to_user_id_str(String in_reply_to_user_id_str) {
        this.in_reply_to_user_id_str = in_reply_to_user_id_str;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public boolean isPossibly_sensitive() {
        return possibly_sensitive;
    }

    public void setPossibly_sensitive(boolean possibly_sensitive) {
        this.possibly_sensitive = possibly_sensitive;
    }

    public long getQuoted_status_id() {
        return quoted_status_id;
    }

    public void setQuoted_status_id(long quoted_status_id) {
        this.quoted_status_id = quoted_status_id;
    }

    public String getQuoted_status_id_str() {
        return quoted_status_id_str;
    }

    public void setQuoted_status_id_str(String quoted_status_id_str) {
        this.quoted_status_id_str = quoted_status_id_str;
    }

    public Tweet getQuoted_status() {
        return quoted_status;
    }

    public void setQuoted_status(Tweet quoted_status) {
        this.quoted_status = quoted_status;
    }

    public int getRetweet_count() {
        return retweet_count;
    }

    public void setRetweet_count(int retweet_count) {
        this.retweet_count = retweet_count;
    }

    public boolean isRetweeted() {
        return retweeted;
    }

    public void setRetweeted(boolean retweeted) {
        this.retweeted = retweeted;
    }

    public Tweet getRetweeted_status() {
        return retweeted_status;
    }

    public void setRetweeted_status(Tweet retweeted_status) {
        this.retweeted_status = retweeted_status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public boolean isWithheld_copyright() {
        return withheld_copyright;
    }

    public void setWithheld_copyright(boolean withheld_copyright) {
        this.withheld_copyright = withheld_copyright;
    }

    public String[] getWithheld_in_countries() {
        return withheld_in_countries;
    }

    public void setWithheld_in_countries(String[] withheld_in_countries) {
        this.withheld_in_countries = withheld_in_countries;
    }

    public String getWithheld_scope() {
        return withheld_scope;
    }

    public void setWithheld_scope(String withheld_scope) {
        this.withheld_scope = withheld_scope;
    }
}
