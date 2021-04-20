public class Graph {

    public Knoten[] knotenfeld;
    private int anzahlKnoten;
    private int maxAnzahl;
    int[][] adjazenmatrix;

    public Graph(int maxAnzahlKnoten){
        adjazenmatrix = new int[maxAnzahlKnoten][maxAnzahlKnoten];
        anzahlKnoten=0;
        maxAnzahl = maxAnzahlKnoten;
        matrixVorbelegen();
    }

    private void matrixVorbelegen(){
        for (int i= 0; i < maxAnzahl; i++){
            for (int a = 0; a < maxAnzahl; a++){
                if (i == a){
                    adjazenmatrix[i][a] = 0;
                }
                adjazenmatrix[i][a] = 0;
            }
        }
    }

    private void adjazenmatrixAusgeben(){
        System.out.println("");
        System.out.println("Die Adjazenzenmatrix lautet:");

        for (int i = 0; i<maxAnzahl; i++) {
            for (int a = 0; i < maxAnzahl; i++){
                System.out.print(adjazenmatrix[i][a] + ",");
        }
        System.out.println("");
        }
    }

    private void knotenAusgeben(){

        for (int i = 0; i<anzahlKnoten; i++){
            knotenfeld[i].getDaten().ausgeben();
        }
    }

    private int knotenHinzufuegen(Datenelement daten) {
        if (anzahlKnoten == maxAnzahl) {
            System.out.println("Das Feld ist voll, es konnte kein neuer Knoten hinzugefuegt werden.");
            return 0;
        }
        knotenfeld[anzahlKnoten] = new Knoten(daten);
        anzahlKnoten = anzahlKnoten + 1;
        return anzahlKnoten;
    }
}
