package BonacinaG;
import java.util.*;
import java.time.*;

public class Feedback
{
    String matricola;
    int punteggio;
    LocalDate data;
    int id;
        
    public Feedback(String matricola, int punteggio, LocalDate dataRecensione, int progressivo) throws PunteggioNonValidoException
    {
        if(punteggio > 3 || punteggio < -3)
        {
            throw new PunteggioNonValidoException();
        }else{
            this.punteggio = punteggio;
        }
        this.matricola = matricola;
        this.data = dataRecensione;
        this.id = progressivo;
    }
    
    @Override
    public String toString(){
        return this.matricola + " " + String.valueOf(this.punteggio) + " " + this.data.toString() + " " + String.valueOf(this.id);
    }
}
