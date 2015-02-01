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
	 * Este test comprobará que tenemos en la actividad los label necesarios
	 * 
	 */
	public void test_elementos() {
		View title = ma.findViewById(R.id.TextView02);
		assertNotNull(title);
		
		TextView text = (TextView)title;
		
		//assertNotNull( title.getContentDescription());
		assertEquals("Nombre", 	text.getText().toString());
		ViewAsserts.assertOnScreen(origin, title);
		
	}

}