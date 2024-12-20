package com.exercicis;

import java.util.Locale;
import java.util.Scanner;

public class Exercici0002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale localeUS = Locale.US;
        scanner.useLocale(Locale.US);

        // Escribimos un precio que sea en formato Euros
        System.out.print("Escriu el valor en Euros: ");
        String eurosInput = scanner.next();
        Double euros = Double.parseDouble(eurosInput.replace(",", ".")); // Remplazamos las comas por puntos

        // Escribimos la tasa de conversion para pasar los euros a dolares
        System.out.print("Escriu la tasa de conversió (ex: 1.25): ");
        String tasaInput = scanner.next();
        Double tasa = Double.parseDouble(tasaInput.replace(",", ".")); // Remplazamos las comas por puntos

        Double dolares = euros * tasa; // Guardamos en una variable el calculo de conversion

        System.out.printf(localeUS, "El valor de %.2f€ són %.2f$%n", euros, dolares); // Mostramos el resultado con formato para decir cuantos decimales queremos

        scanner.close();
    }
}
