package Model;

public abstract class SoundSource {
    int noiseLevel;
    Location loc;

    public SoundSource(int noiseLevel, Location loc) {
        this.noiseLevel = noiseLevel;
        this.loc = loc;
    }

    public SoundSource() {
    }

    public int getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(int noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    public Location getLocation() {
        return loc;
    }

    public void setLocation(Location loc) {
        this.loc = loc;
    }
}
