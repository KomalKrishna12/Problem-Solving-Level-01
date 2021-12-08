import java.util.HashMap;

public class Q1_Function_Of_Hashmap{
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        // put() function is taking two parameter one is key and other is value
        // if that key is already existing then it'll update it's value otherwise it'll add the key for
        // that value
        hm.put("India", 135);
        hm.put("China", 200);
        hm.put("Pakistan", 20);
        System.out.println(hm);
    }
}