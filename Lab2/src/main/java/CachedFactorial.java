import java.util.HashMap;
import java.util.Map;

public class CachedFactorial {

    private static Map<Integer, Long> cache = new HashMap<>();

    public static long factorial(int n){
            Long cached = cache.get(n);
            if (cached != null)
                return cached;

            long result = 1;
            if (n > 1)
                result = n * factorial(n - 1);
            cache.put(n, result);
            return result;
    }
}
