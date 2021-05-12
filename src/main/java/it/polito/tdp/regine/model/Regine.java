package it.polito.tdp.regine.model;

import java.util.ArrayList;
import java.util.List;

public class Regine {

	private List<Integer> scacchiera;
	private int n;
	
	
	public Regine() {
		//this.scacchiera List<Integer> scacchiera;
	}
	
	public List<Integer> soluzione(int n){
		this.n = n;
		List<Integer> parziale = new ArrayList <> ();
		cerca(parziale, 0);
		return this.scacchiera;
	}
	
	private void cerca(List<Integer>parziale, int livello) {
		if(parziale.size()==n) {
			this.scacchiera = new ArrayList<>(parziale);
			return ;
		}
		for(Integer i = 0; i<this.n; i++) {
			if(this.isValid(livello, parziale, i)) {
				parziale.add(livello, i);
				this.cerca(parziale, livello+1);
				parziale.remove(livello);
			}
		}
	}

	private boolean isValid(int livello, List<Integer> parziale, Integer i) {
		if(parziale.size()==0)
			return true;
		if(parziale.contains(i)) {
			return false;
		}
		//int 
		int dmg = (parziale.size())-i;
		//System.out.println("Livello =="+livello+" Somma mg== "+dmg);
		int dmi =(parziale.size())+i;
		for(int j  = 0; j<parziale.size(); j++) {
			if(dmg==(j-parziale.get(j))) {
				//System.out.println("somma== "+(j-parziale.get(j)));
				return false;
			}
			if(dmi==(j+parziale.get(j))) {
				return false;
			}
		}
		return true;
		
	}
	
	
}
