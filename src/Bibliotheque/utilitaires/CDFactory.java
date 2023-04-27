package Bibliotheque.utilitaires;

import Bibliotheque.metier.CD;
import Bibliotheque.metier.Ouvrage;

import java.time.LocalDate;
import java.time.LocalTime;

import static Bibliotheque.utilitaires.Utilitaire.*;


public class CDFactory extends OuvrageFactory{
    public Ouvrage addDetail(String titre, int ageMin, LocalDate dateParution, double prixLocation, String langue, String genre){
        System.out.println("code : ");
        long code= lireLong();
        System.out.println("nombre de plages :");
        byte nbrePlages= (byte) lireInt();
        System.out.println("durée en H M S : ");
        LocalTime dureeTotale = lecTime();
        CD cd = null;
        try {
            cd = new CD(titre,ageMin,dateParution,prixLocation,langue,genre,code,nbrePlages,dureeTotale);
        } catch (Exception e) {
            System.out.println("erreur : "+e);
        }
        return cd;
    }
}
