package crisafullip;
import java.time.LocalDate;


public class Feedback
{
    
    String matricola;
    int punteggio;
    LocalDate data;
    int id;
    
    int conta = 0;
    public Feedback(String m, int p, LocalDate d, int i){
        this.matricola = m;
        this.punteggio = p;
        this.data = d;
        this.id = conta++;
    }
    
    public int getId(){
        return id;
    }
    
    
    public int getPunteggio(){
        return punteggio;
    }
    
    public String getMatricola(){
        return matricola;
    }
    public String toString() {
        return "Feedback{" + "matricola= " + matricola +  ", punteggio=" + punteggio +", data=" + data +", id=" + id + "}";
    }
}
