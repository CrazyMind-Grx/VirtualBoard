package com.vb.iv.virtualboardalpha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal del programa. Se encarga de enviar el mensaje escrito al server.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Esta funcion se encarga de llevarnos al activity Listado al clicar el boton botonListado
     * mediante un Intent
     * @param view
     */
    public void listadoOnClick(View view) {
        startActivity(new Intent(this, Listado.class));


    }

    /**
     * Esta funcion envia el mensaje escrito en el EditText et_texto al server
     * @param view
     */
    public void EnviarOnClik(View view) {
        Thread nt = new Thread() {
            @Override
            /**
             * Con esta funcion obtenesmos los Views que estan en pantalla
             */
            public void run() {
                EditText nombre = (EditText) findViewById(R.id.et_nombre);
                EditText texto = (EditText) findViewById(R.id.et_texto);
                CheckBox modo = (CheckBox) findViewById(R.id.ck_modo);

                try {
                    final String res;
                    if (modo.isChecked()) {
                        res = enviarGet(nombre.getText().toString(), texto
                                .getText().toString());

                    } else {
                        res = enviarPost(nombre.getText().toString(), texto
                                .getText().toString());
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, res,
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        };
        nt.start();
    }

    public String enviarPost(String nombre, String texto) {

        HttpClient httpClient = new DefaultHttpClient();
        HttpContext localContext = new BasicHttpContext();
        HttpPost httpPost = new HttpPost(
                "http://virtualboardphp-virtualboard.rhcloud.com/PutData.php");
        HttpResponse response = null;
        try {
            List<NameValuePair> params = new ArrayList<NameValuePair>(3);
            params.add(new BasicNameValuePair("nombre", nombre));
            params.add(new BasicNameValuePair("texto", texto));
            params.add(new BasicNameValuePair("modo", "POST"));
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            response = httpClient.execute(httpPost, localContext);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return response.toString();

    }

    public String enviarGet(String nombre, String texto) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpContext localContext = new BasicHttpContext();
        HttpResponse response = null;
        String parametros = "?nombre=" + nombre + "&texto=" + texto
                + "&modo=GET";

        HttpGet httpget = new HttpGet(
                "http://virtualboardphp-virtualboard.rhcloud.com/PutData.php" + parametros);
        try {
            response = httpClient.execute(httpget, localContext);

        } catch (Exception e) {

        }
        return response.toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}