package com.exercicis;

import java.util.Locale;
import java.util.Scanner;

public class Exercici0002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale localeUS = Locale.US;
        scanner.useLocale(Locale.US);

        System.out.print("Escriu el valor en Euros: ");
        Double euros = scanner.nextDouble();

        System.out.print("Escriu la tasa de conversió (ex: 1.25): ");
        Double tasa = scanner.nextDouble();

        Double conversion = euros * tasa;

        System.out.printf(localeUS, "El valor de %.2f€ són %.2f$%n", euros, conversion);

        scanner.close();
    }
}
