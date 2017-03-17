package demo;
//定一个类，继承Thread
//重写run方法
public class SubThread extends Thread{
	public void run() {
		for(int i = 0; i < 10; i++)
			System.out.println("run..." + i);
	}
}
