package com.conn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream.PutField;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.example.MainActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class Kommunikacio extends AsyncTask<Void, Void, String>{
	
	public Kommunikacio(Context cont){
		kontextus=cont;
	}

	private String url= "https://dl.dropboxusercontent.com/s/l9d8hu8tne0kgp8/otthon.json?dl=1&amp;token_hash=AAGFBzp2NjFhuN3KXTNlvpEUS8kz3faZi2zR2ndtFyyg-g";

	public static final String eredmeny="eredmeny";
	static Context kontextus;
	
	@Override
	protected String doInBackground(Void... params) {
		// TODO Auto-generated method stub
		
		StringBuilder sb = new StringBuilder();
		HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url); 
        HttpResponse valasz;
        try {
            valasz = httpclient.execute(httpget);
            HttpEntity entity = valasz.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                BufferedReader reader=new BufferedReader(new InputStreamReader(instream, "UTF-8"));
                
                for(String line = null; (line = reader.readLine()) != null;)
                {
                	sb.append(line);
                }
                String s = sb.toString();
                return s;
            }
        } catch (Throwable e) {
        	Log.e("asd", e.getMessage());
        }
        return null;
	}
	
	
	//itt szól, ha végzett az asszinkron szál
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		Intent kesz=new Intent(MainActivity.uzenet);
		
	kesz.putExtra(eredmeny, result);
	LocalBroadcastManager.getInstance(kontextus).sendBroadcast(kesz);
	}

}
