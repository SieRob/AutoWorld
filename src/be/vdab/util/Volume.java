package be.vdab.util;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public record Volume(int breedte, int hoogte, int diepte, Maat maat) implements Comparable<Volume>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    public Volume {
        if(breedte<0||hoogte<0||diepte<0){
            throw new VolumeException("Negatieve waardes niet toegestaan");
            //throw new VolumeException();
        }
    }
    public double getVolume(){
        return (breedte * diepte * hoogte) * maat.getEenheid();
    }

    //TODO
    // equals & Hashcode herschrijven
    // als volume van 2 items hetzelfde is
    // compare herschrijven

    @Override
    public int compareTo(Volume v) {
        return (int)(this.getVolume() - v.getVolume());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Volume volume)) return false;

        return(this.getVolume() == volume.getVolume());
        //return breedte == volume.breedte && hoogte == volume.hoogte && diepte == volume.diepte;
    }
    @Override
    public int hashCode() {
        return Objects.hash(breedte, hoogte, diepte);
    }
}
