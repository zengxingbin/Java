package demo3;
//�߳����ߣ�û����cpu��ִ���ʸ�
public class SleepThread extends Thread{
	public void run() {
		for(int i = 0; i < 20; i ++) {
			System.out.println(i);
			try {
				sleep(1000);//1���Ӻ��̻߳���
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
