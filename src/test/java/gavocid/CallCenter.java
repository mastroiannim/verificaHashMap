package gavocid;

import java.util.*;
import java.time.LocalDate;

public class CallCenter
{
    HashMap<String, Operator> operatori;
    LinkedList<Feedback> feedbacks;
    
    public CallCenter(){
        operatori = new HashMap<String, Operator>();
        feedbacks = new LinkedList<Feedback>();
    }
    
    public String registraOperatore(String n, String c, LocalDate b) throws NotUniqueOperatorException{
        String s = new String();
        s += n.substring(0,2);
        s += c.substring(0,2);
        
        if(!operatori.containsKey(s))
            throw new NotUniqueOperatorException();
            
        Operator o = new Operator(n, c, b);
        operatori.put(s, o);
        return s;
    }
    
    public int registraValutazione(String m, int s, LocalDate d) throws InvalidOperatorException{
        if(!operatori.containsKey(m)){
            throw new InvalidOperatorException();
        }
        
        Iterator<Operator> i = operatori.values().iterator();
        
        while(i.hasNext()){
            Operator u = i.next();
            if(u.matricola == m){
                
            }
        }
        
        Feedback f = new Feedback(m, s, d);
        return -1;
    }
    
    public String toString(){
        String s = new String();
        Iterator<Operator> i = operatori.values().iterator();
        while(i.hasNext()){
            Operator x = i.next();
            s += x.toString() + "\n";
        }
        
        System.out.println("----------------------------------------------"+"\n");
        
        Iterator<Feedback> j = feedbacks.iterator();
        while(j.hasNext()){
            Feedback f = j.next();
            s += f.toString() + "\n";
        }
        return s;
    }
    
    public Operator[] valutazioniNegative(){
        
        Iterator<Feedback> i = feedbacks.iterator();
        while(i.hasNext()){
            Feedback u = i.next();
        }
        return null;
    }

    public Feedback[] restituisciValutazioni() {
        return null;
    }

    public int valutazioneComplessiva(String matricola) {
        return 0;
    }

    public Operator[] best() {
        return null;
    }

    public int valutazioneMese(String matricola, int mese, int anno) {
        return 0;
    }
    
    
}
