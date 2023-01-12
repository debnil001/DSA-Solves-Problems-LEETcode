/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trie;

/**
 *
 * @author HP
 */
public class TriePractice {
    static class Node{
        Node children[]=new Node[26];
        boolean EOS=false;
//        Node(){
//            for(int i=0;i<26;i++)
//               children[i]=null;
//        }
    }
    static Node root=new Node();
    public static void insert(String s){
        Node curr=root;
        for(int i=0;i<s.length();i++){
            if(curr.children[s.charAt(i)-'a']==null){
                curr.children[s.charAt(i)-'a']=new Node();
            }
        curr=curr.children[s.charAt(i)-'a'];
        }
        curr.EOS=true;

    }
    public static boolean search(String key){
        Node curr=root;
        for(int i=0;i<key.length();i++){
            if(curr.children[key.charAt(i)-'a']==null){
                return false;
            }
            curr=curr.children[key.charAt(i)-'a'];
        }
        return curr.EOS==true;
    }
    public static void main(String[]args){
        String strs[]=new String[]{"the","a","any","there","thee"};
        for (String str : strs) {
            insert(str);
        }
        System.out.println(search("the"));
    }
}
