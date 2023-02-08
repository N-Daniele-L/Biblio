package Biblio;

import java.util.ArrayList;
import java.util.List;

public abstract class Ouvrage {
    protected String titre;
    protected byte ageMin;
    protected String dateParution;
    protected TypeOuvrage typeOuvrage;
    protected double prixLocation;
    protected String langue;
    protected String genre;
    protected List<Auteur> lauteur = new ArrayList<>();
    protected List<Exemplaire> lexemplaire = new ArrayList<>();

    public Ouvrage(String titre, byte ageMin, String dateParution, TypeOuvrage typeOuvrage, double prixLocation, String langue, String genre, List<Auteur> lauteur) {
        this.titre = titre;
        this.ageMin = ageMin;
        this.dateParution = dateParution;
        this.typeOuvrage = typeOuvrage;
        this.prixLocation = prixLocation;
        this.langue = langue;
        this.genre = genre;
        this.lauteur = lauteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public byte getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(byte ageMin) {
        this.ageMin = ageMin;
    }

    public String getDateParution() {
        return dateParution;
    }

    public void setDateParution(String dateParution) {
        this.dateParution = dateParution;
    }

    public TypeOuvrage getTypeOuvrage() {
        return typeOuvrage;
    }

    public void setTypeOuvrage(TypeOuvrage typeOuvrage) {
        this.typeOuvrage = typeOuvrage;
    }

    public double getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(double prixLocation) {
        this.prixLocation = prixLocation;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Auteur> getLauteur() {
        return lauteur;
    }

    public void setLauteur(List<Auteur> lauteur) {
        this.lauteur = lauteur;
    }

    public List<Exemplaire> getLexemplaire() {
        return lexemplaire;
    }

    public void setLexemplaire(List<Exemplaire> lexemplaire) {
        this.lexemplaire = lexemplaire;
    }
}
