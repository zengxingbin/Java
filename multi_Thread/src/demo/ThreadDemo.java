package demo;
//创建Thread子类对象，即创建线程对象
//调用start方法，开启线程，让jvm去执行run方法
public class ThreadDemo {
	public static void main(String[] args) {
		//创建两个线程
		SubThread subThread = new SubThread();
		SubThread subThread2 = new SubThread();
		//开启两个线程
		subThread.start();
		subThread2.start();
		for(int i = 0; i < 10; i++) {
			System.out.println("main..." + i);
			
		}
	}
}
