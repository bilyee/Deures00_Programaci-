package com.exercicis;

import java.util.Locale;

public class Exercici0006 {
    public static double calculaEntrada(int numeroAdults, int numNens, int numGrans, String dia) {
        // Guardamos todos los precios de las entradas para cada uno
        Double preuAdults = 10.0;
        Double preuNens = 5.0;
        Double preuGrans = 6.0;

        // Calculo del precio estandart dependiendo de la cantidad de cada uno
        Double preuEstandart = (numeroAdults * preuAdults) + (numNens * preuNens) + (numGrans * preuGrans);

        // Si el dia es igual a "dimarts" el precio recibe un descuento del 20%
        if (dia.equalsIgnoreCase("dimarts")) {
            preuEstandart *= 0.8;
        }

        // Si el dia es igual a "dijous" y hay niños y adultos, el precio del primer niño recibe un descuento del 50% y los otros entran gratis
        else if (dia.equalsIgnoreCase("dijous") && numNens > 0 && numeroAdults > 0) {
            preuEstandart -= preuNens * 0.5;
            preuEstandart -= preuNens * (numNens - 1);
        }

        return preuEstandart; // Regresamos el calculo del precio
    }

    public static void main(String[] args) {

        String template = "%-35s%.2f€";
        // Podemos diferentes situaciones de cantidad y de dias de la semana para ver como varia el precio
        System.out.println(String.format(Locale.US, template, "Cas 1 (2 adults, 2 nens, 1 gran):", calculaEntrada(2, 2, 1, "dimarts")));
        System.out.println(String.format(Locale.US, template, "Cas 2 (1 adult,  2 nens, 0 grans):", calculaEntrada(1, 2, 0, "dijous")));
        System.out.println(String.format(Locale.US, template, "Cas 3 (0 adults, 0 nens, 2 grans):", calculaEntrada(0, 0, 2, "dissabte")));
        System.out.println(String.format(Locale.US, template, "Cas 4 (1 adult,  0 nens, 0 grans):", calculaEntrada(1, 0, 0, "diumenge")));
        System.out.println(String.format(Locale.US, template, "Cas 5 (1 adult,  3 nens, 4 grans):", calculaEntrada(1, 3, 4, "dijous")));
        System.out.println(String.format(Locale.US, template, "Cas 6 (2 adults, 2 nens, 1 gran):", calculaEntrada(2, 2, 1, "diumenge")));
    }
}
