/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MCA;
import java.util.*;
class StockSpanner{
    Stack<int[]> s;
    static int count=0;
    public StockSpanner() {
        s=new Stack<>();
    }
    public int next(int price) {
        if(count==0){
            s.push(new int[]{count,price});
            count++;
            return 1;
        }
        while(!s.isEmpty() && s.peek()[1]<price){
            s.pop();
        }
        if(s.isEmpty()){
            s.push(new int[]{count,price});
            count++;
            return count;
        }
        else{
            int prevHigh=s.peek()[0];
            int c=count;
            s.push(new int[]{count,price});
            count++;
            return c-prevHigh;
        }
    }
    public static void main(String[]args){
        StockSpanner s=new StockSpanner();
        System.out.println(s.next(80));
        System.out.println(s.next(85));
        System.out.println(s.next(76));
        System.out.println(s.next(43));
        System.out.println(s.next(26));
        System.out.println(s.next(52));
    }
}
