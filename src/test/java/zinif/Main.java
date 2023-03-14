import java.time.LocalDate;

class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date);
        CallCenter c = new CallCenter();
        try {
            c.registraOperatore("paolo", "fermi", date);
        } catch (CallCenter.NotUniqueOperatorException e) {
            e.printStackTrace();
        }
        try {
            c.registraOperatore("paolo", "fermi", date);
        } catch (CallCenter.NotUniqueOperatorException e) {
            e.printStackTrace();
        }
        try {
            c.registraValutazione("asdasf",2,date);
        } catch (CallCenter.InvalidOperatorException e) {
            e.printStackTrace();
        }
    }
}