package Bibliotheque.mvp.model;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Livre;
import Bibliotheque.metier.Ouvrage;
import Bibliotheque.metier.TypeLivre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OuvrageModelV2 implements DAOGenerique<Ouvrage>,SpecialOuvrage {
    private List<Bibliotheque.metier.Ouvrage> louvrages = new ArrayList<>();

    public OuvrageModelV2() {
        populate();
    }

    private void populate() {
        Ouvrage o = new Livre("Bonjour",8, LocalDate.of(2023,1,1),12,"Français","Tous","A1234",12, TypeLivre.BIOGRAPHIE,"Bonjours à tous");
    }

    @Override
    public Ouvrage add(Ouvrage ouv) {
        boolean present = louvrages.contains(ouv);
        if (!present) {
            louvrages.add(ouv);
            return ouv;
        } else return null;
    }

    @Override
    public boolean remove(Ouvrage ouv) {
        return louvrages.remove(ouv);
    }

    @Override
    public Ouvrage update(Ouvrage ouvrage) {
        String titre = ouvrage.getTitre();
        int p = louvrages.indexOf(ouvrage);
        if (p < 0) return null;
        louvrages.set(p, ouvrage);//remplacement de l'ouvrage à la même position
        return ouvrage;
    }

    @Override
    public Ouvrage read(Ouvrage reach) {
        return null;
    }

    @Override
    public List<Ouvrage> getAll() {
        return louvrages;
    }

    @Override
    public List<Exemplaire> listerExemplaires(Bibliotheque.metier.Ouvrage ouv) {
        return ouv.listerExemplaires();
    }

    @Override
    public List<Exemplaire> listerExemplairesLocation(Bibliotheque.metier.Ouvrage ouv) {
        return ouv.listerExemplaires(true);
    }
}
