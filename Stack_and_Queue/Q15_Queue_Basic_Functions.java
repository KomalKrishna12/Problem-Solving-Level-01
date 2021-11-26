import java.util.ArrayDeque;
import java.util.Queue;

public class Q15_Queue_Basic_Functions{
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(10);
        queue.add(20);
        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue);

        System.out.println(queue.remove());
        System.out.println(queue);

        System.out.println(queue.remove());
    }
}