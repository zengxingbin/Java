package demo5;
/**
 * ʹ�������ڲ���ʵ�ֶ��߳�
 * ǰ�᣺�ӿڻ��߼̳�ʵ��
 * new ������߽ӿڣ�����
 * ��
 * @author Administrator
 *
 */
public class ThreadDemo {
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				System.out.println("���� Thread");
			}
		}.start();
		//ʹ��Runnable�ӿ�
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Runnable");
				
			}
		}).start(); 
	}
	
}
