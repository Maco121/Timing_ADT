
public class PrvokZoznamu
{
    private Osoba info;
    private PrvokZoznamu dalsi;
  
    public PrvokZoznamu(Osoba noveInfo)
    {
        info = noveInfo;
        dalsi = null;
    }
    
    public Osoba getInfo()
    {
        return info;
    }
    
    public PrvokZoznamu getDalsi()
    {
        return dalsi;
    }
    
    public void setDalsi(PrvokZoznamu dalsi)
    {
        this.dalsi = dalsi;
    }
    
    public String toString()
    {
        return String.format("[%s, %s]", info, dalsi);
    }
}
