package Bibliotheque.mvp;

import Bibliotheque.mvp.model.AuteurModel;
import Bibliotheque.mvp.model.DAOAuteur;
import Bibliotheque.mvp.model.DAOLecteur;
import Bibliotheque.mvp.model.LecteurModel;
import Bibliotheque.mvp.presenter.AuteurPresenter;
import Bibliotheque.mvp.presenter.LecteurPresenter;
import Bibliotheque.mvp.view.AuteurViewConsole;
import Bibliotheque.mvp.view.AuteurViewInterface;
import Bibliotheque.mvp.view.LecteurViewConsole;
import Bibliotheque.mvp.view.LecteurViewInterface;
import Bibliotheque.utilitaires.Utilitaire;

import java.util.Arrays;
import java.util.List;

public class GestBiblio {

    private DAOLecteur lm;
    private LecteurViewInterface lv;
    private LecteurPresenter lp;
    private DAOAuteur am;
    private AuteurViewInterface av;
    private AuteurPresenter ap;



    public void gestion(){
        lm = new LecteurModel();
        lv = new LecteurViewConsole();
        lp = new LecteurPresenter(lm, lv);//création et injection de dépendance

        am = new AuteurModel();
        av = new AuteurViewConsole();
        ap = new AuteurPresenter(am,av);

        List<String> loptions = Arrays.asList("auteurs","fin");
        do {
            int ch = Utilitaire.choixListe(loptions);
            switch (ch){
                case 1: ap.start();
                    break;
                case 2 : System.exit(0);
            }
        }while(true);
    }
    public static void main(String[] args) {
        GestBiblio gb = new GestBiblio();
        gb.gestion();
    }
}
