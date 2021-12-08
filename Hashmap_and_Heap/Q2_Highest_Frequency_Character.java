import java.util.HashMap;
import java.util.Scanner;
// i/p : zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc
// we're required to display that char whose occurence is more 
public class Q2_Highest_Frequency_Character {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();
        // create a hashma with key as Character becoz we're reading one by one char and value will the Integer
        // becoz we're counting the occurence
        HashMap<Character, Integer> hm = new HashMap<>();

        // start a loop from i = 0 to str.length() read char one by one using str.charAt(i)
        // check that the key is already their or not using containKey(ch) if it is already their
        // then it'll return true else false
        // so if already their then store old freq add 1 into that freq and store that key again using put
        // if we use put and key is already their then it'll update it's value
        // else simply put that ch with val 1
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(hm.containsKey(ch)){
                int oldFreq = hm.get(ch);
                int newFreq = oldFreq + 1;
                hm.put(ch, newFreq);
            }
            else{
                hm.put(ch, 1);
            }
        }

        // create a char max freq char as first char
        // now craete a for each loop
        // using get(key) function get the value of that key and max freq key if key value is greater
        // then store that key into max freq char and display it in the end after loop
        // using keyset we get all keys one by one
        char maxFreqChar = str.charAt(0);
        for (Character key : hm.keySet()) {
            if(hm.get(key) > hm.get(maxFreqChar)){
                maxFreqChar = key;
            }
        }
        System.out.println(maxFreqChar);
    }
}
