public class Q20_Increment_Operator {
    
    public static void main(String[] args) {
        
        int i = 10;// i++ means first value will assign then increment
        if(i++ == i)//(10 == 11) not true so else part will execute
        {
            System.out.println(i + " is good.");
        }
        else{
            System.out.println(i + " is bad.");
        }

        int j = 20; //++j means first increment done then value assign
        if(++j == j)//(21 == 21) true so if part will execute
        {
            System.out.println(j + " is good.");
        }
        else{
            System.out.println(j + " is bad.");
        }

    }

}
