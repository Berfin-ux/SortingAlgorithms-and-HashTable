import java.util.Hashtable;
import java.util.Map;

public class HashT {

    public static void main(String[] args) {
        String[] duraklar = {"Inciraltı, 28, 2, 10", "Sahilevleri, 8, 1, 11", "Doğal Yaşam Parkı, 17, 1, 6", "Bostanlı İskele, 7, 0, 5",
                "Bornova Metro, 4, 3, 8", "Fahrettin Altay, 8, 0, 4", "Alsancak İskele, 5, 1, 14", "Konak Metro, 19, 0, 1",
                "Göztepe Köprü, 15, 0, 15"};

        Hashtable<String, String> hashtable = new Hashtable<>();
        String duraks = "";
        int k = 0;

        for (int i = 0; i < duraklar.length; i++) {
            duraks = duraklar[i];
            String[] duraklar2 = duraks.split(", ");

            String value = duraklar2[k + 1] + ", " + duraklar2[k + 2] + ", " + duraklar2[k + 3];
            hashtable.put(duraklar2[k], value);
        }

        for (Map.Entry m : hashtable.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        for (int i = 0; i < duraklar.length; i++) {
            duraks = duraklar[i];
            String[] duraklar2 = duraks.split(", ");

            int bosP = Integer.valueOf(duraklar2[k+1]);
            int nb = Integer.valueOf(duraklar2[k+3]);

            if (bosP>5) {
                nb = nb+5;
                bosP = bosP-5;
            }

            String value = bosP + ", " + duraklar2[k + 2] + ", " + nb;
            hashtable.put(duraklar2[k], value);

        }

        System.out.println();
        System.out.println("________________________________");
        System.out.println();
        System.out.println("Güncellenmiş Hash Table: ");
        System.out.println();

        for (Map.Entry m : hashtable.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}
