package com.example;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Gyerekszoba extends Szoba {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gyerekszoba);

		
		final EditText edit = (EditText) findViewById(R.id.gyerekszoba_homerseklet);
		Button plus = (Button) findViewById(R.id.plusz);
		Button minusz = (Button) findViewById(R.id.minusz);
		
		plus.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Integer fok = Integer.parseInt(edit.getText().toString());
				fok++;
				edit.setText(fok.toString());
			}
		});
		
		minusz.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Integer fok = Integer.parseInt(edit.getText().toString());
				fok--;
				edit.setText(fok.toString());
			}
		});
	
	}

}
