package be.vdab.voertuigen;

import java.io.Serial;

public class Personenwagen extends Voertuig{
    private int zitplaatsen;
    @Serial
    private static final long serialVersionUID = 1L;

    public Personenwagen(String merk, int aankoopprijs) {
        super(merk, aankoopprijs);
        setZitplaatsen(1);
    }

    public Personenwagen(String merk, int aankoopprijs, int zitplaatsen) {
        super(merk, aankoopprijs);
        setZitplaatsen(zitplaatsen);
    }

    public int getZitplaatsen() {
        return zitplaatsen;
    }

    public void setZitplaatsen(int zitplaatsen) {
        if(zitplaatsen<=0){
            throw new IllegalArgumentException("Zitplaatsen moet groter dan 0 zijn");
        }
        this.zitplaatsen = zitplaatsen;
    }

    @Override
    public String toString() {
        return super.toString() + "; " +  zitplaatsen;
    }
}
