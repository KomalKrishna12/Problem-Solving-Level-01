import java.io.BufferedReader;
import java.io.InputStreamReader;
//dynamic queue means when queue is full we display "Queue overflow" in that place we have to
//create a new array with double size and add all element into it and then assign it to old one
public class Q18_Dynamic_Queue {

    public static class CustomQueue{
        int[] data;
        int front;
        int size;

        public CustomQueue(int cap){
            data = new int[cap];
            front = 0;
            size = 0;
        }

        int size(){
            return size;
        }

        void add(int val){
            if(data.length == size){
                int[] newData = new int[2 * data.length];
                for (int i = 0; i < data.length; i++) {
                    newData[i] = data[(front + i) % data.length];
                }
                data = newData;
                int rear = (front + size) % data.length;
                data[rear] = val;
                size++;

            }
            else{
                int rear = (front + size) % data.length;
                data[rear] = val;
                size++;
            }
        }

        void display(){
            for (int i = 0; i < size; i++) {
                int index = (front + i) % data.length;
                System.out.print(data[index] + " ");
            }
            System.out.println();
        }

        int remove(){
            if(size == 0){
                System.out.println("Queue underflow");
                return -1;
            }
            else{
                int val = data[front];
                front = (front + 1) % data.length;
                size--;
                return val;
            }
        }

        int peek(){
            if(size == 0){
                System.out.println("Queue underflow");
                return -1;
            }
            else{
                int val = data[front];
                return val;
            }
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        CustomQueue qu = new CustomQueue(n);

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
            } else if (str.startsWith("display")) {
                qu.display();
            }
            str = br.readLine();
        }
    }
}
