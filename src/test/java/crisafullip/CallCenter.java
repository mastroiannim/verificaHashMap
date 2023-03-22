package crisafullip;
import java.util.*;
import java.time.LocalDate;



public class CallCenter extends Exception
{
   HashMap<String, Operator> operatori; //correzzione: da Integer a string
   HashMap<Integer, Feedback> feedback;
   
   int contaMatricola;
   
   public CallCenter(){
       operatori = new HashMap<String, Operator>(); //stessa cosa di riga 9
       feedback = new HashMap<Integer, Feedback>();
       contaMatricola = 1;
   }
   
   public String registraOperatore(String n, String s, LocalDate b) throws NotUniqueOperatorException{
       int matricola = calcolaMatricola(n,s);
       String mat = Integer.toString(matricola);
       
       if(operatori.containsKey(mat)){
           throw new NotUniqueOperatorException(); 
       }
       Operator o = new Operator(n,s,b,mat);
       operatori.put(mat, o);
       return mat; //correzzione: "Operatore registrato" al posto di mat
   }
   
   public int registraValutazione(String m, int s, LocalDate b) throws crisafullip.InvalidOperatorException {
       if(!operatori.containsKey(m)){
           throw new InvalidOperatorException();   
       }
       Feedback f = new Feedback(m,s,b);
       feedback.put(f.getId(), f);
       return f.getId();
   }
   
   public Feedback[] restituisciValutazioni() {
        Feedback[] arrayDiFeedBack = feedback.values().toArray(new Feedback[0]);
        return arrayDiFeedBack;
   }
   
    
   public int valutazioneComplessiva(String matricola) throws InvalidOperatorException{
       if(!operatori.containsKey(matricola)){
           throw new InvalidOperatorException();
           
       }
       int somma = 0;
       
       for(Feedback f : feedback.values()){
           if(f.getMatricola().equals(matricola)){
               somma += f.getPunteggio();
           } 
       }
       return somma;
   }
   
   
   
   private int calcolaMatricola(String n, String c){
       int matricolaIntera =  n.hashCode() + c.hashCode();
       return matricolaIntera;
   }

public Operator[] valutazioniNegative() {
    return null;
}

public int valutazioneMese(String matricola, int mese, int anno) {
    return 0;
}

public Operator[] best() {
    return null;
}
   

}