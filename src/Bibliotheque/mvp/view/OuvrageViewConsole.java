package Bibliotheque.mvp.view;

import Bibliotheque.metier.*;
import Bibliotheque.mvp.presenter.OuvragePresenter;
import Bibliotheque.utilitaires.LivreFactory;
import Bibliotheque.utilitaires.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Bibliotheque.utilitaires.Utilitaire.*;

public class OuvrageViewConsole extends AbstractViewConsole<Ouvrage>{



    protected void ajouter() {
        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        int choix = Utilitaire.choixListe(lto);
        Ouvrage o = null;
        List<OuvrageFactory> lof = new ArrayList<>(Arrays.asList(new LivreFactory(),new CDFactory(),new DVDFactory()));
        o = lof.get(choix-1).create();
        presenter.add(o);
        //TODO attribuer auteurs, les auteur sont triés par odre de nom et prénom, empêcher doublons
    }

    protected void retirer() {
        try {
            int choix = choixElt(ldatas);
            Ouvrage ouvrage = ldatas.get(choix - 1);
            presenter.remove(ouvrage);
            ldatas = presenter.getAll();//rafraichissement
            Utilitaire.affListe(ldatas);
        }
        catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au au menu des ouvrages");
        }
    }

    protected void rechercher() {
    /*    try {
            System.out.println("titre : ");
            String titre = sc.nextLine();
            presenter.search(titre);
        }
        catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au au menu des ouvrages");
        }*/
    }

    protected void modifier() {
        try{
        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        TypeLivre[] ttl = TypeLivre.values();
        List<TypeLivre> ltl = new ArrayList<>(Arrays.asList(ttl));

        int choix = choixElt(ldatas);
        Ouvrage o = ldatas.get(choix-1);

        String titre = modifyIfNotBlank("nom",o.getTitre());
        int ageMin = Integer.parseInt(modifyIfNotBlank("age", String.valueOf(o.getAgeMin())));
        String date = modifyIfNotBlank("date de parution",getDateFrench(o.getDateParution()));
        String[] jma = sc.nextLine().split(" ");
        int j = Integer.parseInt(jma[0]);
        int m = Integer.parseInt(jma[1]);
        int a = Integer.parseInt(jma[2]);
        LocalDate dp = LocalDate.of(a, m, j);
        System.out.println("choix du type d'ouvrage : ");
        for (TypeOuvrage to : lto) {
            System.out.println("1) " + to);
        }
        int ito = sc.nextInt();
        lto.get(ito - 1);
        TypeOuvrage to = TypeOuvrage.valueOf(modifyIfNotBlank("type d'ouvrage", String.valueOf(o.getTo())));
        double prix = Double.parseDouble(modifyIfNotBlank("prix", String.valueOf(o.getPrixLocation())));
        String langue = modifyIfNotBlank("langue",o.getLangue());
        String genre = modifyIfNotBlank("genre",o.getGenre());

        switch (ito - 1) {
            case 0:
                int nbrpg = sc.nextInt();
                for (TypeLivre tl : ltl) {
                    System.out.println(j +") " + tl);
                }
                int itl = sc.nextInt();

                String isbn = sc.nextLine();
                String resume = sc.nextLine();

                Ouvrage livr = new Livre(titre, ageMin, dp, prix, langue, genre, isbn, nbrpg, ltl.get(itl - 1), resume);
                presenter.add(livr);
                break;
            case 1:
                System.out.println("code : ");
                long code = sc.nextLong();
                System.out.println("nombre de plages : ");
                byte nbrpl = sc.nextByte();
                System.out.println("durée totale : ");
                DateTimeFormatter parseFormat = DateTimeFormatter.ofPattern("H:mm:ss");
                String timeString = sc.nextLine();
                LocalTime time = LocalTime.parse(timeString, parseFormat);
                Ouvrage cd = new CD(titre, ageMin, dp, prix, langue, genre, code, nbrpl, time);
                presenter.add(cd);
            case 2:
                System.out.println("code : ");
                long code2 = sc.nextLong();
                System.out.println("nombre bonus : ");
                byte nbrbns = sc.nextByte();
                System.out.println("durée totale : ");
                DateTimeFormatter parseFormat2 = DateTimeFormatter.ofPattern("H:mm:ss");
                String timeString2 = sc.nextLine();
                LocalTime time2 = LocalTime.parse(timeString2, parseFormat2);
                Ouvrage dvd = new DVD(titre, ageMin, dp, prix, langue, genre, code2, time2, nbrbns);
                presenter.add(dvd);
        }
        } catch (NumberFormatException e){
            System.err.println("Erreur date suivre ce model : \"xx xx xx\"");
            System.out.println("Retour au au menu des ouvrages");
        }
        catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au au menu des ouvrages");
        }
    }

    protected void special() {
        int choix = choixElt(ldatas);
        Ouvrage o = ldatas.get(choix-1);

        do {
            try{
            List<String> options = new ArrayList<>(Arrays.asList("Lister exemplaires", "Lister exemplaires en location", "fin"));

            int ch = Utilitaire.choixListe(options);

            switch (ch) {
                case 1:
                    ((OuvragePresenter)presenter).listerExemplaires(o);
                    break;
                case 2:
                    ((OuvragePresenter)presenter).listerExemplairesLocation(o);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("choix invalide recommencez ");
            }
            }catch (Exception e){
                System.err.println("Erreur : " + e.getMessage());
                System.out.println("Retour au menu des ouvrages");
                break;
            }
        } while (true);


    }

}
