package be.vdab.voertuigen;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;

import java.io.Serial;

public class Vrachtwagen extends Voertuig implements Laadbaar {

    private Volume laadVolume;
    private int maximaalToegelatenMassa;
    private int aantalAssen;
    @Serial
    private static final long serialVersionUID = 1L;

    public Vrachtwagen(String merk, int aankoopprijs, Volume laadVolume, int maximaalToegelatenMassa, int aantalAssen) {
        super(merk, aankoopprijs);
        setLaadVolume(laadVolume);
        setMaxMassa(maximaalToegelatenMassa);
        setAantalAssen(aantalAssen);
    }

    public int getMaximaalToegelatenMassa() {
        return maximaalToegelatenMassa;
    }

    public void setMaxMassa(int maxMassa) {
        if(maxMassa<=0){
            throw new IllegalArgumentException("Waarde moeten groter dan 0 zijn");
        }
        this.maximaalToegelatenMassa = maxMassa;
    }

    public int getAantalAssen() {
        return aantalAssen;
    }

    public void setAantalAssen(int aantalAssen) {
        if(aantalAssen<=0){
            throw new IllegalArgumentException("Waarde moeten groter dan 0 zijn");
        }
        this.aantalAssen = aantalAssen;
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
    public String toString() {
        return super.toString() + "; " + laadVolume.getVolume() + " " + laadVolume.maat() +"³; " + maximaalToegelatenMassa + "; " + aantalAssen;
    }
}
