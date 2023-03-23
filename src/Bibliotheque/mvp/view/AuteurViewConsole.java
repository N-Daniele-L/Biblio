package Bibliotheque.mvp.view;

import Bibliotheque.metier.Auteur;
import Bibliotheque.metier.Ouvrage;
import Bibliotheque.mvp.presenter.AuteurPresenter;

import java.util.List;
import java.util.Scanner;

import static Bibliotheque.utilitaires.Utilitaire.affListe;

public class AuteurViewConsole implements AuteurViewInterface{

    private AuteurPresenter presenter;
    private List<Auteur> laut;
    private Scanner sc = new Scanner(System.in);

    AuteurViewConsole(){

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

    private void menu() {
    }
}
