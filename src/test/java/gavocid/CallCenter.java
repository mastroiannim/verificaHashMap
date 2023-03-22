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
        
        if(operatori.containsKey(s))   //<---- qua avevo messo un not 
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
        
        new Feedback(m, s, d);    //----> avevo sbagliato a creare il nuovo feedback
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
            i.next();    
            //<--- qua avevo creato ua nuova valutazione che non usavo e quindi mi dava errore vscode
        }
        return -1;
    }

    public Feedback[] restituisciValutazioni() {
        return null;
    }

    public Operator[] best() {
        return null;
    }

    public int valutazioneMese(String matricola, int mese, int anno) {
        return 0;
    }

    public int valutazioneComplessiva(String matricola) {
        return 0;
    }
    
    
}