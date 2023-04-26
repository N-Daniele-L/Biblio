package Bibliotheque.mvp.model;


import Bibliotheque.metier.Rayon;

import java.util.List;

public interface DAORayon {
    Rayon addRayon(Rayon ray);

    boolean removeRayon(Rayon ray);
    Rayon updateRayon(Rayon ray);

    Rayon readRayon(String idRay);

    List<Rayon> getRayons();
}
