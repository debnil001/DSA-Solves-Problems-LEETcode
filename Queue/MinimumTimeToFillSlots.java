/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumTimeToFillSlots {
    public static void minTime(int arr[],int N, int K){
// Stores visited slots
        Queue<Integer> q = new LinkedList<>();
 
        // Checks if a slot is visited or not
        boolean vis[] = new boolean[N + 1];
        int time = 0;
 
        // Insert all filled slots
        for (int i = 0; i < K; i++) {
 
            q.add(arr[i]);
            vis[arr[i]] = true;
        }
 
        // Iterate until queue is
        // not empty
        while (!q.isEmpty()) {
 
            // Iterate through all slots
            // in the queue
            for (int i = 0; i < q.size(); i++) {
 
                // Front index
                int curr = q.poll();
 
                // If previous slot is
                // present and not visited
                if (curr - 1 >= 1 &&
                    !vis[curr - 1]) {
                    vis[curr - 1] = true;
                    q.add(curr - 1);
                }
 
                // If next slot is present
                // and not visited
                if (curr + 1 <= N &&
                    !vis[curr + 1]) {
 
                    vis[curr + 1] = true;
                    q.add(curr + 1);
                }
            }
 
            // Increment the time
            // at each level
            time++;
        }
 
        // Print the answer
        System.out.println(time - 1);
    }
    public static void getTime(int arr[],int n,int k){
        Queue<Integer> q=new LinkedList<>();
        boolean[]visited=new boolean[n+1];
        int time=0;
        for(int i=0;i<k;i++){
            q.add(arr[i]);
            visited[arr[i]]=true;
        }
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                System.out.println(q);
                int element=q.poll();
                if(element-1>=1 && visited[element-1]==false){
                    q.add(element-1);
                    visited[element-1]=true;
                }
                if(element+1<=n && visited[element+1]==false){
                    q.add(element+1);
                    visited[element+1]=true;
                }
            }
            time++;
        }
        System.out.println(time-1);
    }
    public static void main(String[]args){
        int arr[]=new int[]{1,2,3,4,5};
//        System.out.print(arr[0]);
            minTime(arr,5,arr.length);
    }
}
