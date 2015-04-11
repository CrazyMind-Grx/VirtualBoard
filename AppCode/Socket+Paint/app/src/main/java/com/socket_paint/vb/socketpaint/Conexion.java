package com.socket_paint.vb.socketpaint;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;

import io.socket.SocketIO;

/**
 * Created by JaviAir on 11/4/15.
 */
public class Conexion extends Thread {
    private SocketIO socket;
    private callback cback;

    public Conexion (callbackAdapter callback){
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

    public void sendMessage(JSONObject message) {

            socket.emit("pepito", message);//Emitimos el objeto al servidor
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
