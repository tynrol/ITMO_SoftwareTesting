import java.util.Map;
import java.util.HashMap;

public class MyMath{

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
        double precision = 0.00001;
        int n = 0;
        while(Math.abs(prev-current)>=precision){
            prev = current;
            current = cos_tailor(x,n);
            value += current;
            n++;
        }
        return 1/value;
    }
}
