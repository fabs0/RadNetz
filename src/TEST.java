/**
 * Diese Klasse gibt das konkrete Radnetz als Testbeispiel an.
 */
class TEST
{
    //Für Testzwecke darf auf den Graphen selbst zugegriffen werden.
    public GRAPH radnetz;

    //Konstruktor
    TEST()
    {
            radnetz = new GRAPH(20);
        
            //Zu Testzwecken werden die ersten sieben Knoten fest angegeben.
            //Die Rueckgabewerte bezeichnen den Index des Knotens.
            int a = radnetz.knotenHinzufuegen(new ORTSCHAFT("Altdorf", 100, "Marktplatz"));
            int f = radnetz.knotenHinzufuegen(new ORTSCHAFT("Fischbach", 80, "Fischspezialitaeten"));
            int w = radnetz.knotenHinzufuegen(new ORTSCHAFT("Weiler", 20, "Naturbad"));
            int z = radnetz.knotenHinzufuegen(new ORTSCHAFT("Ziegelstein", 200, "Heimatmuseum"));
            int b = radnetz.knotenHinzufuegen(new ORTSCHAFT("Burg", 50, "Historische Burg"));
            int n = radnetz.knotenHinzufuegen(new ORTSCHAFT("Neustadt", 80, "Einkaufszentrum"));
            int r = radnetz.knotenHinzufuegen(new ORTSCHAFT("Rain", 50, "Klettergarten"));
        
            //Zu Testzwecken werden Kanten zwischen obigen Knoten festgelegt.
            radnetz.kanteHinzufuegen(a,f,20);
            radnetz.kanteHinzufuegen(a,w,15);
            radnetz.kanteHinzufuegen(f,a,10);
            radnetz.kanteHinzufuegen(f,w,10);
            radnetz.kanteHinzufuegen(w,f,25);
            radnetz.kanteHinzufuegen(w,z,5);
            radnetz.kanteHinzufuegen(z,f,15);
            radnetz.kanteHinzufuegen(z,b,20);
            radnetz.kanteHinzufuegen(b,z,5);
            radnetz.kanteHinzufuegen(b,f,15); 
            radnetz.kanteHinzufuegen(z,n,15);            
            radnetz.kanteHinzufuegen(n,r,20);            
            radnetz.kanteHinzufuegen(r,b,25);
            
            //Die Tiefensuche mit dem Start "Ziegelstein" ausfuehren
            radnetz.tiefensucheStarten(z);
            //Ist Ziegelstein von Rain aus erreichbar?
            radnetz.istVonErreichbar(z,r);
            ausgeben();
    }

    public static void main(String args[]) {
        
    }

    //Alles ausgeben
    void ausgeben()
    {
        radnetz.pfadGeben();
        radnetz.knotenAusgeben();
        radnetz.matrixAusgeben();
    }
}
