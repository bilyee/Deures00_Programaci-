package com.exercicis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Exercici0011 {

    public static ArrayList<String> escullNomsAleatoris(ArrayList<String> noms, int quantitat) {
        // Si la cantidad de numeros es mayor a la alargada de nombres que ya hay en la lista, mostrara un error
        if (quantitat > noms.size()) {
            throw new IllegalArgumentException("La quantitat no pot ser més gran que " + noms.size() + ".");
        }

        ArrayList<String> nombres = new ArrayList<>(); // Creamos una lista vacia para los nombres
        Random random = new Random(); // Para que nos de nombres aleatorios

        ArrayList<String> copiaNoms = new ArrayList<>(noms); // Evitamos duplicados
        for (int i = 0; i < quantitat; i++) { // Creamos un bucle para ir nombre por nombre dependiendo de la cantidad
            // Si la lista de nombres esta llena, salimos directamente del bucle
            if (copiaNoms.isEmpty()) {
                break;
            }
            int index = random.nextInt(copiaNoms.size()); // Sacamos el index aleatorio de los nombres de la lista
            nombres.add(copiaNoms.remove(index)); // Añadimos los nombres pero eliminando el numero de index
        }
        return nombres; // Regresamos la lista de nombres
    }
   
    public static ArrayList<String> nomsAcabenVocal(ArrayList<String> noms) {
        ArrayList<String> nomsVocals = new ArrayList<>(); // Creamos una lista vacia para añadir los nombres que acaben en vocal
        for (String nom : noms) { // Vamos nombre por nombre que haya en la lista
            char ultimaLetra = nom.toLowerCase().charAt(nom.length() - 1); // Guardamos la ultima letra de la palabra en una variable
            // Si las letras coinciden con la ultima letra de la variable, añadimos la palabra a la lista
            if ("aeiou".indexOf(ultimaLetra) >= 0) {
                nomsVocals.add(nom);
            }
        }
        return nomsVocals; // Regresamos la lista de vocales
    }

    public static ArrayList<String> nomsCompostos(ArrayList<String> noms) {
        ArrayList<String> nomsCompostos = new ArrayList<>(); // Creamos una lista vacia para añadir los nombres que sean compuestos
        for (String nom : noms) { // Vamos nombre por nombre que haya en la lista
            // Si el nombre contiene un espacio, añadimos el nombre a la lista
            if (nom.contains(" ")) {
                nomsCompostos.add(nom);
            }
        }
        return nomsCompostos; // Regresamos la lista de palabras compuestas
    }

    public static void main(String[] args) {
        // Creamos una lista predeterminada
        ArrayList<String> noms = new ArrayList<>(Arrays.asList("Mario", "Princess Peach", "Wario", "Luigi", "Iggy Koopa", "Toad", "Yoshi", "Donkey Kong", "Birdo"));
        // Mostramos los nombres escogidos aleatoriamente basados en la lista predeterminada
        ArrayList<String> nomsAleatoris = escullNomsAleatoris(noms, 5);
        System.out.println("Noms escollits a l'atzar: " + nomsAleatoris);
        try {
            // Intentar seleccionar 25 nombres aleatorios (más de los que hay en la lista)
            // Esto probablemente lanzará una excepción porque no hay suficientes nombres en la lista
            ArrayList<String> seleccionatsError = escullNomsAleatoris(noms, 25);
            System.out.println("Noms escollits: " + seleccionatsError);
        } catch (IllegalArgumentException e) {
            // Capturar y manejar la excepción cuando se solicitan más nombres de los disponibles
            // Imprimir un mensaje de error indicando el problema
            System.out.println("Error: " + e.getMessage());
        }

        // Mostramos los nombres de la lista de aleatorios acabados en vocal
        ArrayList<String> nomsVocal = nomsAcabenVocal(noms);
        System.out.println("Noms que acaben amb vocal: " + nomsVocal);
        // Mostramos los nombres de la lista de aleatorios que sean compuestos
        ArrayList<String> nomsCompostos = nomsCompostos(noms);
        System.out.println("Noms compostos: " + nomsCompostos);
    }
}
