/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author HP
 */
public class PriorityQueuePractice {
    static class Student implements Comparable<Student>{
        int roll;
        public Student(int roll){
            this.roll=roll;
        }

        @Override
        public int compareTo(Student that) {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            return this.roll-that.roll;
        }
    }
    public static void main(String[]args){
        PriorityQueue<Student> pq=new PriorityQueue<>(Comparator.reverseOrder());
//        pq.add(10);
        pq.add(new Student(10));
        pq.add(new Student(8));
        pq.add(new Student(5));
        pq.add(new Student(14));
        System.out.println(pq.remove().roll);
        System.out.println(pq.remove().roll);

    }
}
