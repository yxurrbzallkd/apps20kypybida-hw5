package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;
import java.util.Iterator;
import ua.edu.ucu.iterator.*;
import java.util.Arrays;

public class AsIntStream implements IntStream {

    private Queue<Integer> values;

    private AsIntStream(Queue<Integer> q) {
        this.values = q;
    }

    public static IntStream of(int... values) {
        Queue<Integer> q = new Queue<Integer>();
        for (int i: values) {
            q.enqueue(i);
        }
        return new AsIntStream(q);
    }

    @Override
    public Double average() {
        int length = this.values.length();
        if (this.values.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Double avg = 0.0;
        for (int i: this.values) {
            avg += i;
        }
        return avg/length;
    }

    @Override
    public Integer max() {
        if (this.values.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Integer max = Integer.MIN_VALUE;
        for (int i: this.values) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public Integer min() {
        if (this.values.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Integer min = Integer.MAX_VALUE;
        for (int i: this.values) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    @Override
    public long count() {
        long length = 0;
        for (int i: this.values) {
            length++;
        }
        return length;
    }

    @Override
    public Integer sum() {
        Integer sum = 0;
        for (Integer i: this.values) {
            sum += i;
        }
        return sum;
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        Queue<Integer> q = new Queue<Integer>();
        for (int i: this.values) {
            if (predicate.test(i)) {
                q.enqueue(i);
            }
        }
        return new AsIntStream(q);
    }

    @Override
    public void forEach(IntConsumer action) {
        for (int i: this.values) {
            action.accept(i);
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        Queue<Integer> q = new Queue<Integer>();
        for (int i: this.values) {
            q.enqueue(mapper.apply(i));
        }
        return new AsIntStream(q);
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        Queue<Integer> q = new Queue<Integer>();
        for (int i: this.values) {
            for (int j: (func.applyAsIntStream(i)).toArray()) {
                q.enqueue(j);
            }
        }
        return new AsIntStream(q);
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        int reduced = 0;
        int[] arr = this.toArray();
        if (arr.length == 0) {
            throw new IllegalArgumentException();
        }
        reduced += op.apply(identity, arr[0]);
        for (int i = 1; i < arr.length; i++) {
            reduced = op.apply(reduced, arr[i]);
        }
        return reduced;
    }

    @Override
    public int[] toArray() {
        int[] array = new int[this.values.length()];
        int j = 0;
        for (int n: this.values) {
            array[j] = n;
            j++;
        }
        return array;
    }
}
