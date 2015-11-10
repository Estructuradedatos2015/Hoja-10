/*
Autor: Diego Rosales
Implementacion de un Grafo con
Direccion y ponderacion para las aristas
Implementado con ArrayLists
DiGraph.java
*/

import java.util.ArrayList;



public class DiGraph<T>{
	private ArrayList<T> nodos;
	private ArrayList<ArrayList<Integer>> aristas;
	private final int infinito = 1000000;
	
	public DiGraph(){
		nodos = new ArrayList<>(1);
		aristas = new ArrayList<>(1);
	}
	
	
	public void addNode(T node){
		nodos.add(node);
		aristas.add(new ArrayList<Integer>());
		for(int i=0; i<nodos.size(); i++){
			aristas.get(nodos.size()-1).add(infinito);
		}
		for(int i=0; i<nodos.size()-1; i++){
			aristas.get(i).add(infinito);
		}
		ArrayList<Integer> useful = aristas.get(aristas.size()-1);
		useful.set(useful.size()-1,0);
	}
	
	public void addRelation(T origin, T destination, int ponder){
		int org = nodos.indexOf(origin);
		int des = nodos.indexOf(destination);
		ArrayList<Integer> useful = aristas.get(org);
		useful.set(des, ponder);
	}
	
	public String toString(){
		String s = "";
		s+= "Nodos: \n";
		for(int i=0; i<nodos.size(); i++){
			s+=i;
			s+=". "+nodos.get(i);
			s+="\n";
		}
		s+="\n";
		s+="\n";
		s+="Adyacencias:\n";
		for(int i=0; i<aristas.size(); i++){
			for(int h=0; h<aristas.get(i).size(); h++){
				int num = aristas.get(i).get(h);
				if(num<1000){
					s+=num+" ";
				}
				else{
					s+="i ";
				}
			}
			s+="\n";
		}
		return s;
	}
	
	public boolean contains(T nodo){
		return nodos.contains(nodo);
	}
	
	
}