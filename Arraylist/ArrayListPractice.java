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
        ArrayList<Integer> list=new ArrayList<>();
        list.add(50);
        list.add(10);
        list.add(60);
        list.add(40);
        list.add(20);
        list.sort((a,b)->{
            return b-a;
        });
//        Arrays.sort(list);
        System.out.println(list);
    }
}
