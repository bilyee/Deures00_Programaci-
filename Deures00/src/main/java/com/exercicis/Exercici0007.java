package com.exercicis;

import java.util.Locale;

public class Exercici0007 {

    public static double calculaCostLloc(String tipusLloc) {
        return switch (tipusLloc.toLowerCase()) { // Regresamos diferentes casos con las palabras en miniscula
            case "sala estàndard" -> 100.0; // Sala estandard a 100€
            case "jardí amb piscina" -> 200.0; // Jardin con piscina a 200€
            case "saló gran amb escenari" -> 500.0; // Salon grande con escenario a 500€
            default -> throw new IllegalArgumentException("Tipus de lloc desconegut: " + tipusLloc); // Si no han habido estos casos, por defecto mostrara mensaje de error
        };
    }

    public static double calculaCostMenjar(String tipusMenjar, int numConvidats) {
        Double preuConvidat = switch (tipusMenjar.toLowerCase()) { // Regresamos diferentes casos con las palabras en miniscula
            case "menú bàsic" -> 15.0; // Menu basico a 15€
            case "menú premium" -> 30.0; // Menu premium a 30€
            default -> throw new IllegalArgumentException("Tipus de menú desconegut: " + tipusMenjar); // Si no han habido estos casos, por defecto mostrara mensaje de error
        };

        Double totalMenjar = preuConvidat * numConvidats; // Guardamos en una variable el precio total de los menus

        // Si los invitados son mas de 50, se les aplica un descuento del 5%
        if (numConvidats > 50) {
            totalMenjar *= 0.95;
        }
        
        return totalMenjar; // Regresamos el precio total de los menus
    }

    public static double calculaCostEntreteniment(String tipusEntreteniment) {
        return switch (tipusEntreteniment.toLowerCase()) { // Regresamos diferentes casos con las palabras en miniscula
            case "màgia" -> 250.0; // Magia a 250€
            case "música en directe" -> 500.0; // Musica en directo a 500€
            case "cap" -> 0.0; // Si no escogen ninguna, 0€
            default -> throw new IllegalArgumentException("Tipus d'entreteniment desconegut: " + tipusEntreteniment); // Si no han habido estos casos, por defecto mostrara mensaje de error
        };
    }

    public static double calculaFesta(String tipusLloc, String tipusMenjar, String tipusEntreteniment, int numConvidats) {
        Double costLloc = calculaCostLloc(tipusLloc); // Guardamos llamando a la variable el calculo del lugar
        Double costMenjar = calculaCostMenjar(tipusMenjar, numConvidats); // Guardamos llamando a la variable el calculo del menu
        Double costEntreteniment = calculaCostEntreteniment(tipusEntreteniment); // Guardamos llamando a la variable el calculo del entretenimiento

        // Si se escoge el salon grande con escenario + musica en directo, tienen un descuento de 100€ en el entretenimiento
        if (tipusLloc.equalsIgnoreCase("saló gran amb escenari") && tipusEntreteniment.equalsIgnoreCase("música en directe")) {
            costEntreteniment -= 100.0;
        }

        return costLloc + costMenjar + costEntreteniment; // Regresamos todos los costes
    }

    public static void main(String[] args) {

        String template = "%-75s%.2f€";
        // Mostramos diferentes casos y vemos las diferencias de cada uno con los precios
        System.out.println(String.format(Locale.US, template, "Cas 1 (\"sala estàndard\", \"menú bàsic\", \"cap\", 20):", calculaFesta("sala estàndard", "menú bàsic", "cap", 20)));
        System.out.println(String.format(Locale.US, template, "Cas 2 (\"jardí amb piscina\", \"menú premium\", \"màgia\", 60):", calculaFesta("jardí amb piscina", "menú premium", "màgia", 60)));
        System.out.println(String.format(Locale.US, template, "Cas 3 (\"jardí amb piscina\", \"menú bàsic\", \"música en directe\", 40):", calculaFesta("jardí amb piscina", "menú bàsic", "música en directe", 40)));
        System.out.println(String.format(Locale.US, template, "Cas 4 (\"saló gran amb escenari\", \"menú premium\", \"música en directe\", 70):", calculaFesta("saló gran amb escenari", "menú premium", "música en directe", 70)));
        System.out.println(String.format(Locale.US, template, "Cas 5 (\"sala estàndard\", \"menú premium\", \"màgia\", 15):", calculaFesta("sala estàndard", "menú premium", "màgia", 15)));

    }
}
