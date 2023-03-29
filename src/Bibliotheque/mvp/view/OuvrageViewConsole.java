package Bibliotheque.mvp.view;

import Bibliotheque.metier.*;
import Bibliotheque.mvp.presenter.OuvragePresenter;
import Bibliotheque.utilitaires.Utilitaire;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Bibliotheque.utilitaires.Utilitaire.*;

public class OuvrageViewConsole implements OuvrageViewInterface{

    private OuvragePresenter presenter;
    private List<Ouvrage> louvr;
    private Scanner sc = new Scanner(System.in);
    OuvrageViewConsole(){

    }
    @Override
    public void setPresenter(OuvragePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListDatas(List<Ouvrage> ouvr) {
        this.louvr = ouvr;
        affListe(this.louvr);
        menu();
    }

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    @Override
    public void affList(List<Exemplaire> ex) {
        affListe(ex);
    }
    private void menu() {
        List options = new ArrayList<>(Arrays.asList("ajouter", "retirer", "rechercher","modifier","special","fin"));
        do {
            int ch = choixListe(options);

            switch (ch) {
                case 1:
                    ajouter();
                    break;
                case 2:
                    retirer();
                    break;
                case 3:
                    rechercher();
                    break;
                case 4:
                    modifier();
                    break;
                case 5:
                    special();
                    break;
                case 6:
                    return;
            }
        } while (true);
    }

    private void ajouter() {
        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        TypeLivre[] ttl = TypeLivre.values();
        List<TypeLivre> ltl = new ArrayList<>(Arrays.asList(ttl));

        System.out.println("titre : ");
        String titre = sc.nextLine();
        System.out.println("age minimum : ");
        int ageMin = sc.nextInt();
        sc.skip("");
        System.out.println("date de parution : ");
        String[] jma = sc.nextLine().split(" ");
        int j = Integer.parseInt(jma[0]);
        int m = Integer.parseInt(jma[1]);
        int a = Integer.parseInt(jma[2]);
        LocalDate dp = LocalDate.of(a, m, j);
        System.out.println("choix du type d'ouvrage : ");
        for (TypeOuvrage to: lto) {
            System.out.println("1) " + to);
        }
        int ito = sc.nextInt();
        TypeOuvrage to = lto.get(ito - 1);
        System.out.println("Prix location : ");
        double prix = sc.nextDouble();
        sc.skip("");
        System.out.println("langue : ");
        String langue = sc.nextLine();
        System.out.println("genre : ");
        String genre = sc.nextLine();

        switch (ito - 1){
            case 0 :
                System.out.println("nombres de pages: ");
                int nbrpg = sc.nextInt();
                System.out.println("choix du type de livre : ");
                for (TypeLivre tl: ltl) {
                    System.out.println("1) " + tl);
                }
                int itl = sc.nextInt();
                sc.skip("");
                System.out.println("isbn : ");
                String isbn = sc.nextLine();
                System.out.println("resumé : ");
                String resume = sc.nextLine();

                Ouvrage livr = new Livre(titre,ageMin,dp,prix,langue,genre,isbn,nbrpg,ltl.get(itl -1),resume);
                break;
            case 1 :
                System.out.println("code : ");
                long code = sc.nextLong();
                System.out.println("nombre de plages : ");
                byte nbrpl = sc.nextByte();
                System.out.println("durée totale : ");
                DateTimeFormatter parseFormat = DateTimeFormatter.ofPattern("H:mm:ss");
                String timeString = sc.nextLine();
                LocalTime time = LocalTime.parse(timeString, parseFormat);
                Ouvrage cd = new CD(titre,ageMin,dp,prix,langue,genre,code,nbrpl,time);
            case 2 :
                System.out.println("code : ");
                long code2 = sc.nextLong();
                System.out.println("nombre bonus : ");
                byte nbrbns = sc.nextByte();
                System.out.println("durée totale : ");
                DateTimeFormatter parseFormat2 = DateTimeFormatter.ofPattern("H:mm:ss");
                String timeString2 = sc.nextLine();
                LocalTime time2 = LocalTime.parse(timeString2, parseFormat2);
                Ouvrage dvd = new DVD(titre,ageMin,dp,prix,langue,genre,code2,time2,nbrbns);
        }
    }

    private void retirer() {
        int choix = choixElt(louvr);
        Ouvrage ouvrage = louvr.get(choix-1);
        presenter.removeOuvrage(ouvrage);
        louvr=presenter.getAll();//rafraichissement
        Utilitaire.affListe(louvr);
    }

    private void rechercher() {
        System.out.println("titre : ");
        String titre = sc.nextLine();
        presenter.search(titre);
    }

    private void modifier() {
        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        TypeLivre[] ttl = TypeLivre.values();
        List<TypeLivre> ltl = new ArrayList<>(Arrays.asList(ttl));

        int choix = choixElt(louvr);
        Ouvrage o = louvr.get(choix-1);

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
            //TODO cast les ouvrages en livre,cd,dvd aucune idée de comment faire
            case 0:
                int nbrpg = sc.nextInt();
                for (TypeLivre tl : ltl) {
                    System.out.println("1) " + tl);
                }
                int itl = sc.nextInt();

                String isbn = sc.nextLine();
                String resume = sc.nextLine();

                Ouvrage livr = new Livre(titre, ageMin, dp, prix, langue, genre, isbn, nbrpg, ltl.get(itl - 1), resume);
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
        }
    }

    private void special() {
        int choix = choixElt(louvr);
        Ouvrage o = louvr.get(choix-1);

        do {
            List<String> options = new ArrayList<>(Arrays.asList("Lister exemplaires", "Lister exemplaires en location", "fin"));

            int ch = Utilitaire.choixListe(options);

            switch (ch) {
                case 1:
                    presenter.listerExemplaires(o);
                    break;
                case 2:
                    presenter.listerExemplairesLocation(o);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (true);


    }

}
