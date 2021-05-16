public class Main {

    public static void main(String[] args){
        Trigonometric t = new Trigonometric();
        Logarithmic l = new Logarithmic();
        Equation equation = new Equation();
        double x = 2;
//        System.out.println("sin:" + t.sin(x, 0.001));
//        System.out.println("cos:" + t.cos(x, 0.001));
//        System.out.println("csc:" + t.csc(x,0.001));
//        System.out.println("cot:" + t.cot(x, 0.001));
        System.out.println(equation.calculate(x, 0.001));

    }
}
