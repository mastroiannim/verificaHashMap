package gherardi_d;
import java.time.*;


public class Main
{
    public static void main(String[] args) throws gherardi_d.CallCenter.NotUniqueOperatorException, gherardi_d.CallCenter.InvalidOperatorException {
        CallCenter c = new CallCenter();
        String mat = c.registraOperatore("daniele", "gherardi", LocalDate.of(2005,4,26));
        //String mat1 = c.registraOperatore("mattia", "greco", LocalDate.of(2000,4,26));
        int id = c.registraValutazione(mat, 3, LocalDate.of(2023,4,26));
        c.registraValutazione(mat, -6, LocalDate.of(2022,4,26));
        //System.out.println(id);
        //c.to_string();
        System.out.println("voto tot: " + c.valutazioneComplessiva(mat));
    }
}
