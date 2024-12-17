package com.exercicis;

import java.util.Locale;
import java.util.Scanner;

public class Exercici0002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale localeUS = Locale.US;
        scanner.useLocale(Locale.US);

        System.out.print("Escriu el valor en Euros: ");
        String eurosInput = scanner.next();
        Double euros = Double.parseDouble(eurosInput.replace(",", "."));

        System.out.print("Escriu la tasa de conversió (ex: 1.25): ");
        String tasaInput = scanner.next();
        Double tasa = Double.parseDouble(tasaInput.replace(",", "."));

        Double dolares = euros * tasa;

        System.out.printf(localeUS, "El valor de %.2f€ són %.2f$%n", euros, dolares);

        scanner.close();
    }
}
