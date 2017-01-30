
/**
 *
 * @author Marcel
 */
public class DynPole {

    private int velkost = 0;

    public int getVelkost() {
        return velkost;
    }
    private int pole[] = null;
    private int priorita[] = null;

    public DynPole() {
    }

    //pridaj prvok
    public void pridaj(int paPriorita, int cislo) {
         
        if (pole == null) {
            pole = new int[1];
            priorita = new int[1];
            pole[0] = cislo;
            priorita[0] = paPriorita;
            velkost++;
        } else {
           
            int pole2[] = new int[velkost + 1];
            int priorita2[] = new int[velkost + 1];
            for (int i = velkost-1 ; i>=0; i--) {
                if (paPriorita > priorita[i]) {
                    for (int j = i; j < pole2.length; j++) {
                        pole2[i + 1] = pole[i];
                        priorita2[i+1]=priorita[i];
                        pole2[i] = cislo;
                        priorita2[i]=paPriorita;
                    }
                }
                else{
                 for (int j = i; j < pole2.length; j++) {
                        pole2[i] = pole[i];
                        priorita2[i]=priorita[i];
                      
                    }
                }
                
                
            }
            pole=pole2;
           priorita =priorita2 ;
            velkost++;
        }
    }

    public void odober(){ 
            int priorita2[]=new int[velkost-1];
            int pole2[]=new int[velkost-1];
       for(int i=0;i<pole2.length;i++)
       {
       pole2[i]=pole[i+1];
       priorita2[i]=priorita[i+1];
       }
       pole=pole2;
       priorita=priorita2;
       velkost--;
    }

    //vypis prvku kazdeho pola
    public String vypis() {
        String data = " ";
        for (int i = 0; i < velkost; i++) {
            data += "Prvok: " + pole[i] + " Priorita: " + priorita[i] + " \n";

        }
        return data;
    }
}
