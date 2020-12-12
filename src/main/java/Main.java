import ua.edu.ucu.iterator.Queue;
import ua.edu.ucu.stream.*;
import ua.edu.ucu.function.*;
import ua.edu.ucu.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		/*
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(0);
		q.enqueue(5);
		q.enqueue(10);
		for (int i: q) {
			System.out.println(i);
		}

		int[] intArr = {-1, 0, 1, 2, 3};
		IntStream intStream = AsIntStream.of(intArr);

		System.out.println("streamOperations");
        int expResult1 = 42;
        int result1 = StreamApp.streamOperations(intStream);
		System.out.println(expResult1+" "+result1);  
		
		System.out.println("streamToArray");
        int[] expResult2 = {-1, 0, 1, 2, 3};
        int[] result2 = StreamApp.streamToArray(intStream);
		System.out.println(Arrays.toString(expResult2)+" "+Arrays.toString(result2));

		System.out.println("streamForEach");
        String expResult3 = "-10123";
        String result3 = StreamApp.streamForEach(intStream);
		System.out.println(expResult3+" "+result3);
		*/
		int[] intArrEmpty = {};
        IntStream intStreamEmpty = AsIntStream.of(intArrEmpty);
        int[] intArr = {-5, 3, 1, 0, 3, -2};
		IntStream  intStream = AsIntStream.of(intArr);
		/*IntPredicate p = new IntPredicate() {
            public boolean test(int value){
                return value > 1;
            }
		};*/
		/*IntUnaryOperator o = new IntUnaryOperator() {
            @Override
            public int apply(int value){
                return value+2;
            }
		};*/
		/*
		IntToIntStreamFunction f = new IntToIntStreamFunction() {
            @Override
            public IntStream applyAsIntStream(int n){
                if (n < 2) {
                    return AsIntStream.of();
                }
                return AsIntStream.of(new int[] {1, 1});
            }
		};
        int[] result = intStream.flatMap(f).toArray();
		*/
		//int[] result = intStream.map(o).toArray();
		//int[] result = intStream.filter(p).toArray();
		IntBinaryOperator op = new IntBinaryOperator() {
            @Override
            public int apply(int left, int right){
                return left+right;
            }
        };
        int result = intStream.reduce(5, op);
		//System.out.println(Arrays.toString(result));
		//System.out.println(intStreamEmpty.sum()+" "+intStream.sum());
		//System.out.println(intStreamEmpty.count()+" "+intStream.count());
		//int result = intStream.min();
		//int result = intStreamEmpty.min();
		//int result = intStream.max();
		//int result = intStreamEmpty.max();
		//double result = intStream.average();
		System.out.println(result);
		//double result = intStreamEmpty.average();
		/*
		int[] expResult = {-5, 3, 1, 0, 3, -2};
        int[] result = intStream.toArray();
		System.out.println(Arrays.toString(result));
		*/
	}
}