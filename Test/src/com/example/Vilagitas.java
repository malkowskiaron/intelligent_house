package com.example;

import com.pojo.Szobalista;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Switch;

public class Vilagitas extends Activity {

	private Szobalista lista ;
	private Boolean eloszoba_l, furdoszoba_l, gyerekszoba_l,konyha_l, nappali_l, haloszoba_l;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		lista =getIntent().getParcelableExtra(Tulajdonsagok.tulajdonsag);
		nappali_l=lista.getSzoba().get(0).getLampa();
		furdoszoba_l=lista.getSzoba().get(1).getLampa();
		konyha_l=lista.getSzoba().get(2).getLampa();
		eloszoba_l=lista.getSzoba().get(3).getLampa();
		gyerekszoba_l=lista.getSzoba().get(4).getLampa();
		haloszoba_l=lista.getSzoba().get(5).getLampa();
		


		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vilagitas);
		
		
		Switch furdoszoba=(Switch) findViewById(R.id.furdoszoba);
		furdoszoba.setChecked(furdoszoba_l);

		
		Switch nappali=(Switch) findViewById(R.id.nappali);
		nappali.setChecked(nappali_l);

	
		Switch konyha= (Switch) findViewById(R.id.konyha);
		konyha.setChecked(konyha_l);
			
		Switch eloszoba=(Switch) findViewById(R.id.eloszoba);
		eloszoba.setChecked(eloszoba_l);

		Switch gyerekszoba=(Switch) findViewById(R.id.gyerekszoba);
		gyerekszoba.setChecked(gyerekszoba_l);

		Switch haloszoba=(Switch) findViewById(R.id.haloszoba);
		haloszoba.setChecked(haloszoba_l);
	}
}
