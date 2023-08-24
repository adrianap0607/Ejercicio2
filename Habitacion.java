
//Universidad del Valle de Guatemala	                                                                                            
//Adriana Palacios 
//CC2008 - Introducción a la Programación Orientada a Objetos 
//carné 23044
//Semestre II, 2023

//Clase Habitacion que representa una habitación en el hotel.
public class Habitacion {
    private int numero;
    private String tipo;
    private int capacidadMaxima;
    private double precioPorNoche;
    private Cliente clienteAsignado;
    
// Constructor de la clase Habitacion.
    public Habitacion(int numero, String tipo, int capacidadMaxima, double precioPorNoche) {
        this.numero = numero;
        this.tipo = tipo;
        this.capacidadMaxima = capacidadMaxima;
        this.precioPorNoche = precioPorNoche;
        this.clienteAsignado = null;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public boolean estaDisponible() {
        return clienteAsignado == null;
    }

    public boolean asignarCliente(Cliente cliente) {
        if (cliente == null || !estaDisponible()) {
            return false;
        }

        if (tipo.equals("Estándar") || (tipo.equals("Deluxe") && cliente.esFrecuente()) || (tipo.equals("Suite") && cliente.esVIP())) {
            clienteAsignado = cliente;
            return true;
        }

        return false;
    }

    public void liberarHabitacion() {
        clienteAsignado = null;
    }

    public Cliente getClienteAsignado() {
        return clienteAsignado;
    }
}
