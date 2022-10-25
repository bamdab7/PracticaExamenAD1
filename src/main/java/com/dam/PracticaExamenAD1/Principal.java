package com.dam.PracticaExamenAD1;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Principal {
	//	QUEREMOS ALMACENAR LOS VALORES DE ALUMNOS Y LIBROS
	private static ArrayList<Autor> listaAutor = new ArrayList<Autor>();
	private static ArrayList<Libro> listaLibro = new ArrayList<Libro>();
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, NumberFormatException, DOMException, SQLException  {
		//	LEER LOS REGISTROS DEL FICHERO BIBLIOTECA.XML UBICADO EN LA CARPETA DE AD
		FileInputStream fis = new FileInputStream("C:\\PRUEBAS\\AD\\biblioteca.xml");
		
		//	LECTURA DEL FICHERO XML
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = factory.newDocumentBuilder();
		Document documentoXML = db.parse(fis);
		
		//	OBTENDREMOS OS VALORES DEL XML, DE CADA AUTOR
		NodeList codigoAutor= documentoXML.getElementsByTagName("Codigo");
		NodeList  nombreAutor = documentoXML.getElementsByTagName("Nombre");
		NodeList paisAutor = documentoXML.getElementsByTagName("Pais");
		
		//	GUARDAREMOS EN UNA LISTA LOS VALORES DE LOS AUTORES
		for( int i = 0 ; i < codigoAutor.getLength(); i++) {
			listaAutor.add(new Autor(Integer.parseInt(codigoAutor.item(i).getTextContent()), nombreAutor.item(i).getTextContent(), paisAutor.item(i).getTextContent()));
		}
		
		//	OBTENDREMOS LOS VALORES DEL XML, DE LIBRO
		NodeList isnbLibro = documentoXML.getElementsByTagName("ISBN");
		NodeList tituloLibro = documentoXML.getElementsByTagName("Titulo");
		NodeList editorialLibro = documentoXML.getElementsByTagName("Editorial");
		NodeList codAutor = documentoXML.getElementsByTagName("CodAutor");
		
		//	GUARDAREMOS EN UNA LISTA LOS VALORES DE LOS LIBROS
		for(int i = 0; i < tituloLibro.getLength(); i++){
			listaLibro.add(new Libro(isnbLibro.item(i).getTextContent(), tituloLibro.item(i).getTextContent(),editorialLibro.item(i).getTextContent(), Integer.parseInt(codAutor.item(i).getTextContent())));
		}
		/*for(Libro listaLibro: listaLibro) {
			System.out.println(listaLibro.getIsnb());
		}*/

		
		//INSERTAREMOS ESOS VALORES EN NUESTRA TABLA, LLAMAREMOS A OTRO
		// 	InsertsBBDD.generarBBDD(listaAutor, listaLibro);
		//GENERAREMOS UN CSV, CADA CAMPO SEPARADO CON UNA , CON LOS DATOS DEL XML
			GenerarCSV.generarCSV(listaAutor, listaLibro);
			
	} 

}
