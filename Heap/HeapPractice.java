package Heap;

import java.util.*;
public class HeapPractice {
    static class Heap{
        ArrayList<Integer> al=new ArrayList<>();
        
        public void insert(int data){
            al.add(data);
            
            int childIdx=al.size()-1;
            int parentIdx=(childIdx-1)/2;
            
            while(al.get(childIdx)<al.get(parentIdx)){
                int temp=al.get(childIdx);
                al.set(childIdx, al.get(parentIdx));
                al.set(parentIdx, temp);
                
                childIdx=parentIdx;
                parentIdx=(childIdx-1)/2;
            }
        }
        private void heapify(int i){
            int left=2*i+1;
            int right=2*i+2;
            int minElementIdx=i;
            
            if(left<al.size() && al.get(left)<al.get(minElementIdx) ){
                minElementIdx=left;
            }
            if(right<al.size() && al.get(right)<al.get(minElementIdx))
                minElementIdx=right;
             
            if(minElementIdx!=i){
                int temp=al.get(i);
                al.set(i, al.get(minElementIdx));
                al.set(minElementIdx, temp);
                
                heapify(minElementIdx);
            }
        }
        public int delete(){
            int minElement=al.get(0);
            
            al.set(0, al.get(al.size()-1));
            al.set(al.size()-1, minElement);
            
            al.remove(al.size()-1);
            heapify(0);
            return minElement; 
        }
        public int peek(){
            return al.get(0);
        }
    }
    public static void main(String[]args){
        Heap pq=new Heap();
        
        pq.insert(5);
        pq.insert(1);
        pq.insert(3);
        pq.insert(0);
        pq.insert(-1);
        pq.insert(-1);
        pq.insert(-1);

//        System.out.println(pq.peek());
        
        System.out.println(pq.delete());
        System.out.println(pq.delete());
        System.out.println(pq.delete());
        System.out.println(pq.delete());

    }
}
