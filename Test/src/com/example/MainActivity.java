package com.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;

import com.conn.Kommunikacio;
import com.google.gson.Gson;
import com.pojo.Szobalista;


//0:nappali
//1:Fürdõ
//2:Konyha
//3:Elõszoba
//4:gyerek
//5:Haloszoba



public class MainActivity extends Activity {

	private Szobalista szobak= null;
	public static final String atadas = "atadas";
	
	//szobavalaszto, 
	public static final String uzenet ="uzenet";
	
	private Button b1;
	private Button b;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		b1 = (Button)findViewById(R.id.Tulajdonsagok);
		b = (Button)findViewById(R.id.szoba);
		
		
	    ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
	    NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		    if (wifi.isConnected()) {

		    	//itt indítja el az asszinkron szálat
		    	Kommunikacio komm=new Kommunikacio(this);
				komm.execute();
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
		    	alert.setNeutralButton("WiFi megnyitás",new DialogInterface.OnClickListener() {
		    		
					public void onClick(DialogInterface dialog,int id) {
						startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
						}
		    		
				});
		    	AlertDialog alertDialog = alert.create();
		    	 
				alertDialog.show();
		    }

		
		
		setupMessageButton();
	}
		
		private void setupMessageButton(){

			
			b.setEnabled(false);
			
			b.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
					startActivity(new Intent(MainActivity.this, SzobaValaszto.class).putExtra(atadas, szobak));
					
					
					
				};
			});
			
			b1.setEnabled(false);
			b1.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
  					startActivity(new Intent(MainActivity.this, Tulajdonsagok.class).putExtra(atadas, szobak));
				};
			});
		}
	
	//ezzel jelez az asszinkron h vár, hogy végzett
	private BroadcastReceiver iratkozas =new BroadcastReceiver(){
		public void onReceive(android.content.Context context, Intent intent) {
			szobak =new Gson().fromJson(intent.getStringExtra(Kommunikacio.eredmeny), Szobalista.class);
			if(szobak==null || szobak.getSzoba()==null ||szobak.getSzoba().isEmpty()){
				}
			else{
				b1.setEnabled(true);			
				b.setEnabled(true);
			}
		};
	};

	
	//ezzel iratkozik fel
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		LocalBroadcastManager.getInstance(this).registerReceiver(iratkozas, new IntentFilter(uzenet));
	}
	
	//ezzel pedig leiratkozik
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		LocalBroadcastManager.getInstance(this).unregisterReceiver(iratkozas);
	}
	

	

//	@Override
/*	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}*/

}
