package com.exercicis;

import java.util.Locale;
import java.util.Scanner;

public class Exercici0003 {
    public static double calcularPreuFinal(double preuBase, double iva, double descompte) {
        double preuAmbIva = preuBase + (preuBase * iva / 100); // Hacemos el calculo para saber el precio con el IVA incluido
        return preuAmbIva - (preuAmbIva * descompte / 100); // Regresamos a la funcion el resultado del precio con IVA con el descuento
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Locale localeUS = Locale.US;

        System.out.print("Introdueix el preu base: "); // Escribe el precio base de un producto
        Double preuBase = scanner.nextDouble();
        
        System.out.print("Introdueix l'IVA (%): "); // Introduce el IVA
        Double iva = scanner.nextDouble();

        System.out.print("Introdueix el descompte (%): "); // Introduce el porcentaje de descuento
        Double descompte = scanner.nextDouble();

        Double preuFinal = calcularPreuFinal(preuBase, iva, descompte); // Invocando a la funcion, guardamos en una variable el resultado del calculo

        System.out.printf(localeUS, "El preu final és: %.2f\n", preuFinal); // Mostramos el precio con el formato de 2 decimales
        
        scanner.close();
    }
}
