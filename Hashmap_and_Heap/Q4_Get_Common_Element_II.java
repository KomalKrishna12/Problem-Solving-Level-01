import java.util.HashMap;
import java.util.Scanner;
// given n1 : size of an array 1
// elements of n1 given
// given n2 : size of an array 2
// elements of n2 given
// a1 -> 1 1 2 3 2 4 5 6
// a2 -> 1 2 2 4 7
// we have to display those elements of a2 which are in a1 with occurence like 2 is in a1 two times and same 
// with a1
// o/p : 1 2 2 4
public class Q4_Get_Common_Element_II {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] a1 = new int[n1];
        for (int i = 0; i < a1.length; i++) {
            a1[i] = scn.nextInt();
        }
        int n2 = scn.nextInt();
        int[] a2 = new int[n2];
        for (int i = 0; i < a2.length; i++) {
            a2[i] = scn.nextInt();
        }
        scn.close();

        // create a hashmap with key as Integer and value as Integer
        // create a foreach loop for a1
        // if value is already there in hashmap then increase it's occurence
        // if value is not their then insert the value
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (Integer val : a1) {
            if(hm.containsKey(val)){
                int oc = hm.get(val);
                int nc = oc + 1;
                hm.put(val, nc);
            }
            else{
                hm.put(val, 1);
            }
        }

        // now again create a foreach loop for a2
        // if value is in hashmap and occurence is not zero because there is a chance that in a2 1 exixst 3 times
        // while in a1 only two times
        // a1 1 1 2 3 5 6 9
        // a2 1 1 1 2 5
        // o/p : 1 1 2 5
        for (Integer val : a2) {
            if(hm.containsKey(val) && hm.get(val) > 0){
                System.out.println(val);
                int oc = hm.get(val);
                int nc = oc - 1;
                hm.put(val, nc);
            }
        }
    }
}
