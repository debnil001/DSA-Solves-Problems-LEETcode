/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MCA;

/**
 *
 * @author HP
 */
class Animal{
    public void eat(){
        System.out.println("Eats Anything");
    }
}
class Carnivorous extends Animal{
    public void eat(){
        System.out.println("Eats Meat");
    }
}
public class polymorphism {
    public static void main(String[]args){
        Animal obj=new Carnivorous();
//        obj.eat();
        char[]ch=new char[]{'a','b'};
        String s=new String(ch);
        String s1=s;
        char ch2='o',ch1='c';
        if(ch2>ch1){
            System.out.println("Hello");
        }
    }
}
