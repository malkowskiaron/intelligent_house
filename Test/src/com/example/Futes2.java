package com.example;

import com.pojo.Szobalista;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Futes2 extends Activity {

	private Szobalista lista ;
	public static final String tulajdonsag="tulajdonsag";

	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_futes2);
		
		lista =getIntent().getParcelableExtra(Tulajdonsagok.tulajdonsag);	
		Integer gyerekszoba_h= lista.getSzoba().get(4).getHomerseklet();
		Integer furdoszoba_h =lista.getSzoba().get(1).getHomerseklet();
		Integer nappali_h =lista.getSzoba().get(0).getHomerseklet();


		// gyerekszoba
		final EditText gyerekszoba = (EditText) findViewById(R.id.gyerekszoba_homerseklet);
		gyerekszoba.setText(gyerekszoba_h.toString());
		Button gyerekszoba_plusz = (Button) findViewById(R.id.gyerekszoba_plusz);
		Button gyerekszoba_minusz = (Button) findViewById(R.id.gyerekszoba_minusz);

		// fürdõszoba
		final EditText furdoszoba = (EditText) findViewById(R.id.furdoszoba_homerseklet);
		furdoszoba.setText(furdoszoba_h.toString());
		Button furdoszoba_plusz = (Button) findViewById(R.id.furdoszoba_plusz);
		Button furdoszoba_minusz = (Button) findViewById(R.id.furdoszoba_minusz);

		// Nappali
		final EditText nappali = (EditText) findViewById(R.id.nappali_homerseklet);
		nappali.setText(nappali_h.toString());
		Button nappali_plusz = (Button) findViewById(R.id.nappali_plusz);
		Button nappali_minusz = (Button) findViewById(R.id.nappali_minusz);

		Button elozo = (Button) findViewById(R.id.elozo);

		elozo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Futes2.this, Futes.class).putExtra(tulajdonsag, lista));

			};
		});

		// gyerekszoba
		gyerekszoba_plusz.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer gyerekszoba_fok = Integer.parseInt(gyerekszoba.getText()
						.toString());
				gyerekszoba_fok++;
				gyerekszoba.setText(gyerekszoba_fok.toString());

			}
		});

		gyerekszoba_minusz.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer gyerekszoba_fok = Integer.parseInt(gyerekszoba.getText()
						.toString());
				gyerekszoba_fok--;
				gyerekszoba.setText(gyerekszoba_fok.toString());

			}
		});

		// Fürdõszoba
		furdoszoba_plusz.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer furdoszoba_fok = Integer.parseInt(furdoszoba.getText()
						.toString());
				furdoszoba_fok++;
				furdoszoba.setText(furdoszoba_fok.toString());

			}
		});

		furdoszoba_minusz.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer furdoszoba_fok = Integer.parseInt(furdoszoba.getText()
						.toString());
				furdoszoba_fok--;
				furdoszoba.setText(furdoszoba_fok.toString());

			}
		});

		// Nappali
		nappali_plusz.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer nappali_fok = Integer.parseInt(nappali.getText()
						.toString());
				nappali_fok++;
				nappali.setText(nappali_fok.toString());

			}
		});

		nappali_minusz.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer nappali_fok = Integer.parseInt(nappali.getText()
						.toString());
				nappali_fok--;
				nappali.setText(nappali_fok.toString());

			}
		});

	}

}
