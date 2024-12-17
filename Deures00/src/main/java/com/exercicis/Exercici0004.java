package com.exercicis;

import java.util.Scanner;

public class Exercici0004 {

    public static int contaMajuscules(String contrasenya) {
        int countMayusculas = 0;
        for (char c : contrasenya.toCharArray()) {
            if (Character.isUpperCase(c)) {
                countMayusculas++;
            }
        }
        return countMayusculas;
    }

    public static int contaMinuscules(String contrasenya) {
        int countMinusculas = 0;
        for (char c : contrasenya.toCharArray()) {
            if (Character.isLowerCase(c)) {
                countMinusculas++;
            }
        }
        return countMinusculas;
    }

    public static String validaContrasenya(String contrasenya) {
        if (contrasenya.length() >= 8 
            && contaMajuscules(contrasenya) >= 2 
            && contaMinuscules(contrasenya) >= 2) {
            return "La contrasenya és vàlida";
        }
        else {
            return "La contrasenya NO és vàlida";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Escriu una contrasenya: ");
        String contrasenya = scanner.nextLine();

        String validacio = validaContrasenya(contrasenya);

        System.out.printf("La contrasenya '%s': %s\n", contrasenya, validacio);

        scanner.close();
    }
}
