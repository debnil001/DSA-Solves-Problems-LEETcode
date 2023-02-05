/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trie;

import static Trie.Solution.findPrefixes;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author HP
 */
class Solution {
    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;
        int freq;
        
        public Node(){
            this.freq=1;
        }
    }
    public static Node root=new Node();
    public static void insert(String s){
        Node curr=root;
        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            if(curr.children[idx]==null)
                curr.children[idx]=new Node();
            else{
                curr.children[idx].freq++;
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    
    public static void searchPrefix(Node node,ArrayList<String> res,String ans){
        if(node==null)
            return;
        if(node.freq==1){
            System.out.println(ans);
            res.add(ans);
            return;
        }
        for(int i=0;i<node.children.length;i++){
            if(node.children[i]!=null){
                searchPrefix(node.children[i],res,ans+(char)(i+'a'));
            }
        }
    }
    static String[] findPrefixes(String[] arr, int N) {
        // code here
        for(int i=0;i<N;i++){
            insert(arr[i]);
        }
        root.freq=-1;
        ArrayList<String> res=new ArrayList<>();
        searchPrefix(root,res,"");
        String[]finalResult=res.toArray(String[]::new);
        return finalResult;
    }
};
public class shortestUniquePrefix {
    public static void main(String[]args){
        String[]words=new String[]{"zebra" ,"dog" ,"duck","dove"};
        for(String s:findPrefixes(words,words.length))
                System.out.println(s);
    }
}
