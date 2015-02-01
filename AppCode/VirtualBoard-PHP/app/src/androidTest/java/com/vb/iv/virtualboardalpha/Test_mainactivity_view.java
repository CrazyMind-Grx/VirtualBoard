package com.vb.iv.virtualboardalpha.test;
import com.vb.iv.virtualboardalpha.MainActivity;
import com.vb.iv.virtualboardalpha.R;

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
	/**
	 * Constructor por defecto
	 */
	public Test_mainactivity_view() {
		this("Test para MainActivity elementos");
	}

	/**
	 * Constructor con string
	 * @param s String
	 */
	public Test_mainactivity_view(String s) {
		super(MainActivity.class); 
		setName(s);
	}
	
	/**
	 * Constructor con string
	 * @param activityClass actividad a la que realizar test
	 */
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
	public void test_inicializacion() {
		View elemento = ma.findViewById(R.id.TextView01);//el campo de texto a escribir
		assertNotNull(elemento);
		ViewAsserts.assertOnScreen(origin, elemento);
		
		elemento = ma.findViewById(R.id.TextView02);//el campo para introducir login
		assertNotNull(elemento);
		ViewAsserts.assertOnScreen(origin, elemento);
		
		elemento = ma.findViewById(R.id.et_texto);//campo de texto 
		assertNotNull(elemento);
		ViewAsserts.assertOnScreen(origin, elemento);
		
		elemento = ma.findViewById(R.id.ck_modo);//opción de envío
		assertNotNull(elemento);
		ViewAsserts.assertOnScreen(origin, elemento);	
			
		elemento = ma.findViewById(R.id.button1);//boton de envío		
		assertNotNull(elemento);
		ViewAsserts.assertOnScreen(origin, elemento);
		
		elemento = ma.findViewById(R.id.botonListado);//boton de listado	
		assertNotNull(elemento);
		ViewAsserts.assertOnScreen(origin, elemento);

	}
	
	/**
	 * Este test comprobará que tenemos en la actividad los hints necesarios
	 * para el funcionamiento.
	 */
	public void test_hint() {
		View hint= ma.findViewById(R.id.button1);
		assertNotNull(hint);
		
		TextView text = (TextView)hint;

		assertEquals("Listar", text.getHint().toString());
		ViewAsserts.assertOnScreen(origin, hint);
	}
	
	/**
	 * Este test comprobará que tenemos en la actividad las indicaciones necesarias
	 * para el usuario.
	 */
	public void test_elementos() {
		View label = ma.findViewById(R.id.TextView02);//el campo para introducir login
		assertNotNull(label);	
		TextView text = (TextView)label;
		assertEquals("Nombre", 	text.getText().toString());
		ViewAsserts.assertOnScreen(origin, label);
		
		label = ma.findViewById(R.id.TextView01);//campo de texto a escribir
		assertNotNull(label);	
		text = (TextView)label;
		assertEquals("Texto", text.getText().toString());
		ViewAsserts.assertOnScreen(origin, label);
		
		label = ma.findViewById(R.id.ck_modo);//opción para enviar mediante GET
		assertNotNull(label);
		text = (TextView)label;
		assertEquals("Enviar por GET", 	text.getText().toString());
		ViewAsserts.assertOnScreen(origin, label);
		
		label = ma.findViewById(R.id.button1);//boton de envío
		assertNotNull(label);
		text = (TextView)label;
		assertEquals("Enviar", 	text.getText().toString());
		ViewAsserts.assertOnScreen(origin, label);
		
		label = ma.findViewById(R.id.botonListado);//boton de listado
		assertNotNull(label);
		text = (TextView)label;
		assertEquals("Listado", text.getText().toString());
		ViewAsserts.assertOnScreen(origin, label);
		
	}
	
}
