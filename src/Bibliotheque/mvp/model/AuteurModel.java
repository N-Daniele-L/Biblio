package Bibliotheque.mvp.model;

import Bibliotheque.metier.*;

import java.util.List;

public class AuteurModel extends AbstractModel<Auteur> implements SpecialAuteur {
    @Override
    public List<Ouvrage> listerOuvrages(Auteur a) {
        return a.listerOuvrages();
    }

    @Override
    public List<Livre> listerLivre(Auteur a, TypeLivre tl) {
        return a.listerLivres(tl);
    }

    @Override
    public List<Ouvrage> listerOuvrages(Auteur a, String genre) {
        return a.listerOuvrages(genre);
    }

    @Override
    public List<Exemplaire> listerExemplaires(Rayon r) {
        return null;
    }
}
