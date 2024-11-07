package Lab6.HashMap;
import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        HashMap<String, String> nicknames = new HashMap<>();

        nicknames.put("matti", "mage");
        nicknames.put("mikael", "mixu");
        nicknames.put("arto", "arppa");

        String mikaelsNickname = nicknames.get("mikael");
        System.out.println(mikaelsNickname);
    }
}


 class PromissoryNote {
    private HashMap<String, Double> loans;

    public PromissoryNote() {
        loans = new HashMap<>();
    }

    public void setLoan(String toWhom, double value) {
        loans.put(toWhom, value);
    }

    public double howMuchIsTheDebt(String whose) {
        return loans.getOrDefault(whose, 0.0);
    }

    public static void main(String[] args) {
        PromissoryNote mattisNote = new PromissoryNote();

        mattisNote.setLoan("Arto", 51.5);
        mattisNote.setLoan("Mikael", 30);

        System.out.println(mattisNote.howMuchIsTheDebt("Arto"));
        System.out.println(mattisNote.howMuchIsTheDebt("Joel"));
    }
}
