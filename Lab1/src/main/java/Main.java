import java.util.*;

public class Main {

    Map<Integer, Long> cache = new HashMap<>();

    public long factorial(int n){
        Long cached = cache.get(n);
        if (cached != null)
            return cached;

        long result = 1;
        if (n > 1)
            result = n * factorial(n-1);
        cache.put(n,result);
        return result;
    }

    public double cos_tailor(double x, int n){
        int sign = (n % 2 == 0) ? 1 : -1;
        return sign * Math.pow(x, 2*n) / factorial(2*n);
    }

    public double sec(double x){
        if (Math.abs(x) > Math.PI)
            return Double.NaN;
        if (Math.abs(x) == Math.PI/2)
            return Double.NaN;
        double value = 0;
        double prev = 10;
        double current = 0;
        double precision = 0.0001;
        int n = 0;
        while(Math.abs(prev-current)>=precision){
            prev = current;
            current = cos_tailor(x,n);
            value += current;
            n++;
        }
        return 1/value;
    }
    public static void main(String[] args){

//        Main obj = new Main();
//        for(double i = -Math.PI; i<Math.PI;i+=0.2) {
//            double value = obj.sec(i);
//            double expected_value = 1 / Math.cos(i);
//            System.out.printf("value: %s, expected_value: %s\n", value, expected_value);
//        }
//        MyMap<Integer, String> map = new MyMap<>();
//        map.add(1,"first");
//        map.add(2,"second");
//        map.add(3,"third");
//        map.add(4,"forth");
//        map.add(3,"not third");
//        map.add(5,"forth");
//        System.out.println(map.size());
//        System.out.println(map.isEmpty());
//        System.out.println(map.get(3));
//        System.out.println(map.remove(2));
//        System.out.println(map.size());
    }
}
