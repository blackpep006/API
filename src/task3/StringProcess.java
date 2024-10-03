package task3;
import common.CustomException;
import common.Helper;
public class StringProcess{
    public int length(String inputString)throws CustomException{
        try{
        Helper.validate(inputString);
        return inputString.length();
        }catch(CustomException e){
            throw new CustomException("Exception in length ",e);
        }
    }
    public char[] toArray(String inputString)throws CustomException{
        try{
        Helper.validate(inputString);
        return inputString.toCharArray();
        }catch(CustomException e){
            throw new CustomException("Exception in toArray ",e);
        }
    }
    public char charAtNthLast(String inputString,int nthLast)throws CustomException{
        try{
        int length=length(inputString);
        Helper.validateTheLength(length,nthLast);
        return inputString.charAt(length-nthLast-1);
        }catch(CustomException e){
            throw new CustomException("Exception in charAtNthLast ",e);
        }
    }
    public int getOccurences(String inputString,char inputCharacter)throws CustomException{
        try{
        int length=length(inputString);
        Helper.validate(inputCharacter);
        int noOfOccurence=0;
        for(int i=0;i<length;i++){
            if(inputString.charAt(i)==inputCharacter){
                noOfOccurence++;
            }
        }
        return noOfOccurence;
        }catch(CustomException e){
            throw new CustomException("Exception in getOccurences ",e);
        }
    }
    public int greatestPostionOfCharater(String inputString,char inputCharacter)throws CustomException{
        try{
        Helper.validate(inputString);
        Helper.validate(inputCharacter);
        return inputString.lastIndexOf(inputCharacter);
        }catch(CustomException e){
            throw new CustomException("Exception in greatestPostionOfCharater ",e);
        }
    }
    public String lastNCharacter(String inputString,int noOfLastCharacters)throws CustomException{
        try{
        int length=length(inputString);
        Helper.validateTheLength(length,noOfLastCharacters);
        return inputString.substring(length-noOfLastCharacters);
        }catch(CustomException e){
            throw new CustomException("Exception in lastNCharacter ",e);
        }
    }
    public String firstNCharacter(String inputString,int noOfFirstCharacters)throws CustomException{
        try{
        int length=length(inputString);
        Helper.validateTheLength(length,noOfFirstCharacters);
        return inputString.substring(0,noOfFirstCharacters);
        }catch(CustomException e){
            throw new CustomException("Exception in firstNCharacter ",e);
        }
    }
    public String replaceFirstNCharacter(String inputString,int noOfFirstCharacters,String needToBeReplaces)throws CustomException{
        try{
        int length=length(inputString);
        Helper.validateTheLength(length,noOfFirstCharacters);
        return inputString.replace(inputString.substring(0,noOfFirstCharacters),needToBeReplaces);
        }catch(CustomException e){
            throw new CustomException("Exception in replaceFirstNCharacter ",e);
        }
    }
    public boolean startsWith(String inputString,String pattern)throws CustomException{
       try{
       Helper.validate(inputString);
       Helper.validate(pattern);
       return inputString.startsWith(pattern);
       }catch(CustomException e){
            throw new CustomException("Exception in startsWith ",e);
        }
    }
    public boolean endsWith(String inputString,String pattern)throws CustomException{
       try{
       Helper.validate(inputString);
       Helper.validate(pattern);
       return inputString.endsWith(pattern);
       }catch(CustomException e){
            throw new CustomException("Exception in endsWith ",e);
        }
    }
    public String upper(String inputString)throws CustomException{
       try{
       Helper.validate(inputString);
       return inputString.toUpperCase();
       }catch(CustomException e){
            throw new CustomException("Exception in upper ",e);
        }
    }
    public String lower(String inputString)throws CustomException{
       try{
       Helper.validate(inputString);
       return inputString.toLowerCase();
       }catch(CustomException e){
            throw new CustomException("Exception in lower ",e);
        }
    }
    public String reverse(String inputString)throws CustomException{
        try{
        char[] array=toArray(inputString);
        for(int i=0;i<array.length/2;i++){
              char temp=array[i];
              array[i]=array[array.length-1-i];
              array[array.length-1-i]=temp;
        }
        return new String(array);
        }catch(CustomException e){
            throw new CustomException("Exception in reverse ",e);
        }
    }
    /*
    
    output as input
    */
    public String remove(String inputString,String contentToBeRemoved,String replaceWith)throws CustomException{
        try{
        Helper.validate(inputString);
        return inputString.replaceAll(contentToBeRemoved,replaceWith);
        }catch(CustomException e){
            throw new CustomException("Exception in remove ",e);
        }
    }
    public String[] stringArray(String inputString,String splitBasedOn)throws CustomException{
        try{
        Helper.validate(inputString);
        Helper.validate(splitBasedOn);
        return inputString.trim().split(splitBasedOn);
        }catch(CustomException e){
            throw new CustomException("Exception in stringArray ",e);
        }
    }
    public String join(String joinWith,String[] inputString)throws CustomException{
        try{
        Helper.validate(inputString);
        Helper.validate(joinWith);
        return String.join(joinWith,inputString);
        }catch(CustomException e){
            throw new CustomException("Exception in join ",e);
        }
    }
    public boolean equal(String inputString1,String inputString2)throws CustomException{
        try{
        Helper.validate(inputString1);
        Helper.validate(inputString2);
       return inputString1.equals(inputString2);
       }catch(CustomException e){
            throw new CustomException("Exception in equal ",e);
        }
    }
    public boolean equalIgnoreCase(String inputString1,String inputString2)throws CustomException{
      try{
       Helper.validate(inputString1);
       Helper.validate(inputString2);
       return inputString1.equalsIgnoreCase(inputString2);
       }catch(CustomException e){
            throw new CustomException("Exception in equalIgnoreCase ",e);
        }
    }
    public String trimString(String inputString)throws CustomException{
        try{
        Helper.validate(inputString);
        return inputString.trim();
        }catch(CustomException e){
            throw new CustomException("Exception in trimString ",e);
        }
    }
}
