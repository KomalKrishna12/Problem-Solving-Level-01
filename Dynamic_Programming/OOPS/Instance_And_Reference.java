public class Instance_And_Reference{
    public static class Person{
        String name;
        int age;
        void saysHi(){
            System.out.println(name + "[" + age + "]");
        }
    }
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "A";
        p1.age = 10;
        p1.saysHi();

        Person p2 = new Person();
        p2.name = "B";
        p2.age = 20;
        p2.saysHi();
    }
}