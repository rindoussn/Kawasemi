package main.java.com.kawasemi.REST.statuses;

import main.java.com.kawasemi.REST.AbstractRestController;

/**
 * POST statuses/update
 * details <a>https://dev.twitter.com/rest/reference/get/statuses/update</a>
 */
public class Update extends AbstractRestController {

    public Update() {
        setActions("https://api.twitter.com/1.1/statuses/update.json","POST");
    }

    public void setStatus(String value) {
        addQuery("status",value);
    }

    public void setInReplyToStatusId(String value) {
        addQuery("in_reply_to_status_id", value);
    }

    public void setPossiblySensitive(boolean value) {
        addQuery("possibly_sensitive", String.valueOf(value));
    }

    public void setLat(String value) {
        addQuery("lat", value);
    }

    public void setLong(String value) {
        addQuery("long", value);
    }

    public void setPlaceId(String value) {
        addQuery("place_id", value);
    }

    public void setDisplayCoordinates(boolean value) {
        addQuery("display_coordinates", String.valueOf(value));
    }

    public void setTrimUser(boolean value) {
        addQuery("trim_user", String.valueOf(value));
    }

    public void setMediaIds(String value) {
        addQuery("media_ids", value);
    }

    public void setEnableDmCommands(boolean value) {
        addQuery("enable_dm_commands", String.valueOf(value));
    }

    public void setFailDmCommands(boolean value) {
        addQuery("fail_dm_commands", String.valueOf(value));
    }

    @Override
    protected boolean checkRequiredParams() {
        if(params.get("status") != null) {
            return true;
        } else {
            return false;
        }
    }
}
