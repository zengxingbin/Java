package demo4;

public class ThreadDemo {
	public static void main(String[] args) {
		//����Runnable�ӿ�������󣬼������߳��������
		SubRunnable subRunnable = new SubRunnable();
		//�����̶߳��󣬽�Runnable�ӿ����������Ϊ�������ݸ�Thread������
		Thread thread = new Thread(subRunnable);
		//�����߳�
		thread.start();
	}
}
