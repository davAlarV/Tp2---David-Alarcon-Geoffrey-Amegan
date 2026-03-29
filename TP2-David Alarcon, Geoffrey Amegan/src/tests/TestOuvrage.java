package tests;

import java.time.LocalDate;
import java.util.List;

import livres.Auteur;
import livres.Ouvrage;
import livres.OuvrageAudio;
import livres.OuvragePapier;
import livres.Serie;
import livres.Pays;

/**
 * CoursPOO 1
 *
 * @author Julien.Brunet màj Jocelyn
 * @since H25
 */
public class TestOuvrage {

    public static void main(String[] args) {
        TestOuvrage test = new TestOuvrage();
        test.testOuvrages();
        test.testTrouver();
        test.testSerie(); // <-- nouveau
    }


    public void testOuvrages() {
        //Deux auteurs deja prets pour les tests...
        Auteur albertine = new Auteur("Albertine", "Tremblay", new Pays("Canada", "CAN"));
        Auteur john = new Auteur("John", "Smith", new Pays("Etats-Unis", "USA"));

        //Voici une partie des tests! Il faut en ajouter, pour les fonctionnalités non testées!
        System.out.println("-----Test des constructeurs d'ouvrage et des diverses validations-----------");
        Ouvrage livreA = new OuvragePapier("Titre assez long", john);
        System.out.println(livreA);
        Ouvrage livreB = new OuvragePapier("Ti", john);
        System.out.println(livreB);
        Ouvrage livreC = new OuvragePapier(null, john);
        System.out.println(livreC);

        //bibliotheque.Auteur null et valeur par défaut de l'bibliotheque.Auteur
        Ouvrage livreA1 = new OuvragePapier("Titre assez long", null);
        System.out.println(livreA1);
        //bibliotheque.Auteur fonctionnel
        Ouvrage livre1 = new OuvragePapier("Tout va bien", albertine);
        System.out.println(livre1);

        //Date null et valeur par défaut de la date
        livre1.setDate(null);
        System.out.println(livre1);
        livre1.setDate(LocalDate.now().minusYears(5));
        System.out.println(livre1);

        //Test de la validation sur le nb d'exemplaires (valide et non valide)
        Ouvrage livre2 = new OuvrageAudio("Tout va bien", albertine, LocalDate.now(), -10, 90, OuvrageAudio.Format.NUMERIQUE);
        System.out.println(livre2);

        livre2 = new OuvragePapier("Tout va bien", albertine, LocalDate.now(), 20, 300);
        System.out.println(livre2);

        System.out.println("\n-----Tests des méthodes acheter et vendre-----------");

        Ouvrage livre3 = new OuvragePapier("Musique du hasard", new Auteur("Paul", "Auster", new Pays("Etats-Unis", "USA")), LocalDate.now(), 5, 250);
        System.out.println(livre3);

        livre3.acheter(5);
        System.out.println(livre3);

        System.out.println("On peut vendre 8 livres? " + livre3.vendre(8));
        System.out.println(livre3);

        System.out.println("On peut vendre 10 livres? " + livre3.vendre(10));
        System.out.println(livre3);

        Ouvrage livre4 = new OuvragePapier("Test", new Auteur("A", "B", new Pays("Etats-Unis", "USA")), LocalDate.now(), 5, 100);

        System.out.println("\n-----Tests de la  méthode equals()-----------");
        //Deux ouvrages égaux
        Ouvrage livre5 = new OuvragePapier("Test", new Auteur("A", "B", new Pays("Etats-Unis", "USA")), null, 5, 100);
        Ouvrage livre6 = new OuvragePapier("Test", new Auteur("A", "B", new Pays("Etats-Unis", "USA")), LocalDate.now(), 10, 200);
        //Un qui ne l'est pas
        Ouvrage livre7 = new OuvragePapier("Test", new Auteur("Z", "B", new Pays("Etats-Unis", "USA")), LocalDate.now(), 5, 100);

        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + livre4.equals(livre5));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + livre4.equals(livre6));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(livre7));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(john));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(null));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals("Test"));

        System.out.println("\n-----Tests des sous-classes OuvragePapier et OuvrageAudio-----------");

        //Test OuvragePapier
        OuvragePapier papier = new OuvragePapier("Les Misérables", albertine, LocalDate.now(), 10, 1500);
        System.out.println(papier);
        papier.setNombrePages(-5); // invalide
        papier.setNombrePages(200); // valide
        System.out.println(papier);

        //Test OuvrageAudio
        OuvrageAudio audio = new OuvrageAudio("Le Petit Prince", john, LocalDate.now(), 5, 120, OuvrageAudio.Format.NUMERIQUE);
        System.out.println(audio);
        audio.setDureeMinutes(-10); // invalide
        audio.setDureeMinutes(90);  // valide
        audio.setFormat(OuvrageAudio.Format.ANALOGIQUE);
        System.out.println(audio);
    }


    private void testTrouver() {
        Librairie bibliotheque = new Librairie();
        Auteur john = bibliotheque.getAuteurs().get(1);

        System.out.println("\n-----Test de votre méthode trouverOuvrage-----------");
        List<Ouvrage> resultat = bibliotheque.trouverOuvrages(new Auteur("Albertine", "Tremblay", new Pays("Canada", "CAN")));
        System.out.println("Livres de albertine: " + resultat);

        resultat = bibliotheque.trouverOuvrages(john);
        System.out.println("Livres de john: " + resultat);

        resultat = bibliotheque.trouverOuvrages(new Auteur("Jacques", "Beaulieu", new Pays("France", "FRA")));
        System.out.println("Livres de Jacques: " + resultat);
    }


    // NOUVEAU - tests de la classe Serie
    private void testSerie() {
        //Deux auteurs deja prets pour les tests...
        Auteur albertine = new Auteur("Albertine", "Tremblay", new Pays("Canada", "CAN"));
        Auteur john = new Auteur("John", "Smith", new Pays("Etats-Unis", "USA"));

        //On utilise les sous-classes maintenant que Ouvrage est abstraite
        Ouvrage livre1 = new OuvragePapier("Tout va bien", albertine);
        Ouvrage livre2 = new OuvrageAudio("Musique du hasard", john);
        Ouvrage livre3 = new OuvragePapier("Titre assez long", john);

        System.out.println("\n-----Test de la classe Serie-----------");

        //Créer une série vide
        Serie serie = new Serie("Roman");
        System.out.println("Série vide: " + serie);

        //Ajouter des ouvrages à la série
        serie.ajouterOuvrage(livre1);
        serie.ajouterOuvrage(livre2);
        serie.ajouterOuvrage(livre3);
        System.out.println("Après ajout de 3 ouvrages: " + serie);

        //Tenter d'ajouter null (ne doit pas être ajouté)
        serie.ajouterOuvrage(null);
        System.out.println("Après ajout null: " + serie);

        //Retirer un ouvrage existant
        System.out.println("Retirer livre2: " + serie.retirerOuvrage(livre2)); // true
        System.out.println("Après retrait: " + serie);

        //Tenter de retirer un ouvrage qui n'est plus dans la série
        System.out.println("Retirer livre2 de nouveau: " + serie.retirerOuvrage(livre2)); // false
    }


}