package Bibliotheque.mvp.view;

import Bibliotheque.metier.*;
import Bibliotheque.mvp.presenter.OuvragePresenter;
import Bibliotheque.mvp.presenter.SpecialOuvragePresenter;
import Bibliotheque.utilitaires.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Bibliotheque.utilitaires.Utilitaire.*;
import static Bibliotheque.utilitaires.Utilitaire.modifyIfNotBlank;

public class OuvrageViewConsole extends AbstractViewConsole<Ouvrage> implements SpecialOuvrageViewConsole {

    @Override
    public void setListDatas(List<Ouvrage> ldatas){
        ldatas.sort((o1, o2) -> {
            if(o1.getTitre().compareTo(o2.getTitre()) != 0) return (o1.getTitre().compareTo(o2.getTitre()));
            return o1.getTitre().compareTo(o2.getTitre());
        });
        super.setListDatas(ldatas);
    }

    @Override
    protected void rechercher() {
      //TODO rechercher ouvrage
    }

    @Override
    protected void modifier() {
        int choix = choixElt(ldatas);
        Ouvrage o = ldatas.get(choix-1);
         do {
            try {
                double ploc =Double.parseDouble(modifyIfNotBlank("prix location",""+o.getPrixLocation()));
                o.setPrixLocation(ploc);
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
        presenter.update(o);
        ldatas=presenter.getAll();//rafraichissement
        affListe(ldatas);

    }

    @Override
    protected void ajouter() {
        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        int choix = Utilitaire.choixListe(lto);
        Ouvrage o = null;
        List<OuvrageFactory> lof = new ArrayList<>(Arrays.asList(new LivreFactory(),new CDFactory(),new DVDFactory()));
        o = lof.get(choix-1).create();
        presenter.add(o);
        Auteur a = ((OuvragePresenter)presenter).choixAuteur();
        o.addAuteur(a);
    }

    @Override
    protected void special() {
        int choix =  choixElt(ldatas);
        Ouvrage o = ldatas.get(choix-1);

        List options = new ArrayList<>(Arrays.asList("lister exemplaires", "lister exemplaires en location", "lister exemplaires libres","fin"));
        do {
            int ch = choixListe(options);

            switch (ch) {

                case 1:
                    exemplaires(o);
                    break;
                case 2:
                    enLocation(o, true);
                    break;
                case 3:
                    enLocation(o, false);
                    break;

                case 4 :return;
            }
        } while (true);




    }

    @Override
    public void enLocation(Ouvrage o, boolean enLocation) {
        ((SpecialOuvragePresenter) presenter).listerExemplaire(o, enLocation);
    }

    @Override
    public void exemplaires(Ouvrage o) {
        ((SpecialOuvragePresenter)presenter).listerExemplaire(o);
    }
}
