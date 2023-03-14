package gavocid;

import java.util.*;
import java.time.LocalDate;

public class Operator
{
    String name;          // nome dell’operatore
    String surname;       // cognome
    LocalDate birthDate;  // data di nascita
    String matricola;     // matricola
    LinkedList<Feedback> feedbacks;
    
    //un operatore puo avere piu valutazioni
    public Operator(String n, String c, LocalDate b){
        name = n;
        surname = c;
        birthDate = b;
        String s = new String();
        s += name.substring(0,2);
        s += surname.substring(0,2);
        matricola = s;
        feedbacks = new LinkedList<Feedback>();
    }
    
    public String getMatricola(){
        return this.matricola;
    }
    
    public String toString(){
        return "name: " + name + "surname: " + surname + "date: " + birthDate + "matricola: " + matricola;
    }
    
    
    /*public int valutazioneComplessiva(){
        int tot = 0;
        Iterator<Operator> i = feedbacks.iterator();
        while(i.hasNext()){
            Operator u = i.next();
        }
        return tot;
    }*/
}
