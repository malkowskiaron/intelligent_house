package com.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class MainActivity extends Activity {

	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
	    NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

		    if (wifi.isConnected()) {
		    
		    	}
		    else{
		    	AlertDialog.Builder alert= new AlertDialog.Builder(this);
		    	alert.setTitle("Kapcsolódási hiba");
		    	alert.setMessage("Kérem Ellenõrizze, az internet hozzáférést");
		    	alert.setNegativeButton("Kilép",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						MainActivity.this.finish();
					}
				  });
		    	alert.setNeutralButton("Újra",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						dialog.cancel();
					}
				});
		    	AlertDialog alertDialog = alert.create();
		    	 
				alertDialog.show();
		    }

		
		
		setupMessageButton();
	}
		
		private void setupMessageButton(){
			Button b = (Button)findViewById(R.id.szoba);
			b.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
					startActivity(new Intent(MainActivity.this, Szoba.class));
					
				};
			});
			Button b1 = (Button)findViewById(R.id.Tulajdonsagok);
			b1.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
					startActivity(new Intent(MainActivity.this, Tulajdonsagok.class));
					
				};
			});
		}
	

//	@Override
/*	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}*/

}
