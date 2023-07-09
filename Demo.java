interface Aa
{
    void myMethod();
    int a=10;
}

class Bb implements Aa
{
    int a=1000;
    public void myMethod()
    {
        System.out.println(a);
        System.out.println("My Method");
    }
}
class Animal{
    int a;
    Animal(){
        System.out.println("Default called");
    }
    Animal(int a){
        this.a=a;
        System.out.println(a);
    }
}
class Dog extends Animal{
    Dog(){
        super(10);
        System.out.println("Dog class");

    }
}
class C extends Bb implements Aa
{
    static int a;
    static int b=a*2;
}

class MainClass
{
    public static void main(String[] args)
    {
        Aa a = new C();

        a.myMethod();
    }
}