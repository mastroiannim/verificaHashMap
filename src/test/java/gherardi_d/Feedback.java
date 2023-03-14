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
    
    public void to_string(){
        System.out.println("matricola: " + matricola);
        System.out.println("punteggio " + punteggio);
        System.out.println("numero di voti " + valutazioni.size());
        for(Valutazione v : valutazioni){
           System.out.println("voto: " + v.voto); 
        }
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
    
    public int getPunteggioAt(LocalDate data){
        int tot=0;
        for(Valutazione v : valutazioni){
            if(v.data.equals(data)){
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
