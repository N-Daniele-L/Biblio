package Bibliotheque.mvp.model;

import java.util.List;

public interface DAOGenerique<T> {
    T add(T t);
    boolean remove(T t);
    T update (T t);
    T read(T reach);
    List<T> getAll();
}
