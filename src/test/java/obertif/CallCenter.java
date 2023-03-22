package obertif;
import java.util.*;
import java.time.LocalDate;

public class CallCenter
{
   HashMap<String,Operator> operatori;
   HashMap<String, Feedback> valutazioni;
   LinkedList<Feedback> feedback;
   LinkedList<Operator> utenti;
   public CallCenter(){
        operatori = new HashMap<String,Operator>();
        valutazioni = new HashMap<String, Feedback>();
        feedback = new LinkedList<Feedback>();
        utenti = new LinkedList<Operator>();
   }
   
   public String registraOperatore(String n, String c, LocalDate b) throws NotUniqueOperatorException{
       Operator u =  new Operator(n,c,b);
       if(operatori.containsKey(u.matricola)){
           throw new NotUniqueOperatorException();
        }
       utenti.add(u);
       operatori.put(u.matricola, u);
       return u.matricola;
    }
    
    public int registraValutazione(String m, int s, LocalDate d) throws NotUniqueOperatorException,NotValidScoreException {
        Feedback f = new Feedback(m,s,d);
        if( s < -3 || s > 3){
            throw new NotValidScoreException();
        }
        if(!operatori.containsKey(m)){  //mancava il not
           throw new  InvalidOperatorException();
        }
        feedback.add(f);
        valutazioni.put(m,f);
        return f.id;
    }
    
    public Feedback[] restituisciValutazioni(){ //non avevo messo l'id nel toSTring del feedback
        Feedback [] tutti = new Feedback[feedback.size()];
        int index = 0;
        Iterator<Feedback> i= feedback.iterator();
        while(i.hasNext()){
            Feedback u = i.next();
            tutti[index] = u;
            index++;
        }
        return tutti;
        
    }
    
    public int valutazioneComplessiva(String matricola) throws InvalidOperatorException{
        if(!operatori.containsKey(matricola)){
            throw new InvalidOperatorException();
        }
        int somma = 0;
        Iterator<Feedback> i = feedback.iterator(); // itero sulla linkedList perche con l'HashMap mi sovreascrive
        while(i.hasNext()){                         //i feedback precedenti all'ultimo
            Feedback f = i.next();
            if(f.matricola == matricola ){
                somma += f.getPunteggio();
            }
            
            
        }
        return somma;
        
      
    }
    
    public int valutazioniMese(String matricola, int m, int a ) throws InvalidOperatorException {
        if(!operatori.containsKey(matricola)){
            throw new InvalidOperatorException();
        }
        int somma = 0;
        Iterator<Feedback> i = feedback.iterator(); // itero sulla linkedList perche con l'HashMap mi sovreascrive 
        while(i.hasNext()){                         //i feedback precedenti all'ultimo
            Feedback f = i.next();
            if(f.getData().getMonthValue() == m && f.getData().getYear() == a){
                if(f.matricola == matricola ){
                    somma += f.getPunteggio(); //mancava l'if del controllo sulla matricola
                }
            }
        }
        return somma;
    }
    
    public Operator[] valutazioniNegative(){
        Operator[] tutti = new Operator[operatori.size()];
        int index = 0;
        Iterator<Operator> i= utenti.iterator();
        while(i.hasNext()){
            Operator u = i.next();
            //non so come fare 
           
        }
        return tutti;
    }
    
    public String toString(){
        String s = "";
        s = operatori.toString() + "\n" + valutazioni.toString();
        return s;
        
    }
    
    
   
   public class NotUniqueOperatorException extends RuntimeException{}
   public class NotValidScoreException extends RuntimeException{}
   public class InvalidOperatorException extends RuntimeException{}
public Operator[] best() {
    return null;
}
}
