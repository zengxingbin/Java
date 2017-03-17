package demo6;

import java.util.concurrent.Callable;

public class ThreadPoolCallable implements Callable<String >{

	@Override
	public String call() throws Exception {
		for(int i = 0; i < 10; i++) {
			System.out.println(i);
			Thread.currentThread().sleep(1000);
		}
		return "callable";
	}

}
