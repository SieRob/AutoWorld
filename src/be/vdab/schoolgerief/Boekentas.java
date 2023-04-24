package be.vdab.schoolgerief;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Boekentas implements Laadbaar, Serializable {

    private String kleur;
    private Volume laadVolume;
    @Serial
    private static final long serialVersionUID = 1L;

    public Boekentas(String kleur, Volume laadVolume) {
        setKleur(kleur);
        setLaadVolume(laadVolume);
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        if(kleur.isBlank()){
            throw new IllegalArgumentException("Kleur moet ingevuld worden");
        }
        this.kleur = kleur;
    }

    @Override
    public Volume getLaadVolume() {
        return laadVolume;
    }

    @Override
    public void setLaadVolume(Volume laadVolume) {
        if(laadVolume.getVolume()<=0){
            throw new IllegalArgumentException("laadvolume moet ingevuld worden");
        }
        this.laadVolume=laadVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boekentas boekentas)) return false;

        return Objects.equals(kleur, boekentas.kleur) && Objects.equals(laadVolume, boekentas.laadVolume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kleur, laadVolume);
    }

    @Override
    public String toString() {
        return kleur + "; " + laadVolume.getVolume() + " " + laadVolume.maat()+"³";
    }
}
