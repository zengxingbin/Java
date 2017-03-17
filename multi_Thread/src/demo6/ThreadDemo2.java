package demo6;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDemo2 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService ex = Executors.newFixedThreadPool(2);
		Future<String > f = ex.submit(new ThreadPoolCallable());
		Future<String > f2 = ex.submit(new ThreadPoolCallable());
		System.out.println(f.get());
		System.out.println(f2.get());
		ex.shutdown();
	}
}
