package com.example;

import com.pojo.Szobalista;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Futes extends Activity {

	public static final String tulajdonsag="tulajdonsag";
	private Szobalista lista ;
	private Szobalista lista2;
	private Integer haloszoba_h, eloszoba_h, konyha_h;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_futes);
		if((lista =getIntent().getParcelableExtra(Tulajdonsagok.tulajdonsag))==null){
			lista2=getIntent().getParcelableExtra(Futes2.tulajdonsag);
			haloszoba_h= lista2.getSzoba().get(5).getHomerseklet();
			konyha_h =lista2.getSzoba().get(2).getHomerseklet();
			eloszoba_h =lista2.getSzoba().get(3).getHomerseklet();
		}
		else{
		haloszoba_h= lista.getSzoba().get(5).getHomerseklet();
		konyha_h =lista.getSzoba().get(2).getHomerseklet();
		eloszoba_h =lista.getSzoba().get(3).getHomerseklet();
		}

		
		//haloszoba
		final EditText haloszoba = (EditText) findViewById(R.id.haloszoba_homerseklet);
		haloszoba.setText(haloszoba_h.toString());
		Button haloszoba_plusz = (Button) findViewById(R.id.haloszoba_plusz);
		Button haloszoba_minusz = (Button) findViewById(R.id.haloszoba_minusz);
		
		//konyha
		final EditText konyha = (EditText) findViewById(R.id.konyha_homerseklet);
		konyha.setText(konyha_h.toString());
		Button konyha_plusz = (Button) findViewById(R.id.konyha_plusz);
		Button konyha_minusz = (Button) findViewById(R.id.konyha_minusz);
		
		//Eloszoba
		final EditText eloszoba = (EditText) findViewById(R.id.eloszoba_homerseklet);
		eloszoba.setText(eloszoba_h.toString());
		Button eloszoba_plusz = (Button) findViewById(R.id.eloszoba_plusz);
		Button eloszoba_minusz = (Button) findViewById(R.id.eloszoba_minusz);
		
		Button kov = (Button) findViewById(R.id.kovetkezo);

		kov.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Futes.this, Futes2.class).putExtra(tulajdonsag, lista));

			};
		});
		
		
		//haloszoba
		haloszoba_plusz.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer haloszoba_fok = Integer.parseInt(haloszoba.getText()
						.toString());
				haloszoba_fok++;
				haloszoba.setText(haloszoba_fok.toString());

			}
		});

		haloszoba_minusz.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer haloszoba_fok = Integer.parseInt(haloszoba.getText()
						.toString());
				haloszoba_fok--;
				haloszoba.setText(haloszoba_fok.toString());

			}
		});
		
		
		
		//konyha
		konyha_plusz.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer konyha_fok = Integer.parseInt(konyha.getText()
						.toString());
				konyha_fok++;
				konyha.setText(konyha_fok.toString());

			}
		});

		konyha_minusz.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer konyha_fok = Integer.parseInt(konyha.getText()
						.toString());
				konyha_fok--;
				konyha.setText(konyha_fok.toString());

			}
		});
		
		
		
		
		//Eloszoba
		eloszoba_plusz.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer eloszoba_fok = Integer.parseInt(eloszoba.getText()
						.toString());
				eloszoba_fok++;
				eloszoba.setText(eloszoba_fok.toString());

			}
		});

		eloszoba_minusz.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer eloszoba_fok = Integer.parseInt(eloszoba.getText()
						.toString());
				eloszoba_fok--;
				eloszoba.setText(eloszoba_fok.toString());

			}
		});
		
	}

}
