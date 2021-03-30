package Model;


public class Engine extends SoundSource {
    private boolean isWorking;
    private int power;

    public Engine(boolean isWorking, int power, int noiseLevel, Location location) {
        super(noiseLevel, location);
        this.isWorking = isWorking;
        this.power = power;
    }

    public Engine(){
        super();
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
