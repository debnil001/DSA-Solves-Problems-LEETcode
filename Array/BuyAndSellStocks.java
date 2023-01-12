/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Array;

/**
 *
 * @author HP
 */
public class BuyAndSellStocks {
    public int buyAndSell(int arr[]){
        int buyPrice=Integer.MAX_VALUE;
        int profit=0;
        for(int i=0;i<arr.length;i++){
            if(buyPrice<arr[i])
                profit=Math.max(profit, arr[i]-buyPrice);
            
            else
                buyPrice=arr[i];
        }
        return profit;
    }
    public static void main(String[]args){
        int prices[]=new int[]{0,1,5,3,8,4};
        BuyAndSellStocks ob=new BuyAndSellStocks();
        System.out.println(ob.buyAndSell(prices));
    }
}
