/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Array;

public class MultiplyTwoStrings {
  public static  String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        int res[]=new int[num1.length()+num2.length()];
        num1=new StringBuilder(num1).reverse().toString();
        num2=new StringBuilder(num2).reverse().toString();
        for(int pos1=0;pos1<num2.length();pos1++){
            for(int pos2=0;pos2<num1.length();pos2++){
                int digit=(num1.charAt(pos2)-48)*(num2.charAt(pos1)-48);
                res[pos1+pos2]+=digit;
                res[pos1+pos2+1]+=(res[pos1+pos2]/10);
                res[pos1+pos2]=res[pos1+pos2]%10;
            }
        }
        int i=res.length-1;
        String finalResult="";
        for(;i>=0 && res[i]==0;i--);
        for(int j=i;j>=0;j--){
            finalResult+=String.valueOf(res[j]);
        }
        return finalResult;
    }
    public static void main(String[]args){
        String num1="2049874329569346590314032475981765481654981644659031654916541403247598176" +
"5481654984659031654916541403247598176548165490498743204987432049874328465" +
"9031654916541403247598176548165498465903165491654140324759817654816549840" +
"4987432049874326590316654916541403247598176548165498164";
        String num2="5491654140324759817654816549816454916541403247598176548165498164549165414" +
"0324759817654816549816446590316549165414032475981765481654984659031654916" +
"5414032475981765481654904987432049874320498743284659031654916541403247598" +
"1765481654984659031654916541403247598176548165498404987432049874326590316" +
"5491654140324759817654816549846590316549165414032475981765481654980498743" +
"2";
        System.out.println(multiply(num1,num2));
    }
}
