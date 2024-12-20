package com.exercicis;

import java.util.*;

public class Exercici0013 {
    
    // Método para generar un ID único aleatorio para las ciudades
    public static int generateId(ArrayList<HashMap<String, Object>> cities) {
        Random random = new Random(); // Creamos un objeto Random para generar números aleatorios
        int newId;
        do {
            newId = 1000 + random.nextInt(9000); // Generamos un número aleatorio entre 1000 y 9999
        }
        while (idExists(cities, newId)); // Repetimos hasta que no exista un ID igual
        return newId; // Retornamos el ID generado
    }
    
    // Método para verificar si un ID ya existe en la lista de ciudades
    public static boolean idExists(ArrayList<HashMap<String, Object>> cities, int id) {
        for (HashMap<String, Object> city : cities) { // Recorremos la lista de ciudades
            if ((int) city.get("id") == id) { // Comprobamos si el ID ya está en uso
                return true;
            }
        }
        return false; // Retornamos falso si el ID no existe
    }

    // Método para obtener el ID de una ciudad a partir de su nombre
    public static int getIdByName(ArrayList<HashMap<String, Object>> cities, String name) {
        for (HashMap<String, Object> city : cities) { // Recorremos la lista de ciudades
            if (city.get("name").equals(name)) { // Comprobamos si el nombre coincide
                return (int) city.get("id"); // Retornamos el ID de la ciudad
            }
        }
        return -1; // Retornamos -1 si no encontramos la ciudad
    }
    
    // Método para añadir una nueva ciudad a la lista
    public static void addCity(ArrayList<HashMap<String, Object>> cities, 
            String name, int population, int height, boolean sealand) {
        HashMap<String, Object> newCity = new HashMap<>(); // Creamos un nuevo HashMap para la ciudad
        newCity.put("id", generateId(cities)); // Generamos y añadimos un ID único
        newCity.put("name", name); // Añadimos el nombre de la ciudad
        newCity.put("population", population); // Añadimos la población
        newCity.put("height", height); // Añadimos la altitud
        newCity.put("sealand", sealand); // Añadimos si está cerca del mar
        cities.add(newCity); // Añadimos la ciudad a la lista
    }
    
    // Método para eliminar una ciudad de la lista por su ID
    public static void removeCity(ArrayList<HashMap<String, Object>> cities, int id) {
        cities.removeIf((city) -> { // Usamos una función lambda para encontrar y eliminar la ciudad
            return (int) city.get("id") == id;
        });
    }
    
    // Método para actualizar un campo específico de una ciudad por su ID
    public static void updateData(ArrayList<HashMap<String, Object>> cities, 
            int id, String field, Object value) {
        for (HashMap<String, Object> city : cities) { // Recorremos la lista de ciudades
            if ((int) city.get("id") == id) { // Buscamos la ciudad con el ID especificado
                city.put(field, value); // Actualizamos el campo con el nuevo valor
                break; // Salimos del bucle después de actualizar
            }
        }
    }
    
    // Método para mostrar la información de todas las ciudades en formato de tabla
    public static void showInformation(ArrayList<HashMap<String, Object>> cities) {
        int idWidth = 5; // Ancho para la columna ID
        int nameWidth = 10; // Ancho para la columna Nombre
        int popWidth = 10; // Ancho para la columna Población
        int heightWidth = 7; // Ancho para la columna Altura
        int sealandWidth = 8; // Ancho para la columna Sealand
        int totalWidth = idWidth + nameWidth + popWidth + heightWidth + sealandWidth + 6; // Ancho total
        String columnas = "|%-" + idWidth + "s|%-" + nameWidth + "s|%" + popWidth + "s|%" + heightWidth + "s|%" + sealandWidth + "s|\n";

        System.out.println("-".repeat(totalWidth)); // Línea superior de la tabla
        System.out.printf(columnas, "ID", "Name", "Population", "Height", "Sealand"); // Encabezados
        System.out.println("-".repeat(totalWidth)); // Separador

        for (HashMap<String, Object> city : cities) { // Recorremos cada ciudad
            // Mostramos la información de la ciudad en formato tabla
            System.out.printf(columnas, city.get("id"), city.get("name"), city.get("population"), 
            city.get("height"), city.get("sealand"));
        }

        System.out.println("-".repeat(totalWidth)); // Línea inferior de la tabla
    }

    public static void main(String[] args) {
        ArrayList<HashMap<String, Object>> cities = new ArrayList<>(); // Lista de ciudades
        
        // Añadimos ciudades iniciales
        addCity(cities, "Barcelona", 1620343, 12, true);
        addCity(cities, "Madrid", 3207247, 667, false);
        addCity(cities, "València", 791413, 15, true);
        addCity(cities, "Màlaga", 569130, 11, true);
        addCity(cities, "Sevilla", 688711, 7, false);
        addCity(cities, "Alicante", 330525, 12, true);
        addCity(cities, "Zaragoza", 664938, 220, false);
        addCity(cities, "Gijón", 275735, 3, true);
        addCity(cities, "Palma de M", 22610, 14, true);
        addCity(cities, "Bilbao", 345821, 30, false);
        
        // Eliminamos Sevilla de la lista
        int sevillaId = getIdByName(cities, "Sevilla");
        if (sevillaId != -1) { // Comprobamos si existe antes de eliminarla
            removeCity(cities, sevillaId);
        }
        
        // Actualizamos datos de varias ciudades
        int barcelonaId = getIdByName(cities, "Barcelona");
        updateData(cities, barcelonaId, "population", 1621000); // Actualizamos la población

        int valenciaId = getIdByName(cities, "València");
        updateData(cities, valenciaId, "height", 16); // Actualizamos la altitud

        int palmaId = getIdByName(cities, "Palma de M");
        updateData(cities, palmaId, "name", "Palma"); // Cambiamos el nombre

        int zaragozaId = getIdByName(cities, "Zaragoza");
        updateData(cities, zaragozaId, "sealand", false); // Actualizamos la proximidad al mar
        
        // Añadimos una nueva ciudad
        addCity(cities, "Tarragona", 132299, 70, true);
        
        // Mostramos la información final de todas las ciudades
        showInformation(cities);
    }
}
