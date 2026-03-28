package livres;

import java.util.ArrayList;
import java.util.List;

public class Serie {

    private String nom;
    private List<Ouvrage> ouvrages = new ArrayList<>();

    public Serie(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Ouvrage> getOuvrages() {
        return ouvrages;
    }

    public void ajouterOuvrage(Ouvrage ouvrage) {
        if (ouvrage != null){
            ouvrages.add(ouvrage);
        }
    }

    public boolean retirerOuvrage(Ouvrage ouvrage) {
        return ouvrages.remove(ouvrage);
    }

    @Override
    public String toString() {
        return "Serie " + nom + " (" + ouvrages.size() + " ouvrage(s)): " + ouvrages;
    }

}
