package com.vb.iv.virtualboardalpha;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Esta clase es donde se mostrara la informacion enviada desde el servidor
 */
public class Listado extends Activity {


    @Override
    /**
     * Esta funcion leeara de manera remota lo que el servidor envia
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        //Creamos la hebra
        Thread tr = new Thread() {
            @Override
            //Creamos el metodo run
            public void run() {
                final String Resultado = leer();
                runOnUiThread(
                        new Runnable() {

                            @Override
                            public void run() {
                                cargaListado(obtDatosJSON(Resultado));
                            }
                        });
            }
        };
        tr.start();
    }


    /**
     * Esta funcion crea el menu de opciones
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_listado, menu);
        return true;
    }

    /**
     * Esta funcion carga los datos leido en un ListView
     * @param datos los datos que recibimos
     */
    public void cargaListado(ArrayList<String> datos) {
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
        ListView listado = (ListView) findViewById(R.id.listView1);
        listado.setAdapter(adaptador);
    }

    /**
     * Esta funcion lee los datos desde el servidor
     * @return
     */
    public String leer() {
        HttpClient cliente = new DefaultHttpClient();
        HttpContext contexto = new BasicHttpContext();
        HttpGet httpget = new HttpGet("http://virtualboardphp-virtualboard.rhcloud.com/GetData.php");
        String resultado = null;
        try {
            HttpResponse response = cliente.execute(httpget, contexto);
            HttpEntity entity = response.getEntity();
            resultado = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            // TODO: handle exception
        }
        return resultado;
    }

    /**
     * Esta funcion obtiene un arraylist desde reponse y se lo asignamos al listado
     * @param response
     * @return
     */
    public ArrayList<String> obtDatosJSON(String response) {
        ArrayList<String> listado = new ArrayList<String>();
        try {
            JSONArray json = new JSONArray(response);
            String texto = "";
            for (int i = 0; i < json.length(); i++) {
                texto = json.getJSONObject(i).getString("nombre") + " - " +
                        json.getJSONObject(i).getString("texto") + " - " +
                        json.getJSONObject(i).getString("modo");
                listado.add(texto);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return listado;
    }

}