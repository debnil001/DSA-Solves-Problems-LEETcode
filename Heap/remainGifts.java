/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * @author HP
 */
public class remainGifts {
    static class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:gifts)
                pq.add(i);
        while(k>0 && !pq.isEmpty()){
            int gift=pq.remove();
            int remainGift=(int)Math.floor(Math.sqrt(gift));
            pq.add(remainGift);
            k--;
        }
        int totalRemainGifts=0;
        while(!pq.isEmpty()){
                totalRemainGifts+=pq.remove();
        }
        
        return totalRemainGifts;
    }
    }
    public static void main(String[]args){
        Solution s=new Solution();
        System.out.println(s.pickGifts(new int[]{25,64,9,100,4}, 4));
    }
}
