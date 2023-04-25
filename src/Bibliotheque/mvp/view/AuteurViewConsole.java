package Bibliotheque.mvp.view;

import Bibliotheque.metier.*;
import Bibliotheque.mvp.presenter.AuteurPresenter;
import Bibliotheque.utilitaires.Utilitaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Bibliotheque.utilitaires.Utilitaire.*;

public class AuteurViewConsole implements AuteurViewInterface{

    private AuteurPresenter presenter;
    private List<Auteur> laut;
    private Scanner sc = new Scanner(System.in);

    public AuteurViewConsole(){

    }
    @Override
    public void setPresenter(AuteurPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListDatas(List<Auteur> auteurs) {
        this.laut = auteurs;
        affListe(laut);
        menu();
    }



    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    @Override
    public void affList(List<Ouvrage> ouvr) {
        affListe(ouvr);
    }
    @Override
    public void afficheList(List<Livre> livr) {
        affListe(livr);
    }

    private void menu() {
        List options = new ArrayList<>(Arrays.asList("ajouter", "retirer", "rechercher","modifier","special","fin"));
        do {
            try {
                int ch2 = choixListe(options);

                switch (ch2) {
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
        try{
        System.out.println("nom : ");
        String nom = sc.nextLine();
        System.out.println("prenom : ");
        String prenom = sc.nextLine();
        System.out.println("nationalité : ");
        String natio = sc.nextLine();
        Auteur aut = new Auteur(nom, prenom, natio);
        presenter.addAuteur(aut);
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au au menu des auteurs");
        }
    }

    private void retirer() {
        try{
        int choix = choixElt(laut);
        Auteur auteur = laut.get(choix-1);
        presenter.removeAuteur(auteur);
        laut=presenter.getAll();//rafraichissement
        Utilitaire.affListe(laut);
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au au menu des auteurs");
        }
    }

    private void rechercher() {
        try{
        System.out.println("nom : ");
        String nom = sc.nextLine();
        System.out.println("prenom : ");
        String prenom = sc.nextLine();
        System.out.println("nationalité : ");
        String natio = sc.nextLine();
        presenter.search(nom,prenom,natio);
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au au menu des auteurs");
        }
    }

    private void modifier() {
        try {
        int choix = choixElt(laut);
        Auteur auteur = laut.get(choix-1);
        String nom = modifyIfNotBlank("nom",auteur.getNom());
        String prenom = modifyIfNotBlank("prenom",auteur.getPrenom());
        String natio = modifyIfNotBlank("nationalité", auteur.getNationalite());
        Auteur aut = new Auteur(nom,prenom,natio);
        presenter.update(aut);
        laut=presenter.getAll();//rafraichissement
        Utilitaire.affListe(laut);
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au au menu des auteurs");
        }
    }

    private void special() {

        int choix = choixElt(laut);
        Auteur auteur = laut.get(choix-1);
        do {
            try{
            System.out.println("1.Lister tout les ouvrages\n2.Lister les ouvrages par type\n3.Lister les ouvrages par livre\n4.Lister les ouvrages par genre\n5.menu principal");
            System.out.println("choix : ");
            int ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    presenter.listeAllOuvrage(auteur);
                    break;
                case 2:
                    presenter.listeAllOuvrageByType(auteur, TypeOuvrage.DVD);
                    break;
                case 3:
                    presenter.listeAllOuvrageByLivre(auteur,TypeLivre.BIOGRAPHIE);
                    break;
                case 4:
                    presenter.listeAllOuvrageByGenre(auteur,"");
                    break;
                case 5: return;
                default:
                    System.out.println("choix invalide recommencez ");
            }
            } catch (Exception e) {
                System.err.println("Erreur : " + e.getMessage());
                System.out.println("Retour au au menu des auteurs");
                break;
            }
        } while (true);
    }
}
