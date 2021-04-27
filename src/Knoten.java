public class Knoten {

    private DATENELEMENT daten;

    private boolean markierung;

    public Knoten (DATENELEMENT daten) {
        this.daten = daten;
    }

    public DATENELEMENT getDaten() {
        return daten;
    }

    public boolean markierungGeben() {
        return markierung;
    }

    public void markierungSetzen(boolean wert) {
        markierung = wert;
    }

}
