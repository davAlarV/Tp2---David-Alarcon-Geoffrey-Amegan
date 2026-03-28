package livres;

import java.time.LocalDate;

public class OuvrageAudio extends Ouvrage {

    public enum Format {
        NUMERIQUE, ANALOGIQUE
    }

    private int dureeMinutes;
    private Format format;

    public OuvrageAudio(String titre, Auteur auteur, LocalDate date, int nombreExemplaires,
                        int dureeMinutes, Format format) {
        super(titre, auteur, date, nombreExemplaires);
        this.dureeMinutes = dureeMinutes;
        this.format = format;
    }

    public OuvrageAudio(String titre, Auteur auteur) {
        super(titre, auteur);
        this.dureeMinutes = 0;
        this.format = Format.NUMERIQUE;
    }

    public int getDureeMinutes() {
        return dureeMinutes;
    }

    public void setDureeMinutes(int dureeMinutes) {
        if (dureeMinutes >= 0) {
            this.dureeMinutes = dureeMinutes;
        } else {
            System.out.println("Durée invalide: " + dureeMinutes);
        }
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return super.toString() + " - AUDIO - " + dureeMinutes + " min. (" + format + ")";
    }
}