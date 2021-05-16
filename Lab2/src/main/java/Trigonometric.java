
import java.util.*;

public class Trigonometric {

    public double cos(double x, double precision){
        boolean half = false;
        if (Math.abs(x) > 2*Math.PI)
            x = x%(2*Math.PI);
        if (Math.abs(x) > Math.PI) {
            x = x%(Math.PI);
            half = true;
        }
        double value = 0;
        double prev = 10;
        double current = 0;
        int n = 0;
        while(Math.abs(prev-current)>=precision){
            prev = current;
            int sign = (n % 2 == 0) ? 1 : -1;
            current = sign * Math.pow(x, 2*n) / CachedFactorial.factorial(2*n);
            value += current;
            n++;
        }
        value = half ? value *= -1 : value;
        Writer.print(x,value,Modules.COS);
        return value;
    }

    public double sin(double x, double precision){
        if (Math.abs(x) > 2*Math.PI)
            x = x%(2*Math.PI);
        double pow = Math.pow(cos(x, precision), 2);
        pow = pow > 1 ? 1 : pow;
        double value = Math.sqrt(1 - pow);
        if(Math.abs(x)>=Math.PI)
            value = -1 * value;
        value = x > 0 ? value : -1 * value;
        value = Math.abs(value) < precision ? 0 : value;
        Writer.print(x,value,Modules.SIN);
        return value;
    }

    public double csc(double x, double precision){
        double value = 1/sin(x,precision);
        if (value == Double.POSITIVE_INFINITY || value == Double.NEGATIVE_INFINITY)
            value = Double.NaN;
        Writer.print(x,value,Modules.CSC);
        return value;
    }
    public double cot(double x, double precision){
        double value = cos(x,precision)/sin(x,precision);
        if (value == Double.POSITIVE_INFINITY || value == Double.NEGATIVE_INFINITY)
            value = Double.NaN;

        Writer.print(x,value,Modules.COT);
        return value;
    }

}
