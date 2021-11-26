import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

//in this ques we have two stack that means we have LIFO structure and we want to adapt
//FIFO which is of Queue
//and remove effeceint means remove has to be in o(1)
//so work on push
public class Q22_Stack_To_Queue_Adapter_Remove_Effecient {
    public static class StackToQueueAdapter {
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public StackToQueueAdapter() {
            mainS = new Stack<>();
            helperS = new Stack<>();
        }

        int size() {
            return mainS.size();
        }

        void add(int val) {
            //here we move all elements of mainS to helperS
            //now add val to mainS
            //now transafer all elements from helperS to mainS
            while(mainS.size() > 0){
                helperS.push(mainS.pop());
            }
            mainS.push(val);
            while(helperS.size() > 0){
                mainS.push(helperS.pop());
            }
        }

        int remove() {
            if (mainS.size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return mainS.pop();
            }
        }

        int peek() {
            if (mainS.size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return mainS.peek();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StackToQueueAdapter qu = new StackToQueueAdapter();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}
