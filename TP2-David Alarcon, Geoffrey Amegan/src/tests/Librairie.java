package tests;

import livres.*;

import java.util.ArrayList;
import java.util.List;

public class Librairie {
    private List<Auteur> auteurs  = new ArrayList<>();
    private List<Ouvrage> ouvrages = new ArrayList<>();

    public Librairie(){
        Pays canada = new Pays("Canada", "CAN");
        Auteur albertine = new Auteur("Albertine", "Tremblay", canada);
        Pays usa = new Pays("Etats-Unis", "USA");
        Auteur john = new Auteur("John", "Smith", usa);
        Pays suisse = new Pays("Suisse", "SUI");
        Auteur jean = new Auteur("Jean", "Némarre", suisse);
        auteurs.add(albertine);
        auteurs.add(john);
        auteurs.add(jean);

        ouvrages.add(new OuvragePapier("Titre 1", john));
        ouvrages.add(new OuvragePapier("Titre 2", albertine));
        ouvrages.add(new OuvragePapier("Titre 3", john));
        ouvrages.add(new OuvragePapier("Titre 4", john));
        ouvrages.add(new OuvragePapier("Titre 5", albertine));
        ouvrages.add(new OuvragePapier("Titre 6", john));
        ouvrages.add(new OuvragePapier("Titre 7", john));
        ouvrages.add(new OuvragePapier("Titre 8", albertine)); // OuvrageVideo - à compléter
        ouvrages.add(new OuvrageAudio("Titre 9", john));
        ouvrages.add(new OuvragePapier("Titre 10", jean));
    }

    public List<Auteur> getAuteurs() {
        return auteurs;
    }

    public List<Ouvrage> getOuvrages() {
        return ouvrages;
    }

    public List<Ouvrage> trouverOuvrages(Auteur auteur) {
        //ATTENTION il faut implémenter equals dans auteur pour que ca marche!!!!!
        List<Ouvrage> trouves = new ArrayList<>();
        for (Ouvrage ouvrage : ouvrages) {
            if (ouvrage.getAuteur().equals(auteur)) {
                trouves.add(ouvrage);
            }
        }

        return trouves;
    }
}