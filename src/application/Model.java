package application;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import bean.Parola;
import db.Dao;

public class Model {
	
	private Dao dao= new Dao();

	//NUMERI:
	
	
	public int getInizianoCosi(String caratteri){
		int numI= dao.getNumeroIniziano(caratteri);
		return numI;
	}
	
	public int getFinisconoCosi(String caratteri){
		int numF= dao.getNumeroFiniscono(caratteri);
		return numF;
	}
	
	
	public int getMezzoCosi(String caratteri){
		int numM= dao.getNumeroMezzo(caratteri);
		return numM;
	}
	
	public int somma(String caratteri){
		int totParole = getMezzoCosi(caratteri)+ getInizianoCosi(caratteri)+ getFinisconoCosi(caratteri);
		return totParole;
	}
	
	
	//LISTE:
	
	public List<Parola> getListaIniziano(String caratteri){
		List<Parola> listaIniziano= dao.getIniziano(caratteri);
		return listaIniziano;
	}
	
	public List<Parola> getListaFiniscono(String caratteri){
		List<Parola> listaFiniscono = dao.getFiniscono(caratteri);
		return listaFiniscono;
	}
	
	public List<Parola> getListaMezzo(String caratteri){
		List<Parola> listaMezzo= dao.getMezzo(caratteri);
		return listaMezzo;
	}
	
	
	
	
	
	//FRequenza
	
	
	
	public List<Parola> getListaPiena(String caratteri){
		List<Parola> all = new LinkedList<>();
		all.addAll(getListaIniziano(caratteri));
		all.addAll(getListaFiniscono(caratteri));
		all.addAll(getListaMezzo(caratteri));
		return all;

	}
	
	public int numerotutteLettere(String caratteri){       //credo sia giusto 
		List<Parola> all = getListaPiena(caratteri);
		int totLettere=0;
		for(Parola p : all){
			String nome = p.getNome();
			totLettere += nome.length();
		}
		//System.out.println(totLettere);
		return totLettere;                                   //numero tot di lettere in tutte le parole di tutta la lista
	}
	
	public int getNumeroOccorrenzeLettera(String caratteri, char lettera){   //quante volte quella lettera è presente nelle parole di tutta la lista
		List<Parola> lista = getListaPiena(caratteri);
		int totPresenzaLettera = 0;
		for(Parola p : lista){
			String nome = p.getNome();
			for(int i =0; i<nome.length(); i++){
				if(nome.charAt(i)==lettera){
					totPresenzaLettera++;
				}
			}
		}
		System.out.println(totPresenzaLettera);
		return totPresenzaLettera;
	}
	
	
	public Map<Character, Integer> calcoloPerTutteLeLettere(String caratteri){
		Map<Character, Integer> mappa = new HashMap<>();   //Character, integer sono oggetti, la mappa vuole oggetti, so non posso scrivere int o char
		int numeroOccorrenzaLettera = 0;
		char lettera ='a';
		for(int i = 0; i<26 ;i++){                              //26 xke sono le lettere di alfa
			char lettera_attuale  = (char) (lettera + i);      //codice ascii //a = 97 // ( a+0)
		    numeroOccorrenzaLettera = getNumeroOccorrenzeLettera(caratteri, lettera_attuale);
		   // double frequenza = (numeroOccorrenzaLettera/numerotutteLettere(caratteri)*100);
			mappa.put(lettera_attuale, numeroOccorrenzaLettera);
		    }
		return mappa;
   }
	
	public static void main (String [] args){
		Model m = new Model();
		m.getNumeroOccorrenzeLettera("ch", 'a');
	}
}
