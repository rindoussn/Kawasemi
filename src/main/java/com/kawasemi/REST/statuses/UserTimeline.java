package com.kawasemi.REST.statuses;

import com.kawasemi.REST.AbstractRestController;
import com.kawasemi.REST.RESTInvalidValueException;

/**
 * GET status/user_timeline<br>
 * details <a>https://dev.twitter.com/rest/reference/get/statuses/user_timeline</a>
 */
public class UserTimeline extends AbstractRestController {
    public UserTimeline() {
        setActions("https://api.twitter.com/1.1/statuses/user_timeline.json", "GET");
    }

    public void setUserId(String value) {
        addQuery("user_id", value);
    }

    public void setScreenName(String value) {
        addQuery("screen_name", value);
    }

    public void setSinceId(String value) {
        addQuery("since_id", value);
    }

    public void setCount(int value) throws RESTInvalidValueException {
        if (value >= 1 && value <= 200)
            addQuery("count", String.valueOf(value));
        else
            throw new RESTInvalidValueException();
    }

    public void setMaxId(String value) {
        addQuery("max_id", value);
    }

    public void setTrimUser(boolean value) {
        addQuery("trim_user", String.valueOf(value));
    }

    public void setExcludeReplies(boolean value) {
        addQuery("exclude_replies", String.valueOf(value));
    }

    public void setIncludeRts(boolean value) {
        addQuery("include_rts", String.valueOf(value));
    }

    @Override
    protected boolean checkRequiredParams() {
        if (params.get("user_id") != null || params.get("screen_name") != null) {
            return true;
        } else {
            return false;
        }
    }
}
