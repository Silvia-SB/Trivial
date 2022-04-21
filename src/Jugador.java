public class Jugador implements Comparable {
    String nom;
    int puntuacio;

    public Jugador(String nom, int puntuacio) {
        this.nom = nom;
        this.puntuacio  = puntuacio;
    }

    public String getNom() {
        return nom;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nom='" + nom + '\'' +
                ", puntuacio=" + puntuacio +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        int comparacio = ((Jugador)o).getPuntuacio();
        return comparacio - this.puntuacio;
    }
}
