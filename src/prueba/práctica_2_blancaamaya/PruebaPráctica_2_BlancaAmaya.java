package prueba.práctica_2_blancaamaya;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class PruebaPráctica_2_BlancaAmaya {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner entrada = new Scanner(System.in);
        boolean resp = true;
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        while (resp) {
            System.out.println("-- Videoteca --");
            System.out.println("1. Agregar nueva pelicula a la videoteca");
            System.out.println("2. Solicitar pelicula");
            System.out.println("3. Regresar pelicula");
            System.out.println("4. Buscar  pelicula");
            System.out.println("5. Listar Peliculas Disponibles");
            System.out.println("6. Listar Películas Prestadas");
            System.out.println("7. Salir del programa");
            System.out.println("Ingrese opcion: ");

            int opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    agregar(peliculas);
                    break;
                case 2:
                    solicitar(peliculas);
                    break;
                case 3:
                    regresar(peliculas);
                    break;
                case 4:
                    buscar(peliculas);
                    break;
                case 5:
                    listarDisponibles(peliculas);
                    break;
                case 6:
                    listarPrestadas(peliculas);
                    break;
                case 7:
                    resp = false;
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }
    }

    public static void agregar(ArrayList<Pelicula> peliculas) {
        Pelicula nuevaPelicula = crear();
        peliculas.add(nuevaPelicula);
        System.out.println("Pelicula agregada");
        System.out.println("----------------------------");
    }

    public static Pelicula crear() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el titulo de la pelicula: ");
        String titulo = entrada.nextLine();
        System.out.println("Ingrese el director: ");
        String director = entrada.nextLine();
        Random ran = new Random();
        int id = ran.nextInt(100) + 10;
        return new Pelicula(titulo, director, id);
    }

    public static void solicitar(ArrayList<Pelicula> peliculas) {
        Scanner entrada2 = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la persona solicitando por la pelicula: ");
        String propietario = entrada2.nextLine();
        System.out.println("Ingrese el titulo de la pelicula que desea: ");
        String titulo = entrada2.nextLine();
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                peliculas.get(i).prestar(propietario);
                return;
            }
        }
        System.out.println("Pelicula no encontrada");
        System.out.println("----------------------------");
        System.out.println("");
    }

    public static void regresar(ArrayList<Pelicula> peliculas) {
        Scanner entrada3 = new Scanner(System.in);
        System.out.println("Ingrese titulo de la pelicula que se regresara: ");
        String titulo = entrada3.nextLine();
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                peliculas.get(i).regresar();
                return;
            }
        }
        System.out.println("Pelicula no encontrada");
        System.out.println("----------------------------");
        System.out.println("");
    }

    public static void buscar(ArrayList<Pelicula> peliculas) {
        Scanner entrada4 = new Scanner(System.in);
        System.out.println("Ingrese el titulo que desea buscar: ");
        String titulo = entrada4.nextLine();
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Pelicula encontrada: " + peliculas.get(i));
                return;
            }
        }
        System.out.println("Pelicula no encontrada");
        System.out.println("----------------------------");
        System.out.println("");
    }

    public static void listarDisponibles(ArrayList<Pelicula> peliculas) {
        boolean disp = false;
        System.out.println("Peliculas Disponibles: ");
        for (int i = 0; i < peliculas.size(); i++) {
            if (!peliculas.get(i).isEstado()) {
                System.out.println(peliculas.get(i));
                disp = true;
            }
        }
        if (!disp) {
            System.out.println("No hay peliculas disponibles");
        }
        System.out.println("----------------------------");
        System.out.println("");
    }

    public static void listarPrestadas(ArrayList<Pelicula> peliculas) {
        boolean prest = false;
        System.out.println("Peliculas Prestadas: ");
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).isEstado()) {
                System.out.println(peliculas.get(i));
                prest = true;
            }
        }
        if (!prest) {
            System.out.println("No se ha prestado peliculas");
        }
        System.out.println("----------------------------");
        System.out.println("");
    }
}
