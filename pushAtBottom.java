/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MCA;
//import java.lang.reflect.Array;
import java.util.*;
/**
 *
 * @author HP
 */

public class pushAtBottom {
    public static void pushBottom(Stack<Integer> s,int n){
        if(s.empty()){
            s.push(n);
            return;
        }
        int top=s.pop();
        pushBottom(s,n);
        s.push(top);
    }
    public static void main(String[]args){
        Stack<Integer> st=new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        pushBottom(st,5);
        while(!st.empty()){
            System.out.println(st.peek());
         st.pop();
        }
//        Arrays.sort(new int[][]{{},{}},Comparator.comparingInt(keyExtractor));
    }
}
