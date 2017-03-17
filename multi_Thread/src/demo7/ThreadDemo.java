package demo7;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//��ʹ�ö��̣߳���������ֵ��Ȼ���ڰ����Ǽ�����,����ִ��ʱ�� 
		long begin = System.currentTimeMillis();
		System.out.println(begin);
		//��ʹ�ö��̣߳���������ֵ��Ȼ���ڰ����Ǽ�����,����ִ��ʱ��
		//int sum = compute(20000,40000);
		//ʹ�ö��߳�
		int sum = compute2(20000,40000);
		long end = System.currentTimeMillis();
		System.out.println(end);
		System.out.println(end - begin);
		System.out.println(sum);
	}

	private static int compute2(int i, int j) throws InterruptedException, ExecutionException {
		//�������������̵߳��̳߳�
		ExecutorService ex = Executors.newFixedThreadPool(2);
		//�ύ�߳����񣬲�ִ��
		Future f1 = ex.submit(new GetSumCallable(i));
		Future f2 = ex.submit(new GetSumCallable(j));
		ex.shutdown();
		int sum =(Integer)f1.get() + (Integer)f2.get();
		return sum;
	}

	private static int compute(int a, int b) {
		//��û�ж��̵߳�����£���˳����㣬�ȼ�����1-i�ĺ͵�ֵ��Ȼ���ڼ���1-j�͵�ֵ
		int sum1 = 0;
		for(int i = 1; i <= a; i++)
			sum1 += i;
		int sum2 = 0;
		for(int i = 1; i <= b; i++)
			sum2 += i;
		return sum1 + sum2;
		
	}
}
