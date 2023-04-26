package Bibliotheque.mvp.model;


import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Rayon;
import java.util.ArrayList;
import java.util.List;

public class RayonModel implements DAORayon, SpecialRayon{

    private List<Rayon> lrayons= new ArrayList<>();

    public RayonModel() {
        populate();
    }

    private void populate() {

    }

    @Override
    public Rayon addRayon(Rayon ray) {
        boolean present = lrayons.contains(ray);
        if (!present) {
            lrayons.add(ray);
            return ray;
        } else return null;
    }

    @Override
    public boolean removeRayon(Rayon ray) {
        return lrayons.remove(ray);
    }

    @Override
    public Rayon updateRayon(Rayon ray) {
        String code = ray.getCodeRayon();
        int p = lrayons.indexOf(ray);
        if (p < 0) return null;
        lrayons.set(p, ray);
        return ray;
    }

    @Override
    public Rayon readRayon(String idRay) {
        for (Rayon r: lrayons) {
            if (r.getCodeRayon() == idRay) return r;
        }
        return null;
    }

    @Override
    public List<Rayon> getRayons() {
        return lrayons;
    }

    @Override
    public List<Exemplaire> listerExemplaires(Rayon rayon) {
        return rayon.listerExemplaires();
    }
}
