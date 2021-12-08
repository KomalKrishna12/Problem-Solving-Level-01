import java.util.HashMap;

public class Q1_Function_Of_Hashmap{
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        // put(key, value);
        // put() function is taking two parameter one is key and other is value
        // if that key is already existing then it'll update it's value otherwise it'll add the key for
        // that value
        hm.put("India", 135);
        hm.put("China", 200);
        hm.put("Pakistan", 20);
        System.out.println(hm);

        // "pakistan" key is already present so it'll update it's value
        hm.put("Pakistan", 22);
        System.out.println(hm);

        // get(key)
        // if key is present then it'll return value otherwise null
        // "Russia" is not available so it'll return null
        System.out.println(hm.get("India"));
        System.out.println(hm.get("Russia"));
    }
}