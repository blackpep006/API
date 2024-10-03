package task5;
import task5.Car;
import task5.Swift;
import task5.SCross;
import task5.XUV;
import common.CustomException;
public class Runner{
    public static void carObject(Car car){
     car.maintenance();
       /*   if (car instanceof Swift) {
            System.out.println("Hatch");
        } else if (car instanceof SCross) {
            System.out.println("Sedan");
        } else if (car instanceof XUV) {
            System.out.println("SUV");
        } else {
            System.out.println("Unknown car type.");
        }*/
    }
    public static void swiftObject(Swift swift){
        
    }
    public static void main(String[] args){
     /*  try{
            Swift swift=new Swift();
            swift.setSeats(5);
            swift.setAirbags(1);
            swift.setModel("LXI");
            swift.setColor("grey");
            System.out.println("Swift");
            System.out.println("No of seats :"+swift.getSeats());
            System.out.println("No of airbags :"+swift.getAirbags());
            System.out.println("Model :"+swift.getModel());
            System.out.println("Color :"+swift.getColor());
            
            SCross sCross=new SCross();
            sCross.setSeats(7);
            sCross.setAirbags(3);
            sCross.setModel("AXR");
            sCross.setColor("white");
            sCross.SetYearOfMake(2021);
            sCross.SetEngineNumber("TF1045F");
            sCross.SetType("SUV");
            System.out.println("sCross");
            System.out.println("Year :"+sCross.getYearOfMake());
            System.out.println("EngineNumber :"+sCross.getEngineNumber());
            System.out.println("Type :"+sCross.getType());
            System.out.println("No of seats :"+sCross.getSeats());
            System.out.println("No of airbags :"+sCross.getAirbags());
            System.out.println("Model :"+sCross.getModel());
            System.out.println("Color :"+sCross.getColor());
            
            XUV xuv=new XUV();
            
            carObject(swift);
            //carObject(sCross);
            //carObject(xuv);
            
            swiftObject(swift);
            //swiftObject(new Car());
            //swiftObject(xuv);
            
            sCross.maintenance();
            Car car=sCross;
            car.maintenance();
            car=new Car();
            car.maintenance();
            swift.maintenance();
            
            XUV xuv=new XUV();
            Car aa=new Car("alpha");
            Car ava=new Car();
        } catch (CustomException e) {
            e.printStackTrace();
        }
        
        //BirdAbstract bird=new BirdAbstract();
        //ParrotMod parrot=new ParrotMod();
        //BirdAbstract bird=new ParrotMod();
        Duck duck=new Duck();
        duck.speak();
        duck.fly();
        
        
        */
        carObject(new Car());
        carObject(new SCross());
   }
}
        
        
