import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
//pop effecient means work on push to make it as effeiecnt like stack
//so here we can easily pop and top
public class Q20_Queue_To_Stack_Adapter_Pop_Effecient {

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
                return mainQ.remove();
            }
        }

        int top(){
            if(size() == 0){
                System.out.println("Stack underflow");
                return -1;
            }
            else{
                return mainQ.peek();
            }
        }

        void push(int val){
            //so here we simple remove all elements from mainQ and add it into helperQ
            //after that add val into mainQ and again add all element from helperQ to mainQ
            //suppose queue : 10 
            //push 20
            //add mainQ to helperQ : 10
            //now mainQ is empty so add 40 in mainQ
            //mainQ : 20
            //now remove all element from helperQ and add into mainQ
            //mainQ : 20 10
            while(mainQ.size() > 0){
                helperQ.add(mainQ.remove());
            }
            mainQ.add(val);
            while(helperQ.size() > 0){
                mainQ.add(helperQ.remove());
            }

        }

    }

    public static void main(String[] args) throws Exception{
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
