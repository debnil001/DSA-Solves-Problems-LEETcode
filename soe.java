/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MCA;

/**
 *
 * @author HP
 */
import java.util.*;
class SieveofEratosthenes {
    
   public static void SEO(int x)
   {
      boolean prime[]=new boolean[x+1];
      
       for(int i=0; i<=x;i++)
         {
          prime[i]=true;
         }
         
         
      for(int i=2;i*i<x;i++)
      {
          if(prime[i]==true)
          {
              for(int j=i*i;j<=x;j=j+i)
              {
                  prime[j]=false;
              }
          }
      }
      //print the prime number 
      for(int i=2;i<=x;i++)
      {
          if(prime[i]==true)
          {
             System.out.println(i+""); 
          }
      }
      
   }
           
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        SEO(n);   
        
    }   
}