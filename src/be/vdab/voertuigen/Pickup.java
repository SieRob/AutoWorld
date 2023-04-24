package be.vdab.voertuigen;

import be.vdab.util.Laadbaar;
import be.vdab.util.Maat;
import be.vdab.util.Volume;

import java.io.Serial;

public class Pickup extends Personenwagen implements Laadbaar{

    private Volume laadVolume;
    @Serial
    private static final long serialVersionUID = 1L;


    public Pickup(){
        this("--Unset--", 9_999,new Volume(1,1,1, Maat.METER));
    }
    public Pickup(String merk, int aankoopprijs, Volume laadVolume) {
        super(merk, aankoopprijs);
        setLaadVolume(laadVolume);
    }

    public Pickup(String merk, int aankoopprijs, int zitplaatsen, Volume laadVolume) {
        super(merk, aankoopprijs, zitplaatsen);
        setLaadVolume(laadVolume);
    }

    @Override
    public Volume getLaadVolume() {
        return laadVolume;
    }

    @Override
    public void setLaadVolume(Volume laadVolume) {
        if(laadVolume.getVolume()==0){
            throw new IllegalArgumentException("laadvolume moet ingevuld worden");
        }
        this.laadVolume=laadVolume;
    }

    @Override
    public String toString() {
        return super.toString() + "; " +laadVolume.getVolume() + " " + laadVolume.maat()+"³";
    }
}
