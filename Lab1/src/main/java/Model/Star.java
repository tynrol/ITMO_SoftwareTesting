package Model;

public class Star {
    private double shiningLevel;
    private Location location;

    public Star(int shiningLevel, Location location) {
        this.shiningLevel = shiningLevel;
        this.location = location;
    }

    public double getShiningLevel() {
        return shiningLevel;
    }

    public void setShiningLevel(int shiningLevel) {
        this.shiningLevel = shiningLevel;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
