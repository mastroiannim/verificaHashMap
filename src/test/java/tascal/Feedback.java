package tascal;
import java.time.LocalDate;


public class Feedback
{
    static int countId = 0;
    String matricola;
    int punteggio;
    LocalDate data;
    int id ;
    public Feedback(String matricola, int punteggio, LocalDate data){
        matricola = matricola;
        punteggio = punteggio;
        if (punteggio < -3 || punteggio> 3)
            throw new RuntimeException();
        data = data;
        id = countId++;
    }
    public Feedback(int id){
        id = id;
        countId = id;
    }

    public Feedback(){
        id = countId++;
    }
}
