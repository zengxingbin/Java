package demo4;

public class ThreadDemo {
	public static void main(String[] args) {
		//创建Runnable接口子类对象，即创建线程任务对象
		SubRunnable subRunnable = new SubRunnable();
		//创建线程对象，将Runnable接口子类对象作为参数传递给Thread构造器
		Thread thread = new Thread(subRunnable);
		//开启线程
		thread.start();
	}
}
