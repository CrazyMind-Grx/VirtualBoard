package com.vb.iv.socket5;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import io.socket.IOAcknowledge;
import io.socket.IOCallback;
import io.socket.SocketIOException;

/**
 * Created by root on 28/12/14.
 */
public class callback implements IOCallback, IOAcknowledge{
    private callbackAdapter callAdapter;

    public callback(callbackAdapter callAdapter){
        this.callAdapter = callAdapter;
    }

    @Override
    public void ack(Object... data){
        try{
            callAdapter.callback(new JSONArray(Arrays.asList(data)));
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onDisconnect() {
        callAdapter.onDisconnect();
    }

    @Override
    public void onConnect() {
        callAdapter.onConnect();
    }

    @Override
    public void onMessage(JSONObject jsonObject, IOAcknowledge ioAcknowledge) {
        callAdapter.onMessage(jsonObject);
        System.out.println("pasa por ONmessage en callback");
    }

    @Override
    public void onMessage(String s, IOAcknowledge ioAcknowledge) {
        callAdapter.onMessage(s);

        System.out.println("pasa por ONmessage STRING en callback");
    }

    @Override
    public void on(String s, IOAcknowledge ioAcknowledge, Object... objects) {
        //try {

            //callAdapter.on(s, objects[0].toString());
            callAdapter.on(s,(JSONObject)objects[0]);
            System.out.println("pasa por ON en callback");
            //System.out.println(objects[0]);
            //System.out.println(s);
       // }catch (JSONException e){
       ///     e.printStackTrace();
       // }
    }

    @Override
    public void onError(SocketIOException e) {
        e.printStackTrace();
        callAdapter.onConnectFailure();
    }
}
