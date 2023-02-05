/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trie;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
class Solution {
    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;
    }
    Node root=new Node();
    public void insert(String s){
        Node curr=root;
        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            if(curr.children[idx]==null)
                curr.children[idx]=new Node();
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    public boolean search(String s){
        Node curr=root;
        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            if(curr.children[idx]==null)
                return false;
            curr=curr.children[idx];
        }
        return curr.eow==true;
    }
    private boolean helpWordBreak(String s){
        if(s.length()==0)
            return true;
        for(int i=1;i<=s.length();i++){
            if(search(s.substring(0,i))&&helpWordBreak(s.substring(i)))
                return true;
        }
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String str:wordDict){
            insert(str);
        }
        return helpWordBreak(s);
    }
}
public class WordBreakProblem {
    public static void main(String[]args){
        List<String> list=new ArrayList<>();
        list.add("I");
        list.add("like");
        list.add("sam");
        list.add("samsung");
        list.add("mobile");
        list.add("ice");
        
        Solution s=new Solution();
        System.out.println(s.wordBreak("ilikesamsung", list));
    }
}
