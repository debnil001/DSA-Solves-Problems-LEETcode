/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arraylist;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
/**
 *
 * @author HP
 */
public class ArrayListPractice {
    public static void main(String[]args){
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
//        list.add(50);
//        list.add(10);
//        list.add(60);
//        list.add(40);
//        list.add(20);
//        list.sort((a,b)->{
//            return b-a;
//        });
//        Arrays.sort(list);
          list.add(new ArrayList(Arrays.asList(1,2,3,4)));
                     list.add(new ArrayList(Arrays.asList(6,8,9,7)));
           for(ArrayList<Integer>  l:list){
               for(int i:l)
                   System.out.print(i);
           System.out.println();
           }
           int a=Integer.parseInt("0200");
           System.out.print(a);
        System.out.println(list);
    }
}
