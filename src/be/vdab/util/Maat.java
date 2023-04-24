package be.vdab.util;

public enum Maat {

    CENTIMETER(0.01), DECIMETER(0.1), METER(1);

    private final double eenheid;
    Maat(double eenheid) {
        this.eenheid =eenheid;
    }

    public double getEenheid() {
        return eenheid;
    }

}
