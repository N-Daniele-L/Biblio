package Bibliotheque.mvp;

import Bibliotheque.metier.Auteur;
import Bibliotheque.metier.Lecteur;
import Bibliotheque.metier.Ouvrage;
import Bibliotheque.metier.Rayon;
import Bibliotheque.mvp.model.*;
import Bibliotheque.mvp.presenter.*;
import Bibliotheque.mvp.view.*;
import Bibliotheque.utilitaires.Utilitaire;

import java.util.Arrays;
import java.util.List;

public class GestBiblio {

    private DAOGenerique<Lecteur> lm;
    private ViewInterface<Lecteur> lv;
    private Presenter<Lecteur> lp;
    private DAOGenerique<Auteur> am;
    private ViewInterface<Auteur> av;
    private Presenter<Auteur> ap;

    private DAOGenerique<Ouvrage> om;
    private ViewInterface<Ouvrage> ov;
    private Presenter<Ouvrage> op;
    private DAOGenerique<Rayon> rm;
    private ViewInterface<Rayon> rv;
    private Presenter<Rayon> rp;


    public void gestion() {
        lm = new LecteurModelV2();
        lv = new LecteurViewConsole();
        lp = new LecteurPresenter(lm, lv);//création et injection de dépendance

        am = new AuteurModelV2();
        av = new AuteurViewConsole();
        ap = new AuteurPresenter(am, av);

        om = new OuvrageModelV2();
        ov = new OuvrageViewConsole();
        op = new OuvragePresenter(om, ov);

        rm = new RayonModelV2();
        rv = new RayonViewConsole();
        rp = new RayonPresenter(rm, rv);

        List<String> loptions = Arrays.asList("lecteurs", "auteurs", "ouvrages","rayon" , "fin");

        do {
            try {
                int ch = Utilitaire.choixListe(loptions);
                switch (ch) {
                    case 1:
                        lp.start();
                        break;
                    case 2:
                        ap.start();
                        break;
                    case 3:
                        op.start();
                        break;
                    case 4:
                        rp.start();
                        break;
                    case 5:
                        System.exit(0);
                        break;

                }
            } catch (Exception e) {
                System.err.println("Erreur : " + e.getMessage());
                System.out.println("Fin du programme");
                break;
            }
        } while (true);
    }

    public static void main(String[] args) {
        GestBiblio gb = new GestBiblio();
        gb.gestion();
    }
}
