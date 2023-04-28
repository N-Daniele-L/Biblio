package Bibliotheque.mvp.model;

import Bibliotheque.metier.*;

import java.util.ArrayList;
import java.util.List;

public class AuteurModelV2 implements DAOGenerique<Auteur>, SpecialAuteur{
    private List<Auteur> auteurs = new ArrayList<>();

    public AuteurModelV2(){
        populate();
    }
    @Override
    public Auteur add(Auteur aut) {
        boolean present = auteurs.contains(aut);
        if (!present) {
            auteurs.add(aut);
            return aut;
        } else return null;
    }

    @Override
    public boolean remove(Auteur aut) {
        return auteurs.remove(aut);
    }

    @Override
    public Auteur update(Auteur aut) {
        String nom = aut.getNom();
        String prenom = aut.getPrenom();
        String nat = aut.getNationalite();
        int i = auteurs.indexOf(aut);
        if(i < 0) return null;
        auteurs.set(i, aut);
        return aut;
    }

    @Override
    //todo a modfier
    public Auteur read(Auteur aut){
        for (Auteur a : auteurs) {
    //        if (a.getNom() == nom && a.getPrenom() == prenom&& a.getNationalite() == natio) return a;
        }
        return null;
    }

    @Override
    public List<Auteur> getAll() {
        return auteurs;
    }

    private void populate(){
        Auteur aut = new Auteur("Nicolo","Daniele","Italienne");
        add(aut);
        aut = new Auteur("Byrne","Emma","Américiane");
        add(aut);
    }


    @Override
    public List<Ouvrage> listeAllOuvrage(Auteur a) {
        return a.listerOuvrages();
    }

    @Override
    public List<Ouvrage> listeAllOuvrageByType(Auteur a, TypeOuvrage to) {
        return a.listerOuvrages(to);
    }

    public List<Livre> listeAllOuvrageByLivre(Auteur a, TypeLivre tl) {
        return a.listerLivres(tl);
    }

    @Override
    public List<Ouvrage> listeAllOuvrageByGenre(Auteur a, String genre) {
        return a.listerOuvrages(genre);
    }
}
