package extendsTest;

public class Testextends {



    public static void main(String args[]){

        Car car = new Car();

        car.id = "d";
        car.name = "asdf";
        car.velosity = 3;


        CarA carA = (CarA) car;

        System.out.println(carA);

    }


}
