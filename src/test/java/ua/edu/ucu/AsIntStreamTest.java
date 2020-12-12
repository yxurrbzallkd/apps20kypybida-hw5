package ua.edu.ucu;

import ua.edu.ucu.stream.*;
import ua.edu.ucu.function.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author andrii
 */
public class AsIntStreamTest {

    private IntStream intStreamEmpty;
    private IntStream intStream;

    @Before
    public void init() {
        int[] intArrEmpty = {};
        intStreamEmpty = AsIntStream.of(intArrEmpty);
        int[] intArr = {-5, 3, 1, 0, 3, -2};
        intStream = AsIntStream.of(intArr);
    }

    @Test
    public void testStreamToArray() {
        int[] expResult = {-5, 3, 1, 0, 3, -2};
        int[] result = AsIntStream.streamToArray(intStream);
        assertArrayEquals(expResult, result);        
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyAverage() {
        double result = intStreamEmpty.average();
    }

    @Test
    public void testAverage() {
        double expResult = 0.0;
        double result = intStream.average();
        assertArrayEquals(expResult, result);        
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyMax() {
        int result = intStreamEmpty.max();
    }

    @Test
    public void testMax() {
        int expResult = 3;
        int result = intStream.max();
        assertArrayEquals(expResult, result);        
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyMin() {
        int result = intStreamEmpty.min();
    }

    @Test
    public void testMin() {
        int expResult = -5;
        int result = intStream.min();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testCount() {
        assertArrayEquals(0, intStreamEmpty.count());
        assertArrayEquals(6, intStream.count());  
    }

    @Test
    public void testSum() {
        assertArrayEquals(0, intStreamEmpty.sum());
        assertArrayEquals(0, intStream.sum());  
    }

    @Test
    public void testFilter() {
        IntPredicate p = new IntPredicate() {
            @Override
            public boolean test(int value){
                return value > 1;
            }
        };
        int[] result = intStream.filter(p).toArray();
        assertArrayEquals(new int[] {3, 3}, result); 
    }

    @Test
    public void testMap() {
        IntUnaryOperator o = new IntUnaryOperator() {
            @Override
            public int apply(int value){
                return value+2;
            }
        };
        int[] result = intStream.map(o).toArray();
        assertArrayEquals(new int[] {-3, 5, 3, 2, 5, 0}, result); 
    }

    @Test
    public void tesFlatMap() {
        IntToIntStreamFunction f = new IntToIntStreamFunction() {
            @Override
            public IntStream applyAsIntStream(int n){
                if (n < 2) {
                    return AsIntStream.of();
                }
                return AsIntStream.of(1, 1);
            }
        };
        int[] result = intStream.flatMap(f).toArray();
        assertArrayEquals(new int[] {1, 1, 1, 1}, result); 
    }

    @Test
    public void tesReduce() {
        IntBinaryOperator op = new IntBinaryOperator() {
            @Override
            public int apply(int left, int right){
                return left+right;
            }
        };
        assertArrayEquals(5, intStream.reduce(5, op)); 
    }

    @Test(expected = IllegalArgumentException.class)
    public void tesEmptyReduce() {
        IntBinaryOperator op = new IntBinaryOperator() {
            @Override
            public int apply(int left, int right){
                return left+right;
            }
        };
        intStreamEmpty.reduce(5, op);
    }
}
