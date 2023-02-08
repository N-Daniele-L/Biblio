package Biblio;

public class Location {
    private String dateLoc;
    private String dateRestitution;
    private double amende;
    private Exemplaire exemplaire;
    private Lecteur lecteur;

    public Location(String dateLoc, String dateRestitution, double amende, Exemplaire exemplaire, Lecteur lecteur) {
        this.dateLoc = dateLoc;
        this.dateRestitution = dateRestitution;
        this.amende = amende;
        this.exemplaire = exemplaire;
        this.lecteur = lecteur;
    }

    public String getDateLoc() {
        return dateLoc;
    }

    public void setDateLoc(String dateLoc) {
        this.dateLoc = dateLoc;
    }

    public String getDateRestitution() {
        return dateRestitution;
    }

    public void setDateRestitution(String dateRestitution) {
        this.dateRestitution = dateRestitution;
    }

    public double getAmende() {
        return amende;
    }

    public void setAmende(double amende) {
        this.amende = amende;
    }

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    public Lecteur getLecteur() {
        return lecteur;
    }

    public void setLecteur(Lecteur lecteur) {
        this.lecteur = lecteur;
    }
}