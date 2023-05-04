package Bibliotheque.mvp.model;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Lecteur;
import Bibliotheque.metier.Rayon;

import java.util.List;

public class ExemplaireModel extends AbstractModel<Exemplaire> implements SpecialExemplaire {
    @Override
    public void modifierEtat(Exemplaire ex, String etat) {
         ex.setDescriptionEtat(etat);
    }

    @Override
    public Lecteur lecteurActuel(Exemplaire ex) {
        return ex.lecteurActuel();
    }

    @Override
    public List<Lecteur> lecteurs(Exemplaire ex) {
        return ex.lecteurs();
    }

    @Override
    public void envoiMailLecteurActuel(Exemplaire ex) {
     //TODO envoi mail lecteur
    }

    @Override
    public void envoiMailLecteurs(Exemplaire ex) {
     //TODO envoi mail lecteurs
    }

    @Override
    public boolean enRetard(Exemplaire ex) {
        return ex.enRetard();
    }

    @Override
    public int joursRetard(Exemplaire ex) {
        return ex.joursRetard();
    }

    @Override
    public boolean enLocation(Exemplaire ex) {
        return ex.enLocation();
    }

    @Override
    public List<Exemplaire> listerExemplaires(Rayon r) {
        return null;
    }
}
