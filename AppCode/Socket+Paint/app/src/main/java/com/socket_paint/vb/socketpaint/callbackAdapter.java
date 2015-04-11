package com.socket_paint.vb.socketpaint;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by JaviAir on 11/4/15.
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
