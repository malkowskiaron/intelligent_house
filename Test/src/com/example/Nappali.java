package com.example;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class Nappali extends Szoba {

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nappali);
		
		homerseklet= ((com.pojo.Szoba) getIntent().getExtras().get(SzobaValaszto.szoba)).getHomerseklet();
		lampa=((com.pojo.Szoba) getIntent().getExtras().get(SzobaValaszto.szoba)).getLampa();
		
		final EditText edit = (EditText) findViewById(R.id.nappali_homerseklet);
		edit.setText(((Integer)(homerseklet)).toString());
		
		Button plus = (Button) findViewById(R.id.plusz);
		Button minusz = (Button) findViewById(R.id.minusz);
		
		Switch lampakapcsolo= (Switch) findViewById(R.id.nappali);
		lampakapcsolo.setChecked(lampa);
		
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
