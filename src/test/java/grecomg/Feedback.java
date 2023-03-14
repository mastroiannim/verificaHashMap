package grecomg;
import java.time.LocalDate;


public class Feedback
{
    private String matricola;
    private int punteggio;
    private LocalDate data;
    private int id;
    private static int publicId = 0;
    
    public Feedback(String m, int p, LocalDate d) {
        matricola = m;
        punteggio = p;
        data = d;
        id = publicId;
        publicId++;
    }
    
    public String toString() {
        return "Matricola operatore: "+matricola+
        "; Punteggio: "+punteggio+
        "; Data valutazione: "+data+
        "; Id valutazione: "+id;
    };
    
    public String getMatricola() {return matricola;}
    public int getPunteggio() {return punteggio;}
    public LocalDate getLocalDate() {return data;}
    public int getId() {return id;}
}
