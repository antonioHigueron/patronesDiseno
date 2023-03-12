package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 7) Dado un archivo con los datos representativos de una escuela como:
 * nombre, apellidos, nombre del primer hijo, nombre del segundo hijo...etc,
 * crear un nuevo archivo con las iniciales de cada padre y el número de hijos que tiene.
 * Al final del fichero, incluye el nombre completo del padre con el mayor número de hijos.
 * <p>
 * Fichero “datos.txt”:
 * Ramón Rodríguez Mar Lorena
 * Luisa Medina Dario
 * Jesús González Pedro Pablo Laura
 */
public class Pruebas7 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File("archivo.txt"));
            Scanner input = new Scanner(new File("D:\\proyectos\\patronesDiseno\\proyecto\\src\\main\\java\\org\\example\\datos.txt"));
            input.useDelimiter("-|\n");
            String padre="";
            int tmpHijos=0;
            while (input.hasNext()) {
                String[] valores = input.nextLine().split(" ");
                String nombre = valores[0];
                String apellido = valores[1];
                int hijos = 0;
                for (int i = 2; i < valores.length; i++,hijos++) {
                    if(tmpHijos<hijos){
                        tmpHijos=hijos;
                        padre = nombre+" "+apellido;
                    }
                }
                fw.write(nombre.toUpperCase().substring(0,1)+apellido.toUpperCase().substring(0,1)+" "+hijos+"\n");
            }
            fw.write(padre);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            fw.close();
        }


    }
}
