import java.util.Scanner;
//this is similar problem like count binary strings but here we are given a road in both side of road
//n plots are there
//withing that plots either we can build buiding or we can leave it as space
//their can't be two consecutive buildings
//their can be two consecutive space
//both side plots can be in same way or other
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
        //here we are using long because if user gave 45 as n that means we have to add 45 no which can be
        //in size 45 which is of long type that's why we are using long
        //at end we can print total^2 that means total*total beacuse in both side n plots are there and they
        //can either be in same order or different so if there is 10 way for one side there is also 10 ways 
        //for other side so total will bcome 10*10 that is 100
        //there is second approach also which we used in previous question
        //that is we can create two 1D array
        //one for storing ways repected to index to contains building at last
        //other for storing space
        //in building array we can store building only when the last plot is space 
        //because this is mentioned in question that two condsecuitve building can't be there
        //but in space array we can store spaace in both cases either last plot is space or building
        total = total * total;
        System.out.println(total);
        scn.close();
    }
}
