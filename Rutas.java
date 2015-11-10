/*
Autor: Diego Rosales
Utiliza un Grafo direccional e implementa
algoritmos para encontrar la ruta mas corta
entre cualesquiera dos nodos
*/

public class Rutas{
	
	
	public static void main(String args[]){
		DiGraph<String> grafo=new DiGraph<>();
		grafo.addNode("Erick");
		grafo.addNode("Kervin");
		grafo.addNode("Sofi");
		System.out.println(grafo);
		
		grafo.addRelation("Erick","Kervin",7);
		grafo.addRelation("Sofi","Erick",5);
		System.out.println(grafo);
	}
}