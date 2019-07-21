public class Main {

    public static void main(String[] args) {
    	long start = System.currentTimeMillis();
        System.out.println(ForkJoinSum.startForkJoinSum(1000000));
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        long sum=0;
    	start = System.currentTimeMillis();

        for( int i=0; i<=1000000; i++)
        	sum+=i;
		end  = System.currentTimeMillis();
		System.out.println(end-start);
		System.out.println(sum);
    }

}