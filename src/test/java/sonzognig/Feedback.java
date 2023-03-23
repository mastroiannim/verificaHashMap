package sonzognig;
import java.time.LocalDate;

public class Feedback
{
    public class InvalidScoreException extends RuntimeException{}
    String matricola;
    int punteggio;
    LocalDate data;
    static int id = 0;
    public Feedback(String matricola, int punteggio, LocalDate data) throws InvalidScoreException {
        if(punteggio < -3 || punteggio > 3){
            throw new InvalidScoreException();
        }
        this.matricola = matricola;
        this.punteggio = punteggio;
        this.data = data;
        this.id = id;
        id++;
    }
    
    public int getId(){
        return id;
    }
    
    public String toString(){
        String s = "Matricola  : " + matricola +" Punteggio: " + punteggio + " Data: " + data.toString() + " Id: " + id;
        return s;
    }
}
