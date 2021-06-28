package it.polito.tdp.crimes.model;

import java.time.LocalDate;
import java.util.List;
import java.util.PriorityQueue;

import it.polito.tdp.crimes.model.Agente.AgenteType;

public class Simulatore {
	Model model;
	//coda degli eventi
	private PriorityQueue<Agente> queue;
	
	//modello del mondo
	int numeroAgenti;
	List<Event> eventi;
	int velocità;

	//output
	int nMale;
	
	public void init(int giorno, int mese, int anno, int numeroAgente) {
		queue=new PriorityQueue<Agente>(); 
		eventi=model.eventi(giorno, mese, anno);
		this.numeroAgenti=numeroAgente;
		for(int i=0;i<numeroAgente;i++) {
			queue.add(new Agente(i,eventi.get(0).getReported_date(),AgenteType.LIBERO,model.district(anno+"")));
		}
		velocità=60;
			}
	

	

}
