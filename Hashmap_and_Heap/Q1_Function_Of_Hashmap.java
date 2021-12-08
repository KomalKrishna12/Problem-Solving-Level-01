import java.util.HashMap;
import java.util.Set;

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

        // containKey(key) if key is available then return true else false
        // "Pak" is not available so it'll return false
        // same in containValue(value)
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Pak"));

        // containValue(value);
        System.out.println(hm.containsValue(135));
        System.out.println(hm.containsValue(10));

        // Set is used to contain a list with key value pair
        // using keySet() we can set our keys to set 
        Set<String> set = hm.keySet();
        System.out.println(set);

        // instead of Set we can create a foreach loop and using keySet display one by one it's value and key
        for (String str : hm.keySet()) {
            int val = hm.get(str);
            System.out.println(str + " " + val);
        }
    }
}