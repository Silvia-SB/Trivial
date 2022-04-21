import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Partida {

    public static void main(String[] args) {
        int encerts,puntuacio;
        ArrayList<Pregunta> preguntes = new ArrayList<Pregunta>(10);

        crearPreguntes(preguntes);

        Scanner input = new Scanner(System.in);

        System.out.print("Quants jugadors voldreu jugar? ");
        int quants = input.nextInt();

        ArrayList<Jugador> taulaPuntuacio = new ArrayList<Jugador>(quants);

        int torn = 0;

        while (torn < quants) {

            boolean resultat;
            encerts = 0; puntuacio = 0;

            System.out.print("Quin és el teu nom? ");
            String name = input.next();

            for (Pregunta pregunta : preguntes) {
                System.out.print(pregunta.getAfirmacio());
                System.out.print("\n" + "Quina és la teva resposta " + name + " ? true(cert) o false(fals): ");
                String resposta = input.next();
                resultat = Boolean.parseBoolean(resposta);

                if (pregunta.isValidarAfirmacio() == resultat) {
                    encerts++;
                    puntuacio = pregunta.getDificultat() + puntuacio;
                }
            }

            System.out.print("Número d'encerts: " + encerts + "\n" + "Puntuació: " + puntuacio + "\n" +
                    "Percentatge d'encerts: " + percentatge(encerts) + "%");

            Jugador usuari = new Jugador(name, puntuacio);
            taulaPuntuacio.add(usuari);
            torn++;
            System.out.println();
        }

        System.out.print("Ranking final del joc: ");
        Collections.sort(taulaPuntuacio); //Ordena els jugadors de més puntuació a menys
        System.out.print(taulaPuntuacio);

        input.close();
    }

    private static int percentatge(int encerts) {
        return encerts * 100/ 10 ;
    }

    private static void crearPreguntes(ArrayList<Pregunta> preguntes) {

        Pregunta pregunta1 = new Pregunta("L'home va trepitjar la Lluna en l'any 1969", true, 4);
        Pregunta pregunta2 = new Pregunta("La illa que va servir de presó per a Napoleó després de la seva derrota a la batalla de Waterloo va ser Ibiza", false, 5);
        Pregunta pregunta3 = new Pregunta("John Travolta interpretava en la película Grease a Danny Zuko", true, 3);
        Pregunta pregunta4 = new Pregunta("El famós cantant de Queen va ser Bertin Osborne", false, 2);
        Pregunta pregunta5 = new Pregunta("El personatge Jack Sparrow pertany a la saga de Pirates del Carib", true, 1);
        Pregunta pregunta6 = new Pregunta("Pablo Picasso va pintar el Guernica", true, 3);
        Pregunta pregunta7 = new Pregunta("La poesía Haiko és originaria de la China", false, 5);
        Pregunta pregunta8 = new Pregunta("L'acrofobia és la por o la fobia a les alçades", true, 4);
        Pregunta pregunta9 = new Pregunta("Marie Curie va ser famosa per descubrir l'LSD", false, 2);
        Pregunta pregunta10 = new Pregunta("Cobi és un virus", false, 1);


        preguntes.add(pregunta1);
        preguntes.add(pregunta2);
        preguntes.add(pregunta3);
        preguntes.add(pregunta4);
        preguntes.add(pregunta5);
        preguntes.add(pregunta6);
        preguntes.add(pregunta7);
        preguntes.add(pregunta8);
        preguntes.add(pregunta9);
        preguntes.add(pregunta10);


        //Collections.shuffle(preguntes); //per fer l'ordenació de les preguntes de manera random

        Collections.sort(preguntes); //per fer l'ordenació de les preguntes segons la dificultat (de menys a més)

    }
}
