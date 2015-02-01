package com.example.virtualapp.test;
import com.example.virtualapp.MainActivity;
import com.example.virtualapp.R;

import android.annotation.TargetApi;
import android.os.Build;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.TextView;


/**
 * Test de los componentes de la vista de la actividad principal
 * 
 * @author Marquina
 */
public class Test_mainactivity_view extends ActivityInstrumentationTestCase2<MainActivity> {

	public Test_mainactivity_view() {
		this("Test para MainActivity elementos");
	}


	public Test_mainactivity_view(String s) {
		super(MainActivity.class); 
		setName(s);
	}
	
	public Test_mainactivity_view(Class<MainActivity> activityClass) {
		super(activityClass);
	}
	
	
	MainActivity ma;
	View origin;

	protected void setUp() throws Exception {
		super.setUp();
		ma = this.getActivity();
		origin = ma.getWindow().getDecorView();
	}
	
	/**
	 * Test para comprobar que hemos creado la interfeaz correctamente (todos los elementos)
	 * Para que el usuario pueda usar la aplicación correctamente
	 */
	
	public void testinicializacion() {
		View elemento = ma.findViewById(R.id.TextView01);
		assertNotNull(elemento);
		ViewAsserts.assertOnScreen(origin, elemento);
		
		elemento = ma.findViewById(R.id.et_texto);
		assertNotNull(elemento);
		ViewAsserts.assertOnScreen(origin, elemento);
		
		elemento = ma.findViewById(R.id.ck_modo);
		assertNotNull(elemento);
		ViewAsserts.assertOnScreen(origin, elemento);	
			
		elemento = ma.findViewById(R.id.button1);		
		assertNotNull(elemento);
		ViewAsserts.assertOnScreen(origin, elemento);
		
		elemento = ma.findViewById(R.id.botonListado);		
		assertNotNull(elemento);
		ViewAsserts.assertOnScreen(origin, elemento);

	}
	
	/**
	 * Este test comprobará que tenemos en la actividad las indicaciones necesarias
	 * para el usuario.
	 */
	public void test_elementos() {
		View label = ma.findViewById(R.id.TextView02);
		assertNotNull(label);	
		TextView text = (TextView)label;
		assertEquals("Nombre", 	text.getText().toString());
		ViewAsserts.assertOnScreen(origin, label);
		
		label = ma.findViewById(R.id.TextView01);
		assertNotNull(label);	
		text = (TextView)label;
		assertEquals("Texto", text.getText().toString());
		ViewAsserts.assertOnScreen(origin, label);
		
		label = ma.findViewById(R.id.ck_modo);
		assertNotNull(label);
		text = (TextView)label;
		assertEquals("Enviar por GET", 	text.getText().toString());
		ViewAsserts.assertOnScreen(origin, label);
		
		label = ma.findViewById(R.id.button1);
		assertNotNull(label);
		text = (TextView)label;
		assertEquals("Enviar", 	text.getText().toString());
		ViewAsserts.assertOnScreen(origin, label);
		
		label = ma.findViewById(R.id.botonListado);
		assertNotNull(label);
		text = (TextView)label;
		assertEquals("Listado", text.getText().toString());
		ViewAsserts.assertOnScreen(origin, label);
		
	}

}