public class Pregunta implements Comparable {

    String afirmacio;
    boolean validarAfirmacio;
    int dificultat;
    public Pregunta (String afirmacio,boolean validarAfirmacio,int dificultat){
        this.afirmacio = afirmacio;
        this.validarAfirmacio = validarAfirmacio;
        this.dificultat = dificultat;
    }

    public String getAfirmacio() {
        return afirmacio;
    }

    public boolean isValidarAfirmacio() {
        return validarAfirmacio;
    }

    public int getDificultat() {
        return dificultat;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "afirmació='" + afirmacio + '\'' +
                ", validarAfirmació=" + validarAfirmacio +
                ", dificultat=" + dificultat +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Pregunta){
            if (this.getDificultat() < ((Pregunta) o).getDificultat()){
                return -1;
            }
            else if (this.getDificultat() > ((Pregunta) o).getDificultat())
                return 1;
        }
        return 0;
    }
}
