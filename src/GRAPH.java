
public class GRAPH
{
    private KNOTEN[] knotenfeld;
    private int[][] adjazenzmatrix;
    private int anzahlKnoten;
    private int maxAnzahl;

    public GRAPH(int maxAnzahlKnoten)
    {
        anzahlKnoten = 0;
        maxAnzahl = maxAnzahlKnoten;
        knotenfeld = new KNOTEN[maxAnzahl];
        adjazenzmatrix = new int[maxAnzahl][maxAnzahl];
        matrixVorbelegen();
    }

    public void matrixVorbelegen()
    {
        for(int i=0; i < maxAnzahl; i=i+1)
        {
            for(int e=0; e < maxAnzahl; e=e+1)
            {
                if(i == e)
                {
                    adjazenzmatrix[i][e] = 0;
                }else{
                    adjazenzmatrix[i][e] = -1;
                }

            }
        }
    }

    public void knotenAusgeben()
    {
        for(int i=0; i< anzahlKnoten; i=i+1)
        {
            knotenfeld[i].datenLiefern().ausgeben();
        }
    }

    public void MatrixAusgeben()
    {
        System.out.println("");
        System.out.println("Die Adjazenzmatrix lautet");
        for(int i=0; i<anzahlKnoten; i=i+1)
        {
            for(int j=0; j<anzahlKnoten; j=j+1)
            {
                System.out.print(adjazenzmatrix[i][j] + ", ");
            }
            System.out.println("");
        }
    }

    public int KnotenHinzufuegen(DATENELEMENT Inhalt)
    {
        int index = -1;
        if(anzahlKnoten < knotenfeld.length)
        {
            index = anzahlKnoten;
            knotenfeld[index] = new KNOTEN(Inhalt);
            anzahlKnoten = anzahlKnoten + 1;
        }else{
            System.out.println("Error: Graph voll!");
        }
        return index;
    }

    public void kanteHinzufuegen(int start, int ziel, int bewertung)
    {
        if(start < knotenfeld.length && ziel < knotenfeld.length){
            adjazenzmatrix[start][ziel] = bewertung;
        }else{
            System.out.println("Error: Start oder Ziel existiert nicht!");
        }
    }

    public void kanteLoeschen(int start, int ziel)
    {
        if(start < knotenfeld.length && ziel < knotenfeld.length){
            adjazenzmatrix[start][ziel] = -1;
            System.out.println("Kante wurde geloescht!");
        }else{
            System.out.println("Error: Start oder Ziel existiert nicht!");
        }
    }
}
