package livres;

import java.time.LocalDate;

public class OuvrageVideo extends Ouvrage {

    private int dureeMinutes;
    private int tailleMb;

    public OuvrageVideo(String titre, Auteur auteur, LocalDate date, int nombreExemplaires, int dureeMinutes, int tailleMb) {
        super(titre, auteur, date, nombreExemplaires);
        setDureeMinutes(dureeMinutes);
        setTailleMb(tailleMb);
    }

    public void setDureeMinutes(int dureeMinutes) {
        if (dureeMinutes > 0) {
            this.dureeMinutes = dureeMinutes;
        } else {
            System.out.println("Durée invalide pour la vidéo : " + dureeMinutes);
        }
    }

    // Setter avec validation simple
    public void setTailleMb(int tailleMb) {
        if (tailleMb > 0) {
            this.tailleMb = tailleMb;
        } else {
            System.out.println("Taille invalide pour la vidéo : " + tailleMb);
        }
    }

    @Override
    public String toString() {
        // On appelle le toString() de la classe parente (Ouvrage) et on ajoute les infos vidéo
        return super.toString() + " [Vidéo: " + dureeMinutes + " min, " + tailleMb + " Mb]";
    }
}