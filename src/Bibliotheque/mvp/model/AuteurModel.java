package Bibliotheque.mvp.model;

import Bibliotheque.metier.Auteur;
import Bibliotheque.metier.Lecteur;
import Bibliotheque.metier.Ouvrage;

import java.util.ArrayList;
import java.util.List;

public class AuteurModel implements DAOAuteur, SpecialAuteur{


    private List<Auteur> auteurs = new ArrayList<>();

    public AuteurModel(){
        populate();
    }
    @Override
    public Auteur addAuteur(Auteur aut) {
        boolean present = auteurs.contains(aut);
        if (!present) {
            auteurs.add(aut);
            return aut;
        } else return null;
    }

    @Override
    public boolean removeAuteur(Auteur aut) {
        return auteurs.remove(aut);
    }

    @Override
    public Auteur updateAuteur(Auteur aut) {
        String nom = aut.getNom();
        String prenom = aut.getPrenom();
        String nat = aut.getNationalite();
        int i = auteurs.indexOf(aut);
        if(i < 0) return null;
        auteurs.set(i, aut);
        return aut;
    }

    @Override
    public Auteur readAuteur(String nom, String prenom, String natio) {
        for (Auteur a : auteurs) {
            if (a.getNom() == nom && a.getPrenom() == prenom&& a.getNationalite() == natio) return a;
        }
        return null;
    }

    @Override
    public List<Auteur> getAuteurs() {
        return auteurs;
    }

    private void populate(){

    }


    @Override
    public List<Ouvrage> listeAllOuvrage(Auteur a) {
        return a.listerOuvrages();
    }

    @Override
    public List<Ouvrage> listeAllOuvrageByType(Auteur a) {
        return a.listerOuvrages();
    }

    @Override
    public List<Ouvrage> listeAllOuvrageByLivre(Auteur a) {
        return a.listerLivres();
    }

    @Override
    public List<Ouvrage> listeAllOuvrageByGenre(Auteur a) {
        return a.listerOuvrages();
    }
}
