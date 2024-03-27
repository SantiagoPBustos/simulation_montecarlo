package models;

public class Suerte {

	private String nombre;
	private float suerte;
	
	public Suerte(String nombre, float suerte) {
		this.nombre = nombre;
		this.suerte = suerte;
	}
	
	public float getSuerte() {
		return suerte;
	}
	
	public String getNombre() {
		return nombre;
	}	
}
