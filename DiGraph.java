/*
Autor: Diego Rosales
Implementacion de un Grafo con
Direccion y ponderacion para las aristas
Implementado con ArrayLists
DiGraph.java
*/

import java.util.ArrayList;



public class DiGraph{
	private ArrayList<String> nodos;
	private ArrayList<ArrayList<Integer>> aristas;
	private int[][] D;
	private String[][] S;
	private final int infinito = 1000000;
	
	public DiGraph(){
		nodos = new ArrayList<>(1);
		aristas = new ArrayList<>(1);
	}
	
	
	public void addNode(String node){
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
	
	public void addRelation(String origin, String destination, int ponder){
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
		s+="\n\n\n\n";
		s+="Rutas mas cortas:\n\n";
		for(int i=0; i<nodos.size(); i++){
			for(int j=0; j<nodos.size(); j++){
				s+=D[i][j]+" ";
			}
			s+="\n";
		}
		s+="\n\n\n\n";
		s+="Predecesores:\n\n";
		for(int i=0; i<nodos.size(); i++){
			for(int j=0; j<nodos.size(); j++){
				s+=S[i][j]+" ";
			}
			s+="\n";
		}
		return s;
	}
	
	public boolean contains(String nodo){
		return nodos.contains(nodo);
	}
	
	public void removeRelation(String origin, String destination){
		int org = nodos.indexOf(origin);
		int des = nodos.indexOf(destination);
		ArrayList<Integer> useful = aristas.get(org);
		useful.set(des, infinito);
		this.FloydWarshall();
	}
	
	public void FloydWarshall(){
		ArrayList<Integer> useful;
		D = new int[nodos.size()][nodos.size()];
		for(int i=0; i<nodos.size(); i++){
			useful=aristas.get(i);
			for(int j=0; j<nodos.size(); j++){
				D[i][j]=useful.get(j);
			}
		}
		S=new String[nodos.size()][nodos.size()];
		for(int k=0; k<nodos.size(); k++){
			for(int i=0; i<nodos.size(); i++){
				for(int j=0; j<nodos.size(); j++){
					if(D[i][j]>(D[i][k]+D[k][j])){
						D[i][j]=(D[i][k]+D[k][j]);
						S[i][j]=nodos.get(k);
					}
				}
			}
		}
	}
	
	public String centro(){
		this.FloydWarshall();
		int min=0;
		int max=0;
		int nod=0;
		for(int i=0; i<nodos.size(); i++){
			for(int j=0; j<hodos.size(); j++0){
				if(D[i][j]>max){
					max=D[i][j];
				}
			}
			if(max<min){
				min=max;
				nod=i;
			}
		}
		return nodos.get(i);
	}
	
}