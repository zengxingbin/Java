package demo7;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//不使用多线程，计算两个值，然后在把他们加起来,计算执行时间 
		long begin = System.currentTimeMillis();
		System.out.println(begin);
		//不使用多线程，计算两个值，然后在把他们加起来,计算执行时间
		//int sum = compute(20000,40000);
		//使用多线程
		int sum = compute2(20000,40000);
		long end = System.currentTimeMillis();
		System.out.println(end);
		System.out.println(end - begin);
		System.out.println(sum);
	}

	private static int compute2(int i, int j) throws InterruptedException, ExecutionException {
		//创建含有两个线程的线程池
		ExecutorService ex = Executors.newFixedThreadPool(2);
		//提交线程任务，并执行
		Future f1 = ex.submit(new GetSumCallable(i));
		Future f2 = ex.submit(new GetSumCallable(j));
		ex.shutdown();
		int sum =(Integer)f1.get() + (Integer)f2.get();
		return sum;
	}

	private static int compute(int a, int b) {
		//在没有多线程的情况下，按顺序计算，先计算完1-i的和的值，然后在计算1-j和的值
		int sum1 = 0;
		for(int i = 1; i <= a; i++)
			sum1 += i;
		int sum2 = 0;
		for(int i = 1; i <= b; i++)
			sum2 += i;
		return sum1 + sum2;
		
	}
}
