package task5;
import common.Helper;
import common.CustomException;
public class Car{
    private int yearOfMake;
    private String engineNumber,type;
    
    public Car(){
        System.out.println("In car default Constructor");
    }
    public Car(String string){
        System.out.println(string+"In car con");
    }
    
    public int getYearOfMake(){
        return yearOfMake;
    }
    public void SetYearOfMake(int year)throws CustomException{
        try{
            Helper.validate(year);
            this.yearOfMake=year;
        }catch(CustomException e){
            throw new CustomException("Exception in SetYearOfMake ",e);
        }
    }
    public String getEngineNumber(){
        return engineNumber;
    }
    public void SetEngineNumber(String engineNumber)throws CustomException{
        try{
            Helper.validate(engineNumber);
            this.engineNumber=engineNumber;
        }catch(CustomException e){
            throw new CustomException("Exception in SetEngineNumber ",e);
        }
    }
    public String getType(){
        return type;
    }
    public void SetType(String type)throws CustomException{
        try{
            Helper.validate(type);
            this.type=type;
        }catch(CustomException e){
            throw new CustomException("Exception in SetType ",e);
        }
    }
    public void maintenance(){
        System.out.println("Car is under Maintenance");
    }
  }
