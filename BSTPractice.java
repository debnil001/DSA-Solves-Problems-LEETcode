/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MCA;

/**
 *
 * @author HP
 */
public class BSTPractice {
    static class BST{
        int val;
        BST left;
        BST right;
        
        public BST(int val){
            this.val=val;
        }
    }
    public static BST buildBST(BST root,int val){
        if(root==null){
            BST newNode=new BST(val);
            return newNode;
        }
        if(val>root.val){
            root.right=buildBST(root.right,val);
        }
        else{
            root.left=buildBST(root.left,val);
        }
        return root;
    }
    public static BST deleteNode(BST root,int key){
        if(root==null)
            return null;
        if(key>root.val){
            root.right=deleteNode(root.right,key);
        }
        if(key<root.val)
            root.left=deleteNode(root.left,key);
        else{
            if(root.left==null && root.right==null)
                return null;
            if(root.left==null)
                    return root.right;
            if(root.right==null)
                    return root.left;
            else{
                BST IS=findInrderSuccessor(root.right);
                root.val=IS.val;
                root.right=deleteNode(root.right,IS.val);
            }
        }
        return root;
    }
    public static BST findInrderSuccessor(BST root){
        while(root.left!=null)
                root=root.left;
        return root;
    }
    public static void inorder(BST root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    public static void main(String[]args){
        int []vals=new int[]{5,6,2,9,10,7,4};
        BST root=null;
        for(int i=0;i<vals.length;i++)
            root=buildBST(root,vals[i]);
        deleteNode(root,22);
        inorder(root);
    }
}
