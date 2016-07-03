package exercise.comparatorAndComparable;

/**
 * Created by HOME on 7/4/2016.
 */
public class Pisica implements Comparable<Pisica> {
    private String culoare;
    private String nume;
    private int varsta;

    public Pisica(String culoare, String nume, int varsta){
        this.nume=nume;
        this.culoare=culoare;
        this.varsta=varsta;
    }
    public Pisica(){}

    public int compareTo(Pisica pisica){
        return this.varsta-pisica.varsta;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
