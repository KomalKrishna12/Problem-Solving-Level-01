public class Reverse_string {
    public static void reverseString(char[] s) {
        int li = 0;
        int ri = s.length - 1;
        while(li < ri){
            char temp = s[li];
            s[li] = s[ri];
            s[ri] = temp;
            li++;
            ri--;
        }
    }
    public static String reverseWord(String str1)
    {
        String str = "";
        for(int i = str1.length() - 1; i >= 0; i--){
            str += str1.charAt(i);
        }
        return str;
    }
    public static int reverse(int x){
        long num = 0;
        while(x > 0){
            num = num * 10 + x % 10;
            x = x/10; 
        }
        return (int)num;
    }
    public static void display(char[] s){
        for(char ch : s){
            System.out.print(ch + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        char[] s = {'a','b','c'};
        display(s);
        reverseString(s);
        display(s);
        System.out.println(reverseWord("abc"));
        System.out.println(reverse(123));
    }
}
