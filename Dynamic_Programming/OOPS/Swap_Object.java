public class Swap_Object {
    public static class Person{
        String name;
        int age;
        void saysHi(){
            System.out.println(name + "[" + age + "] says hi");
        }
    }
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "A";
        p1.age = 10;
        Person p2 = new Person();
        p2.name = "B";
        p2.age = 20;
        p1.saysHi();
        p2.saysHi();
        swap(p1, p2);
        p1.saysHi();
        p2.saysHi();
    }
    public static void swap(Person p1, Person p2) {
        Person temp = p1;
        p1 = p2;
        p2 = temp;
    }
}
