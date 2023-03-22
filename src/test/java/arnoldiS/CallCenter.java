package arnoldiS;
import java.util.*;
import java.time.LocalDate;
public class CallCenter
{
    HashMap<String,Operator> operatori;
    HashMap<String,Feedback> f; 
    public CallCenter()
    {
       operatori=new HashMap<String,Operator>();
       f=new HashMap<String,Feedback>();
    }
    // *public String registraOperatore(String n, String c, LocalDate b) throws  NotUniqueOperatorException
    // *public int registraValutazione(String m, int s, LocalDate d) throws  InvalidOperatorException
    // public Feedback[] restituisciValutazioni();
    // *public int valutazioneComplessiva(String matricola) throws InvalidOperatorException
    // public int valutazioneMese(String matricola, int m, int a) throws InvalidOperatorException
    // public Operator[] valutazioniNegative()
    // public Operator[] best()
    // *public String toString();
    
    public String registraOperatore(String n, String c, LocalDate b) throws NotUniqueOperatorException{
        Operator o=new Operator(n,c,b);
        if(operatori.containsKey(o.matricola)==true){
            throw new NotUniqueOperatorException();
        }
        operatori.put(o.matricola, o);
        return o.matricola;
    }
    public int registraValutazione(String m, int s, LocalDate d) throws  InvalidOperatorException{
        if(!operatori.containsKey(m)){
            throw new InvalidOperatorException();
        }
        Operator o=operatori.get(m);
        Feedback ff=new Feedback(o,s,d);
        f.put(ff.matricola, ff);
        return ff.id;
    }
    public Feedback[] restituisciValutazioni(){
         Feedback[] ff=new Feedback[f.size()];
          Iterator<Feedback> j = f.values().iterator();
          int i=0;
          int c;
            while(j.hasNext() && i<f.size()){
                c=j.hashCode();
                ff[i]=f.get(c);
                Feedback v = j.next();  
            }
        return ff;
    }
    public int valutazioneComplessiva(String matricola) throws InvalidOperatorException{
        if(!operatori.containsKey(matricola)){
            throw new InvalidOperatorException();
        }
        Feedback ff=f.get(matricola);
        return ff.punteggio;
    }
    public String toString(){
        String s="";
        s+=operatori.toString();
        s+=""+f.toString();
        return s ;
    }
    public void main() throws arnoldiS.InvalidOperatorException, arnoldiS.NotUniqueOperatorException {
        CallCenter c= new CallCenter();
        System.out.println(c.toString());
        LocalDate datab= LocalDate.of(2005, 10,22);
        LocalDate data= LocalDate.now();
        String m=c.registraOperatore("Silvia", "Arnoldi", datab);
        c.registraValutazione(m , 2, data);
    }

    public Operator[] valutazioniNegative() {
        return null;
    }

    public int valutazioneMese(String matricola, int mese, int anno) {
        return 0;
    }

    public Operator[] best() {
        return null;
    }
}
