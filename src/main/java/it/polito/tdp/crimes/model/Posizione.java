package it.polito.tdp.crimes.model;

import com.javadocmd.simplelatlng.LatLng;

public class Posizione {
	int id;
	double uno;
	double due;
	public LatLng getRif() {
		return rif;
	}
	public void setRif(LatLng rif) {
		this.rif = rif;
	}
	LatLng rif;
	public Posizione(int id, double uno, double due) {
		super();
		this.id = id;
		this.uno = uno;
		this.due = due;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getUno() {
		return uno;
	}
	public void setUno(double uno) {
		this.uno = uno;
	}
	public double getDue() {
		return due;
	}
	public void setDue(double due) {
		this.due = due;
	}

}
