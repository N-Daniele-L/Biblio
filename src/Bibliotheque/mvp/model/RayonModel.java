package Bibliotheque.mvp.model;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Rayon;

import java.util.List;

public class RayonModel extends AbstractModel<Rayon> implements SpecialRayon{
    @Override
    public List<Exemplaire> listerExemplaires(Rayon r) {
        return null;
    }
}
