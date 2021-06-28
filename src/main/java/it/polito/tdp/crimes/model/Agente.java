package it.polito.tdp.crimes.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.javadocmd.simplelatlng.LatLng;

public class Agente implements Comparable<Agente>{
	
	enum AgenteType{
		LIBERO,
		MOVIMENTO,
		OCCUPATO;
	}
	
	Integer id;
	LocalDateTime date;
	AgenteType tipo;
	LatLng posizione;
	
	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public LocalDateTime getDate() {
		return date;
	}




	public AgenteType getTipo() {
		return tipo;
	}




	public void setTipo(AgenteType tipo) {
		this.tipo = tipo;
	}



		public Agente(Integer id, LocalDateTime localDateTime, AgenteType tipo, LatLng posizione) {
		super();
		this.id = id;
		this.date = localDateTime;
		this.tipo = tipo;
		this.posizione = posizione;
	}




		@Override
	public int compareTo(Agente arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}