package domain;

public class SpaceShip {
    int enginePower;
    boolean engineIsOn;
    Location location;
    int capacity;
    Human[] passangers;
    int amountPassangers;
    Human owner;



    public SpaceShip(int enginePower, Location location, int capacity, Human owner){
        this.enginePower = enginePower;
        this.location = location;
        this.capacity = capacity;
        this.passangers = new Human[capacity];
        this.owner = owner;
    }

    public String addPassanger(Human human){
        if (amountPassangers < capacity){
            amountPassangers++;
            passangers[amountPassangers] = human;
            return "Passanger added";
        }
        return "Not enought seats";
    }
    public String removePassanger(Human human){
        for(int i=0;i<=amountPassangers;i++){
            if(passangers[i].equals(human)){
                for(int j=i;j<=amountPassangers;j++){
                    passangers[j]=passangers[j+1];
                }
                passangers[amountPassangers] = null;
                amountPassangers--;
                return "Passanger ejected";
            }
            return "No such person";
        }
        return "No passangers";
    }
}
