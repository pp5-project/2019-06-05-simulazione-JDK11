package it.polito.tdp.crimes.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

import it.polito.tdp.crimes.db.EventsDao;

public class Model {
	EventsDao dao;
	private SimpleWeightedGraph<Integer, DefaultWeightedEdge> grafo;
	
	
	public Model() {
	dao= new EventsDao();	
	}
	
	
	public List<Integer> ListAnni() {
		return dao.listaDate();
	}
	
	public void CreaGrafo() {
		this.grafo=new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		//aggiungo vertici
		Graphs.addAllVertices(grafo,dao.getVertici());
		//aggiungo archi
		for(Posizione p:dao.getPosizione()) {
			p.rif=new LatLng(p.uno,p.due);
			for(Posizione i:dao.getPosizione()) {
				if(i.id!=p.id) {
					i.rif=new LatLng(i.uno,i.due);
			Graphs.addEdgeWithVertices(grafo,p.id,i.id,LatLngTool.distance(p.rif,i.rif, LengthUnit.KILOMETER));
		}
		}
		}
		
}
	
	public String vicini() {
		String s="";
		for(Integer v:dao.getVertici()) {
			s+="VICINI VERTICE ID"+v+"\n";
			List<Integer> vicini=Graphs.neighborListOf(grafo, v);
			List<Arco> fine=new LinkedList<Arco>();
			for(Integer c:vicini) {
				fine.add(new Arco(v,c,grafo.getEdgeWeight(grafo.getEdge(c, v))));
			}
			s+=fine;
		}
		
		return s;
	}
	
	public int nvertci() {
		// TODO Auto-generated method stub
		return grafo.vertexSet().size();
	}
	
	public int nArchi() {
		// TODO Auto-generated method stub
		return grafo.edgeSet().size();
	}
	
	public List<Integer> mese(String anno){
		return dao.listaMesi(anno);
	}
	
	public List<Integer> giorni(String anno){
		return dao.listaGiorni(anno);
	}
	
	public int getDistretto(String anno) {
		return dao.Distretto(anno).get(0);
	}
	public List<Event> eventi(int giorno, int mese, int anno){
		return dao.listAllEvents(giorno, mese, anno);
	}
	public LatLng district(String anno) {
		LatLng prova=null;
		int uno=this.getDistretto(anno);
		for(Posizione p:dao.getPosizione()) {
			if(p.id==uno)
				prova=p.rif;
		}
		return prova;
	}
	
}
