package gherardiV;
import java.time.LocalDate;

public class Feedback {
    String matricola;
    int punteggio;
    LocalDate data;
    int id;
    public static int progressive = 0;

    public Feedback(String matricola, int punteggio, LocalDate data) {
        this.matricola = matricola;
        this.punteggio = punteggio;
        this.data = data;
        this.id = Feedback.progressive++;
    }
    @Override
    public String toString() {
        return "Feedback{" +
                "matricola='" + this.matricola + '\'' +
                ", punteggio=" + this.punteggio +
                ", data=" + this.data +
                ", id=" + this.id +
                '}';
    }
}
