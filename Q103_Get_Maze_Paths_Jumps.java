import java.util.ArrayList;
import java.util.Scanner;

public class Q103_Get_Maze_Paths_Jumps {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();// no of rows
        int m = scn.nextInt();// no of columns
        ArrayList<String> list = getMazePaths(1, 1, n, m);
        System.out.println(list);
        scn.close();
    }

    private static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc){
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        ArrayList<String> paths = new ArrayList<>();
        //for horizontal jumps
        //here we want to print jump value with h so we take a loop which start from 1 and go to dc - sc
        //if sc=1 dc=3 so it can jump with h1 and h2 which is till dc-sc
        //then we call recursive method for next coumn which is sc + 1 and add "h" with index value 
        for(int i = 1; i <= dc - sc; i++){
            ArrayList<String> hPaths = getMazePaths(sr, sc + i, dr, dc);
            for (String str : hPaths) {
                paths.add("h" + i + str);
            }
        }

        //for vertical jumps
        //same as horizontal but here we add "v" with index value and in recursive fun we pass sr+1
        for(int i = 1; i <= dr - sr; i++){
            ArrayList<String> vPaths = getMazePaths(sr+i, sc, dr, dc);
            for (String str : vPaths) {
                paths.add("v" + i + str);
            }
        }

        //for diagonal jumps
        //here for diagonal both row and column value will change so we have to call recursive method with 
        //sr+1 and sc+1
        //add "d" with index value
        for(int i = 1; i <= dc - sc && i <= dr - sr; i++){
            ArrayList<String> dPaths = getMazePaths(sr+i, sc + i, dr, dc);
            for (String str : dPaths) {
                paths.add("d" + i + str);
            }
        }
        return paths;
    }
}
