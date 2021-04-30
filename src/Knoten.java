public class Knoten {

    private Datenelement daten;

    private boolean markierung;

    public Knoten (Datenelement daten) {
        this.daten = daten;
    }

    public Datenelement getDaten() {
        return daten;
    }

    public boolean markierungGeben() {
        return markierung;
    }

    public void markierungSetzen(boolean wert) {
        markierung = wert;
    }

}
