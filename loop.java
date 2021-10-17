import java.util.Scanner;

public class loop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String str = scanner.nextLine();
        // int n = scanner.nextInt();
        // String str = scanner.nextLine();
        // // int i = 1;
        // // while(i <= 10){
        // //     System.out.println(i);
        // //     i++;
        // // }
        // // System.out.println("done");
         System.out.println("Dear " + str + " here is the loop ");

         for(int i = 0; i<=n; i++){
             System.out.println(i);
             if(i==6){
                 break;
             }
         }
        

    }
}
