package gherardi_d;
import java.time.LocalDate;
import java.util.Hashtable;



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
            if(x.getMatricola().equals(matricola)){
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
    
    public String toString(){
        System.out.println("numero di operatori: " + classifica.size());
        String operatori = "";
        String feedback = "";
        for(Operator o : classifica.keySet()){
            operatori+=o.toString();
        }
        
        for(Feedback f : classifica.values()){
            feedback += f.toString();
        }
        return operatori + feedback;
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
    
    public int valutazioneMese(String matricola, int m, int a) throws InvalidOperatorException{
        /*for(Operator x : classifica.keySet()){
            if(x.getMatricola().equals(matricola)){
                throw new InvalidOperatorException();
            }
        }*/
        int tot=0;
        for(Feedback f : classifica.values()){
            if(f.matricola==matricola){
                tot = f.getPunteggioAt(m, a);
            }
        }
        return tot;
    }

    public Operator[] valutazioniNegative() {
        return null;
    }

    public Operator[] best() {
        return null;
    }
    
    public Feedback[] restituisciValutazioni() {
        //impossibile per come ho "impostato" il problema
        return null;
    }

    
    public class NotUniqueOperatorException extends Exception{
    
    }
    public class InvalidOperatorException extends Exception{

    }
    
    
}