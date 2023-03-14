package brescianin;
import java.time.LocalDate;
public class Test {
    public static void main(String[] args) throws brescianin.InvalidOperatorException, brescianin.NotUniqueOperatorException {
        // Crea un nuovo call center
        CallCenter callCenter = new CallCenter();
        // Aggiunge alcuni operatori
        callCenter.registraOperatore("Mario", "Rossi", LocalDate.of(1980, 6, 15));
        callCenter.registraOperatore("Luigi", "Verdi", LocalDate.of(1985, 8, 23));
        callCenter.registraOperatore("Giovanni", "Bianchi", LocalDate.of(1990, 4, 2));
        
        // Aggiunge alcune valutazioni
        callCenter.registraValutazione("1", 2, LocalDate.of(2023, 3, 1));
        callCenter.registraValutazione("OP2", -1, LocalDate.of(2023, 3, 2));
        callCenter.registraValutazione("OP3", 3, LocalDate.of(2023, 3, 3));
        callCenter.registraValutazione("OP1", -2, LocalDate.of(2023, 3, 4));
        
        // Stampa la lista di operatori e valutazioni attualmente memorizzati
        System.out.println(callCenter);
        //callCenter.registraOperatore("Mario", "Rossi", LocalDate.of(1980, 6, 15)); funziona
        //stavo iniziando a verificare se restituisse larray di feedback
        /*Feedback[] valutazioni = callCenter.restituisciValutazioni();
        System.out.println(valutazioni);*/
    }
}