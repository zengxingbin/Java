package demo3;
//线程休眠，没有了cpu的执行资格
public class SleepThread extends Thread{
	public void run() {
		for(int i = 0; i < 20; i ++) {
			System.out.println(i);
			try {
				sleep(1000);//1秒钟后，线程唤醒
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
