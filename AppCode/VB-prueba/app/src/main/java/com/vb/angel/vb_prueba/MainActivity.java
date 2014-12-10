package com.vb.angel.vb_prueba;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class MainActivity extends Activity {

    private ObjectOutputStream salida;
    private String servidorChat;
    private int puerto;
    private Socket cliente;
    private CheckBox check;
    private Button boton;
    private EditText entrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Componentes Graficos
        boton = (Button)findViewById(R.id.BotonEnviar);
        entrada = (EditText)findViewById(R.id.editText);
        check = (CheckBox)findViewById(R.id.checkBoxConectar);


        servidorChat = "https://vb-angeljcc.c9.io";
        puerto = 8080;

        try {

            cliente = new Socket(servidorChat,puerto);

            salida = new ObjectOutputStream(cliente.getOutputStream());

        }catch (UnknownHostException e){
            Toast.makeText(MainActivity.this, "error al conectar con el servidor", Toast.LENGTH_LONG).show();
        }catch (IOException e){
            Toast.makeText(MainActivity.this, "error de conexion", Toast.LENGTH_LONG).show();
        }



        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!b) {
                    boton.setEnabled(false);
                    entrada.setEnabled(false);
                } else {
                    boton.setEnabled(true);
                    entrada.setEnabled(true);
                }
            }
        });
    }
}
