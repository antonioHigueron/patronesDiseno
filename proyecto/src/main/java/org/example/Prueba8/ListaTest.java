package org.example.Prueba8;

import java.util.Scanner;

public class ListaTest {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        String option = "";

        while(option != "6") {
            System.out.println("1.- Agregar un nuevo cliente\n" +
                    "2.- Elimina un cliente\n" +
                    "3.- Busca un cliente\n" +
                    "4.- Mostrar clientes\n" +
                    "5.- Ordenar clientes\n" +
                    "6.- Salir");
            option = input.next();
            switch (option) {
                case "1":
                    add();
                    break;
                case "2":
                    delete();
                    break;
                case "3":
                    find();
                    break;
                case "4":
                    findAll();
                    break;
                case "5":
                    orderAll();
                    break;
                case "6":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
            option = "";
        }


    }

    private static void orderAll() {
        Lista.ordenarClientes();
    }

    private static void findAll() {
       Lista.mostrarClientes();
    }

    private static void find() {
        System.out.println("Introduce un dni");
        String dni = input.next();
        System.out.println( Lista.buscarClientes(dni) );
    }

    private static void delete() {
        System.out.println("Introduce un dni");
        String dni = input.next();
        Lista.eliminarCliente(dni);
    }

    private static void add() {
        System.out.println("Introduce dni");
        String dni = input.next();
        System.out.println("Introduce nombre");
        String nombre = input.next();
        System.out.println("Introduce apellidos");
        String apellido = input.next();

        Cliente cliente = new Cliente(dni,nombre,apellido);
        Lista.añadirCliente(cliente);
    }
}
