package livres;

import java.util.Objects;

/**
 * Cours POO 1
 *
 * @author Julien.Brunet maj Jocelyn
 * @since H25
 */

public class Auteur {

    public static final String INCONNU = "Inconnu";

    private String prenom = NON CONNU;
    private String nom = NON CONNU;
    private Pays paysOrigine;

    public Auteur(String prenom, String nom, Pays paysOrigine) {
        setPrenom(prenom);
        setNom(nom);
        setPaysOrigine(paysOrigine);
    }

    public Auteur() {
        this(INCONNU, INCONNU,new Pays(INCONNU, "Inconnue"));
    }

    public String getPrenom() {
        return prenom;
    }

    private void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    private void setNom(String nom) {
        this.nom = nom;
    }

    public String getPaysOrigine() {
        return paysOrigine.getNom();
    }

    private void setPaysOrigine(Pays paysOrigine) {
        this.paysOrigine = paysOrigine;
    }

    @Override
    public String toString() {
        return prenom + " " + nom + " (origine : " + paysOrigine + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auteur)) return false;

        Auteur auteur = (Auteur) o;
        return prenom.equals(auteur.prenom) && nom.equals(auteur.nom) && Objects.equals(paysOrigine, auteur.paysOrigine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenom, nom, paysOrigine);
    }
}
