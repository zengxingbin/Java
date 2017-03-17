package demo7;

import java.util.concurrent.Callable;

public class GetSumCallable implements Callable<Integer> {
	private int num;
	public GetSumCallable(int num) {
		this.num = num;
	}
	@Override
	public Integer call() throws Exception {
		int sum  = 0;
		for(int i = 1; i <= num; i++)
			sum += i;
		return sum;
	}

}
