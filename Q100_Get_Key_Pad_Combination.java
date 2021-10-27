import java.util.ArrayList;
import java.util.Scanner;

public class Q100_Get_Key_Pad_Combination {
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> list = getKpc(str);
        System.out.println(list);
        scn.close();
    }
    public static ArrayList<String> getKpc(String str) {
        if(str.length() == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        char ch = str.charAt(0);
        String restString = str.substring(1);
        ArrayList<String> recList = getKpc(restString);
        ArrayList<String> myStr = new ArrayList<>();
        String charCode = codes[ch - '0'];
        for(int i = 0; i < charCode.length(); i++){
            char chCode = charCode.charAt(i);
            for (String string : recList) {
                myStr.add(chCode + string);
            }
        }
        return myStr;
    }
}
