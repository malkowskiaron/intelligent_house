package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pojo.Szobalista;

public class SzobaValaszto extends Activity {

	public static final String szoba = "szoba";
	private Szobalista lista ;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_szoba);
		
		lista =getIntent().getParcelableExtra(MainActivity.atadas);
		setupMessageButton();
	}

	private void setupMessageButton(){
		Button b = (Button)findViewById(R.id.Nappali);
		b.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				startActivity(new Intent(SzobaValaszto.this, Nappali.class).putExtra(szoba, lista.getSzoba().get(0)));
				
			};
		});
		Button b1 = (Button)findViewById(R.id.Furdoszoba);
		b1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				startActivity(new Intent(SzobaValaszto.this, Furdoszoba.class).putExtra(szoba, lista.getSzoba().get(1)));
				
			};
		});
		Button b2 = (Button)findViewById(R.id.Konyha);
		b2.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				startActivity(new Intent(SzobaValaszto.this, Konyha.class).putExtra(szoba, lista.getSzoba().get(2)));
				
			};
		});
		Button b3 = (Button)findViewById(R.id.Eloszoba);
		b3.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				startActivity(new Intent(SzobaValaszto.this, Eloszoba.class).putExtra(szoba, lista.getSzoba().get(3)));
				
			};
		});
		Button b4 = (Button)findViewById(R.id.Gyerekszoba);
		b4.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				startActivity(new Intent(SzobaValaszto.this, Gyerekszoba.class).putExtra(szoba, lista.getSzoba().get(4)));
				
			};
		});
		Button b5 = (Button)findViewById(R.id.Haloszoba);
		b5.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				startActivity(new Intent(SzobaValaszto.this, Haloszoba.class).putExtra(szoba, lista.getSzoba().get(5)));
				
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
