package com.exercicis;

import java.util.Locale;
import java.util.Scanner;

public class Exercici0001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale localeUS = Locale.US;

        // Escribimos el peso 
        System.out.print("Escriu el pes (kg): ");
        Double pes = scanner.nextDouble();
        // Escribimos la altura en centimentros
        System.out.print("Escriu l'alçada (cm): ");
        Double altura = scanner.nextDouble();

        Double alturaMetros = altura / 100; // Pasamos la altura de centimetros a metros
        Double imc = pes / (alturaMetros * alturaMetros); // Guardamos en una variable el calculo para saber la masa corporal

        System.out.printf(localeUS, "imc = %.2f%n", imc); // Mostramos el calculo con el resultado

        scanner.close();
    }
}
