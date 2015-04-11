package com.socket_paint.vb.socketpaint;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.lang.Float;

public class IrPizarra extends Activity implements callbackAdapter{

    private Conexion conexionMensajes;
    private  String datosx,datosy;

    JSONObject json = new JSONObject();//Creamos un nuevo objeto json


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Pizarra pizarra=new Pizarra(this);
        setContentView(pizarra);

        conexionMensajes = new Conexion(this);
        conexionMensajes.start();
    }

    @Override
    public void callback(JSONArray data) throws JSONException {

    }

    @Override
    public void on(String event, JSONObject data) {

        try{
            if(event.equals("new message")){


                datosx=(data.getString("data").toString());
                System.out.println("Evento: "+event);
                System.out.println("cadena mandada: "+data.getString("data").toString());
            }
        }catch (JSONException e){
            e.printStackTrace();

        }
    }

    @Override
    public void onMessage(String message) {

    }

    @Override
    public void onMessage(JSONObject json) {

    }

    @Override
    public void onConnect() {

    }

    @Override
    public void onDisconnect() {

    }

    @Override
    public void onConnectFailure() {

    }

    //Creamos nuestra propia vista
    class Pizarra extends View {

        Float x = new Float(0);
        Float y = new Float(0);
        String accion= "accion";

        Path path = new Path(); // Encapsula varios tipos de caminos geometricos

        public Pizarra(Context context) {
            super(context);
        }
        /*
        onDrew es el metodo que se utiliza para dibujar
         */
        public void onDraw (Canvas canvas){
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);//Dibujamos un tipo de linea stroke
            paint.setStrokeWidth(5);
            paint.setColor(Color.BLACK);

            if(accion== "down"){
                path.moveTo(x,y);//Desde este punto comienza nuestra linea a dibujar

            }

            if (accion=="move"){
                path.lineTo(x,y);//Sigue el camino de la linea

            }

            canvas.drawPath(path,paint);
        }

        /*Gestiona los eventos al tocar la pantalla*/
        public boolean onTouchEvent(MotionEvent e){

            x=e.getX();//Nos devuelve el valor x de la posicion donde tocamos
            y=e.getY();//Nos devuelve el valor y de la posicion donde tocamos

            if(e.getAction()==MotionEvent.ACTION_DOWN)//Al pulsar la prantalla...
            {
                accion="down";
                datosx=(x.toString());
                datosy=(y.toString());

                try{
                    json.putOpt("x", datosx);
                    json.putOpt("y",datosy);}//Le pasamos al nuevo objeto un mensaje
                catch (JSONException ex) {
                    ex.printStackTrace();
                }
                conexionMensajes.sendMessage(json);
            }
            if(e.getAction()==MotionEvent.ACTION_MOVE)//Al mover el dedo sobre la pantalla....
            {
                accion="move";
                datosx=(x.toString());
                datosy=(y.toString());

                try{
                    json.putOpt("x", datosx);
                    json.putOpt("y",datosy);}//Le pasamos al nuevo objeto un mensaje
                catch (JSONException ex) {
                    ex.printStackTrace();
                }
                conexionMensajes.sendMessage(json);
            }

            invalidate();
            return true;
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
