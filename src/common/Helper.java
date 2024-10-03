package common;

import java.util.Scanner;

public class Helper{
    private static Scanner input=new Scanner(System.in);
	public static void validate(Object object)throws CustomException{
      if(object==null){
          throw new CustomException("object is NUll...");
      }
    }
    public static void validateTheLength(int lengthOfInputString,int length)throws CustomException{
        if(lengthOfInputString<length){
            throw new CustomException("Length is less than N");
         }
    }
    public static String getString(){
        System.out.print("Enter String:");
        return input.next();
    }
    public static int getInteger(){
        System.out.print("Enter Integer:");
        return input.nextInt();
    }
    public static double getDouble(){
        System.out.print("Enter Double:");
        return input.nextDouble();
    }
    public static long getLong(){
        System.out.print("Enter Long:");
        return input.nextLong();
    }
    public static char getChar(){
        System.out.print("Enter a Char:");
        return input.next().charAt(0);
    }

    public static String getLine(){
        System.out.print("Enter a str of Lines:");
        return input.nextLine();
    }
}
