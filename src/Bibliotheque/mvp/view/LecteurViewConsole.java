package Bibliotheque.mvp.view;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Lecteur;
import Bibliotheque.mvp.presenter.LecteurPresenter;
import Bibliotheque.utilitaires.Utilitaire;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Bibliotheque.utilitaires.Utilitaire.*;

public class LecteurViewConsole implements LecteurViewInterface {
    private LecteurPresenter presenter;
    private List<Lecteur> llec;
    private Scanner sc = new Scanner(System.in);

    public LecteurViewConsole() {

    }

    @Override
    public void setPresenter(LecteurPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListDatas(List<Lecteur> lecteurs) {
        this.llec = lecteurs;
        affListe(llec);
        menu();
    }

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    @Override
    public void affList(List<Exemplaire> lex) {
        affListe(lex);
    }

    public void menu() {
        List options = new ArrayList<>(Arrays.asList("ajouter", "retirer", "rechercher","modifier","special","fin"));
        do {
            try{
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
            }catch (Exception e){
                System.err.println("Erreur : " + e.getMessage());
                System.out.println("Retour au menu principal");
                break;
            }
        } while (true);
    }

    private void rechercher() {
        try{
        System.out.println("numLecteur : ");
        int idLecteur = sc.nextInt();
        presenter.search(idLecteur);
        }catch (Exception e){
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au menu des lecteurs");
        }
    }

    private void modifier() {
        try{
        int choix = choixElt(llec);
        Lecteur l = llec.get(choix-1);
        String nom = modifyIfNotBlank("nom",l.getNom());
        String prenom = modifyIfNotBlank("nom",l.getNom());
        String date = modifyIfNotBlank("date de naissance",getDateFrench(l.getDn()));
        //try {
            String[] jma = date.split(" ");
            int j = Integer.parseInt(jma[0]);
            int m = Integer.parseInt(jma[1]);
            int a = Integer.parseInt(jma[2]);
            LocalDate dn = LocalDate.of(a, m, j);
        //}catch (Exception)
        String adr = modifyIfNotBlank("adresse",l.getAdresse());
        String mail= modifyIfNotBlank("mail",l.getMail());
        String tel =modifyIfNotBlank("tel",l.getTel());
        Lecteur lec = new Lecteur(l.getNumlecteur(), nom, prenom, dn, adr, mail, tel);
        presenter.update(lec);
        llec=presenter.getAll();//rafraichissement
        Utilitaire.affListe(llec);
        }catch (Exception e){
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au au menu des lecteurs");
        }
    }

    private void retirer() {
        try{
        int choix = choixElt(llec);
        Lecteur lecteur = llec.get(choix-1);
        presenter.removeLecteur(lecteur);
        llec=presenter.getAll();//rafraichissement
        Utilitaire.affListe(llec);
        }catch (Exception e){
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au au menu des lecteurs");
        }
    }


    private void ajouter() {
        try {
            System.out.println("nom ");
            String nom = sc.nextLine();
            System.out.println("prénom ");
            String prenom = sc.nextLine();
            System.out.println("date de naissance");
            String[] jma = sc.nextLine().split(" ");
            int j = Integer.parseInt(jma[0]);
            int m = Integer.parseInt(jma[1]);
            int a = Integer.parseInt(jma[2]);
            LocalDate dn = LocalDate.of(a, m, j);
            System.out.println("adresse");
            String adr = sc.nextLine();
            System.out.println("mail");
            String mail = sc.nextLine();
            System.out.println("tel ");
            String tel = sc.nextLine();
            Lecteur lec = new Lecteur(0, nom, prenom, dn, adr, mail, tel);
            presenter.addLecteur(lec);
            llec = presenter.getAll();//rafraichissement
            Utilitaire.affListe(llec);
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au au menu des lecteurs");
        }
    }
    private void special() {
        int choix =  choixElt(llec);
        Lecteur lec = llec.get(choix-1);
            do {
                try{
                System.out.println("1.Exemplaire en location\n2.Exemplaires loués\n3.menu principal");
                System.out.println("choix : ");
                int ch = sc.nextInt();
                sc.skip("\n");
                switch (ch) {
                    case 1:
                        presenter.exemplairesEnLocation(lec);
                        break;
                    case 2:
                        presenter.exemplairesLoues(lec);
                        break;
                    case 3: return;
                    default:
                        System.out.println("choix invalide recommencez ");
                }
                }catch (Exception e) {
                    System.err.println("Erreur : " + e.getMessage());
                    System.out.println("Retour au au menu des lecteurs");
                }
            } while (true);


        }
    }


