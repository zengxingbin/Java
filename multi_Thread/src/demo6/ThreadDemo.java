package demo6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {
	public static void main(String[] args) {
		//ʹ��java�ṩ���̳߳�,
		ExecutorService ex = Executors.newFixedThreadPool(2);//�����̳߳ض��� �����������߳�
		//�ύ�߳�����ִ��
		ex.submit(new ThreadPoolRunnable());
		ex.submit(new ThreadPoolRunnable());
	}
}
