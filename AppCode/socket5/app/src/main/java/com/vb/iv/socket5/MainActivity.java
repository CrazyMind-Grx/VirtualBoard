package com.vb.iv.socket5;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.util.ArrayList;

import io.socket.IOAcknowledge;
import io.socket.IOCallback;
import io.socket.SocketIO;
import io.socket.SocketIOException;


public class MainActivity extends ActionBarActivity implements callbackAdapter{
    private Button enviar;
    private Button conectar;
    private EditText mensaje;
    private ScrollView scroll;
    private SocketIO socket;

    //private IOCallback callback;
    private ListView listado;
    private callback callbackIO;
    private TextView textoArriba,infor;
   // private callback call;
    private Mensajes conexionMensajes;
    private String aux;
    private  ArrayList<String> datos;

    private ArrayAdapter<String> adaptador;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enviar= (Button) findViewById(R.id.enviar);
        conectar = (Button)findViewById(R.id.conectar);
        mensaje = (EditText) findViewById(R.id.mensaje);
        scroll = (ScrollView)findViewById(R.id.scrollView);
        listado = (ListView)findViewById(R.id.listView);
        textoArriba = (TextView)findViewById(R.id.textView);
        infor = (TextView)findViewById(R.id.texto);
        datos = new ArrayList<String>();

        //ArrayAdapter<String> adaptador = new ArrayAdapter<String> (this,android.R.layout.simple_list_item_1,datos);
        //listado.setAdapter(adaptador);
        adaptador = new ArrayAdapter<String> (this,android.R.layout.simple_list_item_1,datos);

        conexionMensajes = new Mensajes(this);
        conexionMensajes.start();



        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conexionMensajes.sendMessage(mensaje.getText().toString());
                infor.setText(aux);
                mensaje.setText("");
                //ArrayAdapter<String> adaptador = new ArrayAdapter<String> (this,android.R.layout.simple_list_item_1,datos);
                listado.setAdapter(adaptador);


                //socket = new SocketIO();
                /*callback = new IOCallback() {
                    @Override
                    public void onDisconnect() {
                        Toast.makeText(getApplicationContext(),"Desconectado",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onConnect() {
                        Toast.makeText(getApplicationContext(),"Conectado",Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onMessage(String s, IOAcknowledge ioAcknowledge) {
                        //if (ioAcknowledge.equals("onMessage"))
                        Toast.makeText(getApplicationContext(),"Servidor: "+ s,Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onMessage(JSONObject jsonObject, IOAcknowledge ioAcknowledge) {
                        //Toast.makeText(getApplicationContext(),"ervidor dice:"+jsonObject.toString(2),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void on(String s, IOAcknowledge ioAcknowledge, Object... objects) {
                        Toast.makeText(getApplicationContext(),"servidor dice: "+objects[0],Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(SocketIOException e) {
                        Toast.makeText(getApplicationContext(),"ERROR",Toast.LENGTH_LONG).show();

                    }
                };
                try {
                    socket.connect("http://192.168.0.194:3000/", callback);

                    socket.send("Hello server");
                    socket.send(mensaje.getText().toString());

                    socket.emit("sendMessage", mensaje.getText().toString(), "arg2", 13.37);

                    //callback.onMessage("onMessage",null);

                }catch (MalformedURLException e){
                    e.printStackTrace();
                }*/
            }
        });

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

    @Override
    public void callback(JSONArray data) throws JSONException {

    }

    @Override
    public void on(String event, JSONObject data) {
        try{
            if(event.equals("new message")){

                aux=event;

                datos.add(data.getString("data").toString());
            System.out.println("Evento: "+event);
            System.out.println("cadena mandada: "+data.getString("data").toString());
            }
        }catch (JSONException e){
            e.printStackTrace();

        }
    }

    @Override
    public void onMessage(String message) {
        //Toast.makeText(getApplicationContext(),"on message String Servidor dice: "+message+" ",Toast.LENGTH_LONG).show();
        textoArriba.setText(message);
    }

    @Override
    public void onMessage(JSONObject json) {
        //Toast.makeText(getApplicationContext(),"onMessage json Servidor dice: "+json.toString()+"  ",Toast.LENGTH_LONG).show();
        textoArriba.setText("por aqui");
    }

    @Override
    public void onConnect() {
        //textoArriba.setText("___Conectado___");
    }

    @Override
    public void onDisconnect() {
        textoArriba.setText("Desonectado");
    }

    @Override
    public void onConnectFailure() {
        textoArriba.setText("Error");
    }
}
