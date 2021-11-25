import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
//In this question we have to print smallest num
//eg : d : 21,   i : 12
//    dd : 321, ii : 123
//   did : 2143
//so we create a stack and a variable num initialize num with 1
//create a for loop from 0 to str.length()
//now take each char one by one
//if char == 'd' then push num into stack and num++
//if char == 'i' then push num and num++ and pop each value till st.size()>0
//after loop push last element and print all element
public class Q14_Smallest_No_Following_Pattern {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Integer> st = new Stack<>();
        int num = 1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == 'd'){
                st.push(num);
                num++;
            }
            else{
                st.push(num);
                num++;
                while(st.size() > 0){
                    System.out.print(st.pop());
                }
            }
        }
        
        st.push(num);
        while(st.size() > 0){
            System.out.print(st.pop());
        }
    }
}
