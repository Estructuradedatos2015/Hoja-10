/*
Autor: Diego Rosales
Utiliza un Grafo direccional e implementa
algoritmos para encontrar la ruta mas corta
entre cualesquiera dos nodos
*/

import java.io.*;

public class Rutas{
	
	
	public static void main(String args[]){
		DiGraph grafo=new DiGraph();
		
			
		// Declaración e inicialización de variables.
		// el primer parametro indica el nombre del archivo con las definiciones de las palabras
		File wordFile = new File(args[0]);
		
		

		BufferedReader wordreader;
		String[] wordparts;
		// Verificar que los dos parámetros que se pasaron sean archivos que existen
		if(wordFile.isFile()) {
			// Leer archivos
			try
			{
				wordreader = new BufferedReader(new FileReader(wordFile));
			}
			catch (Exception ex)
			{
				System.out.println("Error al leer!");
				return;
			}


			
			String line = null;
			String[] wordParts;
			
			// leer el archivo que contiene las palabras y cargarlo al WordSet.
			try{
				line = wordreader.readLine();
			}
			catch(Exception ex){
				System.out.println("Error al leer linea sin ciclo!");
			}
			while(line!=null){
				wordparts = line.split(" ");
				if(!grafo.contains(wordparts[0])){
					grafo.addNode(wordparts[0]);
				}
				if(!grafo.contains(wordparts[1])){
					grafo.addNode(wordparts[1]);
				}
				grafo.addRelation(wordparts[0],wordparts[1],Integer.parseInt(wordparts[2]));
				
				try{
					line = wordreader.readLine();
				}
				catch(Exception ex){
					System.out.println("Error al leer linea en ciclo!");
				}
			}
			
			try{
				wordreader.close();
			}
			catch(Exception ex){
				System.out.println("Error al cerrar el archivo!");
			}
			grafo.FloydWarshall();
			
			System.out.println(grafo);
			
		}
		else
		{
			System.out.println("No encuentro los archivos :'( ");
		}

		
		
		
	}
}