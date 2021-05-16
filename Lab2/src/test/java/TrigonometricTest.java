import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;

public class TrigonometricTest {
    @Test
    public void testCos(){
        Trigonometric t = new Trigonometric();
        Assertions.assertEquals(-1, BigDecimal.valueOf(t.cos(-Math.PI,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(1, BigDecimal.valueOf(t.cos(0,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(0, BigDecimal.valueOf(t.cos(Math.PI/2,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-1, BigDecimal.valueOf(t.cos(Math.PI,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(0, BigDecimal.valueOf(t.cos(3* Math.PI/2,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(0.540, BigDecimal.valueOf(t.cos(1,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-0.416, BigDecimal.valueOf(t.cos(2,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-0.654, BigDecimal.valueOf(t.cos(4,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }
    @Test
    public void testSin(){
        Trigonometric t = Mockito.spy(Trigonometric.class);
        Mockito.when(t.cos(eq(-Math.PI), anyDouble())).thenReturn(-1.0);
        Mockito.when(t.cos(eq(0), anyDouble())).thenReturn(1.0);
        Mockito.when(t.cos(eq(Math.PI/2), anyDouble())).thenReturn(0.0);
        Mockito.when(t.cos(eq(Math.PI), anyDouble())).thenReturn(-1.0);
        Mockito.when(t.cos(eq(3*Math.PI/2), anyDouble())).thenReturn(0.0);
        Mockito.when(t.cos(eq(1), anyDouble())).thenReturn(0.540);
        Mockito.when(t.cos(eq(2), anyDouble())).thenReturn(-0.416);
        Mockito.when(t.cos(eq(4), anyDouble())).thenReturn(-0.654);
        Assertions.assertEquals(0, t.sin(-Math.PI, 0.0001));
        Assertions.assertEquals(0, t.sin(0, 0.0001));
        Assertions.assertEquals(1, t.sin(Math.PI/2, 0.00001));
        Assertions.assertEquals(0, t.sin(Math.PI, 0.00001));
        Assertions.assertEquals(-1, t.sin(3*Math.PI/2, 0.00001));
        Assertions.assertEquals(0.841, BigDecimal.valueOf(t.sin(1, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(0.909, BigDecimal.valueOf(t.sin(2, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-0.757, BigDecimal.valueOf(t.sin(4, 0.00001)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }
    @Test
    public void testCot(){
        Trigonometric t = Mockito.spy(Trigonometric.class);
        Mockito.when(t.cos(eq(-Math.PI), anyDouble())).thenReturn(-1.0);
        Mockito.when(t.cos(eq(0), anyDouble())).thenReturn(1.0);
        Mockito.when(t.cos(eq(Math.PI/2), anyDouble())).thenReturn(0.0);
        Mockito.when(t.cos(eq(Math.PI), anyDouble())).thenReturn(-1.0);
        Mockito.when(t.cos(eq(3*Math.PI/2), anyDouble())).thenReturn(0.0);
        Mockito.when(t.cos(eq(1), anyDouble())).thenReturn(0.540);
        Mockito.when(t.cos(eq(2), anyDouble())).thenReturn(-0.416);
        Mockito.when(t.cos(eq(4), anyDouble())).thenReturn(-0.654);
        Mockito.when(t.sin(eq(-Math.PI), anyDouble())).thenReturn(0.0);
        Mockito.when(t.sin(eq(0), anyDouble())).thenReturn(0.0);
        Mockito.when(t.sin(eq(Math.PI/2), anyDouble())).thenReturn(1.0);
        Mockito.when(t.sin(eq(Math.PI), anyDouble())).thenReturn(0.0);
        Mockito.when(t.sin(eq(3*Math.PI/2), anyDouble())).thenReturn(-1.0);
        Mockito.when(t.sin(eq(1), anyDouble())).thenReturn(0.841);
        Mockito.when(t.sin(eq(2), anyDouble())).thenReturn(0.909);
        Mockito.when(t.sin(eq(4), anyDouble())).thenReturn(-0.757);
        Assertions.assertEquals(Double.NaN, t.cot(-Math.PI,0.0001 ));
        Assertions.assertEquals(Double.NaN, t.cot(0,0.0001 ));
        Assertions.assertEquals(0, BigDecimal.valueOf(t.cot(Math.PI/2,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(Double.NaN, t.cot(Math.PI,0.0001 ));
        Assertions.assertEquals(0, BigDecimal.valueOf(t.cot(3* Math.PI/2,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(0.642, BigDecimal.valueOf(t.cot(1,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-0.458, BigDecimal.valueOf(t.cot(2,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(0.864, BigDecimal.valueOf(t.cot(4,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }
    @Test
    public void testCsc(){
        Trigonometric t = Mockito.spy(Trigonometric.class);
        Mockito.when(t.sin(eq(-Math.PI), anyDouble())).thenReturn(0.0);
        Mockito.when(t.sin(eq(0), anyDouble())).thenReturn(0.0);
        Mockito.when(t.sin(eq(Math.PI/2), anyDouble())).thenReturn(1.0);
        Mockito.when(t.sin(eq(Math.PI), anyDouble())).thenReturn(0.0);
        Mockito.when(t.sin(eq(3*Math.PI/2), anyDouble())).thenReturn(-1.0);
        Mockito.when(t.sin(eq(1), anyDouble())).thenReturn(0.841);
        Mockito.when(t.sin(eq(2), anyDouble())).thenReturn(0.909);
        Mockito.when(t.sin(eq(4), anyDouble())).thenReturn(-0.757);
        Assertions.assertEquals(Double.NaN, t.csc(-Math.PI,0.0001 ));
        Assertions.assertEquals(Double.NaN, t.csc(0,0.0001 ));
        Assertions.assertEquals(1, BigDecimal.valueOf(t.csc(Math.PI/2,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(Double.NaN, t.csc(Math.PI,0.0001 ));
        Assertions.assertEquals(-1, BigDecimal.valueOf(t.csc(3* Math.PI/2,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(1.188, BigDecimal.valueOf(t.csc(1,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(1.100, BigDecimal.valueOf(t.csc(2,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-1.321, BigDecimal.valueOf(t.csc(4,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }
    @Test
    public void testIntegrateSin(){
        Trigonometric t = new Trigonometric();
        Assertions.assertEquals(0, BigDecimal.valueOf(t.sin(-Math.PI,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(0, BigDecimal.valueOf(t.sin(0,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(1, BigDecimal.valueOf(t.sin(Math.PI/2,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(0, BigDecimal.valueOf(t.sin(Math.PI,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-1, BigDecimal.valueOf(t.sin(3* Math.PI/2,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(0.841, BigDecimal.valueOf(t.sin(1,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(0.909, BigDecimal.valueOf(t.sin(2,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-0.757, BigDecimal.valueOf(t.sin(4,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }
    @Test
    public void testIntegrateCot(){
        Trigonometric t = new Trigonometric();
        Assertions.assertEquals(Double.NaN, t.cot(-Math.PI,0.0001 ));
        Assertions.assertEquals(Double.NaN, t.cot(0,0.0001 ));
        Assertions.assertEquals(0, BigDecimal.valueOf(t.cot(Math.PI/2,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(Double.NaN, t.cot(Math.PI,0.0001 ));
        Assertions.assertEquals(0, BigDecimal.valueOf(t.cot(3* Math.PI/2,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(0.642, BigDecimal.valueOf(t.cot(1,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-0.458, BigDecimal.valueOf(t.cot(2,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(0.864, BigDecimal.valueOf(t.cot(4,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }
    @Test
    public void testIntegrateCsc(){
        Trigonometric t = new Trigonometric();
        Assertions.assertEquals(Double.NaN, t.csc(-Math.PI,0.0001 ));
        Assertions.assertEquals(Double.NaN, t.csc(0,0.0001 ));
        Assertions.assertEquals(1, BigDecimal.valueOf(t.csc(Math.PI/2,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(Double.NaN, t.csc(Math.PI,0.0001 ));
        Assertions.assertEquals(-1, BigDecimal.valueOf(t.csc(3* Math.PI/2,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(1.188, BigDecimal.valueOf(t.csc(1,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(1.100, BigDecimal.valueOf(t.csc(2,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
        Assertions.assertEquals(-1.321, BigDecimal.valueOf(t.csc(4,0.0001 )).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());

    }
}
