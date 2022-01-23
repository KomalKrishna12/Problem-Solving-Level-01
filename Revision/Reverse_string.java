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
    }
}
