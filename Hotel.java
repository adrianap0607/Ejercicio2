import java.util.ArrayList;
import java.util.List;


//Clase Hotel que gestiona las reservas de habitaciones.
public class Hotel {
    private Habitacion[] habitaciones;
    private Cliente[] listaEspera;

    public Hotel(Habitacion[] habitaciones) {
        this.habitaciones = habitaciones;
        this.listaEspera = new Cliente[10]; // Tamaño máximo de la lista de espera
    }

    public Habitacion[] getHabitacionesDisponibles() {
        List<Habitacion> disponibles = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.estaDisponible()) {
                disponibles.add(habitacion);
            }
        }
        return disponibles.toArray(new Habitacion[0]);
    }

    public boolean asignarHabitacion(Cliente cliente) {
        Habitacion[] disponibles = getHabitacionesDisponibles();
        for (Habitacion habitacion : disponibles) {
            if (habitacion.asignarCliente(cliente)) {
                return true;
            }
        }
        return false; // No se pudo asignar
    }

    public void agregarClienteListaEspera(Cliente cliente) {
        for (int i = 0; i < listaEspera.length; i++) {
            if (listaEspera[i] == null) {
                listaEspera[i] = cliente;
                break;
            }
        }
    }

    public Habitacion getHabitacionAsignada(Cliente cliente) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getClienteAsignado() == cliente) {
                return habitacion;
            }
        }
        return null;
    }
}
