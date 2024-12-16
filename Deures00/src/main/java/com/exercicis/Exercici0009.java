package com.exercicis;

import java.util.Scanner;

public class Exercici0009 {

    public static void dibuixarRectangle(int ample, int alt) {
        // Creamos una condicion de que si es menor a 2x2, muestre un mensaje de error
        if (ample < 2 || alt < 2) {
            System.out.println("Error. Com a minim ha de ser 2 per alt y 2 per amplada");
        }
        // Repetimos tantas veces el signo "*" como hayamos puesto en amplada para crear la parte de arriba
        System.out.println("*".repeat(ample));

        // Hacemos un bucle para poder hacer el relleno del rectangulo y los laterales del rectangulo
        for (int i = 0; i < alt - 2; i++) {
            System.out.println("*" + "o".repeat(ample - 2) + "*");
        }
        // Repetimos tantas veces el signo "*" como hayamos puesto en amplada para crear la parte de abajo
        System.out.println("*".repeat(ample));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Introducimos la amplada y la altura del rectangulo
        System.out.print("Introdueix l'ample del rectangle: ");
        Integer ample = scanner.nextInt();
        System.out.print("Introdueix l'altura del rectangle: ");
        Integer alt = scanner.nextInt();
        // Mostramos el resultado llamando a la funcion con los parametros
        System.out.println("Resultat: ");
        dibuixarRectangle(ample, alt);

        scanner.close();
    }
}
