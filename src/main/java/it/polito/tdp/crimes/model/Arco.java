package it.polito.tdp.crimes.model;

public class Arco implements Comparable<Arco> {
	int uno;
	int due;
	Double peso;
	@Override
	public int compareTo(Arco arg0) {
		// TODO Auto-generated method stub
		return this.peso.compareTo(arg0.peso);
	}
	public Arco(int uno, int due, Double peso) {
		super();
		this.uno = uno;
		this.due = due;
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "Arco [due=" + due + ", peso=" + peso + "]"+"\n";
	}

}
