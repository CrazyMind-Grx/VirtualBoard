package com.vb.angel.vb;

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


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton_enviar = (Button)findViewById(R.id.button);
        final EditText mensaje = (EditText)findViewById(R.id.escribir);
        final TextView scroll = (TextView)findViewById(R.id.scroll);

        boton_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mensaje.getContext(), "escribiste: "+mensaje.getText(), Toast.LENGTH_LONG).show();
                if(mensaje.getText().toString()!="") {
                    scroll.setText(mensaje.getText().toString());
                    mensaje.setText("");
                }else{
                    Toast.makeText(mensaje.getContext(), "El campo esta vacío, no se enviará nada!!", Toast.LENGTH_LONG).show();
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
