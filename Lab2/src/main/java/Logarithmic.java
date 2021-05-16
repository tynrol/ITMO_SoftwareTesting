public class Logarithmic {

    public double ln(double x, double precision){
        if (x <= 0)
            return Double.NaN;
        double value = 0;
        double prev = 10;
        double current = 0;
        int n = 1;
        while(Math.abs(prev-current)>=precision){
            prev = current;
            current += Math.pow((x-1)/(x+1), n) / n;
            n+=2;
        }
        value = 2*current;
        Writer.print(x,value,Modules.LN);
        return value;
    }

    public double log2(double x, double precision){
        double value = ln(x,precision) / ln(2,precision);
        Writer.print(x,value,Modules.LN2);
        return value;
    }

    public double log3(double x, double precision){
        double value = ln(x,precision) / ln(3,precision);
        Writer.print(x,value,Modules.LN3);
        return value;
    }

    public double log5(double x, double precision){
        double value = ln(x,precision) / ln(5,precision);
        Writer.print(x,value,Modules.LN5);
        return value;
    }

    public double log10(double x, double precision){
        double value = ln(x,precision) / ln(10,precision);
        Writer.print(x,value,Modules.LN10);
        return value;
    }


}
