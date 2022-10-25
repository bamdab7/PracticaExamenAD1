package com.dam.PracticaExamenAD1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class InsertsBBDD {
	
	public static void generarBBDD(ArrayList<Autor> listaAutor, ArrayList<Libro> listaLibro) throws SQLException {
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/eval1?serverTimezone=Europe/Madrid","root","");
		
		//	BUCLE EN EL QUE RECOJO TODOS LOS VALORES DEL ARRAY DONDE METI EL XML Y LOS METO EN LA CONSULTA
		for(int i = 0; i< listaAutor.size(); i ++) {
			PreparedStatement ps= conexion.prepareStatement("INSERT INTO autor (codigo,nombre,pais) VALUES (?,?,?)");
			ps.setInt(1,listaAutor.get(i).getCodigo());
			ps.setString(2, listaAutor.get(i).getNombre());
			ps.setString(3, listaAutor.get(i).getPais());
			ps.executeUpdate();
		}
		//	BUCLE EN EL QUE RECOJO TODOS LOS VALORES DEL ARRAY DONDE METI EL XML Y LOS METO EN LA CONSULTA
		for( int i = 0; i < listaLibro.size(); i ++) {
			PreparedStatement ps = conexion.prepareStatement("INSERT INTO libro (isnb,titulo,editorial,codAutor) VALUES (?,?,?,?)");
			ps.setString(1, listaLibro.get(i).getIsnb());
			ps.setString(2, listaLibro.get(i).getTitulo());
			ps.setString(3, listaLibro.get(i).getEditorial());
			ps.setInt(4, listaLibro.get(i).getCodAutor());
			ps.executeUpdate();
		}
	}

}
