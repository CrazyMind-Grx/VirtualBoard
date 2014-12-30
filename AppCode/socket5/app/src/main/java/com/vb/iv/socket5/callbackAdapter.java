package com.vb.iv.socket5;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by root on 28/12/14.
 */
public interface callbackAdapter {
    public void callback(JSONArray data)throws JSONException;
    public void on(String event,JSONObject data);
    public void onMessage(String message);
    public void onMessage(JSONObject json);
    public void onConnect();
    public void onDisconnect();
    public void onConnectFailure();
}
