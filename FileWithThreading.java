import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Read extends Thread{
    final ArrayList<String>buffer;
    public Read(ArrayList<String> buffer){
        this.buffer=buffer;
    }
    public void run(){
        try {
            File f=new File("D:\\FileHandling\\GRADE.txt");
            Scanner sc=new Scanner(f);
            String data=null;
            while(true){
                synchronized (buffer) {
                    if (buffer.size()==10) {
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            System.out.println(e);
                        }
                    }
                    else{
                        while (buffer.size()<10 && sc.hasNextLine()) {
                            data=sc.nextLine();
                            String[] info = data.split(",");
                            if(Double.parseDouble(info[2])>9.0)
                                buffer.add(data);
                        }
                        buffer.notify();
                        if(!sc.hasNextLine())
                            break;
                    }
                }
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
class Write extends Thread{
    final ArrayList<String>buffer;
    Read thread;
    public Write(ArrayList<String>buffer,Read thread){
        this.thread=thread;
        this.buffer=buffer;
    }

    public void run(){
        try {
            FileOutputStream f=new FileOutputStream("PLACEMENT.txt");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(f));
            String data=null;
            while(true){
                synchronized (buffer) {
                    if (buffer.size()==0) {
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            System.out.println(e);
                        }
                    }
                    else{
                        while (buffer.size()>0) {
                            data=buffer.remove(0);
                            bw.write(data);
                            bw.newLine();
                            bw.flush();
                        }
                        buffer.notify();
                    }
                    if(!thread.isAlive())
                        break;
                }
            }
            FileInputStream fin=new FileInputStream("D:\\FileHandling\\PLACEMENT.txt");
            System.out.println(fin.available());
            bw.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
public class FileWithThreading {

    public static void main(String[] args) throws InterruptedException{
        ArrayList<String>buffer=new ArrayList<>();
        Read reader=new Read(buffer);
        Write writer=new Write(buffer,reader);
        long start=System.currentTimeMillis();
        reader.start();
        writer.start();

        reader.join();
        writer.join();
        long end=System.currentTimeMillis();
        System.out.println("Total time taken::"+(end-start));
    }
}
