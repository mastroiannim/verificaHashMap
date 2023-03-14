package volpis;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter();
        LocalDate data = LocalDate.of(2000, 1, 1);
        try {
            callCenter.registraOperatore("Paolo", "Bonacina", data);
        } catch (NotUniqueOperatorException e) {
            e.printStackTrace();
        }

        //Lancia NotUniqueOperatorException:
        /*
        try {
            callCenter.registraOperatore("Paolo", "Bonacina", data);
        } catch (NotUniqueOperatorException e) {
            e.printStackTrace();
        }
        */

        try {
            callCenter.registraValutazione("PB2000", 3, data);
        } catch (InvalidOperatorException e) {
            e.printStackTrace();
        }
        
        try {
            callCenter.registraValutazione("PB2000", -3, data);
        } catch (InvalidOperatorException e) {
            e.printStackTrace();
        }

        for (int index = 0; index < callCenter.restituisciValutazioni().length; index++) {
            System.out.println(callCenter.restituisciValutazioni()[index]);
        }
        
        
        
        try {
            System.out.println(callCenter.valutazioneComplessiva("PB2000"));
        } catch (InvalidOperatorException e) {
            e.printStackTrace();
        }
        System.out.println(callCenter);

    System.out.println( callCenter.valutazioniNegative());
       
        
    }
}
