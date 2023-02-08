package Biblio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rayon {
    private String codeRayon;
    private String genre;
    private List<Exemplaire> lexemplaire = new ArrayList<>();

    public Rayon(String codeRayon, String genre) {
        this.codeRayon = codeRayon;
        this.genre = genre;
    }

    public String getCodeRayon() {
        return codeRayon;
    }

    public void setCodeRayon(String codeRayon) {
        this.codeRayon = codeRayon;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Exemplaire> getLexemplaire() {
        return lexemplaire;
    }

    public void setLexemplaire(List<Exemplaire> lexemplaire) {
        this.lexemplaire = lexemplaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rayon rayon = (Rayon) o;
        return Objects.equals(codeRayon, rayon.codeRayon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeRayon);
    }
}