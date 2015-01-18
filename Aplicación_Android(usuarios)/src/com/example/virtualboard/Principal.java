package com.example.virtualboard;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Clase principal del programa. Se encarga de la comunicación con el server
 */
public class Principal extends Activity {

    TextView textResponse;
    EditText editIP, editPort;
    Button bconectar, beliminar;
    /**
     * Función que se encarga de crear la actividad, se puede querer crear con
     *  información que tenía previamente
     *  @param Bundle información que se recibe para crearla
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        editIP = (EditText)findViewById(R.id.ip);
        editPort = (EditText)findViewById(R.id.puerto);
        bconectar = (Button)findViewById(R.id.connect);
        beliminar = (Button)findViewById(R.id.borrar);
        textResponse = (TextView)findViewById(R.id.response);

        bconectar.setOnClickListener(buttonConnectOnClickListener);

        beliminar.setOnClickListener(new OnClickListener(){//evento a la espera de un click en beliminar

            @Override
            public void onClick(View v) {//borra los datos de respuesta
                textResponse.setText("");
            }});
    }

    OnClickListener buttonConnectOnClickListener =
            new OnClickListener(){

		        /**
		         * Función que se encarga de crear el hilo, después de haber pasado
		         * a string la ip y a entero el puerto
		         *  @param View información que se recibe de la interfaz
		         */
                @Override
                public void onClick(View arg0) {
                    MyClientTask myClientTask = new MyClientTask(
                            editIP.getText().toString(),
                            Integer.parseInt(editPort.getText().toString()));
                    myClientTask.execute();//crea la tarea (hilo/proceso)
                }};

                
    /**
    * Clase MyClientTask del programa, que se extiende de AsynkTask, y que nos da la posibilidad
    * de  crear varios hilos y asi no interrumpir la aplicación mientras recibimos información
    * del servidor mediante los socket
    */
    public class MyClientTask extends AsyncTask<Void, Void, Void> {
    	 /** Constantes */
        String dstAddress;
        int dstPort;
        String response = "";
        
        /** Constructor */
        MyClientTask(String addr, int port){
            dstAddress = addr;
            dstPort = port;
        }

        /**
         * Esta funcion se encarga de recibir la información que le envia el socket
         * y mostralar en la pantalla, además de crear la conexión con el servidor mediante
         * el socket. Todo esto se realiza en segundo plano
         * 
         * @param void información que contiene arg0
         * @exception UnknownHostException Se genera una excepción de error de conexión .
         * @exception IOException Se genera una excepción de entrada/salida.
         * @return null
         */
        @Override
        protected Void doInBackground(Void... arg0) {

            Socket socket = null;

            try {
                socket = new Socket(dstAddress, dstPort);//creamos el socket con la ip y puerto

                ByteArrayOutputStream byteArrayOutputStream =
                        new ByteArrayOutputStream(1024);// guardaremos los bytes recibidos en memoria en un array de bytes
                byte[] buffer = new byte[1024];//creamos buffer dónde almacenar los datos que recibimos de 1 KB

                int bytesRead;
                InputStream inputStream = socket.getInputStream();//obtenemos la información recibida del servidor
              
                //guardamos la información del socket en forma de string en response
                while ((bytesRead = inputStream.read(buffer)) != -1){
                    byteArrayOutputStream.write(buffer, 0, bytesRead);//escribimos los bytes(bytesRead) del socket en el buffer 
                    response += byteArrayOutputStream.toString("UTF-8");
                }

            } catch (UnknownHostException e) {
                e.printStackTrace();
                response = e.toString();
            } catch (IOException e) {
                e.printStackTrace();
                response =  e.toString();
            }finally{
                if(socket != null){
                    try {
                        socket.close();//cerramos la conexión
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }
        
        /**
         * Esta funcion se encarga de mostrar el string response (información del socket u errores)
         * Se va actualizando mientras se ejecuta la tarea doInBackground
         * @param objeto que regresa de doInBackground
         */
        @Override
        protected void onPostExecute(Void result) {
            textResponse.setText(response);//mostramos el contenido de response
            super.onPostExecute(result);
        }

    }

}