package com.dam.PracticaExamenAD1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class GenerarCSV {
		//SE GENERA UN FICHERO CSV EN UNA RUTA ESPECIFICA CON LOS DATOS DEL XML
	public static void generarCSV(ArrayList<Autor> listaAutor, ArrayList<Libro> listaLibro) throws IOException{
		Path archivoCSV = Paths.get("C:\\PRUEBAS\\AD\\NPC.csv");
		BufferedWriter bw = Files.newBufferedWriter(archivoCSV);
		
		//ITERAMOS UNA LISTA CON AMBOS VALORES Y LOS ESCRIBIMOS EN EL ARCHIVO
		for(int i = 0; i < listaAutor.size(); i++) {
			bw.write(listaAutor.get(i).getCodigo() + "," + listaAutor.get(i).getNombre() + "," + listaAutor.get(i).getPais()+ "\r" ) ;	
		}
		for( int i = 0; i < listaLibro.size(); i++) {
			bw.write(listaLibro.get(i).getIsnb() + "," + listaLibro.get(i).getTitulo() + "," + listaLibro.get(i).getEditorial()+ "," + listaLibro.get(i).getCodAutor() + "\r");
		}
		bw.flush();
		
}
	}
	
