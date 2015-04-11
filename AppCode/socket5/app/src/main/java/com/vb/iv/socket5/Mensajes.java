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
            socket = new SocketIO("http://nodejs-angeljcc.c9.io", cback);//Servidor en Cloud9
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        try {
            JSONObject json = new JSONObject();//Creamos un nuevo objeto json
            json.putOpt("data", message);//Le pasamos al nuevo objeto un mensaje
            socket.emit("pepito", json);//Emitimos el objeto al servidor
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
