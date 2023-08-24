import java.util.Scanner;
//Clase Main que contiene el punto de entrada del programa
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Habitacion habitacion1 = new Habitacion(101, "Estándar", 2, 100.0);
        Habitacion habitacion2 = new Habitacion(102, "Deluxe", 4, 200.0);
        Habitacion habitacion3 = new Habitacion(103, "Suite", 6, 300.0);

        Habitacion[] habitaciones = {habitacion1, habitacion2, habitacion3};
        Hotel hotel = new Hotel(habitaciones);

        System.out.println("¡Bienvenido al sistema de reservas de habitaciones!");

        Cliente cliente = null;

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Registrar huésped");
            System.out.println("2. Asignar cliente a habitación");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            if (opcion == 1) {
                System.out.print("Ingrese el nombre del cliente: ");
                String nombreCliente = scanner.nextLine();
                System.out.print("Ingrese la cantidad de visitas del cliente: ");
                int visitas = scanner.nextInt();
                scanner.nextLine(); 

                cliente = new Cliente(nombreCliente, visitas);
                System.out.println("¡Cliente registrado exitosamente!");
            } else if (opcion == 2) {
                if (cliente != null) {
                    if (hotel.asignarHabitacion(cliente)) {
                        Habitacion habitacionAsignada = hotel.getHabitacionAsignada(cliente);
                        System.out.println("Habitación asignada a cliente: " + cliente.getNombre());
                        System.out.println("Tipo de habitación: " + habitacionAsignada.getTipo());
                        System.out.println("Habitación asignada a cliente: " + cliente.getNombre());
                        System.out.println("Tipo de habitación: " + habitacionAsignada.getTipo());
                    } else {
                        hotel.agregarClienteListaEspera(cliente);
                        System.out.println("No se pudo asignar habitación. Cliente agregado a lista de espera.");
                    }
                } else {
                    System.out.println("Primero debe registrar al cliente.");
                }
                // Salir del programa
            } else if (opcion == 3) {
                System.out.println("¡Gracias por usar el sistema de reservas!");
                break;
            } else {
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }

        scanner.close();
    }
}

