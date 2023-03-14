package gherardi_d;
import java.util.*;
import java.time.*;



public class CallCenter
{
    Hashtable<Operator, Feedback> classifica;
    
    public CallCenter(){
        classifica=new Hashtable();
    }
    
    public String registraOperatore(String nome, String cognome, LocalDate nasc) throws gherardi_d.CallCenter.NotUniqueOperatorException {
        Operator o = new Operator(nome, cognome, nasc);
        String matricola = o.getMatricola();
        for(Operator x : classifica.keySet()){
            if(x.getMatricola()==matricola){
                throw new NotUniqueOperatorException();
            }
        }
        classifica.put(o, new Feedback(matricola));
        return matricola;
    }
    
    public int registraValutazione(String matricola, int voto, LocalDate dataVoto) throws gherardi_d.CallCenter.InvalidOperatorException {
        for(Feedback f : classifica.values()){
            if(f.matricola==matricola){
                int i = f.addVote(voto, dataVoto);
                return i;
            }
        }
        throw new InvalidOperatorException();
    }
    
    public void to_string(){
        System.out.println("numero di operatori: " + classifica.size());
        for(Operator o : classifica.keySet()){
            o.to_string();
        }
        
        for(Feedback f : classifica.values()){
            f.to_string();
        }
        
    }
    
    public int valutazioneComplessiva(String matricola){
        int tot=0;
        for(Feedback f : classifica.values()){
            if(f.matricola==matricola){
                tot = f.getPunteggio();
            }
        }
        return tot;
    }
    
    public int valutazioneMese(String matricola, int m, int a){
        int tot=0;
        for(Feedback f : classifica.values()){
            if(f.matricola==matricola){
                //tot = f.getPunteggioAt(new LocalDate(a,m,26));
            }
        }
        return tot;
    }
    
    public class NotUniqueOperatorException extends Exception{
    
    }
    public class InvalidOperatorException extends Exception{

    }
}
