package demo3;

public class ThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		SleepThread  sleepThread = new SleepThread();
		sleepThread.start();
		for(int i = 0; i < 10;i++) {
			System.out.println("i " + i);
			Thread.currentThread().sleep(100);
		}
		
	}
}
