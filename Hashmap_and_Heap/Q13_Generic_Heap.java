import java.util.PriorityQueue;

public class Q13_Generic_Heap{
    static class Student implements Comparable<Student>{
        int roll;
        int marks;
        Student(int roll, int marks){
            this.roll = roll;
            this.marks = marks;
        }
        public String toString() {
            return "Roll : " + this.roll + " , " + "Marks : " + this.marks;
        }
        
        public int compareTo(Student o) {
            //return this.roll - o.roll; // return small elemnts
            return o.marks - this.marks;
        }
    }
    public static void main(String[] args) {
        //int[] arr = {10, 2, 17, 3, 18, 9, 22};
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student(101, 100));
        pq.add(new Student(110, 150));
        pq.add(new Student(121, 90));
        pq.add(new Student(151, 4));
        pq.add(new Student(123, 40));
        while(pq.size() > 0){
            System.out.println(pq.remove());
        }
    }
}
