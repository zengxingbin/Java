package demo4;
//定一个类实现Runnable接口
//重写run方法
public class SubRunnable implements Runnable{

	@Override
	public void run() {
		
		System.out.println("runnable");
	}
	
}
