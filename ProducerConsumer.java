class SharedData{
    private int data;
    private boolean turn=true;
    synchronized void produce(int x){
        if(!turn){
            try{
                wait();
            }
            catch (InterruptedException e){
                System.out.println(e);
            }
        }
        this.data=x;
        System.out.println("Produce item "+this.data);
        turn=false;
        notify();

    }
    synchronized int consume(){
        if(turn){
            try {
                wait();
            }
            catch (InterruptedException e){
                System.out.println(e);
            }
        }
        System.out.println("Consumed data "+this.data);
        turn=true;
        notify();
        return this.data;
    }
}
class Producer extends Thread{
    SharedData ref;

    public Producer(SharedData x){
        this.ref=x;
    }
    public void run(){
        for(int i=1;i<=10;i++){
            ref.produce(i);
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}

class Consumer extends Thread{
    SharedData ref;
    public Consumer(SharedData x){
        this.ref=x;
    }

    public void run(){
        for(int i=1;i<=10;i++){
            ref.consume();
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        SharedData d=new SharedData();
        Producer producer=new Producer(d);
        Consumer consumer=new Consumer(d);
        producer.start();
        consumer.start();
    }
}
