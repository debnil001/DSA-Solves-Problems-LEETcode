import java.util.ArrayList;
import java.util.Random;

class Fill_Up extends Thread{
    Random r=new Random();
    final ArrayList<Integer>buffer;
    public Fill_Up(ArrayList<Integer>ref){
        this.buffer=ref;
    }
    public void run(){
        while (true) {
            synchronized(buffer) {
                if(buffer.size()>0){
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
                else {
                    int data = r.nextInt(10) + 1;
                    buffer.add(data);
                    System.out.println("Produced data " + data);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    buffer.notify();
                }
            }
        }
    }
}
class Vacant extends Thread{
    ArrayList<Integer>buffer;
    public Vacant(ArrayList<Integer>ref){
        this.buffer=ref;
    }
    public void run(){
        while (true){
            synchronized (buffer) {
                if (buffer.size() == 0) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
                else {
                    System.out.println("Consumed data " + buffer.remove(0));
                    buffer.notify();
                }
            }

        }
    }
}
public class QueueThreading {
    public static void main(String[] args) {


        ArrayList<Integer> buffer = new ArrayList<>();

        Fill_Up fp = new Fill_Up(buffer);
        Vacant vc = new Vacant(buffer);
        fp.start();
        vc.start();
    }

}
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//class ArrayListReadWriteExample {
//    private static final int MAX_CAPACITY = 10;
//    private static final int MAX_RANDOM_INT = 10;
//
//    private static List<Integer> sharedList = new ArrayList<>();
//
//    public static void main(String[] args) {
//        Thread writerThread = new Thread(() -> {
//            Random random = new Random();
//
//            while (true) {
//                synchronized (sharedList) {
//                    while (sharedList.size() >= MAX_CAPACITY) {
//                        try {
//                            sharedList.wait(); // Wait for vacant space in the list
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    int randomInt = random.nextInt(MAX_RANDOM_INT) + 1;
//                    sharedList.add(randomInt);
//                    System.out.println("Writer: Added " + randomInt);
//                    sharedList.notifyAll(); // Notify waiting reader thread(s)
//                }
//
//                try {
//                    Thread.sleep(1000); // Sleep for 1 second before writing again
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        Thread readerThread = new Thread(() -> {
//            while (true) {
//                synchronized (sharedList) {
//                    while (sharedList.isEmpty()) {
//                        try {
//                            sharedList.wait(); // Wait for elements in the list
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    int randomIndex = new Random().nextInt(sharedList.size());
//                    int randomInt = sharedList.get(randomIndex);
//                    sharedList.remove(randomIndex);
//                    System.out.println("Reader: Removed " + randomInt);
//                    sharedList.notifyAll(); // Notify waiting writer thread(s)
//                }
//
//                try {
//                    Thread.sleep(1000); // Sleep for 1 second before reading again
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        writerThread.start();
//        readerThread.start();
//    }
//}
