package Biblio;

import java.util.List;
import java.util.Objects;

public class Livre extends Ouvrage {
    private String isbn;
    private int nombrePages;
    private TypeLivre typleLivre;
    private String resume;

    public Livre(String titre, byte ageMin, String dateParution, TypeOuvrage typeOuvrage, double prixLocation, String langue, String genre, List<Auteur> lauteur, String isbn, int nombrePages, TypeLivre typleLivre, String resume) {
        super(titre, ageMin, dateParution, typeOuvrage, prixLocation, langue, genre, lauteur);
        this.isbn = isbn;
        this.nombrePages = nombrePages;
        this.typleLivre = typleLivre;
        this.resume = resume;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNombrePages() {
        return nombrePages;
    }

    public void setNombrePages(int nombrePages) {
        this.nombrePages = nombrePages;
    }

    public TypeLivre getTypleLivre() {
        return typleLivre;
    }

    public void setTypleLivre(TypeLivre typleLivre) {
        this.typleLivre = typleLivre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livre livre = (Livre) o;
        return Objects.equals(isbn, livre.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}