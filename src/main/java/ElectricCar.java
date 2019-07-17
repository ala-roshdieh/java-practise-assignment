public class ElectricCar extends Car{

    private int kiloWattsAvailable;
    private int batteryCapacity;
    private int batteryEfficiency;  // km traveled per Kilowatt charge

    ElectricCar(String name, int range, int kilowattsAvailable, int batteryCapacity, int batteryEfficiency) {
        super(name, range);
        this.kiloWattsAvailable = kilowattsAvailable;
        this.batteryCapacity = batteryCapacity;
        this.batteryEfficiency = batteryCapacity;
    }

    public void charge(int amountCharged){
        int totalCharged = amountCharged + this.kiloWattsAvailable;
        if(totalCharged > batteryCapacity) {
            System.out.println("You only need charge " + (this.batteryCapacity - this.kiloWattsAvailable) + " kilowatts");
        } else if (totalCharged == batteryCapacity) {
            System.out.println("battery is full now!");
        } else {
            System.out.println(this.name + " has " + totalCharged + "kiloWatts in their battery");
        }
    }

    public void drive(int km){
        try {
            int energyConsumed = km / batteryEfficiency;
            int rangeLeft = km - range;
            if(energyConsumed > kiloWattsAvailable || rangeLeft <= 0) {
                System.out.println(this.name + " has run out of battery!");
                this.range = 0;
                this.kiloWattsAvailable = 0;
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
