package demo;
//����Thread������󣬼������̶߳���
//����start�����������̣߳���jvmȥִ��run����
public class ThreadDemo {
	public static void main(String[] args) {
		//���������߳�
		SubThread subThread = new SubThread();
		SubThread subThread2 = new SubThread();
		//���������߳�
		subThread.start();
		subThread2.start();
		for(int i = 0; i < 10; i++) {
			System.out.println("main..." + i);
			
		}
	}
}
