/**
 * Diese Klasse enthält die Datenelemente für das Radnetz,
 * d.h. alle für Radfahrer interessanten Informationen über die Orte.
 * 
 */

public class ORTSCHAFT extends DATENELEMENT
{
    private String ortsname;
    private int uebernachtungsplaetze;
    private String sehenswuerdigkeiten;

    public ORTSCHAFT(String ortsname, int uebernachtungsplaetze, String sehenswuerdigkeiten )
    {
        this.ortsname = ortsname;
        this.uebernachtungsplaetze = uebernachtungsplaetze;
        this.sehenswuerdigkeiten = sehenswuerdigkeiten;   
    }

    public void ausgeben()
    {
        System.out.println( " Im Ort " + ortsname + " gibt es " + uebernachtungsplaetze + " Betten. ");
        System.out.println( " Sie können hier folgendes erleben: " + sehenswuerdigkeiten );
    }

    public String ortsnameGeben() {
        return this.ortsname;
    }
}
