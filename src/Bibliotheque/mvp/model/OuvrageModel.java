package Bibliotheque.mvp.model;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Livre;
import Bibliotheque.metier.Ouvrage;
import Bibliotheque.metier.TypeLivre;
import Bibliotheque.mvp.model.DAOLecteur;
import Bibliotheque.mvp.model.SpecialLecteur;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class OuvrageModel implements DAOOuvrage, SpecialOuvrage {
    private List<Ouvrage> louvrages = new ArrayList<>();

    public OuvrageModel() {
        populate();
    }

    private void populate() {
        Ouvrage o = new Livre("Bonjour",8,LocalDate.of(2023,1,1),12,"Français","Tous","A1234",12, TypeLivre.BIOGRAPHIE,"Bonjours à tous");
    }

    @Override
    public Ouvrage addOuvrage(Ouvrage ouv) {
        boolean present = louvrages.contains(ouv);
        if (!present) {
            louvrages.add(ouv);
            return ouv;
        } else return null;
    }

    @Override
    public boolean removeOuvrage(Ouvrage ouv) {
        return louvrages.remove(ouv);
    }

    @Override
    public Ouvrage updateOuvrage(Ouvrage ouvrage) {
        String titre = ouvrage.getTitre();
        int p = louvrages.indexOf(ouvrage);
        if (p < 0) return null;
        louvrages.set(p, ouvrage);//remplacement de l'ouvrage à la même position
        return ouvrage;
    }

    @Override
    public Ouvrage readOuvrage(String titre) {
        for (Ouvrage o : louvrages) {
            if (o.getTitre() == titre) return o;
        }
        return null;
    }

    @Override
    public List<Ouvrage> getOuvrages() {
        return louvrages;
    }

    @Override
    public List<Exemplaire> listerExemplaires(Ouvrage ouv) {
        return ouv.listerExemplaires();
    }

    @Override
    public List<Exemplaire> listerExemplairesLocation(Ouvrage ouv) {
        return ouv.listerExemplaires(true);
    }
}