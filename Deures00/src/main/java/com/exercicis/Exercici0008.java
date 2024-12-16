package com.exercicis;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercici0008 {

    // Funcion para introducir un numero en una ArrayLIst
    public static ArrayList<Integer> generaImparells(int numero) {
        ArrayList<Integer> imparells = new ArrayList<>(); // Creamos una ArrayList vacia donde se introduciran los numeros impares

        // Si los numeros son impares (es decir, que su residuo no sea 0) los añadimos a la ArrayList
        for(int i = 2; i <= numero; i++) {
            if (i % 2 != 0) {
                imparells.add(i);
            }
        }
        // Regresamos una ArrayList con los numeros impares
        return imparells;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Introducimos un numero para determinar el rango
        System.out.print("Introdueix un número: ");
        Integer numero = scanner.nextInt();
        // Generamos (llamando a la funcion) la lista con los impares
        ArrayList<Integer> impares = generaImparells(numero);
        System.out.println("Numeros imparells entre 2 i " + numero + ": " + impares); // Mostramos la lista con los impares entre 2 y el numero introducido

        scanner.close();
    }
}
