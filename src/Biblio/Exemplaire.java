package Biblio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Exemplaire {
    private long matricule;
    private String description;
    private Ouvrage ouvrage;
    private Rayon rayon;
    private List<Location> llocation = new ArrayList<>();

    public Exemplaire(long matricule, String description) {
        this.matricule = matricule;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exemplaire that = (Exemplaire) o;
        return matricule == that.matricule;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule);
    }
}