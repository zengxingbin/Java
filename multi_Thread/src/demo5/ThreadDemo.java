package demo5;
/**
 * 使用匿名内部类实现多线程
 * 前提：接口或者继承实现
 * new 父类或者接口（）｛
 * ｝
 * @author Administrator
 *
 */
public class ThreadDemo {
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				System.out.println("匿名 Thread");
			}
		}.start();
		//使用Runnable接口
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Runnable");
				
			}
		}).start(); 
	}
	
}
