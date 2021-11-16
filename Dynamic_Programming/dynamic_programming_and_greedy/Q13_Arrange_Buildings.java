import java.util.Scanner;

public class Q13_Arrange_Buildings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        long oldBuilding = 1;
        long oldSpace = 1;
        for (int i = 2; i <= n; i++) {
            long newBuilding = oldSpace;
            long newSpace = oldBuilding + oldSpace;
            oldBuilding = newBuilding;
            oldSpace = newSpace;
        }
        long total = oldBuilding + oldSpace;
        total = total * total;
        System.out.println(total);
        scn.close();
    }
}
