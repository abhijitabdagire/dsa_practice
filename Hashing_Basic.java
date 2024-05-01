import java.util.HashMap;

public class Hashing_Basic {
    public static void main(String[] args) {
        // Create
        HashMap<String, Integer> hm = new HashMap<>();

        // Insert
        hm.put("India", 100);
        hm.put("US", 150);
        hm.put("China", 200);

        System.out.println(hm);

        // get
        int population = hm.get("India");
        System.out.println(population);

        // containsKey
        System.out.println(hm.containsKey("India"));

        // remove
        System.out.println(hm.remove("China"));

        // print
        System.out.println(hm);

        // size
        System.out.println(hm.size());

        // isEmpty
        hm.clear();
        System.out.println(hm.isEmpty());
    }
}
