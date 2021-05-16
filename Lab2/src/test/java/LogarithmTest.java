import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;

public class LogarithmTest {
    @Test
    public void testLN(){
        Logarithmic log = new Logarithmic();
        Assertions.assertEquals(0, log.ln(1,0.00001));
        Assertions.assertEquals(Double.NaN, log.ln(0,0.00001));
            Assertions.assertEquals(1.000, BigDecimal.valueOf(log.ln(Math.E, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-1.386, BigDecimal.valueOf(log.ln(0.25, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-0.693, BigDecimal.valueOf(log.ln(0.5, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-0.288, BigDecimal.valueOf(log.ln(0.75, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(1.609, BigDecimal.valueOf(log.ln(5, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(2.303, BigDecimal.valueOf(log.ln(10, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }
    @Test
    public void testModuleLN(){
        Logarithmic log = Mockito.spy(Logarithmic.class);
        Mockito.when(log.ln(eq(1), anyDouble())).thenReturn(0.0);
        Mockito.when(log.ln(eq(0), anyDouble())).thenReturn(Double.NaN);
        Mockito.when(log.ln(eq(0.25), anyDouble())).thenReturn(-1.386);
        Mockito.when(log.ln(eq(0.75), anyDouble())).thenReturn(-0.288);
        Mockito.when(log.ln(eq(5), anyDouble())).thenReturn(1.609);
        Assertions.assertEquals(0, BigDecimal.valueOf(log.log2(1,0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(Double.NaN, log.log2(0,0.00001));
        Assertions.assertEquals(-2, BigDecimal.valueOf(log.log2(0.25,0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-0.415, BigDecimal.valueOf(log.log2(0.75,0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(2.322, BigDecimal.valueOf(log.log2(5,0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }
    @Test
    public void testIntegrateLN(){
        Logarithmic log = new Logarithmic();
        Assertions.assertEquals(0, log.log2(1,0.00001));
        Assertions.assertEquals(Double.NaN, log.log2(0, 0.00001));
        Assertions.assertEquals(1.443, BigDecimal.valueOf(log.log2(Math.E, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-2, BigDecimal.valueOf(log.log2(0.25, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-1, BigDecimal.valueOf(log.log2(0.5, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-0.415, BigDecimal.valueOf(log.log2(0.75, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(2.322, BigDecimal.valueOf(log.log2(5, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(3.322, BigDecimal.valueOf(log.log2(10, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }
}
