/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MCA;
import java.util.*;
/**
 *
 * @author HP
 */

public class queuePractice {
    public static void generateBinary(int n){
        Queue<String> q=new LinkedList<>();
        q.add("1");
        while(n>0){
            String s1=q.peek();
            System.out.println(s1);
            q.remove();
            String s2=s1;
            q.add(s1+"0");
            q.add(s2+"1");
            n--;
        }
    }
    public static void reverseKElementsInQueue(int k,Deque<Integer> dq){
        Deque<Integer> temp=new LinkedList<>();
        int tempV=k;
        while(tempV>0){
            temp.addLast(dq.removeFirst());
            tempV--;
        }
        while(k>0){
              dq.addFirst(temp.removeLast());
              k--;
        }
    }
    public static void printQueue(Deque<Integer> dq){
        while(!dq.isEmpty())
            System.out.println(dq.removeFirst());
    }
    public static void main(String[]args){
        int n=10                                                                                                                                                                                                                                                                                                                                                                                                                                               ;
        generateBinary(n);
         Deque<Integer> q=new LinkedList<>();
//         10, 20, 30, 40, 50, 60, 70,80, 90, 100
         q.add(10);
         q.add(20);
         q.add(30);
         q.add(40);
         q.add(50);
         q.add(60);
         q.add(70);
         q.add(80);
         printQueue(q);
         reverseKElementsInQueue(3,q);
         printQueue(q);
    }
}
