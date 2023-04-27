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

public class RayonViewConsole extends AbstractViewConsole<Rayon>{


    protected void ajouter() {
        try {
            System.out.println("code rayon : ");
            String code = sc.nextLine();
            System.out.println("genre : ");
            String genre = sc.nextLine();
            Rayon r = new Rayon(code, genre);
            presenter.add(r);
        }catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au au menu des ouvrages");
        }
    }

    protected void retirer() {
        try {
            int choix = choixElt(ldatas);
            Rayon rayon = ldatas.get(choix - 1);
            presenter.remove(rayon);
            ldatas = presenter.getAll();//rafraichissement
            Utilitaire.affListe(ldatas);
        }
        catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au au menu des ouvrages");
        }
    }

    protected void rechercher() {
        /*try {
            System.out.println("code rayon : ");
            String idRay = sc.nextLine();
            presenter.search(idRay);
        }
        catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au au menu des ouvrages");
        }*/
    }

    protected void modifier() {
        try{
        int choix = choixElt(ldatas);
        Rayon r = ldatas.get(choix-1);

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

    protected void special() {
        try {
            int choix = choixElt(ldatas);
            Rayon r = ldatas.get(choix - 1);

            ((RayonPresenter)presenter).listerExemplaires(r);

        }catch (Exception e){
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au menu des ouvrages");
        }
    }
}

