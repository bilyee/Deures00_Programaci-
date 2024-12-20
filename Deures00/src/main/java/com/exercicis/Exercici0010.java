package com.exercicis;

import java.util.ArrayList;
import java.util.Random;

public class Exercici0010 {

    public static ArrayList<Integer> generarNumerosAleatoris(int quantitat, int min, int max) {
        ArrayList<Integer> numeros = new ArrayList<>(); // Creamos una nueva lista vacia para añadir numeros
        Random random = new Random(); // Para que nos de numeros aleatorios entre 2 numeros

        // Si el menor es mas grande que el numero mayor, se mostrara mensaje de error
        if (min > max) { 
            System.out.println("ERROR: El numero menor no puede ser mas grande que el mayor");
        }

        for (int i = 0; i < quantitat; i++) { // Creamos un bucle para decir cuantas veces lo hacemos dependiendo de la cantidad
            // Creamos numeros aleatorios entre el rango de numeros y los añadimos a la lista
            int numerosAleatorios = random.nextInt((max - min) + 1) + min; 
            numeros.add(numerosAleatorios);
        }
        return numeros; // Regresamos la lista de numeros
    }

    public static ArrayList<Integer> multiplicarPerDos(ArrayList<Integer> llista) {
        ArrayList<Integer> numerosMult = new ArrayList<>(); // Creamos una lista vacia para añadir los numeros multiplicados
        for (int num : llista) { // Creamos un bucle para repasar numero por numero que haya en la lista
            numerosMult.add(num * 2); // Añadimos los numeros multiplicados por 2
        }
        return numerosMult; // Regresamos la lista de numeros multiplicados
    }

    public static ArrayList<Integer> filtrarImparells(ArrayList<Integer> llista) {
        ArrayList<Integer> numerosImpares = new ArrayList<>(); // Creamos una lista vacia para añadir los numeros impares
        for (int num : llista) { // Creamos un bucle para repasar numeros por numero que haya en la lista
            // Si el numero dividido entre 2 no da cero, lo añadimos a la lista de impares
            if (num % 2 != 0) { 
                numerosImpares.add(num);
            }
        }
        return numerosImpares; // Regresamos la lista de numeros impares
    }

    public static ArrayList<Double> dividirPerDos(ArrayList<Integer> llista) {
        ArrayList<Double> numerosDivididos = new ArrayList<>();
        for (int num : llista) { // Creamos un bucle para repasar numeros por numero que haya en la lista
            // Si el numero dividido entre 2 no da cero, lo añadimos a la lista de numerosDivididos
            if (num % 2 != 0) {
                numerosDivididos.add(num / 2.0); // Añadimos los numeros divididos entre 2
            }
        }
        return numerosDivididos; // Regresamos la lista de numeros divididos
    }

    public static void main(String[] args) {

        // Mostramos todas las variantes basados en la lista generada aleatoriamente
        ArrayList<Integer> listaAleatoria = generarNumerosAleatoris(10, 0, 99);
        System.out.println("Llista inicial: " + listaAleatoria);

        ArrayList<Integer> listaMultiplicada = multiplicarPerDos(listaAleatoria);
        System.out.println("Llista multiplicada per 2: " + listaMultiplicada);

        ArrayList<Integer> listaImpares = filtrarImparells(listaAleatoria);
        System.out.println("Llista només amb números imparells: " + listaImpares);

        ArrayList<Double> listaDividida = dividirPerDos(listaImpares);
        System.out.println("Llista imparells dividits per 2: " + listaDividida);

    }
}
