package demo6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {
	public static void main(String[] args) {
		//使用java提供的线程池,
		ExecutorService ex = Executors.newFixedThreadPool(2);//返回线程池对象 含有了两个线程
		//提交线程任务并执行
		ex.submit(new ThreadPoolRunnable());
		ex.submit(new ThreadPoolRunnable());
	}
}
