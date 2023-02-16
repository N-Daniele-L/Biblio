package Biblio;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Gestion {


    public static void main(String[] args) {
        LocalDate dp = LocalDate.of(2023,2,15);
        LocalDate dn = LocalDate.of(2002,12,8);
        List<Location> Location_1 = new ArrayList<>();

        Auteur a1 = new Auteur("Nicolo","Paniel","Italienne");
        Livre l1 = new Livre("MA CHE",16,dp,12,"Italien","Biographie","01234",120, TypeLivre.BIOGRAPHIE,"L'histoire de Paniel Nicolò");

        a1.addLouvrage(l1);

        System.out.println(a1.getLouvrage());
        System.out.println(l1.getLauteurs());

        Rayon r1 = new Rayon("R1","Biographie");
        Exemplaire ex1 = new Exemplaire("p1","Nouveau",l1);

        r1.addExemplaire(ex1);

        System.out.println(ex1.getRayon());
        System.out.println(r1.getLex());

        Lecteur lec1 = new Lecteur(001,"Bruyninckx","Benjamin",dn,"Rue des templiers","Benj.gmail.com","047/12.23.34");
        Location loc1 = new Location(lec1,ex1);

        Location_1.add(loc1);

        lec1.setLloc(Location_1);
        ex1.setLloc(Location_1);

        /*
        System.out.println(a1);
        System.out.println(l1);
        System.out.println(r1);
        System.out.println(ex1);
        System.out.println(lec1);
        System.out.println(loc1);
        */

        }
    }

