package Bibliotheque.mvp.view;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Ouvrage;
import Bibliotheque.metier.Rayon;
import Bibliotheque.mvp.presenter.RayonPresenter;
import Bibliotheque.utilitaires.Utilitaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Bibliotheque.utilitaires.Utilitaire.*;

public class RayonViewConsole implements RayonViewInterface{

    private RayonPresenter presenter;
    private List<Rayon> lray;
    private Scanner sc = new Scanner(System.in);
    public RayonViewConsole(){

    }
    @Override
    public void setPresenter(RayonPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListDatas(List<Rayon> rayons) {
        this.lray = rayons;
        affListe(this.lray);
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

    private void ajouter() {
        try {
            System.out.println("code rayon : ");
            String code = sc.nextLine();
            System.out.println("genre : ");
            String genre = sc.nextLine();
            Rayon r = new Rayon(code, genre);
            presenter.addRayon(r);
        }catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au au menu des ouvrages");
        }
    }

    private void retirer() {
        try {
            int choix = choixElt(lray);
            Rayon rayon = lray.get(choix - 1);
            presenter.removeRayon(rayon);
            lray = presenter.getAll();//rafraichissement
            Utilitaire.affListe(lray);
        }
        catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au au menu des ouvrages");
        }
    }

    private void rechercher() {
        try {
            System.out.println("code rayon : ");
            String idRay = sc.nextLine();
            presenter.search(idRay);
        }
        catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au au menu des ouvrages");
        }
    }

    private void modifier() {
        try{
        int choix = choixElt(lray);
        Rayon r = lray.get(choix-1);

        String idRay = modifyIfNotBlank("nom",r.getCodeRayon());
        String genre = modifyIfNotBlank("age", String.valueOf(r.getGenre()));
        Rayon rayon = new Rayon(idRay,genre);
        presenter.update(rayon);
        }
        catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au au menu des ouvrages");
        }
    }

    private void special() {
        try {
            int choix = choixElt(lray);
            Rayon r = lray.get(choix - 1);

            presenter.listerExemplaires(r);

        }catch (Exception e){
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au menu des ouvrages");
        }
    }
}

