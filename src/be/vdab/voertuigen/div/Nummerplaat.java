package be.vdab.voertuigen.div;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Nummerplaat implements Comparable<Nummerplaat>, Serializable {
    private final String plaat;
    public Nummerplaat(String plaat) {
        this.plaat = plaat;
    }

    public String getPlaat() {
        return plaat;
    }
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public int compareTo(Nummerplaat p) {
        //1-AAA-[111] -> split on last part and compare this between 2
        //var plaat1 = plaat.substring(plaat.lastIndexOf('-')+1);
        //var plaat2 = p.getPlaat().substring(p.getPlaat().lastIndexOf('-')+1);

        return p.getPlaat().compareTo(plaat);
        //return (Integer.parseInt(plaat1) - Integer.parseInt(plaat2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nummerplaat nrPlaat)) return false;

        return plaat.equals(nrPlaat.getPlaat());
    }
    @Override
    public int hashCode() {
        return Objects.hash(plaat);
    }
    @Override
    public String toString() {
        return plaat;
    }
}
