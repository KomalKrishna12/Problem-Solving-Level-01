import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
//in this ques we try to implement stack behaviour using two queue
//so push and size will work normally
//for pop and top
//for top :
//we push all elements of mainQ into helperQ except last one then store last element into val and add 
//that also then again add all element of helperQ to mainQ and return val that is the last element
//for pop :
//this will same as top but when we store val from last element don't add that into helper stack bcoz
//we want to pop last element
//here push effeceinet means work on pop and top for making stack
//so we can easily push the value
public class Q19_Queue_To_Stack_Adapter_Push_Effecient {

    public static class QueueToStackAdapter{

        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public QueueToStackAdapter(){
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size(){
            return mainQ.size();
        }

        int pop(){
            if(size() == 0){
                System.out.println("Stack underflow");
                return -1;
            }
            else{
                while(mainQ.size() > 1){
                    helperQ.add(mainQ.remove());
                }
                int val = mainQ.remove();
                while(helperQ.size() > 0){
                    mainQ.add(helperQ.remove());
                }
                return val;
            }
        }

        int top(){
            if(size() == 0){
                System.out.println("Stack underflow");
                return -1;
            }
            else{
                while(mainQ.size() > 1){
                    helperQ.add(mainQ.remove());
                }
                int val = mainQ.remove();
                helperQ.add(val);
                while(helperQ.size() > 0){
                    mainQ.add(helperQ.remove());
                }
                return val;
            }
        }

        void push(int val){
            mainQ.add(val);
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        QueueToStackAdapter st = new QueueToStackAdapter();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            }
            str = br.readLine();
        }
    }
}
