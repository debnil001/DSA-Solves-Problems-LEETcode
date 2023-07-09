import java.io.*;
import java.util.Scanner;

class Student implements Serializable{
    int roll;
    float marks1;
    float marks2;
    public Student(int roll,float marks1,float marks2){
        this.roll=roll;
        this.marks1=marks1;
        this.marks2=marks2;
    }

    public float doAverage() {
            if(this.marks1<0 || this.marks2<0 || this.marks1>100 || this.marks2>100)
                throw new ArithmeticException("Invalid marks");
            float avg=(this.marks1+this.marks2)/2;
            return avg;
    }

    public String toString(){
        return (roll+" "+marks1+" "+marks2+"\n");
    }
}

 class Demo{
    public static void main(String[]args) throws IOException,ClassNotFoundException{
        Student[]objArr=new Student[2];
        for(int i=0;i<2;i++){
            System.out.print("Enter roll and ct marks for student"+(i+1)+"::");
            objArr[i]=new Student(new Scanner(System.in).nextInt(),new Scanner(System.in).nextFloat(),
                    new Scanner(System.in).nextFloat());
        }
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("info.txt"));
            for(int i=0;i<2;i++){
                try{
                    System.out.print("Average of student"+i+"is"+objArr[i].doAverage());
                }
                catch (ArithmeticException e){
                    System.out.print(e.getMessage()+" for student"+i);
                }
            }
            oos.writeObject(objArr);
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream("info.txt"));
            Student[]output=(Student[]) ois.readObject();

            for(Student o:output){
                System.out.println(o);
            }
    }
}
