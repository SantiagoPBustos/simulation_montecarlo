package models;

public enum Genero {
    MASCULINO("Hombre"), FEMENINO("Mujer");

    private String nombre;

    private Genero(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
