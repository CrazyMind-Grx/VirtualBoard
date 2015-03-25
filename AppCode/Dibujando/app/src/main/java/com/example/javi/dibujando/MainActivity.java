package com.example.javi.dibujando;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Pizarra pizarra=new Pizarra(this);
        setContentView(pizarra);
    }
    //Creamos nuestra propia vista
    class Pizarra extends View{

        float x = 0;
        float y = 0;
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
            }
            if(e.getAction()==MotionEvent.ACTION_MOVE)//Al mover el dedo sobre la pantalla....
            {
                accion="move";
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
