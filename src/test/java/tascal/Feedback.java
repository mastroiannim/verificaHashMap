package tascal;
import java.time.LocalDate;


public class Feedback
{
    String matricola;
    int punteggio;
    LocalDate data;
    int id ;
    public Feedback(String matricola, int punteggio, LocalDate data) throws Exception{
        matricola = matricola;
        punteggio = punteggio;
        if (punteggio < -3 || punteggio> 3)
            throw new Exception();
        data = data;
    }
    public Feedback(int id){
        id = id;
    }
}
