import java.util.ArrayList;
import java.util.Scanner;

public class Q101_Get_Stairs_Paths {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> list = getStairs(n);
        System.out.println(list);
        scn.close();
    }
    public static ArrayList<String> getStairs(int n) {
        if(n == 0){//if n == 0 that means we reached the destination so we return empty path which represent 
            // one way to reach n that is stay there
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        else if(n < 0){//if n < 0 that means we are not at ground if we walk that means we are going in negetive
            //and if we stay there that means we are at the negetive point so we return array list without
            //adding any path.
            ArrayList<String> list = new ArrayList<>();
            return list;
        }
        ArrayList<String> path1 = getStairs(n-1);//n-1 represent we asked n-1 for the path
        ArrayList<String> path2 = getStairs(n-2);//same as n-1
        ArrayList<String> path3 = getStairs(n-3);   //same as n-1
        ArrayList<String> paths = new ArrayList<>();//ans
        for (String string : path1) {
            paths.add(1+string);//we are adding 1 to n-1 path so 1 + (n-1) = n
        }
        for (String string : path2) {
            paths.add(2+string);//we are adding 2 to n-2
        }
        for (String string : path3) {
            paths.add(3+string);//we are adding 3 to n-3
        }
        return paths;
    }
}
