package com.exercicis;

import java.util.Scanner;

public class Exercici0000 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Escribimos 2 numeros random
        System.out.print("Escriu el primer número: ");
        Integer num1 = scanner.nextInt();

        System.out.print("Escriu el segon número: ");
        Integer num2 = scanner.nextInt();

        Integer resta = num1 - num2; // Guardamos en una variable la operacion

        System.out.println("El resultat de calcular " + num1 + " - " +  num2 + " és " + resta); // Mostramos el resultado de la operacion

        scanner.close();
    }
}
