public abstract class Car {
    String name;
    int range;

    Car(String name, int range) {
        this.name = name;
        this.range = range;
    }

    public abstract void drive(int km);
}
