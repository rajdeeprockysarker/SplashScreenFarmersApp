package com.example.splashscreenfarmersapp.model;

import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("password")
	private String password;

	@SerializedName("full_name")
	private String fullName;

	@SerializedName("mobile_no")
	private String mobileNo;

	@SerializedName("lon")
	private String lon;

	@SerializedName("Id")
	private String id;

	@SerializedName("lat")
	private String lat;

	@SerializedName("errormessage")
	private String errormessage="Success";

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setFullName(String fullName){
		this.fullName = fullName;
	}

	public String getFullName(){
		return fullName;
	}

	public void setMobileNo(String mobileNo){
		this.mobileNo = mobileNo;
	}

	public String getMobileNo(){
		return mobileNo;
	}

	public void setLon(String lon){
		this.lon = lon;
	}

	public String getLon(){
		return lon;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setLat(String lat){
		this.lat = lat;
	}

	public String getLat(){
		return lat;
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	@Override
 	public String toString(){
		return 
			"User{" + 
			"password = '" + password + '\'' + 
			",full_name = '" + fullName + '\'' + 
			",mobile_no = '" + mobileNo + '\'' + 
			",lon = '" + lon + '\'' + 
			",id = '" + id + '\'' + 
			",lat = '" + lat + '\'' +
					",errormessage = '" + errormessage + '\'' +
					"}";
		}
}