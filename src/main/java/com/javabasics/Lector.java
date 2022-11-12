package com.javabasics;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Lector {

    private String ruta;
    private int dni;

    public Lector(String ruta) {
        this.ruta = ruta;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    /*
    Este método abrirá el archivo que se encuentra en la ruta
    almacenada en la variable ruta y devolverá la línea de texto en el número pasado como
    parámetro. Ejemplo: si se pide la línea número 0, se devolverá la primera línea del archivo. Si
    se pide la línea 3 se devolverá la 4ta línea del archivo - contamos desde el 0 -.
    programar lo necesario para que, en caso de pasar como parámetro
    un número de línea menor a 0, mayor a la cantidad de líneas del archivo, o si el archivo no
    existe, el método retorne el String “error”
    */
    public String leerLinea(int numLinea) throws IOException {
        String linea;
        List<String> lineas = Files.readAllLines(Path.of(ruta), StandardCharsets.UTF_8);

        //Valido condiciones de error.
        if (numLinea < 0 || numLinea > lineas.size() || Files.notExists(Path.of(ruta)))
            return "error";

        linea = lineas.get(numLinea);

        return linea;
    }

    /*Programaremos un método público llamado leerLineas que tomará un array de enteros (int[])
    como parámetro y devolverá un Mapa con llaves de tipo Integer y valores de tipo String
    (Map<Integer, String>). El método leerá los números de líneas contenidas en el array y las
    almacenará en el mapa de modo que el número de línea es la llave y la línea leída es el valor*/

    public Map<Integer,String> leerLineas(int[] numLineas) throws IOException {

        Map<Integer,String> respuesta = new HashMap<>();
        List<String> lineas = Files.readAllLines(Path.of(ruta), StandardCharsets.UTF_8);

        for (int i = 0; i < numLineas.length; i++) {

          if (numLineas[i] < 0 || numLineas[i] > lineas.size())  //Esta funcionalidad no esta en el enunciado pero si coomo caso de test.
          {
              respuesta.put(numLineas[i] ,"error");
              continue;
          }

           String linea = lineas.get(numLineas[i]);
           respuesta.put(numLineas[i],linea);
        }

        return respuesta;

    }

}