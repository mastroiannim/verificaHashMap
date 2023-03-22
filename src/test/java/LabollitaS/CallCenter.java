package LabollitaS;
import java.util.*;
import java.util.Iterator;
import java.time.LocalDate;

public class CallCenter
{
    private HashMap<String, Operator> operatori;
    private HashMap<Integer, Feedback> feedbacks;
    
    static int idValutProgressivo=0;
    
    public CallCenter(){
        operatori = new HashMap<>();
        feedbacks = new HashMap<>();
    }
    public String toString(){
        String s=new String();
        Iterator<Operator > i=operatori.values().iterator();
        Iterator<Feedback > c=feedbacks.values().iterator();
        while(i.hasNext()){
            Operator x=i.next();
            s+=(x.toString())+"\n";
        }
        while(c.hasNext()){
            Feedback x=c.next();
            s+=(x.toString())+"\n";
        }
        return s;
    }
    public String registraOperatore(String n, String c, LocalDate d) throws NotUniqueOperatorException{
        String matricola = String.format("%s-%s-%s", c.substring(0, 3).toUpperCase(), n.substring(0, 3).toUpperCase(), d.toString());
        Operator op = new Operator(n,c,d);
        operatori.put(matricola, op);
        return matricola;
    }
    
        
    public int registraValutazione(String m, int s, LocalDate d) throws InvalidOperatorException{
        int idValut=idValutProgressivo;
        Feedback f = new Feedback(m, s, d);
       
        feedbacks.put(idValut, f); 
        idValutProgressivo++;
        return idValut;
    }
    
    public Feedback[] restituisciValutazioni(){
        Feedback[] feedback = feedbacks.values().toArray(new Feedback[0]);
        return feedback;
    }
    
    public int valutazioneComplessiva(String matricola) {
        int tot=0;
        return tot;
    }
    public Operator[] valutazioniNegative() {
        return null;
    }
    public int valutazioneMese(String matricola,int mese, int anno) {
      return 0;
    }
    public Operator[] best() {
        return null;
      }
  
}
