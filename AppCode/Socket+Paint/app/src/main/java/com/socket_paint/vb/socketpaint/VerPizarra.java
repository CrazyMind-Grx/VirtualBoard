package com.socket_paint.vb.socketpaint;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by JaviAir on 11/4/15.
 */
public class VerPizarra extends Activity implements callbackAdapter{

    private Float x=new Float(0.0),y=new Float(0.0);
    Path path = new Path(); // Encapsula varios tipos de caminos geometricos
    boolean cambio=true;
    private Conexion conexionMensajes;
    ArrayList<Float> lista = new ArrayList<>();
    int contador=0;
    Float negativo = new Float(-1);
    Float ultimo = new Float(0);
    boolean bloqueado=true;
    boolean doubleBackToExitPressedOnce;
    // 1440-2368 emulador
    // 720-1280
    float ancho, alto;
    float widthPantalla;
    float heightPantalla;
    float widthPantalla_otro;
    float heightPantalla_otro;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Pizarra pizarra=new Pizarra(this);
        setContentView(pizarra);


        Display display = getWindowManager().getDefaultDisplay();
        Point tam= new Point();
        display.getSize(tam);
        widthPantalla = tam.x;
        heightPantalla = tam.y;

        System.out.print("TONTO "+widthPantalla+"  "+heightPantalla);
        // 1440-2368 emulador
        // 720-1280
        conexionMensajes = new Conexion(this);
        conexionMensajes.start();
    }

    @Override
    public void callback(JSONArray data) throws JSONException {

    }

    public boolean onTouchEvent(MotionEvent e){


        if(e.getAction()==MotionEvent.ACTION_CANCEL)//Al pulsar la prantalla...
        {
           lista=null;

        }
        return true;
    }

    @Override
    public void on(String event, JSONObject data) {
        System.out.println("entra por ON");
        try{
            if(event.equals("IrPizarra")){

                widthPantalla_otro = ancho *Float.parseFloat(data.getString("w"));
                heightPantalla_otro = alto *Float.parseFloat(data.getString("h"));
                ancho = widthPantalla / widthPantalla_otro ;
                alto = heightPantalla / heightPantalla_otro ;


                ultimo = Float.parseFloat(data.getString("ultimo"));

                         if ( ultimo == 0) {
                             //bloqueado = false;
                             System.out.println("------------------- si ------------------ ");
                             System.out.println("ArrayList size before removing elements : " + lista.size());
                             System.out.println( lista.size() + " == " + contador + "\n");
                             lista.add(negativo);
                             lista.add(negativo);


                         }
                        else if ( ultimo == 1 ) {
                            //bloqueado = true;
                            System.out.println("------------------- no ------------------ ");
                            x = Float.parseFloat(data.getString("x"));
                             lista.add(x);
                            y = Float.parseFloat(data.getString("y"));
                             lista.add(y);

                        }
                        if ( ultimo == 2){
                             System.out.println("------------------- jorgeeeeeee ------------------ ");

                             path.reset();
                             lista.clear();
                             contador=0;
                         }

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

            if ( contador+4 < lista.size() ) {

                if ( lista.get(contador) != -1 && lista.get(contador+1) != -1 ) {
                    path.moveTo(lista.get(contador), lista.get(contador + 1));

                    contador += 2;

                    if ( lista.get(contador) == -1 && lista.get(contador+1) == -1 ) path.lineTo(lista.get(contador-2), lista.get(contador -1));

                    else path.lineTo(lista.get(contador), lista.get(contador + 1));
                }
                else contador += 2;

            }



            canvas.drawPath(path,paint);
            invalidate();
        }


    }
    @Override
    public void onBackPressed() {


        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Vuelva a pulsar el botón ATRAS para salir", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;

            }
        }, 2000);
    }
}
