/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MCA;

/**
 *
 * @author HP
 */
abstract class hello{
    public static void h(){
        System.out.print("");
    }
    public abstract void w(int w,int a);
}
public class towerOfHanoi {
    public static void TOH(int n,char src,char dest,char helper){
        if(n==1){
            System.out.println("Disk "+n+" has been moved from "+src+" to "+dest);
            return;
        }
        TOH(n-1,src,helper,dest);
        System.out.println("Disk "+n+" has been moved from "+src+" to "+dest);
        TOH(n-1,helper,dest,src);
    }
    
    public static void main(String[]args){
        int n=5;
        TOH(n,'A','C','B');
    }
}
class SqrtNum{
static int floorSqrt(int x){
    if(x==0||x==1)return x;
    int i=1,result=1;
    while(result<=x) {
        i++;
        result=i*i;
    }
    return i-1;
}
public static void main(String[]args){
int x=11;
System.out.print(floorSqrt(x));}
}
