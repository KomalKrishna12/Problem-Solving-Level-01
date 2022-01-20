public class Binary_to_decimal {
    public static int binary_to_decimal(String str)
    {
        // Code here
        int res = 0, carry = 1;
        for(int i = str.length() - 1; i >= 0; i--){
            char ch = str.charAt(i);
            if(ch == '1'){
                res += carry;
            }
            carry *= 2;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(binary_to_decimal("10001000"));
    }
}
