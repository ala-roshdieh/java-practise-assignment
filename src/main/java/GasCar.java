public class GasCar extends Car {

    //amount gas in liters
    private int gasolineAvailable;
    private int fuelTankCapacity;
    private int fuelEfficiency; //km travelled per litre fuel

    GasCar(String name, int range, int gasolineAvailable, int fuelTankCapacity, int fuelEfficiency) {
        super(name, range);
        this.gasolineAvailable = gasolineAvailable;
        this.fuelTankCapacity = fuelTankCapacity;
        this.fuelEfficiency = fuelEfficiency;
    }

    public void fillUp(int amountPumped){
        int totalGas = amountPumped + this.gasolineAvailable;
        if(totalGas > fuelTankCapacity) {
            System.out.println("You only need add " + (this.fuelTankCapacity - this.gasolineAvailable) + " litres of gas");
        } else if (totalGas == fuelTankCapacity) {
            System.out.println("tank is full now!");
        } else {
            System.out.println("You have " + totalGas + " litres of gas");
        }
    }

    public void drive(int km) {
        try {
            int rangeLeft = range - km;
            int energyConsumed = km / fuelEfficiency;
            if(energyConsumed > gasolineAvailable || rangeLeft <= 0) {
                System.out.println(this.name + "has  run out of fuel!");
                this.range = 0;
                this.gasolineAvailable = 0;
                throw new CarOutOfRangeException();
            } else {
                System.out.println(this.name + " can drive for " + rangeLeft + " more kilometres");
            }
        }
        catch(CarOutOfRangeException e) {
            System.out.println(e.getMessage());
        }

    }
}
