import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;

public class CalculationTest {
    @Test
    public void testFunc(){
        Logarithmic l = Mockito.spy(Logarithmic.class);
        Trigonometric t = Mockito.spy(Trigonometric.class);

        Mockito.when(l.ln(eq(1), anyDouble())).thenReturn(0.0);
        Mockito.when(l.ln(eq(2), anyDouble())).thenReturn(0.693);
        Mockito.when(l.ln(eq(4), anyDouble())).thenReturn(1.386);

        //Mockito.when(l.log2(eq(1), anyDouble())).thenReturn(0.0);
        Mockito.when(l.log2(eq(2), anyDouble())).thenReturn(1.0);
        Mockito.when(l.log2(eq(4), anyDouble())).thenReturn(2.0);

        //Mockito.when(l.log3(eq(1), anyDouble())).thenReturn(0.0);
        Mockito.when(l.log3(eq(2), anyDouble())).thenReturn(0.631);
        Mockito.when(l.log3(eq(4), anyDouble())).thenReturn(1.262);

        //Mockito.when(l.log5(eq(1), anyDouble())).thenReturn(0.0);
        Mockito.when(l.log5(eq(2), anyDouble())).thenReturn(0.431);
        Mockito.when(l.log5(eq(4), anyDouble())).thenReturn(0.861);

        //Mockito.when(l.log10(eq(1), anyDouble())).thenReturn(0.0);
        Mockito.when(l.log10(eq(2), anyDouble())).thenReturn(0.301);
        Mockito.when(l.log10(eq(4), anyDouble())).thenReturn(0.602);

        Mockito.when(t.cos(eq(-1), anyDouble())).thenReturn(0.540);
        Mockito.when(t.cos(eq(-2), anyDouble())).thenReturn(-0.416);
        Mockito.when(t.cos(eq(-4), anyDouble())).thenReturn(-0.654);

        Mockito.when(t.sin(eq(-1), anyDouble())).thenReturn(-0.814);
        Mockito.when(t.sin(eq(-2), anyDouble())).thenReturn(-0.909);
        Mockito.when(t.sin(eq(-4), anyDouble())).thenReturn(0.757);

        Mockito.when(t.cot(eq(-1), anyDouble())).thenReturn(-0.642);
        Mockito.when(t.cot(eq(-2), anyDouble())).thenReturn(0.458);
        Mockito.when(t.cot(eq(-4), anyDouble())).thenReturn(-0.863);

        Mockito.when(t.csc(eq(-1), anyDouble())).thenReturn(-1.188);
        Mockito.when(t.csc(eq(-2), anyDouble())).thenReturn(-1.100);
        Mockito.when(t.csc(eq(-4), anyDouble())).thenReturn(1.321);

        Equation e = new Equation(l,t);
        Assertions.assertEquals(1.149, BigDecimal.valueOf(e.calculate(-1, 0.001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(859.800, BigDecimal.valueOf(e.calculate(-2, 0.001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(14.336, BigDecimal.valueOf(e.calculate(-4, 0.001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(Double.NaN, e.calculate(1, 0.001));
        Assertions.assertEquals(0, BigDecimal.valueOf(e.calculate(2, 0.001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(0, BigDecimal.valueOf(e.calculate(4, 0.001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }
}
