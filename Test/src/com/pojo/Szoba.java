package com.pojo;


import android.os.Parcel;
import android.os.Parcelable;

public class Szoba implements Parcelable{
	Boolean lampa;
	Integer homerseklet;
	
	public Szoba(Boolean a, Integer h){
		lampa=a;
		homerseklet=h;	
	} 
	
	public Boolean getLampa() {
		return lampa;
	}
	public void setLampa(Boolean lampa) {
		this.lampa = lampa;
	}
	public Integer getHomerseklet() {
		return homerseklet;
	}
	public void setHomerseklet(Integer homerseklet) {
		this.homerseklet = homerseklet;
	}
	
	 public Szoba (Parcel in){
		 boolean[] array = new boolean[1];
		 in.readBooleanArray(array);
		 lampa = array[0];
		 this.homerseklet = in.readInt();
		 
	 }
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) { 
		dest.writeBooleanArray(new boolean[]{lampa});
		dest.writeInt(homerseklet);
		
	}
	
	public static final Parcelable.Creator<Szoba>CREATOR =new Parcelable.Creator<Szoba>() {
		public Szoba createFromParcel (Parcel in) {
			return new Szoba(in);
		}

		@Override
		public Szoba[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Szoba[size];
		}

	};
	
}
