package Biblio;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Gestion {

    private static List<Auteur> laut = new ArrayList<>();
    private static List<Lecteur> llect = new ArrayList<>();
    private static List<Ouvrage> louv= new ArrayList<>();
    private static List<Exemplaire> lex = new ArrayList<>();
    private static List<Rayon> lrayon= new ArrayList<>();
    private static List<Location> lloc = new ArrayList<>();

    public static void populate(){
        Auteur a = new Auteur("Verne","Jules","France");
        laut.add(a);

        Biblio.Ouvrage l = new Livre("Vingt mille lieues sous les mers",10, LocalDate.of(1880,1,1),1.50,"français","aventure","a125",350, TypeLivre.ROMAN,"histoire de sous-marin");
        louv.add(l);

        a.addLouvrage(l);

        a = new Auteur("Spielberg","Steven","USA");
        laut.add(a);

        Ouvrage d = new DVD("AI",12,LocalDate.of(2000,10,1),TypeOuvrage.DVD,2.50,"anglais","SF",4578l,"120 min",(byte)2);
        ((DVD) d).getAutresLangues().add("français");
        ((DVD) d).getAutresLangues().add("italien");
        ((DVD) d).getSousTitres().add("néerlandais");
        louv.add(d);

        a.addLouvrage(d);

        a = new Auteur("Kubrick","Stanley","GB");
        laut.add(a);

        a.addLouvrage(d);

        Ouvrage c = new CD("The Compil 2023",0,LocalDate.of(2023,1,1),TypeOuvrage.CD,2,"English","POP",1245,(byte)20,"100 min");
        louv.add(c);

        Rayon r = new Rayon("r12","aventure");
        lrayon.add(r);

        Exemplaire e = new Exemplaire("m12","état neuf",l);
        lex.add(e);

        r.addExemplaire(e);

        r = new Rayon("r45","science fiction");
        lrayon.add(r);

        e = new Exemplaire("d12","griffé",d);
        lex.add(e);

        r.addExemplaire(e);

        Lecteur lec = new Lecteur(1,"Dupont","Jean",LocalDate.of(2000,1,4),"Mons","jean.dupont@mail.com","0458774411");
        llect.add(lec);

        Location loc = new Location(LocalDate.of(2023,2,1),LocalDate.of(2023,3,1),lec,e);
        lec.getLloc().add(loc);
        e.getLloc().add(loc);
        lloc.add(loc);

        lec = new Lecteur(1,"Durant","Aline",LocalDate.of(1980,10,10),"Binche","aline.durant@mail.com","045874444");
        llect.add(lec);

        loc = new Location(LocalDate.of(2023,2,5),LocalDate.of(2023,3,5),lec,e);
        lec.getLloc().add(loc);
        e.getLloc().add(loc);
        lloc.add(loc);
    }

    public static void main(String[] args) {



        }
    }

