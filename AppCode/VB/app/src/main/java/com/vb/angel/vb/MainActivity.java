package com.vb.angel.vb;

import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Handler;
import java.util.logging.LogRecord;


public class MainActivity extends ActionBarActivity {
    private String ip;
    private int puerto;
    Socket miCliente;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    String mdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton_enviar = (Button)findViewById(R.id.button);
        final EditText mensaje = (EditText)findViewById(R.id.escribir);
        final TextView scroll = (TextView)findViewById(R.id.scroll);
        final String vacio="";

        ip = "vs-angeljcc.c9.io";
        puerto = 8080;

        boton_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mensaje.getText().toString().equals(vacio)) {
                    Toast.makeText(mensaje.getContext(), "El campo esta vacío, no se enviará nada!!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(mensaje.getContext(), "escribiste: "+mensaje.getText(), Toast.LENGTH_LONG).show();
                    //scroll.setText(mensaje.getText().toString());
                    EnviarMensaje(mensaje.getText().toString());
                    mensaje.setText("");
                }
            }
        });

        mensaje.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER){
                    //Toast.makeText(mensaje.getContext(), "escribiste: "+mensaje.getText(), Toast.LENGTH_LONG).show();
                    return true;
                }
                return false;
            }
        });
    }

    //Funciones de  conexion y desconexion
    public void EnviarMensaje(String mens) {
        //Obtengo datos ingresados en campos

        try {//creamos sockets con los valores anteriores
            miCliente = new Socket("23.251.142.247",8080);
            oos = new ObjectOutputStream(miCliente.getOutputStream());
            oos.writeObject(mens);
            Message serverMenssage =Message.obtain();
            ois = new ObjectInputStream(miCliente.getInputStream());
            serverMenssage.obj = (String)ois.readObject();

            oos.close();
            ois.close();
        }catch (Exception e){
            e.printStackTrace();
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
