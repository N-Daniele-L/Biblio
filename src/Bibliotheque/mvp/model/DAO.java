package Bibliotheque.mvp.model;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Rayon;

import java.util.List;

public interface DAO<T> {

    T add(T t);

    boolean remove(T t);
    T update(T t);

    T read(T rech);

    List<T> getAll();

    List<Exemplaire> listerExemplaires(Rayon r);
}
