package Bibliotheque.mvp.view;

import Biblio.TypeLivre;
import Bibliotheque.metier.Auteur;
import Bibliotheque.metier.TypeOuvrage;
import Bibliotheque.mvp.presenter.AuteurPresenter;
import Bibliotheque.utilitaires.Utilitaire;

import java.util.*;

import static Bibliotheque.utilitaires.Utilitaire.*;

public class AuteurViewConsole extends AbstractViewConsole<Auteur> {



    protected void ajouter() {
        try{
        System.out.println("nom : ");
        String nom = sc.nextLine();
        System.out.println("prenom : ");
        String prenom = sc.nextLine();
        System.out.println("nationalité : ");
        String natio = sc.nextLine();
        Auteur aut = new Auteur(nom, prenom, natio);
        presenter.add(aut);
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au au menu des auteurs");
        }
    }

    protected void retirer() {
        try{
        int choix = choixElt(ldatas);
        Auteur auteur = ldatas.get(choix-1);
        presenter.remove(auteur);
        ldatas=presenter.getAll();//rafraichissement
        Utilitaire.affListe(ldatas);
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au au menu des auteurs");
        }
    }

    protected void rechercher() {
        try{
        System.out.println("nom : ");
        String nom = sc.nextLine();
        System.out.println("prenom : ");
        String prenom = sc.nextLine();
        System.out.println("nationalité : ");
        String natio = sc.nextLine();
        //presenter.search(nom,prenom,natio);
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au au menu des auteurs");
        }
    }

    protected void modifier() {
        try {
        int choix = choixElt(ldatas);
        Auteur auteur = ldatas.get(choix-1);
        String nom = modifyIfNotBlank("nom",auteur.getNom());
        String prenom = modifyIfNotBlank("prenom",auteur.getPrenom());
        String natio = modifyIfNotBlank("nationalité", auteur.getNationalite());
        Auteur aut = new Auteur(nom,prenom,natio);
        presenter.update(aut);
        ldatas=presenter.getAll();//rafraichissement
        Utilitaire.affListe(ldatas);
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            System.out.println("Retour au au menu des auteurs");
        }
    }

    protected void special() {

        int choix = choixElt(ldatas);
        Auteur auteur = ldatas.get(choix-1);
        do {
            try{
            System.out.println("1.Lister tout les ouvrages\n2.Lister les ouvrages par type\n3.Lister les ouvrages par livre\n4.Lister les ouvrages par genre\n5.menu principal");
            System.out.println("choix : ");
            int ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    ((AuteurPresenter)presenter).listeAllOuvrage(auteur);
                    break;
                /*case 2:
                    ((AuteurPresenter)presenter).listeAllOuvrageByType(auteur, TypeOuvrage.DVD);
                    break;
                case 3:
                    ((AuteurPresenter)presenter).listeAllOuvrageByLivre(auteur, TypeLivre.BIOGRAPHIE);
                    break;
                case 4:
                    ((AuteurPresenter)presenter).listeAllOuvrageByGenre(auteur,"");
                    break;*/
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
