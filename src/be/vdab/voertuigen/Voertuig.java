package be.vdab.voertuigen;

import be.vdab.voertuigen.div.Div;
import be.vdab.voertuigen.div.Nummerplaat;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Voertuig implements Comparable<Voertuig>, Serializable {
    private final Nummerplaat nummerplaat = Div.INSTANCE.getNummerPlaat();
    private String merk;
    private int aankoopprijs;
    @Serial
    private static final long serialVersionUID = 1L;

    public Voertuig(String merk, int aankoopprijs) {
        setMerk(merk);
        setAankoopprijs(aankoopprijs);
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        if(merk.isBlank()){
            throw new IllegalArgumentException("Merk moet ingevuld worden");
        }
        this.merk = merk;
    }

    public int getAankoopprijs() {
        return aankoopprijs;
    }

    public void setAankoopprijs(int aankoopprijs) {
        if(aankoopprijs<0){
            throw new IllegalArgumentException("Aankoopprijs moet groter zijn dan 0");
        }
        this.aankoopprijs = aankoopprijs;
    }

    @Override
    public int compareTo(Voertuig nrPlaat) {
        //var plaat1 = nummerplaat.getPlaat().substring(nummerplaat.getPlaat().lastIndexOf('-')+1);
        //var plaat2 = nrPlaat.nummerplaat.getPlaat().substring(nrPlaat.nummerplaat.getPlaat().lastIndexOf('-')+1);

        return this.nummerplaat.compareTo(nrPlaat.nummerplaat);
        //return (Integer.parseInt(plaat1) - Integer.parseInt(plaat2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voertuig voertuig)) return false;

        return nummerplaat.equals(voertuig.nummerplaat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nummerplaat);
    }

    @Override
    public String toString() {
        return nummerplaat + "; " + merk + "; €" + aankoopprijs;
    }
}
