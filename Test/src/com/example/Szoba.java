package com.example;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Szoba extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_szoba);
		
		
		setupMessageButton();
	}

	private void setupMessageButton(){
		Button b = (Button)findViewById(R.id.Nappali);
		b.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Szoba.this, Nappali.class));
				
			};
		});
		Button b1 = (Button)findViewById(R.id.Furdoszoba);
		b1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Szoba.this, Furdoszoba.class));
				
			};
		});
		Button b2 = (Button)findViewById(R.id.Konyha);
		b2.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Szoba.this, Konyha.class));
				
			};
		});
		Button b3 = (Button)findViewById(R.id.Eloszoba);
		b3.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Szoba.this, Eloszoba.class));
				
			};
		});
		Button b4 = (Button)findViewById(R.id.Gyerekszoba);
		b4.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Szoba.this, Gyerekszoba.class));
				
			};
		});
		Button b5 = (Button)findViewById(R.id.Haloszoba);
		b5.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Szoba.this, Haloszoba.class));
				
			};
		});
	
	}
	
/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.szoba, menu);
		return true;
	}*/

}
