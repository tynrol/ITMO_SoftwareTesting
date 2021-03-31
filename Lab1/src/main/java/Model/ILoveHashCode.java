package Model;

public class ILoveHashCode {
    public String key;

    public ILoveHashCode(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public int hashCode(){
        System.out.println(this.key.length());
        return this.key.length();
    }
}
