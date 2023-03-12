package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 6) Dados dos archivos con números enteros ordenados,
 crea otro archivo mezclando los datos de los archivos anteriores.
 Además, ordena los datos en el nuevo archivo.

 Fichero “clientes1.txt”:
 1 jesus melero 100
 3 pepe garcia 200
 5 antonio perez 300

 Fichero “clientes2.txt”:
 2 daniel martinez 400
 4 pedro sanchez 500
 6 daniela vazquez 600

 Fichero resultante “clientes3.txt”:

 1	Jesus	Melero	100
 2	Daniel	Martínez	400
 3	Pepe	García	200
 4	Pedro	Sánchez	500
 5	Antonio 	Pérez	300
 6	Daniela	Vázquez	600

 */
public class Pruebas {
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(new File("D:\\proyectos\\piedad\\Ejercicios\\programacion12032023\\src\\main\\java\\ejercicio6\\clientes1_copy.txt"));
        Scanner input = new Scanner(new File("D:\\proyectos\\piedad\\Ejercicios\\programacion12032023\\src\\main\\java\\ejercicio6\\clientes1.txt"));
        //input.useDelimiter("-|\n");

        //Scanner input2 = new Scanner(new File("D:\\proyectos\\piedad\\Ejercicios\\programacion12032023\\src\\main\\java\\ejercicio6\\clientes2_copy.txt"));
        Scanner input2 = new Scanner(new File("D:\\proyectos\\piedad\\Ejercicios\\programacion12032023\\src\\main\\java\\ejercicio6\\clientes2.txt"));
        //input2.useDelimiter("-|\n");


        ArrayList<Cliente> myList = new ArrayList<>();
        addClientFromFiles(input, myList);
        addClientFromFiles(input2, myList);

        for (Cliente cliente : myList) {
            System.out.println(cliente);
        }

        FileWriter writer=null;
        try {
            //writer = new FileWriter(new File("D:\\proyectos\\piedad\\Ejercicios\\programacion12032023\\src\\main\\java\\ejercicio6\\final.txt"));
            writer = new FileWriter(new File("al.txt"));
            for (Cliente cliente : myList) {
                writer.write(cliente.getCliente());
                writer.write("\n");
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            writer.close();
        }
    }

    private static void addClientFromFiles(Scanner input, ArrayList<Cliente> clientes) {
        ArrayList<Cliente> list = null;
        while(input.hasNext()) {
            String[] valores = input.nextLine().split(" ");
            int id = Integer.parseInt(valores[0]);
            String nombre = valores[1];
            String apellido = valores[2];
            int numero = Integer.parseInt(valores[3]);


            Cliente nuevoCliente = new Cliente(id, nombre, apellido, numero);
            addClient(clientes, nuevoCliente);
        }

    }

    private static void addClient(ArrayList<Cliente> clientes, Cliente cliente) {
        clientes.add(cliente);
        /* //solucion 1
        Collections.sort(clientes,new Comparator<Cliente>() {
            @Override
            public int compare(Cliente s1, Cliente s2) {
                return s1.getId().compareTo(s2.getId());
            }
        });*/

        //solucion 2
        clientes.sort(cliente);



    }

    public static class Cliente implements Comparator {
        private int id;
        private String nombre;
        private String apellido;
        private int numero;

        public Cliente(int i, String n, String a, int num) {
            id = i;
            nombre = n;
            apellido = a;
            numero = num;
        }

        public Integer getId() {
            return id;
        }

        public String getCliente(){
            return id+" "+nombre+" "+apellido+" "+numero;
        }

        @Override
        public String toString() {
            //return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", numero=" + numero + "]";
            return String.format("ID: %d\r\nNombre: %s\r\nApellido: %s\r\nNumero: %s\r\n",
                    id, nombre, apellido, numero);
        }


        @Override
        public int compare(Object o1, Object o2) {
            Cliente c1 = (Cliente) o1;
            Cliente c2 = (Cliente) o2;
            return c1.getId() - c2.getId();
        }
    }
}


