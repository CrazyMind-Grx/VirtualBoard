package com.prueba.virtualboard;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    EditText insertarTexto;
    TextView verTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    //Esto es para probar que funcionan bien los texrView y de mas
    /*public void MostrarTexto (View v){
        insertarTexto = (EditText)findViewById(R.id.editText);
        verTexto = (TextView)findViewById(R.id.TextoScroll);

        String a = insertarTexto.getText().toString();
        verTexto.setText(a);
    }*/


}
