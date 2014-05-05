package com.pojo;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class Szobalista implements Parcelable{
	List<Szoba> szoba = new ArrayList<Szoba>();

	
	
	public Szobalista(ArrayList szob){
		szoba = szob;
	}
	
	public List<Szoba> getSzoba() {
		return szoba;
	}

	public void setSzoba(List<Szoba> szoba) {
		this.szoba = szoba;
	}

	
	 public Szobalista (Parcel in){
		 szoba = in.readArrayList(Szoba.class.getClassLoader());
	 	 }
	
	
	
	 public void writeToParcel(Parcel out, int flags) {
		 out.writeList(szoba);
	 }

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static final Parcelable.Creator<Szobalista> CREATOR =new Parcelable.Creator<Szobalista>() {
		public Szobalista createFromParcel (Parcel in) {
			return new Szobalista(in);
		}

		@Override
		public Szobalista[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Szobalista[size];
		}

	};
	
	
}
