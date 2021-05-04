/**
 * Diese Klasse stellt die Knoten eines Graphen dar.
 * Jedes Objekt dieser Klasse enthält genau ein Datenelement.
 * 
 */

public class KNOTEN
{
    private DATENELEMENT daten;
    
    //Dieses Attribut wird für Verfahren zum Graphendurchlauf benötigt.
    private boolean markierung;
    
    public KNOTEN(DATENELEMENT inhalt)
    {
        daten = inhalt;       
    }
    
    public DATENELEMENT datenLiefern()
    {
        return daten;
    }
    
    public boolean markierungGeben()
    {
        return markierung;   
    }
    
    public void markierungSetzen(boolean wert)
    {
        markierung = wert;
    }

    public String ortsnameGeben() {return "";};
}
