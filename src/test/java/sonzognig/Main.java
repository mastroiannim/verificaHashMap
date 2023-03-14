package sonzognig;
import java.time.LocalDate;

public class Main{
    public static void main (String[] args) throws sonzognig.Feedback.InvalidScoreException, sonzognig.CallCenter.NotUniqueOperatorException, sonzognig.CallCenter.InvalidOperatorException {
        CallCenter c = new CallCenter();
        LocalDate d = LocalDate.of(2020, 1, 8);
        c.registraOperatore("bonny", "giorgio", d);
        c.registraOperatore("michele", "mastroianni", d);
        c.registraValutazione("bonnygiorgio2020", 3, d);
        c.registraValutazione("bonnygiorgio2020", -3, LocalDate.now());
        c.registraValutazione("michelemastroianni2020", -2, LocalDate.now());
        System.out.println(c.toString());
        c.valutazioniNegative();
        c.best();
    }
}
