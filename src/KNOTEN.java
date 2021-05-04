/**
 * Diese Klasse stellt die Knoten eines Graphen dar.
 * Jedes Objekt dieser Klasse enth�lt genau ein Datenelement.
 * 
 */

public class KNOTEN
{
    private DATENELEMENT daten;
    
    //Dieses Attribut wird f�r Verfahren zum Graphendurchlauf ben�tigt.
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
