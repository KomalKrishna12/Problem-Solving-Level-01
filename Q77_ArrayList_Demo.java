import java.util.ArrayList;

public class Q77_ArrayList_Demo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(list + " -> " +list.size());//[] -> 0
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list + " -> " +list.size());//[10, 20, 30] -> 3
        list.add(1,1000);//add 1000 at index 1
        System.out.println(list + " -> " +list.size());//[10, 1000, 20, 30] -> 4
        list.set(1, 2000);//set index 1 with 2000
        System.out.println(list + " -> " +list.size());//[10, 2000, 20, 30] -> 4
        int val = list.get(1);//get value at 1 index
        System.out.println("Val : " + val);//2000
        list.remove(1);//remove 1 index and size will reduce by 1
        System.out.println(list + " -> " +list.size());//[10, 20, 30] -> 3
        for (int i = 0; i < list.size(); i++) {
            int val1 = list.get(i);
            System.out.println(val1);
        }
        for (int value : list) {
            System.out.println(value);
        }
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("hello");
        list2.add("bello");
        list2.add("cello");
        System.out.println(list2 + " -> " + list2.size());
    }
}
