public class Equation {

    private Logarithmic l;
    private Trigonometric t;

    public Equation(){
        this.l = new Logarithmic();
        this.t = new Trigonometric();
    }
    public Equation(Logarithmic logarithmic, Trigonometric trigonometric){
        this.l = logarithmic;
        this.t = trigonometric;
    }

    public double calculate(double x, double precision){
        if (Math.abs(x) > Integer.MAX_VALUE)
            return Double.NaN;
        double value;
        if (x > 0){
            value = ((((Math.pow(l.log5(x,precision) + l.log3(x,precision),2)) + l.log5(x,precision))
                    + ((l.log10(x, precision) * (l.log2(x,precision)/l.ln(x,precision)))-l.ln(x,precision)))
                    + (l.log2(x,precision)+l.log5(x,precision)/l.log3(x,precision)));
        } else {
            value = ((Math.pow(((Math.pow(t.csc(x,precision)+t.cos(x,precision),3) / Math.pow(t.csc(x,precision),3) * t.cos(x, precision))
                    / (t.csc(x,precision) * t.cot(x,precision))),3) * t.cot(x,precision)) - t.csc(x, precision));
        }
        return value;
    }
}
