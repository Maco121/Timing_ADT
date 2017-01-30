
public class Zoznam {

    private int pocetPrvkov;
    private PrvokZoznamu zaciatok;
    private PrvokZoznamu koniec;

    public Zoznam() {
        pocetPrvkov = 0;
        zaciatok = null;
        koniec = null;

    }

    @Override
    public String toString() {
        String pomStr = "Pocet prvkov = " + pocetPrvkov + " \n -------------------------\n";
        pomStr += "PORADIE  PRIORITA  PRVOK \n";
        PrvokZoznamu pom = zaciatok;
        while (pom != null) {
            pomStr += pom.getInfo().getPriorita() + " -> " + pom.getInfo().getMeno() + " \n";
            pom = pom.getDalsi();

        }
        return pomStr;
    }

    public void pridajPrvokNaZaciatok(Osoba noveInfo) {
        PrvokZoznamu novy = new PrvokZoznamu(noveInfo);
        novy.setDalsi(zaciatok);
        koniec.setDalsi(novy);
        pocetPrvkov++;
    }

   public void zrusPrvy()
    {
        zaciatok = zaciatok.getDalsi();
        if(zaciatok == null)
            koniec = null;
        pocetPrvkov--;
    }

    public void pridajPrvokNaZaciatok(PrvokZoznamu novy) {
        novy.setDalsi(zaciatok);
        zaciatok = novy;
        if (koniec == null) {
            koniec = novy;
        }
        pocetPrvkov++;
    }

    public void pridajPrvokNaKoniec(PrvokZoznamu novy) {
        if (zaciatok == null) {
            pridajPrvokNaZaciatok(novy);
            return;
        }
        novy.setDalsi(null);
        koniec.setDalsi(novy);
        koniec = novy;
        pocetPrvkov++;
    }

    public void zaradKamParti(PrvokZoznamu novy) {
        if ((zaciatok == null) || (novy.getInfo().getPriorita() < zaciatok.getInfo().getPriorita())) {
            pridajPrvokNaZaciatok(novy);
        } else if (novy.getInfo().getPriorita() > koniec.getInfo().getPriorita()) {
            pridajPrvokNaKoniec(novy);
        } else {
            PrvokZoznamu pom = zaciatok;
            while (pom.getDalsi().getInfo().getPriorita() < novy.getInfo().getPriorita()) {
                pom = pom.getDalsi();

            }
            novy.setDalsi(pom.getDalsi());
            pom.setDalsi(novy);
            pocetPrvkov++;
        }
    }
   public Object[] toArray()
 {
    Object pomPole[]=new Object[pocetPrvkov];
    PrvokZoznamu pom=zaciatok;
    for(int i=0;i<pocetPrvkov;i++){
    pomPole[i]=pom.getInfo();
    pom=pom.getDalsi();
 
 }
 return pomPole;
 }

    public int getPocetPrvkov() {
        return pocetPrvkov;
    }

    public boolean jePrazny() {
        if (pocetPrvkov > 0) {
            return false;
        } else {
            return true;
        }

    }

    public int maxprvok() {
        return koniec.getInfo().getPriorita();
    }
}
