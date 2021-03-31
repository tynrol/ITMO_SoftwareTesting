package Model;

public class Human {
    private String name;
    private int age, weight;
    private Location location;
    private boolean isFlying;

    public Human(String name, int age, int weight, Location location) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.location = location;
    }

    public Human(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean getFlying(){
        return this.isFlying;
    }

    public void setFlying(boolean flying) {
        isFlying = flying;
    }

    public void isFlying(){
        if (this.isFlying)
            System.out.println(this.name.toUpperCase() + " ЛЕТИТ");
        else
            System.out.println(this.name.toUpperCase() + " НЕ ПОЛЕТЕЛ :(");
    }
}
