package com.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;

private String name;

@Column(unique = true)
private String email;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getBusser() {
	return busser;
}
public void setBusser(String busser) {
	this.busser = busser;
}
public int getPhone() {
	return phone;
}
public void setPhone(int phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
private int GPSID;
public int getGPSID() {
	return GPSID;
}
public void setGPSID(int gPSID) {
	GPSID = gPSID;
}
private String password;
private String busser;
private int phone;
private String address;
}
