package gherardi_d;
import java.time.*;
import java.util.*;



public class Feedback
{
    public String matricola;
    int punteggio;
    LocalDate data;
    int id;
    private static int n=0;
    
    //HashMap<LocalDate, Integer> valutazioni;
    LinkedList<Valutazione> valutazioni;
    
    public Feedback(String matricola){
        this.matricola=matricola;
        //valutazioni=new HashMap();
        valutazioni=new LinkedList();
        id=Feedback.n;
        Feedback.n++;
    }
    
    public Feedback(String matricola, int voto, LocalDate data){
        this.matricola=matricola;
        this.punteggio=voto;
        this.data=data;
        id=Feedback.n;
        valutazioni=new LinkedList();
        valutazioni.add(new Valutazione(data, voto));
        Feedback.n++;
    }
    
    public String toString(){
        String m = " matricola: " + matricola;
        String p = " punteggio " + punteggio;
        String n = " numero di voti " + valutazioni.size();
        String voti = " voti: ";
        for(Valutazione v : valutazioni){
           voti += v.voto + ","; 
        }
        return m + p + n + voti;
        //System.out.println("voti " + punteggio);
        //System.out.println("data del Feed: " + matricola);
    }
    
    public int addVote(int voto, LocalDate data){
        valutazioni.add(new Valutazione(data, voto));
        punteggio+=voto;
        return id;
    }
    
    public int getPunteggio(){
        int tot=0;
        for(Valutazione v : valutazioni){
            tot+=v.voto;
        }
        return tot;
    }
    
    public int getPunteggioAt(int m, int a){
        int tot=0;
        int mese = data.getMonthValue();
        int anno = data.getYear();
        for(Valutazione v : valutazioni){
            if(mese==m && anno==a){
                tot+=v.voto;
            }
        }
        return tot;
    }
    
    public class Valutazione{
        public LocalDate data;
        public int voto;
        
        public Valutazione(LocalDate data, int voto){
            this.data=data;
            this.voto=voto;
        }
        
    }
}