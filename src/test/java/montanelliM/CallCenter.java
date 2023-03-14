import java.util.*;
import java.time.*;


public class CallCenter
{
    HashMap <LinkedList<Operator>, Feedback> center;
    public CallCenter()
    {
      center= new HashMap();
       
    }
    
    public String registraOperatore(String n, String c, LocalDate b) throws InvalidOperatorException{
        Operator o =new Operator(n,c,b);
         Iterator<Map.Entry<LinkedList<Operator>, Feedback>> iterator = center.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<LinkedList<Operator>, Feedback> entry = iterator.next();
                LinkedList<Operator> key = entry.getKey();
                Feedback value = entry.getValue();
                if (key==null){
                    key =new LinkedList();
                    key.add(o);
                    center.put(key,null);
                    return n;
                }
                else{
                    for (int j = 0; j < key.size(); j++) {
                        if (key.get(j).getName() == n){
                            throw new InvalidOperatorException();
                            
                        }
                    }
                    key.add(o); 
                    center.put(key, null);
                }
                
        }
         return "";
    }
    
   
   public String calcolaMatricola (String n, String c, LocalDate b )throws NotUniqueOperatorException, InvalidOperatorException{
        String m ="";
        m=Integer.toString(b.hashCode());
        int volte=0;
         Operator o =new Operator(n,c,b);
         Iterator<Map.Entry<LinkedList<Operator>, Feedback>> iterator = center.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<LinkedList<Operator>, Feedback> entry = iterator.next();
                LinkedList<Operator> key = entry.getKey();
                Feedback value = entry.getValue();
                Operator teemp = new Operator();
                 for (int j = 0; j < key.size(); j++) {
                      teemp=key.get(j);   
                      if (volte >1){
                          throw new NotUniqueOperatorException();
                      }
                      if (teemp.getName() == n){
                            teemp.setMatricola(m);
                            volte++;
                        }
                        
                    }
        }
         return "";
        
    }

   public void aggiungiFeedback (String n, int m, LocalDate l, int r) throws RatingNotValidException{
       Feedback j= new Feedback(r,l);
       if (r<-3 ||r>3){
           throw new RatingNotValidException();
       }
       else {
           Iterator<Map.Entry<LinkedList<Operator>,Feedback>> iterator = center.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry<LinkedList<Operator>, Feedback> entry = iterator.next();
                LinkedList<Operator> key = entry.getKey();
                Feedback value = entry.getValue();
                Operator teemp = new Operator();
                for (int i = 0; i < key.size(); i++) {
                    if (key.get(i).getName() == n){
                        teemp=key.get(i);
                        //center.put(key.add(i,teemp), j);
                    }
                }
            }
       }
   }
   public LinkedList<Feedback> restituisciValutazioni(){
       LinkedList<Feedback> t= new LinkedList();
       Iterator<Feedback> i = center.values().iterator();
       while(i.hasNext()){
            Feedback entry = i.next();
            t.add(entry);
        }
       return t;
   }
   public int valutazioneComplessiva(){
        Iterator<Map.Entry<LinkedList<Operator>,Feedback>> iterator = center.entrySet().iterator();
        int somma=0;
        int media=0;
        int counter=0;
           while (iterator.hasNext()) {
                Map.Entry<LinkedList<Operator>, Feedback> entry = iterator.next();
                Feedback value = entry.getValue();
                somma+=value.getId();
                counter++;
            }
        media=somma/counter;
        return media;
   }
}
