package Nivell1Ex1;

public abstract class Instrument {
    protected String nom = "";
    protected float preu = 0f;

    public Instrument(String nom, float preu) {
        this.nom = nom;
        this.preu = preu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public abstract String tocar();

    @Override
    public String toString() {
        return "nom: " + nom + ", preu:" + preu + "€";
    }

    // Tot i que està implementada al final de la classe, es carrega primer a la memòria
    static {
        System.out.println("Classe Instrument carregada a la memòria!");
    }
}
