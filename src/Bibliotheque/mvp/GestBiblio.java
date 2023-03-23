package Bibliotheque.mvp;

import Bibliotheque.mvp.model.DAOLecteur;
import Bibliotheque.mvp.model.LecteurModel;
import Bibliotheque.mvp.presenter.LecteurPresenter;
import Bibliotheque.mvp.view.LecteurViewConsole;
import Bibliotheque.mvp.view.LecteurViewInterface;
import Bibliotheque.utilitaires.Utilitaire;

import java.util.Arrays;
import java.util.List;

public class GestBiblio {

    private DAOLecteur lm;
    private LecteurViewInterface lv;
    private LecteurPresenter lp;



    public void gestion(){
        lm = new LecteurModel();
        lv = new LecteurViewConsole();
        lp = new LecteurPresenter(lm, lv);//création et injection de dépendance

        List<String> loptions = Arrays.asList("lecteurs","fin");
        do {
            int ch = Utilitaire.choixListe(loptions);
            switch (ch){
                case 1: lp.start();
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
