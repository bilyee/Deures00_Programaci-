package com.exercicis;

import java.util.ArrayList;
import java.util.Random;

public class Exercici0010 {

    public static ArrayList<Integer> generarNumerosAleatoris(int quantitat, int min, int max) {
        ArrayList<Integer> numeros = new ArrayList<>();
        Random random = new Random();

        if (min > max) {
            System.out.println("ERROR: El numero menor no puede ser mas grande que el mayor");
        }

        for (int i = 0; i < quantitat; i++) {
            int numerosAleatorios = random.nextInt((max - min) + 1) + min;
            numeros.add(numerosAleatorios);
        }
        return numeros;
    }

    public static ArrayList<Integer> multiplicarPerDos(ArrayList<Integer> llista) {
        ArrayList<Integer> numerosMult = new ArrayList<>();
        for (int num : llista) {
            numerosMult.add(num * 2);
        }
        return numerosMult;
    }

    public static ArrayList<Integer> filtrarImparells(ArrayList<Integer> llista) {
        ArrayList<Integer> numerosImpares = new ArrayList<>();
        for (int num : llista) {
            if (num % 2 != 0) {
                numerosImpares.add(num);
            }
        }
        return numerosImpares;
    }

    public static ArrayList<Double> dividirPerDos(ArrayList<Integer> llista) {
        ArrayList<Double> numerosDivididos = new ArrayList<>();
        for (int num : llista) {
            if (num % 2 != 0) {
                numerosDivididos.add(num / 2.0);
            }
        }
        return numerosDivididos;
    }

    public static void main(String[] args) {

        ArrayList<Integer> listaAleatoria = generarNumerosAleatoris(10, 0, 99);
        System.out.println("Llista inicial: " + listaAleatoria);

        ArrayList<Integer> listaMultiplicada = multiplicarPerDos(listaAleatoria);
        System.out.println("Llista multiplicada per 2: " + listaMultiplicada);

        ArrayList<Integer> listaImpares = filtrarImparells(listaAleatoria);
        System.out.println("Llista només amb números imparells: " + listaImpares);

        ArrayList<Double> listaDividida = dividirPerDos(listaImpares);
        System.out.println("Llista imparells dividits per 2: " + listaDividida);

    }
}
