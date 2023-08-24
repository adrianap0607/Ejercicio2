

//Clase Cliente que representa a un cliente del hotel.

public class Cliente {
    private String nombre;
    private int visitas;

    // Constructor de la clase Cliente.
    public Cliente(String nombre, int visitas) {
        this.nombre = nombre;
        this.visitas = visitas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVisitas() {
        return visitas;
    }

    public void incrementarVisitas() {
        visitas++;
    }

    public boolean esFrecuente() {
        return visitas >= 5;
    }

    public boolean esVIP() {
        return visitas >= 10;
    }
}
