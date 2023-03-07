package Bibliotheque.metier;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Exemplaire {

    private String matricule;
    private String descriptionEtat;

    private Ouvrage ouvrage;
    private Rayon rayon;

    private List<Location> lloc= new ArrayList<>();


    public Exemplaire(String matricule, String descriptionEtat,Ouvrage ouvrage) {
        this.matricule = matricule;
        this.descriptionEtat=descriptionEtat;
        this.ouvrage = ouvrage;
        this.ouvrage.getLex().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exemplaire that = (Exemplaire) o;
        return Objects.equals(matricule, that.matricule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule);
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getDescriptionEtat() {
        return descriptionEtat;
    }

    public void setDescriptionEtat(String descriptionEtat) {
        this.descriptionEtat = descriptionEtat;
    }

     public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        if(this.ouvrage!=null) this.ouvrage.getLex().remove(this);
        this.ouvrage = ouvrage;
        this.ouvrage.getLex().add(this);
    }

    public Rayon getRayon() {
        return rayon;
    }

    public void setRayon(Rayon rayon) {
        if(this.rayon!=null) this.rayon.getLex().remove(this);
        this.rayon=rayon;
        this.rayon.getLex().add(this);
    }

    public List<Location> getLloc() {
        return lloc;
    }

    public void setLloc(List<Location> lloc) {
        this.lloc = lloc;
    }

    @Override
    public String toString() {
        return "Exemplaire{" +
                "matricule='" + matricule + '\'' +
                ", descriptionEtat='" + descriptionEtat + '\'' +
                ", ouvrage=" + ouvrage +
                ", rayon=" + rayon +
                '}';
    }

    public void modifierEtat(String etat){
        descriptionEtat = etat;
    }

    public Lecteur lecteurActuel(){
        int max = getLloc().size();
        Lecteur DernLect = getLloc().get(max - 1).getLoueur();
        LocalDate date = getLloc().get(max - 1).getDateRestitution();
        if(date == null){
            return DernLect;
        }
        else{
            return null; //pas de lecteur actuel
        }
    }
    public List<Lecteur> lecteurs(){
        List<Lecteur> llecteur = new ArrayList<>();
        for (Location lect: getLloc()) {
            llecteur.add(lect.getLoueur()); //possible doublon de lecteurs
        }
        return llecteur;
    }

    public void envoiMailLecteurActuel(Mail mail){
        Lecteur DernLect = lecteurActuel();
        if (DernLect == null){
            System.out.println("pas de lecteur actuel");
        }
        else{
            String mailLect = DernLect.getMail();
            System.out.println("Destinataire : " + mailLect);
            System.out.println("Contenu : " + mail);
        }
    }
    public void envoiMailLecteurs(Mail mail){
        // envoi de mail un par un ???
        for (Lecteur l: lecteurs()) {
            String mailLect = l.getMail();
            System.out.println("Destinataire : " + mailLect);
            System.out.println("Contenu : " + mail);
        }
    }

    public boolean enRetard(){
        LocalDate Ajd = LocalDate.now();
        int max = getLloc().size();
        Location DernLoc = lloc.get(max - 1);

        if(DernLoc.getDateRestitution().isBefore(Ajd)){
            return true;
        }
        else{
            return false;
        }
    }

    public int joursRetard() {
        if (enRetard()) {
            LocalDate Ajd = LocalDate.now();
            int max = getLloc().size();
            Location DernLoc = lloc.get(max - 1);
            return (int) DernLoc.getDateRestitution().until(Ajd, ChronoUnit.DAYS);
        } else {
            return 0;
        }
    }

    public boolean enLocation(){
        //TODO en location exemplaires
        return false;
    }



}
