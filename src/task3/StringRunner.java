package task3;
import common.Helper;
import task3.StringProcess;
import java.io.Console;
import java.util.Scanner;
import common.CustomException;
import java.lang.Throwable;
public class StringRunner{
    StringProcess p;
    Scanner in;
    public StringRunner(){
       p=new StringProcess();
       in=new Scanner(System.in);
    }
    public void q1()throws CustomException{
        try{
        Console console=System.console();
        String inputString=console.readLine("Enter a str to find len:");
        System.out.println("Length of str:"+p.length(inputString));
        }catch(CustomException e){
            throw new CustomException("Exception in q1 ",e);
        }
    }
    public void q2()throws CustomException{
        try{
        String inputString=Helper.getString();
        char[] arr=p.toArray(inputString);
        for(int i=0;i<p.length(inputString);i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        }catch(CustomException e){
            throw new CustomException("Exception in q2 ",e);
        }
    }
    public void q3()throws CustomException{
        try{
        String inputString=null;//getString();
        int nthLast=2;
        System.out.println("char at 2nd last :"+p.charAtNthLast(inputString,nthLast));
        }catch(CustomException e){
            throw new CustomException("Exception in q3 ",e);
        }
    }
    public void q4()throws CustomException{
        try{
        String inputString=Helper.getString();
        char inputCharacter=Helper.getChar();
        System.out.println(inputCharacter+" occurs "+p.getOccurences(inputString,inputCharacter)+" in "+inputString);
        }catch(CustomException e){
            throw new CustomException("Exception in q4 ",e);
        }
    }
    public void q5()throws CustomException{
        try{
        String inputString=Helper.getString();
        char inputCharacter=Helper.getChar();
        int position=p.greatestPostionOfCharater(inputString,inputCharacter);
        System.out.println("(0 index) Greatest pos of "+inputCharacter+" in "+inputString+" is "+position);
        }catch(CustomException e){
            throw new CustomException("Exception in q5 ",e);
        }
    }
    public void q6()throws CustomException{
        try{
        String inputString=Helper.getString();
        int noOfLastCharacters=5;
        System.out.println("last 5 char are :"+p.lastNCharacter(inputString,noOfLastCharacters));
        }catch(CustomException e){
            throw new CustomException("Exception in q6 ",e);
        }
    }
    public void q7()throws CustomException{
        try{
        String inputString=Helper.getString();
        int noOfFirstCharacters=3;
        System.out.println("First 3 char are :"+p.firstNCharacter(inputString,noOfFirstCharacters));
        }catch(CustomException e){
            throw new CustomException("Exception in q7 ",e);
        }
    }  
    public void q8()throws CustomException{
        try{
        String inputString=Helper.getString();
        int noOfFirstCharacters=3;
        String needToBeReplaces="XYZ";
        System.out.println("Replaced String :"+p.replaceFirstNCharacter(inputString,noOfFirstCharacters,needToBeReplaces));
        }catch(CustomException e){
            throw new CustomException("Exception in q8 ",e);
        }
    } 
    public void q9()throws CustomException{
        try{
        String inputString=Helper.getString();
        String pattern="ent";
        System.out.println("starts with 'ent':"+p.startsWith(inputString,pattern));
        }catch(CustomException e){
            throw new CustomException("Exception in q9 ",e);
        }
    }
    public void q10()throws CustomException{
        try{
        String inputString=Helper.getString();
        String pattern="le";
        System.out.println("Ends with 'le':"+p.endsWith(inputString,pattern));
        }catch(CustomException e){
            throw new CustomException("Exception in q10 ",e);
        }
    }
    public void q11()throws CustomException{
        try{
        String inputString=Helper.getString();
        System.out.println("lower to upper:"+p.upper(inputString));
        }catch(CustomException e){
            throw new CustomException("Exception in q11 ",e);
        }
    }
    public void q12()throws CustomException{
        try{
        String inputString=Helper.getString();
        System.out.println("upper to lower:"+p.lower(inputString));
        }catch(CustomException e){
            throw new CustomException("Exception in q12 ",e);
        }
    }
    public void q13()throws CustomException{
        try{
        String inputString=Helper.getString();
        System.out.println("Reverse:"+p.reverse(inputString));
        }catch(CustomException e){
            throw new CustomException("Exception in q13 ",e);
        }
    }
    public void q14(){
        String inputString=Helper.getLine();
        System.out.println("Given Input :"+inputString);
    }
    public void q15()throws CustomException{
        try{
        String inputString=Helper.getLine();
        String contentToBeRemoved="//s+";
        String replaceWith="";
        System.out.println("Remove space :"+p.remove(inputString,contentToBeRemoved,replaceWith));
        }catch(CustomException e){
            throw new CustomException("Exception in q15 ",e);
        }
    }
    public void q16()throws CustomException{
        try{
        String inputString=Helper.getLine();
        String splitBasedOn="\\s+";
        String[] arr=p.stringArray(inputString,splitBasedOn);
        System.out.print("String Array : ");
        for(int i=0;i<arr.length;i++){
           System.out.print(arr[i]+" ");
        }
        System.out.println();
        }catch(CustomException e){
            throw new CustomException("Exception in q16 ",e);
        }
    }
    public void q17()throws CustomException{
        try{
        int n;
        String joinWith="-";
        System.out.print("Enter no of strings to join : ");
        n=in.nextInt();
        String[] inputStrings=new String[n];
        for(int i=0;i<n;i++){
            inputStrings[i]=Helper.getString();
        }
        System.out.println("Join :"+p.join(joinWith,inputStrings));
        }catch(CustomException e){
            throw new CustomException("Exception in q17 ",e);
        }
    }
    public void q18()throws CustomException{
        try{
        String inputString1=Helper.getString();
        String inputString2=Helper.getString();
        System.out.println("Two string are equal:"+p.equal(inputString1,inputString2));
        }catch(CustomException e){
            throw new CustomException("Exception in q18 ",e);
        }
    }
    public void q19()throws CustomException{
        try{
        String inputString1=Helper.getString();
        String inputString2=Helper.getString();
        System.out.println("Two string are equal case insensitive : "+p.equalIgnoreCase(inputString1,inputString2));
        }catch(CustomException e){
            throw new CustomException("Exception in q19 ",e);
        }
    }
    void q20()throws CustomException{
        try{
        String inputString=Helper.getLine();
        System.out.println("Trimmed :"+p.trimString(inputString));
        }catch(CustomException e){
            throw new CustomException("Exception in q20 ",e);
        }
    }
    public static void main(String[] args){
        StringRunner r=new StringRunner();
        //r.q1();
        //r.q2();
        //r.q3();
        //r.q4();
        //r.q5();
        //r.q6();
        //r.q7();
        //r.q8();
        //r.q9();
        //r.q10();
        //r.q11();
        //r.q12();
        //r.q13();
        //r.q14();
        //r.q15();
        //r.q16();
        //r.q17();
        //r.q18();
        //r.q19();
        //r.q20();
        int a=1;
        while(a!=-1){
            System.out.print("\n1. to accept a String & find the length of a String.\n2.convert it into character Array\n3.ind the character at the last but one place(penultimate).\n4.find the number of occurrences of a given letter/character\n5.& find the greatest position of the given letter/character \n6.last 5 characters of a given String\n7print the first 3 characters of a given String\n8.replace the first 3 characters of a String with “XYZ”\n9.check whether a String starts with “ent”\n10. check whether a String ends with “le”\n11. convert an all lowercase string to an uppercase string.\n12.convert an all uppercase string to an lowercase string\n13.reverse a String.\n14.accept a line with multiple Strings\n15.accept a line with multiple Strings and concatenate each individual Strings and output a Single String without space.\n16.accept a line with multiple Strings & enclose each String into a String array\n17.accept multiple Strings & merge each String with “-” in between\n18.check whether the two given input String are equal -case sensitive\n19.check whether the two given input String are equal -case insensitive\n20. accept a String with a space at the end & beginning or both and output the proper String with no space either at the beginning or end.\n\nEnter ur Choice : ");
            a=r.in.nextInt();
            try{
            switch(a){
            case 1:
                r.q1();break;
            case 2:
                r.q2();break;
            case 3:
                r.q3();break;
            case 4:
                r.q4();break;
            case 5:
                r.q5();break;
            case 6:
                r.q6();break;
            case 7:
                r.q7();break;
            case 8:
                r.q8();break;
            case 9:
                r.q9();break;
            case 10:
                r.q10();break;
            case 11:
                r.q11();break;
            case 12:
                r.q12();break;
            case 13:
                r.q13();break;
            case 14:
                r.q14();break;
            case 15:
                r.q15();break;
            case 16:
                r.q16();break;
            case 17:
                r.q17();break;
            case 18:
                r.q18();break;
            case 19:
                r.q19();break;
            case 20:
                r.q20();break;
            case -1:
                break;
            default:System.out.println("Enter valid number");
        }
        }catch(CustomException e){
            
          e.printStackTrace();
        }
      }
    }
}
