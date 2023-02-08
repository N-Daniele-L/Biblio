package Biblio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lecteur {
    private long numLecteur;
    private String nom;
    private String prenom;
    private String dateNaiss;
    private String mail;
    private String adresse;
    private String tel;
    private List<Location> llocation = new ArrayList<>();

    public Lecteur(long numLecteur, String nom, String prenom, String dateNaiss, String mail, String adresse, String tel) {
        this.numLecteur = numLecteur;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.mail = mail;
        this.adresse = adresse;
        this.tel = tel;
    }

    public long getNumLecteur() {
        return numLecteur;
    }

    public void setNumLecteur(long numLecteur) {
        this.numLecteur = numLecteur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(String dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<Location> getLlocation() {
        return llocation;
    }

    public void setLlocation(List<Location> llocation) {
        this.llocation = llocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecteur lecteur = (Lecteur) o;
        return numLecteur == lecteur.numLecteur;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numLecteur);
    }
}
