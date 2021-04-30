public class TEST {
    public static void main(String[] args) 
    {
        Graph radnetz = new Graph(20);

        //Zu Testzwecken werden die ersten sieben Knoten fest angegeben.
        //Die Rueckgabewerte bezeichnen den Index des Knotens.
        int a = radnetz.knotenHinzufuegen(new Ortschaft("Altdorf", 100, "Marktplatz"));
        int f = radnetz.knotenHinzufuegen(new Ortschaft("Fischbach", 80, "Fischspezialitaeten"));
        int w = radnetz.knotenHinzufuegen(new Ortschaft("Weiler", 20, "Naturbad"));
        int z = radnetz.knotenHinzufuegen(new Ortschaft("Ziegelstein", 200, "Heimatmuseum"));
        int b = radnetz.knotenHinzufuegen(new Ortschaft("Burg", 50, "Historische Burg"));
        int n = radnetz.knotenHinzufuegen(new Ortschaft("Neustadt", 80, "Einkaufszentrum"));
        int r = radnetz.knotenHinzufuegen(new Ortschaft("Rain", 50, "Klettergarten"));

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

        radnetz.tiefensucheStarten(z);




    }
}
