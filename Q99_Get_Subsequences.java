import java.util.ArrayList;
import java.util.Scanner;

public class Q99_Get_Subsequences {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> list = gss(str);
        System.out.println(list);
        scn.close();
    }
    public static ArrayList<String> gss(String str) {
        if(str.length() == 0){
            ArrayList<String> als = new ArrayList<>();
            als.add("");
            return als;
        }
        char ch = str.charAt(0);
        String ss = str.substring(1);
        ArrayList<String> list = gss(ss);
        ArrayList<String> mList = new ArrayList<>();
        for (String string : list) {
            mList.add("" + string);
        }
        for (String string : list) {
            mList.add(ch + string);
        }
        return mList;
    }
}
