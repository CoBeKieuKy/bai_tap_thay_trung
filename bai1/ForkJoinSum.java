import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinSum extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int start;
    private final int end;
    public static final long threshold = 10000;

    public ForkJoinSum(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSum(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= threshold) {
            return add();
        }

        ForkJoinSum firstTask = new ForkJoinSum(numbers, start, start + length / 2);
        firstTask.fork(); //start asynchronously

        ForkJoinSum secondTask = new ForkJoinSum(numbers, start + length / 2, end);

        Long secondTaskResult = secondTask.compute();
        Long firstTaskResult = firstTask.join();

        return firstTaskResult + secondTaskResult;

    }

    private long add() {
        long result = 0;
        for (int i = start; i < end; i++) {
            result += numbers[i];
        }
        return result;
    }

    public static long startForkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSum(numbers);
        return new ForkJoinPool().invoke(task);
    }
}
