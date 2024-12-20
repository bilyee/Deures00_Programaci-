package com.exercicis;

import java.util.*;

public class Exercici0012 {

    // Método para crear una Maravilla del Mundo representada como un HashMap
    public static HashMap<String, Object> createWonder(String name, String location, int age) {
        HashMap<String, Object> wonder = new HashMap<>(); // Creamos un HashMap vacío
        wonder.put("name", name); // Añadimos el nombre
        wonder.put("location", location); // Añadimos la localización
        wonder.put("age", age); // Añadimos la antigüedad
        return wonder; // Retornamos el HashMap
    }

    // Método para mostrar la información de todas las maravillas
    public static void showInformation(ArrayList<HashMap<String, Object>> wonders) {
        for (HashMap<String, Object> wonder : wonders) { // Recorremos cada maravilla
            System.out.println("* Name: " + wonder.get("name")); // Mostramos el nombre
            System.out.println("  Location: " + wonder.get("location")); // Mostramos la localización
            System.out.println("  Age: " + wonder.get("age") + " years"); // Mostramos la antigüedad
        }
    }

    // Método para ordenar las maravillas por nombre
    public static ArrayList<HashMap<String, Object>> sortWondersByName(ArrayList<HashMap<String, Object>> wonders) {
        ArrayList<HashMap<String, Object>> sortedWonder = new ArrayList<>(wonders); // Creamos una copia
        sortedWonder.sort((wonder1, wonder2) -> { // Ordenamos con un comparador
            String a = (String) wonder1.get("name"); // Nombre de la primera maravilla
            String b = (String) wonder2.get("name"); // Nombre de la segunda maravilla
            return a.compareTo(b); // Comparamos los nombres alfabéticamente
        });
        return sortedWonder; // Retornamos la lista ordenada
    }

    // Método para obtener las maravillas ordenadas por nombre y limitar la cantidad
    public static ArrayList<HashMap<String, Object>> getSortedWondersByName(ArrayList<HashMap<String, Object>> wonders, int quantity) {
        ArrayList<HashMap<String, Object>> sortedWonder = sortWondersByName(wonders); // Ordenamos por nombre
        // Retornamos solo las primeras 'quantity' maravillas
        return new ArrayList<>(sortedWonder.subList(0, Math.min(quantity, sortedWonder.size())));
    }

    // Método para obtener solo los nombres de las maravillas, ordenados alfabéticamente
    public static ArrayList<String> sortNames(ArrayList<HashMap<String, Object>> wonders) {
        ArrayList<HashMap<String, Object>> sortedWonder = getSortedWondersByName(wonders, wonders.size()); // Ordenamos todas las maravillas
        ArrayList<String> names = new ArrayList<>(); // Lista para los nombres
        for (HashMap<String, Object> wonder : sortedWonder) { // Recorremos las maravillas ordenadas
            names.add((String) wonder.get("name")); // Añadimos el nombre a la lista
        }
        return names; // Retornamos la lista de nombres
    }

    // Método para obtener las maravillas más antiguas
    public static ArrayList<HashMap<String, Object>> getOlder(ArrayList<HashMap<String, Object>> wonders, int quantity) {
        ArrayList<HashMap<String, Object>> sortedWonder = new ArrayList<>(wonders); // Creamos una copia
        sortedWonder.sort((wonder1, wonder2) -> { // Ordenamos por antigüedad, descendente
            Integer a = (Integer) wonder1.get("age"); // Antigüedad de la primera maravilla
            Integer b = (Integer) wonder2.get("age"); // Antigüedad de la segunda maravilla
            return b.compareTo(a); // Orden descendente (mayor a menor)
        });
        // Retornamos solo las primeras 'quantity' maravillas
        return new ArrayList<>(sortedWonder.subList(0, Math.min(quantity, sortedWonder.size())));
    }

    // Método para filtrar maravillas por región
    public static ArrayList<HashMap<String, Object>> getRegion(ArrayList<HashMap<String, Object>> wonders, String region) {
        ArrayList<HashMap<String, Object>> result = new ArrayList<>(); // Lista para las maravillas de la región
        for (HashMap<String, Object> wonder : wonders) { // Recorremos cada maravilla
            if (((String) wonder.get("location")).contains(region)) { // Comprobamos si la localización contiene la región
                result.add(wonder); // Añadimos la maravilla a la lista
            }
        }
        return result; // Retornamos las maravillas filtradas
    }

    public static void main(String[] args) {
        // Creamos una lista de maravillas y las añadimos
        ArrayList<HashMap<String, Object>> wonders = new ArrayList<>();
        wonders.add(createWonder("Great Pyramid of Giza", "Egypt", 4500));
        wonders.add(createWonder("Hanging Gardens of Babylon", "Babylon, Mesopotamia", 2500));
        wonders.add(createWonder("Statue of Zeus at Olympia", "Olympia, Greece", 2500));
        wonders.add(createWonder("Temple of Artemis at Ephesus", "Ephesus, Turkey", 2400));
        wonders.add(createWonder("Mausoleum at Halicarnassus", "Halicarnassus, Turkey", 2300));
        wonders.add(createWonder("Colossus of Rhodes", "Island of Rhodes, Greece", 2300));
        wonders.add(createWonder("Lighthouse of Alexandria", "Alexandria, Egypt", 2200));

        // Mostramos todas las maravillas
        System.out.println("All Wonders:");
        showInformation(wonders);

        // Mostramos los nombres de las maravillas ordenados
        System.out.println("-".repeat(25));
        System.out.println("Sorted Names:");
        ArrayList<String> sortedNames = sortNames(wonders);
        System.out.println(sortedNames);

        // Mostramos las 3 maravillas más antiguas
        System.out.println("-".repeat(25));
        System.out.println("Top 3 Oldest Wonders:");
        ArrayList<HashMap<String, Object>> oldWonder = getOlder(wonders, 3);
        showInformation(oldWonder);

        // Mostramos las maravillas ubicadas en Turquía
        System.out.println("-".repeat(25));
        System.out.println("Wonders in Turkey:");
        ArrayList<HashMap<String, Object>> turkeyWonder = getRegion(wonders, "Turkey");
        showInformation(turkeyWonder);
    }
}
