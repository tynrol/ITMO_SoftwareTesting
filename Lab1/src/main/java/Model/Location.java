package Model;

public class Location {
    private int x, y, z;

    public Location(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int[] getCoordinates() {
        int[] coordinates = {x, y, z};
        return coordinates;
    }
    public void setCoordinates(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getDistance(Location location){
        return (int) Math.sqrt(Math.pow((location.getX() - this.x), 2)
                + Math.pow((location.getY() - this.y), 2)
                + Math.pow((location.getZ() - this.z), 2));
    }
}
