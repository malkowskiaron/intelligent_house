package com.example;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Tulajdonsagok extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tulajdonsagok);
		
		setupMessageButton();

	}
	private void setupMessageButton(){
		Button b = (Button)findViewById(R.id.Gyerekszoba);
		b.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Tulajdonsagok.this, Vilagitas.class));
				
			};
		});
			Button b1 = (Button)findViewById(R.id.Futes);
			b1.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
					startActivity(new Intent(Tulajdonsagok.this, Futes.class));
					
				};
			});
	}
/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tulajdonsagok, menu);
		return true;
	}*/

}
