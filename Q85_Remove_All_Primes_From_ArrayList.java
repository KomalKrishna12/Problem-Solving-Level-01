import java.util.ArrayList;
import java.util.Scanner;

public class Q85_Remove_All_Primes_From_ArrayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(scanner.nextInt());
        }
        solution(al);
        System.out.println(al);
        scanner.close();
    }

    public static boolean isPrime(int val) {
        for (int div = 2; div * div <= val; div++) {
            if(val % div == 0){
                return false;
            }
        }
        return true;
    }

    public static void solution(ArrayList<Integer> al) {
        for (int i = al.size() - 1; i >= 0; i--) {
            int val = al.get(i);
            if (isPrime(val) == true) {
                al.remove(i);
            }
        }
    }
}
