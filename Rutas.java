/*
Autor: Diego Rosales
Utiliza un Grafo direccional e implementa
algoritmos para encontrar la ruta mas corta
entre cualesquiera dos nodos
*/

import java.io.*;
import java.util.Scanner;

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
			
			Scanner user_input = new Scanner( System.in );
			int option;
			String input;
			String[] deco;
			
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("1. Mostrar la ruta mas corta entre dos ciudades");
			System.out.println("2. Mostrar la Ciudad que es el centro del grafo");
			System.out.println("3. Modificar las conexiones entre ciudades");
			System.out.println("4. Finalizar Programa");
			
			option = Integer.parseInt(user_input.nextLine());
			
			do{
				switch(option){
					case 1:
						System.out.print("Escriba el nombre de la ciudad de origen y luego el destino separadas por un espacio");
						input=user_input.nextLine();
						deco=input.split(" ");
						System.out.println("");
						System.out.println(grafo.getPath(deco[0],deco[1]));
						break;
					case 2:
						System.out.println("");
						System.out.println(grafo.centro());
						break;
					case 3:
						System.out.println("");
						System.out.println("Introduzca la opci[on que desea ejecutar");
						System.out.println("1. Una Interrupcion de trafico entre dos ciudades");
						System.out.println("2. Establecer una conexion entre dos ciudades");
						option = Integer.parseInt(user_input.nextLine());
						switch(option){
							case 1:
								System.out.println("Escriba el nombre de la ciudad de origen y luego el destino separadas por un espacio");
								input=user_input.nextLine();
								deco=input.split(" ");
								grafo.removeRelation(deco[0],deco[1]);
								System.out.println(grafo);
								break;
							case 2:
								System.out.println("Escriba el nombre de la ciudad de origen y luego el destino separadas por un espacio y la distancia entre ambas en Km tambien separada por un espacio");
								input=user_input.nextLine();
								deco=input.split(" ");
								grafo.addRelation(deco[0],deco[1],Integer.parseInt(deco[2]));
								System.out.println(grafo);
								break;
							default:
								break;
						}
						break;
					default:
						break;
				}
				if(option!=4){
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("1. Mostrar la ruta mas corta entre dos ciudades");
					System.out.println("2. Mostrar la Ciudad que es el centro del grafo");
					System.out.println("3. Modificar las conexiones entre ciudades");
					System.out.println("4. Finalizar Programa");
					
					option = Integer.parseInt(user_input.nextLine());
				}
			}while(option!=4);
			
			
		}
		else
		{
			System.out.println("No encuentro los archivos :'( ");
		}

		
		
		
	}
}