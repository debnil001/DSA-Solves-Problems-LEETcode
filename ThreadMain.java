class MyThread extends Thread {
    @Override
    public void run() {
        Thread th=Thread.currentThread();
        String name=th.getName();
        for(int i=1;i<=10;i++){
            try {
                Thread.sleep(2000);

            }
            catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println(name+" -->"+i);
        }
    }
}
class ThreadDemo implements Runnable{
    public ThreadDemo(){
        new Thread(this).start();
    }
    public void run(){
        for(int k=0;k<10;k++){
            System.out.println("k "+k);
        }
    }
}
class A{
    public void f(int a){
        System.out.println("int");
    }
}
class B extends A{
    public void f(int a){
        System.out.println("int child");
    }
    public void f(float b){
        System.out.println("float");
    }
}
class Table extends Thread{
    int total;
    public void run(){
        for(int i=1;i<=10;i++){
            total+=100;
        }
        synchronized (this) {
            this.notify();
        }
    }
}
public class ThreadMain {
    public static void main(String[] args) throws InterruptedException{
//        B obj1=new B();
//        obj1.f(10.36f);
//
//        A obj2=obj1;
//        obj2.f(23_00);

        Table t=new Table();
        t.start();
        synchronized(t){
            t.wait();
        }
        System.out.println(t.total);


        //        MyThread th1 = new MyThread();
//        th1.start();
//        ThreadDemo th2=new ThreadDemo();
//        Thread obj=new Thread(th2);
//        obj.start();
//        Thread th=Thread.currentThread();
//        for(int i=0;i<=10;i++) {
//            Thread.sleep(2000);
//            System.out.println(th.getName() + " -->" + i);
//        }
    }
}
