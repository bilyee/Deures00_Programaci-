package com.exercicis;
public class Exercici0005 {

    // Creamos una funcion para invertir la palabra y comprobar si es palindrom o no
    public static boolean isPalindrom(String text) {
        text = normalize(text); // Normalizamos el texto para que no tenga caracteres especiales

        int ultimaLletra = text.length() - 1; // Pillamos la ultima letra de la palabra introducida
        String invertido = ""; // Creamos una variable para introducir la palabra invertida letra por letra

        // Creamos un bucle para ir letra por letra para invertir la palabra en la variable "invertido"
        for (int cnt = ultimaLletra; cnt >= 0; cnt = cnt - 1) {
            String Letra = String.valueOf(text.charAt(cnt));
            invertido = invertido + Letra;
        }

        // Regresamos la palabra si es igual invertida o no
        return text.equals(invertido);
    }

    // Creamos una variable para quitarle los caracteres especiales a las palabras
    public static String normalize(String text) {
        String palabra = text.toLowerCase(); // Volvemos toda la palabra a minusculas

        // Creamos dos listas distintas. Una con todos los caracteres especiales, y otra sin ellos
        String[] acentos = {"à", "á", "è", "é", "í", "ò", "ó", "ù", " ", "'", "!", "\\.", ",", "·"};
        String[] sinAcentos = {"a", "a", "e", "e", "i", "o", "o", "u", "", "", "", "", "", ""};

        // Creo un bucle para intercambiar los caracteres especiales por los normales (si tienen)
        for (int cnt = 0; cnt < acentos.length; cnt++) {
            palabra = palabra.replaceAll(acentos[cnt], sinAcentos[cnt]);
        }
        return palabra; // Regresamos la palabra modificada
    }
   
    public static void main(String[] args) {

        // Creamos una lista con ejemplos de palindromos y uno que no
        String[] ejemplos = {
            "radar",
            "level",
            "Dábale arroz a la zorra el abad",
            "No lemon no melon",
            "sometemos",
            "Hola mundo" // No palíndromo
        };

        // Creamos un bucle para mostrar palabra por palabra y que nos diga si es palindromo o no con un mensaje sencillo
        for (String texto : ejemplos) {
            Boolean Palindrom = isPalindrom(texto);
            System.out.println(texto + " (" + (Palindrom ? "Si" : "No") + " )");
        }
    }
}
