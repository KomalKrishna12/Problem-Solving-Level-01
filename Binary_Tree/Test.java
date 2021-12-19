import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(34);
        list.add(1);
        list.add(12);
        System.out.println(list);
        Collections.sort(list); // this is use to sort an ArrayList
        System.out.println(list);
    }
}
