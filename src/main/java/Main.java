public class Main {
    public static void main(String[] args) {
        GasCar hummer = new GasCar("HoraceTheHummer", 300, 100, 100, 10);
        ElectricCar tesla = new ElectricCar("TammyTheTesla", 560, 500, 500, 2);
        hummer.drive(100);
        tesla.drive(100);
    }
}
