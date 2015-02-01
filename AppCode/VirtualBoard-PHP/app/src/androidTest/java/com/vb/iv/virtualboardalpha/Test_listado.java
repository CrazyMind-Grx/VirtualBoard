package com.example.virtualapp.test;
import com.example.virtualapp.Listado;
import com.example.virtualapp.R;

import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;

/**
 * Test de los componentes de la vista de la actividad Listado
 * 
 * @author Marquina
 */
public class Test_listado extends ActivityInstrumentationTestCase2<Listado> {
	/**
	 * Constructor por defecto
	 */
	public Test_listado() {
		this("Test para Listado elementos");
	}

	/**
	 * Constructor con string
	 * @param s String
	 */
	public Test_listado(String s) {
		super(Listado.class); 
		setName(s);
	}
	
	/**
	 * Constructor con string
	 * @param activityClass actividad a la que realizar test
	 */
	public Test_listado(Class<Listado> activityClass) {
		super(activityClass);
	}
	
	
	Listado ma;
	View origin;

	protected void setUp() throws Exception {
		super.setUp();
		ma = this.getActivity();
		origin = ma.getWindow().getDecorView();
	}
	
	/**
	 * Test para comprobar que hemos creado la interfeaz correctamente
	 * Para que el usuario pueda usar la aplicación correctamente
	 */
	public void test_inicializacion() {
		View elemento = ma.findViewById(R.id.listView1);//lista de los mensajes
		assertNotNull(elemento);
		ViewAsserts.assertOnScreen(origin, elemento);	
	}
	
}