import ua.edu.ucu.iterator.Queue;
import ua.edu.ucu.stream.*;
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
		*/

		int[] intArr = {-1, 0, 1, 2, 3};
		IntStream intStream = AsIntStream.of(intArr);

		/*
		System.out.println("streamOperations");
        int expResult1 = 42;
        int result1 = StreamApp.streamOperations(intStream);
		System.out.println(expResult1+" "+result1);  
		*/
		/*
		System.out.println("streamToArray");
        int[] expResult2 = {-1, 0, 1, 2, 3};
        int[] result2 = StreamApp.streamToArray(intStream);
		System.out.println(Arrays.toString(expResult2)+" "+Arrays.toString(result2));
		*/
		System.out.println("streamForEach");
        String expResult3 = "-10123";
        String result3 = StreamApp.streamForEach(intStream);
		System.out.println(expResult3+" "+result3);
	}
}