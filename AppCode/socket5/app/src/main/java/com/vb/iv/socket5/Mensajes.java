package com.vb.iv.socket5;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;

import io.socket.SocketIO;
import io.socket.SocketIOException;

/**
 * Created by root on 28/12/14.
 */
public class Mensajes extends Thread {
    private SocketIO socket;
    private callback cback;

    public Mensajes(callbackAdapter callback){
        this.cback=new callback(callback);
    }

    @Override
    public void run(){
        try{
           // socket = new SocketIO("http://192.168.0.194:3000/", cback);
            socket = new SocketIO("http://nodejs-angeljcc.c9.io", cback);
            //socket = new SocketIO("http://54.237.116.169:8080", cback);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        try {
            JSONObject json = new JSONObject();
            json.putOpt("data", message);
            socket.emit("sendMessage", json);
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

    /*public void join(String nickname) {
        try {
            JSONObject json = new JSONObject();
            json.putOpt("nickname", nickname);
            socket.emit("nickname", callback, json);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/



}
