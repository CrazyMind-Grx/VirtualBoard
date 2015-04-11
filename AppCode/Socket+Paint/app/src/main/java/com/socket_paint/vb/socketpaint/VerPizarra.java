package com.socket_paint.vb.socketpaint;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by JaviAir on 11/4/15.
 */
public class VerPizarra extends Activity implements callbackAdapter{

    private Float x,y;
    Path path = new Path(); // Encapsula varios tipos de caminos geometricos
    boolean cambio=true;

    @Override
    public void callback(JSONArray data) throws JSONException {

    }

    @Override
    public void on(String event, JSONObject data) {

        try{
            if(event.equals("IrPizarra")){


                x=(float)(data.getLong("x"));
                y=(float)(data.getLong("y"));
                System.out.println("Estoy en ver pizarra x: "+x+ " y: "+y);

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

    class Pizarra extends View{



        public Pizarra(Context context) {
            super(context);
        }

        public void onDraw (Canvas canvas){
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);//Dibujamos un tipo de linea stroke
            paint.setStrokeWidth(5);
            paint.setColor(Color.BLACK);

            if(cambio){
                path.moveTo(x,y);//Desde este punto comienza nuestra linea a dibujar
                cambio=false;
            }

            else {
                path.lineTo(x,y);//Sigue el camino de la linea
                cambio=true;
            }

            canvas.drawPath(path,paint);
            invalidate();
        }
    }

}
