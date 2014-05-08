package com.example;

import com.pojo.Szobalista;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Tulajdonsagok extends Activity {
	
	public static final String tulajdonsag="tulajdonsag";
	private Szobalista lista ;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tulajdonsagok);
		
		lista =getIntent().getParcelableExtra(MainActivity.atadas);
		
		setupMessageButton();

	}
	private void setupMessageButton(){
		Button b = (Button)findViewById(R.id.Gyerekszoba);
		b.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Tulajdonsagok.this, Vilagitas.class).putExtra(tulajdonsag, lista));
				
			};
		});
			Button b1 = (Button)findViewById(R.id.Futes);
			b1.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
					startActivity(new Intent(Tulajdonsagok.this, Futes.class).putExtra(tulajdonsag, lista));
					
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
