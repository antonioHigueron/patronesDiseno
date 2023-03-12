package org.example.Prueba8;

import java.util.ArrayList;
import java.util.Collections;

public class Lista {

    private static ArrayList<Cliente> lista = new ArrayList<>();

    public static  boolean añadirCliente(Cliente c){
        lista.add(c);
        return true;
    }

    public static boolean eliminarCliente(String dni){
        Cliente cliente = buscarClientes(dni);
        lista.remove(cliente);
        return true;
    }

    public static void mostrarClientes(){
        if(!lista.isEmpty()) {
            for (Cliente c : lista) {
                System.out.println(c);
            }
        }
    }

    public static Cliente buscarClientes(String dni){
        if(!lista.isEmpty()) {
            for (Cliente c : lista) {
                if (c.getDni().equals(dni)) {
                    return c;
                }
            }
        }
        return null;
    }

    /**
     * Ordena por dni descendente
     */
    public static void ordenarClientes(){
        Collections.sort(lista);
    }

}
