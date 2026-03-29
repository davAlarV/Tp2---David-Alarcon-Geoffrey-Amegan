package livres;

public class Pays {
    private String nom;
    private String codePays;

    public Pays(String nom, String codePays) {
        this.nom = nom;
        setCodePays(codePays);
    }

    public void setCodePays(String codePays) {
        if (codePays != null && codePays.length() == 3 && codePays.equals(codePays.toUpperCase())) {
            this.codePays = codePays;
        } else {
            throw new IllegalArgumentException("Le code pays doit être de 3 lettres majuscules (ex: CAN).");
        }
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() { return nom; }
    public String getCodePays() { return codePays; }
}