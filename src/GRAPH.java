 /**
 * Beispiel für einen gerichteten, bewerteten Graphen, der mit Hilfe der
 * Adjazenzmatrix implementiert wird.
 * Der Anwendungszusammenhang ist ein Wegenetz für Radfahrer. 
 * Die Richtung einer Kante gibt die Richtung des Radweges an 
 * und ihre Bewertung steht für die durchschnittlich benoetigte Zeit.
 * 
 */
public class GRAPH
{
    private KNOTEN[] knotenfeld;
    private int[][] adjazenzmatrix;
    private int anzahlKnoten;
    private int maxAnzahl;

    // Route
    public KNOTEN[] path;
    private int z;
    
    // Konstruktor
    public GRAPH(int maxAnzahlKnoten)
    {    
        anzahlKnoten = 0;
        maxAnzahl = maxAnzahlKnoten;
        knotenfeld = new KNOTEN[maxAnzahl];
        adjazenzmatrix = new int[maxAnzahl][maxAnzahl];
        path = new KNOTEN[20];
        z = 0;
        //Die Adjazenzmatrix wird mit den Werten 0 auf der Diagonalen und 
        //sonst mit den Werten -1 ("keine Kante") vorbelegt.
        for(int i=0; i < maxAnzahl; i=i+1)
        {
            for(int j=0; j < maxAnzahl; j=j+1)
            {
                if(i == j)
                {
                    adjazenzmatrix[i][j] = 0;
                }
                else
                {
                    adjazenzmatrix[i][j] = -1;
                }
            }
        }
    }
    
    
    //Die Knoten ausgeben
    public void knotenAusgeben()
    {
            for(int i=0; i < anzahlKnoten; i=i+1)
            {
                knotenfeld[i].datenLiefern().ausgeben();
            }
    }
    
    
    //Die Kanten bzw. Adjazenzmatrix ausgeben
    public void matrixAusgeben()
    {
        System.out.println("");
        System.out.println("Die Adjazenzmatrix lautet:");

        for(int i = 0; i < anzahlKnoten; i=i+1)
        {
            for(int j = 0; j < anzahlKnoten; j=j+1)
            {
                System.out.print(adjazenzmatrix[i][j]+ ",  ");
            }
            System.out.println("");
        }
    }
    
    
    /****************************************************************************************************
     * Hinzufuegen und Loeschen von Knoten bzw. Kanten
     ****************************************************************************************************/
    
    //Einen Knoten hinzufuegen, der Index wird zurückgegeben
    public int knotenHinzufuegen(DATENELEMENT inhalt)
    {
        int index = -1;
        if(anzahlKnoten < knotenfeld.length)
        {
            //Den Knoten an die erste freie Stelle im Feld setzen. 
            index = anzahlKnoten;
            knotenfeld[index] = new KNOTEN(inhalt);
            anzahlKnoten = anzahlKnoten + 1;
        }
        else
        {
            System.out.println("Es wurde kein Knoten erzeugt, da der Graph schon die maximale Anzahl an Knoten enthält.");
        } 
        return index;
    }
    
    
    //Eine Kante hinzufuegen
    public void kanteHinzufuegen(int start, int ziel, int bewertung)
    {
        if(start < knotenfeld.length && ziel < knotenfeld.length )
        {
            adjazenzmatrix[start][ziel] = bewertung;
        }
        else
        {
            System.out.println("Es wurde keine Kante erzeugt, da Start- oder Zielknoten nicht existieren.");
        }          
    }
    
    
    //Eine Kante loeschen
    public void kanteLoeschen(int start, int ziel)
    {
        if(start < knotenfeld.length && ziel < knotenfeld.length)
        {
            adjazenzmatrix[start][ziel] = -1;
        }
        else
        {
            System.out.println("Es wurde keine Kante geloescht, da Start- oder Zielknoten nicht existieren.");
        }          
    }
    
    //Einen Knoten loeschen
    public void knotenLoeschen(int knotenIndex)
    {
        if(knotenIndex == knotenfeld.length - 1 )
        {
            //Letzten Knoten mit allen Kanten loeschen
            knotenfeld[knotenIndex] = null;
            for(int i = 0; i < knotenfeld.length - 1; i= i+1)
            {
                adjazenzmatrix[i][knotenIndex] = -1;
                adjazenzmatrix[knotenIndex][i] = -1;
            }
            adjazenzmatrix[knotenIndex][knotenIndex]= 0;
        }
        else
        {
            //Alle Feldelemente des Knotenfeldes ab dem zu loeschenden Knoten werden eine Stelle nach vorne gerückt.
            for(int i = knotenIndex; i < knotenfeld.length - 1; i= i+1)
            {
                knotenfeld[i] = knotenfeld[i+1];
            }
            //Die Eintraege der Adjazenzmatrix entsprechend verschieben.
            for(int i = knotenIndex; i < knotenfeld.length - 1; i= i+1)
            {
                for(int j = 0; j < knotenfeld.length; j= j+1)
                {
                    //Zeileneintraege verschieben
                    adjazenzmatrix[i][j] = adjazenzmatrix[i+1][j];
                }
            }
            for(int i = 0; i < knotenfeld.length; i= i+1)
            {
                for(int j = knotenIndex; j < knotenfeld.length - 1; j= j+1)
                {
                    //Spaltenneintraege verschieben
                    adjazenzmatrix[i][j] = adjazenzmatrix[i][j+1];
                }
            }
        }
        anzahlKnoten = anzahlKnoten - 1;
        System.out.println("Es wurde der Knoten mit der Nummer " + knotenIndex + " geloescht.");
    }
    
    
    /****************************************************************************************************
     * Tiefensuche als Verfahren zum Graphendurchlauf
     * Rekursives Verfahren
     ****************************************************************************************************/
    //Methode zum Starten der Tiefensuche
    public void tiefensucheStarten(int startKnotenNr)
    {
        //Am Anfang alle Knoten auf unbesucht setzen
        for(int i=0; i < anzahlKnoten; i++)
        {
            knotenfeld[i].markierungSetzen(false);
        }
        // Startknoten in den pfadarray schreiben
        path[0] = knotenfeld[startKnotenNr];
        //Beginn der Tiefensuche mit dem angegebenen Startknoten
        if (startKnotenNr >= 0 && startKnotenNr < anzahlKnoten)
        {
            tiefensucheDurchfuehren(startKnotenNr);
        }
    }
    
    //Rekursive Methode zum Durchfuehren der Tiefensuche
    private void tiefensucheDurchfuehren(int knotenNr)
    {
       //Knoten als besucht markieren und auf der Konsole ausgeben.
       knotenfeld[knotenNr].markierungSetzen(true);
       System.out.println("Jetzt wurde der folgende Ort besucht:" );
       z = z + 1;
       path[z] = knotenfeld[knotenNr];
       knotenfeld[knotenNr].datenLiefern().ausgeben();
       
       //Für benachbarte Knoten die Tiefensuche erneut aufrufen.
       for( int j=0; j < anzahlKnoten; j++)
       {
           if ( adjazenzmatrix[knotenNr][j] > 0 && (knotenfeld[j].markierungGeben()==false))
           {
               //Rekursiver Aufruf der Tiefensuche für den naechsten Knoten
               tiefensucheDurchfuehren(j);
           }
        }
    }

    // 04.05.2021


    public void pfadGeben() {
        System.out.println(" \n Folgender Pfad wurde durchlaufen:");
        for(int i = 0; i < z; i++) {
            String str1 = path[i].ortsnameGeben();
            String str2 = " -> ";
            System.out.println(str1.concat(str2));
        }
    }

    //Methode zum Starten der Tiefensuche
    public boolean tiefensucheNachKnotenStarten(int startKnotenNr, int zielKnotenNr)
    {
        //Am Anfang alle Knoten auf unbesucht setzen
        for(int i=0; i < anzahlKnoten; i++)
        {
            knotenfeld[i].markierungSetzen(false);
        }
        // Startknoten in den pfadarray schreiben
        path[0] = knotenfeld[startKnotenNr];
        //Beginn der Tiefensuche mit dem angegebenen Startknoten
        if (startKnotenNr >= 0 && startKnotenNr < anzahlKnoten)
        {
            boolean found = tiefensucheNachZielKnotenDurchfuehren(startKnotenNr, zielKnotenNr);
            if (found) {
                return true;
            }
        }
        return false;
    }

    public void istVonErreichbar(int knoten1, int knoten2) {

        if (tiefensucheNachKnotenStarten(knoten1, knoten2)) {
            System.out.println("Knoten 2 ist von Knoten 1 aus errreichbar.");
        } else {
            System.out.println("Knoten 2 ist nicht von Knoten 1 aus errreichbar.");
        }
    }


    private boolean tiefensucheNachZielKnotenDurchfuehren(int knotenNr, int zielKnotenNr)
    {
        //Knoten als besucht markieren und auf der Konsole ausgeben.
        knotenfeld[knotenNr].markierungSetzen(true);
        if((knotenfeld[knotenNr].ortsnameGeben()).equals(knotenfeld[zielKnotenNr].ortsnameGeben())) {
            return true;
        }
        System.out.println("Jetzt wurde der folgende Ort besucht:" );
        z = z + 1;
        path[z] = knotenfeld[knotenNr];
        knotenfeld[knotenNr].datenLiefern().ausgeben();

        //Für benachbarte Knoten die Tiefensuche erneut aufrufen.
        for( int j=0; j < anzahlKnoten; j++)
        {
            if ( adjazenzmatrix[knotenNr][j] > 0 && (!knotenfeld[j].markierungGeben()))
            {
                //Rekursiver Aufruf der Tiefensuche für den naechsten Knoten
                boolean found = tiefensucheNachZielKnotenDurchfuehren(knotenNr, zielKnotenNr);
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }
}
