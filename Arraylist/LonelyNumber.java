/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author HP
 */

public class LonelyNumber {
    public static List<Integer> findLonely(int nums[]){
        List<Integer> res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>nums[i-1]+1&&nums[i]<nums[i+1]-1)
                res.add(nums[i]);
        }
        if(nums[0]<nums[1]-1)
            res.add(nums[0]);
        if(nums[nums.length-2]<nums[nums.length-1]-1)
            res.add(nums[nums.length-1]);
        
        return res;
    }
    public static void main(String[]args){
        LonelyNumber s=new LonelyNumber();
        System.out.print(s.findLonely(new int[]{10,8,3,2,5,6,7}));
    }
}
