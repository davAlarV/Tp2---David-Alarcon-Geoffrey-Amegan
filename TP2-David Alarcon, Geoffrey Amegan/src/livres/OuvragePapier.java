package livres;

import java.time.LocalDate;

public class OuvragePapier extends Ouvrage {

    private int nombrePages;

    public OuvragePapier(String titre, Auteur auteur, LocalDate date, int nombreExemplaires, int nombrePages) {
        super(titre, auteur, date, nombreExemplaires);
        this.nombrePages = nombrePages;
    }

    public OuvragePapier(String titre, Auteur auteur) {
        super(titre, auteur);
        this.nombrePages = 0;
    }

    public int getNombrePages() {
        return nombrePages;
    }

    public void setNombrePages(int nombrePages) {
        if (nombrePages >= 0) {
            this.nombrePages = nombrePages;
        } else {
            System.out.println("Nombre de pages invalide: " + nombrePages);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " - PAPIER - " + nombrePages + " pages";
    }
}