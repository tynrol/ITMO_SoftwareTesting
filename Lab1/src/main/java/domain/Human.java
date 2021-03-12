package domain;

public class Human {
    String name;
    int age;
    Location location;
    boolean inSpace = false;

    public Human(String name, int age, Location location){
        this.name = name;
        this.age = age;
        this.location = location;
    }

    public String buyShip(Human oldOwner){

    }

    @Override
    public String toString(){
        return "{" +
                "name='" + name + "'" +
                "age'" + age + "'" +
                "location'" + location + "'" +
                "}";
    }
}
