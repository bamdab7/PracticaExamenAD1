package com.dam.PracticaExamenAD1;

public class Libro {
	
	protected String isnb;
	protected String titulo;
	protected String editorial;
	protected int codAutor;
	
	
	public Libro(String isnb, String titulo, String editorial, int codAutor) {
		super();
		this.isnb = isnb;
		this.titulo = titulo;
		this.editorial = editorial;
		this.codAutor = codAutor;
	}
	
	public String getIsnb() {
		return isnb;
	}
	public void setIsnb(String isnb) {
		this.isnb = isnb;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public int getCodAutor() {
		return codAutor;
	}
	public void setCodAutor(int codAutor) {
		this.codAutor = codAutor;
	}
	
	
}
