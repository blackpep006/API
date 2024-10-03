package task5;
import task5.Car;
import common.Helper;
import common.CustomException;
public class Swift extends Car{
    private int seats,airbags;
    private String model,color;
    public int getSeats(){
        return seats;
    }
    public void setSeats(int seats)throws CustomException{
        try{
            Helper.validate(seats);
            this.seats=seats;
        }catch(CustomException e){
            throw new CustomException("Exception in setSeats ",e);
        }
    }
    public int getAirbags(){
        return airbags;
    }
    public void setAirbags(int airbags)throws CustomException{
        try{
          Helper.validate(airbags);
            this.airbags=airbags;
        }catch(CustomException e){
            throw new CustomException("Exception in setAirbags ",e);
        }
    }
    public String getModel(){
        return model;
    }
    public void setModel(String model)throws CustomException{
        try{
            Helper.validate(model);
            this.model=model;
        }catch(CustomException e){
            throw new CustomException("Exception in SetModel ",e);
        }
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color)throws CustomException{
        try{
            Helper.validate(color);
            this.color=color;
        }catch(CustomException e){
            throw new CustomException("Exception in SetColor ",e);
        }
    }
}
