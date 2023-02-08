package Biblio;

import java.util.List;
import java.util.Objects;

public class CD extends Ouvrage{
    private long code;
    private byte nbrePlages;
    private String dureeTotale;

    public CD(String titre, byte ageMin, String dateParution, TypeOuvrage typeOuvrage, double prixLocation, String langue, String genre, List<Auteur> lauteur, long code, byte nbrePlages, String dureeTotale) {
        super(titre, ageMin, dateParution, typeOuvrage, prixLocation, langue, genre, lauteur);
        this.code = code;
        this.nbrePlages = nbrePlages;
        this.dureeTotale = dureeTotale;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public byte getNbrePlages() {
        return nbrePlages;
    }

    public void setNbrePlages(byte nbrePlages) {
        this.nbrePlages = nbrePlages;
    }

    public String getDureeTotale() {
        return dureeTotale;
    }

    public void setDureeTotale(String dureeTotale) {
        this.dureeTotale = dureeTotale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CD cd = (CD) o;
        return code == cd.code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
