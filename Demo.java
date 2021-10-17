public class Demo {
    public static void main(String[] args) {
        int x = 10;
        int y = 15;
        int sum = x + y;
        System.out.println("sum of " + x + " and " + y+ " : " + sum);
        int product = x*y;
        System.out.println("product of " + x + " and " + y + " : " + product);
        int v1 = x/y;
        int v2 = y/x;
        int v3 = x%y;
        int v4 = y%x;
        System.out.println(v1 + "\n" + v2 + "\n" + v3 + "\n" + v4);
        int exp = x * y / x + y;
        System.out.println(exp);
        int exp2 = (x*y)/(x+y);
        System.out.println(exp2);
    }
}
