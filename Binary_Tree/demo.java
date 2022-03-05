import java.util.ArrayList;

public class demo {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> list = new ArrayList<>() ;

        list.add(1) ;
        list.add(2) ;
        list.add(3) ;
        list.add(4) ;
        list.add(5) ;

        System.out.println(list);
        list.add(0, 0);
        System.out.println(list);

    }
}
