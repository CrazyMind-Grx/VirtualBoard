package com.prueba.virtualboard;

/**
 * Created by Javier Aranda Izquierdo on 10/12/14.
 */
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Cliente extends Activity{

    private ObjectOutputStream salida;
    private String servidorChat;
    private int puerto;
    private Socket cliente;
    private CheckBox check;
    private Button boton;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Componentes graficos
        boton = (Button) findViewById(R.id.BotonEnviar);
        check = (CheckBox) findViewById(R.id.checkBoxConectar);
        text = (TextView) findViewById(R.id.TextoScroll);

        servidorChat = "192.168.1.33"; // servidor
        puerto = 12345; // puerto

        try {
            // Crea un socket conectado al servidor y al puerto
            cliente = new Socket(servidorChat, puerto);
            // Flujos de salida
            salida = new ObjectOutputStream(cliente.getOutputStream());
        } catch (UnknownHostException e) {
            // Alert que avisa del error
            Toast.makeText(Cliente.this, R.string.UnkowHost,
                    Toast.LENGTH_LONG).show();
            android.util.Log.w("¡¡¡ERROR!!!", e.getMessage());
        } catch (IOException e) {
            Toast.makeText(Cliente.this, R.string.ConectionError,
                    Toast.LENGTH_LONG).show();
            android.util.Log.w("¡¡¡ERROR!!!", e.getMessage());
        }
    }

    protected void onDestroy() {
        try {
            salida.close();
            cliente.close();
        } catch (IOException e) {
            Toast.makeText(Cliente.this, R.string.errorDesconexion,
                    Toast.LENGTH_LONG).show();
            android.util.Log.w("¡¡¡ERROR!!!", e.getMessage());
        }
        super.onDestroy();

    }

    public void onEnviarClick(View botton) {
        try {
            if (cliente != null) {
                salida.writeObject(text.getText().toString());
                salida.flush(); // vacíar búfer de salida para enviar
                // información de
            } else
                Toast.makeText(Cliente.this, R.string.ConectionError,
                        Toast.LENGTH_LONG).show();

            // encabezado
        } catch (UnknownHostException e) {
            Toast.makeText(Cliente.this, R.string.UnkowHost,
                    Toast.LENGTH_LONG).show();
            android.util.Log.w("¡¡¡Error!!!", e.getMessage());
        } catch (IOException e) {
            Toast.makeText(Cliente.this, R.string.ConectionError,
                    Toast.LENGTH_LONG).show();
            android.util.Log
                    .w("¡¡¡ERROOOOORRRORORORORORORO!!!", e.getMessage());
        }

    }

    public void onConectarDesconectar(View checkBox) {
        if (!check.isChecked()) {
            boton.setEnabled(false);
            text.setEnabled(false);

        } else {
            boton.setEnabled(true);
            text.setEnabled(true);
        }

    }
}

}
