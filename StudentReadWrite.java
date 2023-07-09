import java.io.*;
import java.util.ArrayList;

public class StudentReadWrite {

    public static void main(String[] args) throws IOException {
        File f=new File("STUDENT.txt");
        BufferedReader br=new BufferedReader(new FileReader(f));
        ArrayList<String>al=new ArrayList<>();
        String data;
        while((data=br.readLine())!=null){
            al.add(data);
        }
        int size=al.size();
        for(int i=0;i<size;i++){
            String d=al.get(i);
            String[]info=d.split(",");
            double marks=Double.valueOf(info[2]);
            int age=Integer.valueOf(info[1]);
            if(marks<8 || age<20){
                al.remove(i);
                i--;
                size--;
            }
        }
        BufferedWriter bw=new BufferedWriter(new FileWriter("new file.txt",true));
//        bw.write("hhooo");
        for(String d:al){
            bw.write(d);
            bw.newLine();
            System.out.println(d);
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
