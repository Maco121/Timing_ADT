/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcel
 */
public class Osoba {

    Priorita priorita;
    String meno;
    public Osoba(Priorita priorita,String meno){
    this.priorita=priorita;
    this.meno=meno;
    }
     
    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public int getPriorita() {
        return priorita.getPriorita();
    }
   public String toString(){
   return meno;
   }
}
