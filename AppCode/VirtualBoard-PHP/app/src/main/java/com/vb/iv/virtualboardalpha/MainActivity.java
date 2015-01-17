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
     * Esta funcion envia el mensaje escritos en el EditText al pulsar el boton "et_texto"
     * al server
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
                    //res es el resultado que finalmente sera http
                    final String res;
                    //Enviamos los datos por GET
                    if (modo.isChecked()) {
                        res = enviarGet(nombre.getText().toString(), texto
                                .getText().toString());

                    }
                    //Enviamos los datos por POST
                    else {
                        res = enviarPost(nombre.getText().toString(), texto
                                .getText().toString());
                    }
                    /**
                     * Esta funcion nos da acceso a los elementos de la interface de usuario
                     */
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, res,
                                    //Mostramos el resultado en un toast
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        };
        //Hacemos que comience la hebra
        nt.start();
    }

    /**
     * Esta funcion envia los datos mediante el metodo POST de http
     * @param nombre String con el nombre que se envia
     * @param texto String con el texto que se envia
     * @return String con los datos recibidos del objeto HttpResponse de la solicitud POST
     */
    public String enviarPost(String nombre, String texto) {

        //Creamos un cliente
        HttpClient httpClient = new DefaultHttpClient();

        //Creamos el contecto donde se va a ejecutar
        HttpContext localContext = new BasicHttpContext();

        HttpPost httpPost = new HttpPost(
                //Introducimos la direccion del server
                "http://virtualboardphp-virtualboard.rhcloud.com/PutData.php");
        HttpResponse response = null;
        try {
            List<NameValuePair> params = new ArrayList<NameValuePair>(3);
            params.add(new BasicNameValuePair("nombre", nombre));
            params.add(new BasicNameValuePair("texto", texto));
            params.add(new BasicNameValuePair("modo", "POST"));

            //Creamos una entidad
            httpPost.setEntity(new UrlEncodedFormEntity(params));

            //Obtenemos el resultado de la ejecucucion
            response = httpClient.execute(httpPost, localContext);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return response.toString();

    }

    /**
     * Esta funcion manda los datos por GET al server
     * @param nombre String con el nombre que se envia
     * @param texto String con el texto que se envia
     * @return String con los datos recibidos del objeto HttpResponse de la solicitud GET
     */
    public String enviarGet(String nombre, String texto) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpContext localContext = new BasicHttpContext();
        HttpResponse response = null;

        //Creamos los parametro para pasarlos por el GET
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

    /**
     * Este metodo crea el menu de opciones
     * @param menu
     * @return true.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
