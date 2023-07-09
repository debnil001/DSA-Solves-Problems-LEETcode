import java.util.ArrayList;

public class Memery {
    public static void main(String[] args) {
        Runtime r=Runtime.getRuntime();

        System.out.println(r.totalMemory());
        Integer[]ints=new Integer[1000];
        r.gc();
        System.out.println(r.freeMemory());


        for(int i:ints){
            System.out.println(i);
        }
    }
}
