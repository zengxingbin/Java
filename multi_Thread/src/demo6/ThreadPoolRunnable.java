package demo6;

public class ThreadPoolRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Runnable" + Thread.currentThread().getName());
	}

}
