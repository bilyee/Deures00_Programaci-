package com.exercicis;

import java.util.Scanner;

public class Exercici0004 {

    public static int contaMajuscules(String contrasenya) {
        int countMayusculas = 0; // Creamos variable para contar las mayusculas que aparezcan
        for (char c : contrasenya.toCharArray()) { // Hacemos un bucle letra por letra
            if (Character.isUpperCase(c)) { // Si la letra es mayuscula, sumamos 1 a la variable
                countMayusculas++;
            }
        }
        return countMayusculas; // Regresamos el recuento de mayusculas
    }

    public static int contaMinuscules(String contrasenya) {
        int countMinusculas = 0; // Creamos variable para contar las minusculas que aparezcan
        for (char c : contrasenya.toCharArray()) { // Hacemos un bucle leyta por letra
            if (Character.isLowerCase(c)) { // Si la letra es minuscula, sumamos 1 a la variable
                countMinusculas++;
            }
        }
        return countMinusculas; // Regresamos el recuento de minusculas
    }

    public static String validaContrasenya(String contrasenya) {
        // Si la contraseña es mayor a 8 digitos, y hay mas de 2 mayusculas y minusculas, la contraseña sera valida
        if (contrasenya.length() >= 8 
            && contaMajuscules(contrasenya) >= 2 
            && contaMinuscules(contrasenya) >= 2) {
            return "La contrasenya és vàlida";
        }
        // Si no cumple los requisitos, la contraseña no sera valida
        else {
            return "La contrasenya NO és vàlida";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Escribimos una contraseña
        System.out.print("Escriu una contrasenya: ");
        String contrasenya = scanner.nextLine();
        // Guardamos en una variable la validacion de la contraseña llamando a la funcion
        String validacio = validaContrasenya(contrasenya);
        // Mostramos si la contraseña es valida o no
        System.out.printf("La contrasenya '%s': %s\n", contrasenya, validacio);

        scanner.close();
    }
}
