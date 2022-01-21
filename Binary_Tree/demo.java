import java.util.ArrayList;

public class demo {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> list = new ArrayList<>() ;

        list.add(5) ;
        list.add(5) ;
        list.add(5) ;
        list.add(5) ;
        list.add(5) ;

        System.out.println(list);

        list.add(2, 2);

        System.out.println(list);

    }
}
