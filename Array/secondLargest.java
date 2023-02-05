/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Array;

///**// JAVA Code for Find Second largest
// element in an array
import java.io.*;

class secondLargest {

	/* Function to print the second largest
	elements */
	public static void print2largest(int arr[],int arr_size)
	{
		int i, first, second;

		/* There should be atleast two elements */
		if (arr_size < 2) {
			System.out.print(" Invalid Input ");
			return;
		}

		first = second = Integer.MIN_VALUE;
		for (i = 0; i < arr_size; i++) {
			/* If current element is greater than
			first then update both first and second */
			if (arr[i] > first) {
				second = first;
				first = arr[i];
			}

			/* If arr[i] is in between first and
			second then update second */
			else if (arr[i] > second && arr[i] != first)
				second = arr[i];
		}

		if (second == Integer.MIN_VALUE)
			System.out.print("There is no second largest"
							+ " element\n");
		else
			System.out.print("The second largest element"
							+ " is " + second);
	}
        public static int[][] sortTheStudents(int[][] score, int k) {
        int temp[];
        for(int round=1;round<=score.length-1;round++){
            for(int j=0;j<=score.length-1-round;j++){
                if(score[j][k]<score[j+1][k]){
                    temp=score[j];
                    score[j]=score[j+1];
                    score[j+1]=temp;
                }
//                System.out.print(j+" ");
            }
//            System.out.println();
        }
        
        return score;
    }

	/* Driver program to test above function */
	public static void main(String[] args)
	{
                int a[][]=new int[][]{{10,6,9,1},{7,5,11,2},{4,8,3,15}};
//		int arr[] = a[0];
//		int n = arr.length;
//		print2largest(arr, n);
                a=sortTheStudents(a,2);
                System.out.println(a[0].length);
                for(int i[]:a){
                    for(int j:i)
                        System.out.print(j+" ");
                    System.out.println();
                }
                
	}
}
// This code is contributed by Arnav Kr. Mandal.

