import java.io.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fin;
        FileOutputStream fout;
        int i;
        try {
            try {
                fin = new FileInputStream(args[0]);
                fout = new FileOutputStream(args[1]);
                do {
                    i = fin.read();
                    if (i != -1) fout.write(i);
                } while (i != -1);
                System.out.println("File Write Successful");
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.print(e.getMessage());
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File nei");
        }
//        BufferedReader br=new BufferedReader(new FileReader("D:\\FileHandling\\src\\abc.txt"));
//        String s=br.readLine();
//        do{
//            System.out.println(s);
//            s=br.readLine();
//        }while (s!=null);
    }
}