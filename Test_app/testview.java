package com.example.virtualboard.test;


import com.example.virtualboard.Principal;
import com.example.virtualboard.R;

import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.TextView;


/**
 * Esta clase testea los componentes de la vista de la actividad principal:
 *  -Si estan todos los elemenos que deben de estar
 *  -Si se muestran las indicaciones en los sitios correspondientes y correctamente
 * 
 * @author Marquina
 *
 */
public class testview extends ActivityInstrumentationTestCase2<Principal> {

	public testview() {
		this("PrincipalView");
	}


	public testview(String s) {
		super(Principal.class); 
		setName(s);
	}
	
	public testview(Class<Principal> activity_Class) {
		super(activity_Class);
	}
	
	Principal ma;
	View origin;
	
	/**
	 * Código de inicialización común a todos los tests
	 */
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
		View elemento = ma.findViewById(R.id.ip);
		assertNotNull(elemento);
		ViewAsserts.assertOnScreen(origin, elemento);
		
		elemento = ma.findViewById(R.id.puerto);
		assertNotNull(elemento);
		ViewAsserts.assertOnScreen(origin, elemento);
		
		elemento = ma.findViewById(R.id.borrar);
		assertNotNull(elemento);
		ViewAsserts.assertOnScreen(origin, elemento);	
			
		elemento = ma.findViewById(R.id.connect);		
		assertNotNull(elemento);
		ViewAsserts.assertOnScreen(origin, elemento);
		
		elemento = ma.findViewById(R.id.response);		
		assertNotNull(elemento);
		ViewAsserts.assertOnScreen(origin, elemento);

	}
	
	
	/**
	 * Test para comprobar que hemos creado los hints con sus mensajes indicativos correctamente
	 * Para que el usuario sepa dónde escribir los datos de acceso al host
	 */
	public void testHint() {
		View title = ma.findViewById(R.id.ip);
		assertNotNull(title);
		
		TextView text = (TextView)title;

		assertEquals("IP(0.0.0.0)", text.getHint().toString());
		ViewAsserts.assertOnScreen(origin, title);
		
		title = ma.findViewById(R.id.puerto);
		assertNotNull(title);
		
		text = (TextView)title;

		assertEquals("Puerto", text.getHint().toString());
		ViewAsserts.assertOnScreen(origin, title);	
	}

}