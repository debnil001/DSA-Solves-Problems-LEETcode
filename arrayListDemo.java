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
public class arrayListDemo {
    static class Solution {
    public void help(int[]nums,int index,List<List<Integer>> res,List<Integer> ans,HashSet<List<Integer>> hs){
        if(index>=nums.length){
            if(!hs.contains(ans)){
                System.out.println(ans+"***\n\n");
                res.add(ans);
                hs.add(ans);
                System.out.println(hs);

            }
            return;
        }
        
        //include
        int element=nums[index];
        ans.add(element);
        help(nums,index+1,res,ans,hs);
        ans.remove(ans.size()-1);
        // System.out.println(ans);
        //exclude
        help(nums,index+1,res,ans,hs);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> hs=new HashSet<>();
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        help(nums,0,res,ans,hs);
        return res;
    }
}
    public static void main(String[]args){
        List<List<Integer>> al=new ArrayList<>();
        List<Integer> a=new ArrayList<>();
        a.add(5);
        a.add(4);
        al.add(a);
        List<Integer> a1=new ArrayList<>();
        a1.add(10);
        a1.add(45);
        a1.add(100);
        al.add(a1);
        Solution s=new Solution();
        al=s.subsetsWithDup(new int[]{1,2,2});
        System.out.print(al);
    }
}
class GFG {
    
    public static void main(String args[])
    {
        String str = "word1, word2 word3@.word4?word5.word6";
        String[] arrOfStr = str.split("[, ?.@]+");
  
        for (String a : arrOfStr)
            System.out.println(a);
        System.out.println(Integer.parseInt(""));
    }
}
