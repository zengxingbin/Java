package chat_with_udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//ʵ��һ���򵥵�Ⱥ�ĳ��򣬵�ǰӦ�ó�����ǽ��նˣ����Ƿ��Ͷ�,���ܽ��գ����ܷ��ͣ�����Ҫ�õ����̵߳ļ���
public class Chat {
	public static void main(String[] args) throws IOException {
		// �������ն˺ͷ��Ͷ�
		DatagramSocket sendDs = new DatagramSocket();
		DatagramSocket receiveDs = new DatagramSocket(10000);
		// ���������߳�����һ�����ڷ��ͣ���һ�����ڽ���
		SendSocket ss = new SendSocket(sendDs);
		ReceiveSocket rs = new ReceiveSocket(receiveDs);
		
		//���������̶߳���
		Thread t1 = new Thread(ss);
		Thread t2 = new Thread(rs);
		//�����߳�
		t1.start();
		t2.start();
		
	}
}
//���Ͷ��߳��������
class SendSocket implements Runnable {
	private DatagramSocket ds;

	public SendSocket(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		//���������ַ�������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//�Ӽ���ѭ����ȡ
		String line = null;
		try{
			while((line = br.readLine()) != null) {
				//��ȡ�ֽ�����
				byte[] buf = line.getBytes();
				//�������ݰ���װ�ֽ����飬��ȷ���ն�������ַ�Ͷ˿ں�
				DatagramPacket dp = new DatagramPacket(buf, buf.length,InetAddress.getLocalHost(),10000);
				//�������ݰ�
				ds.send(dp);
				if("quit".equals(line))
					break;
			}
		}catch(Exception e) {
			
		}finally {
			ds.close();
		}
		
	}
}
//���ն��߳��������
class ReceiveSocket implements Runnable {
	private DatagramSocket ds;
	public  ReceiveSocket(DatagramSocket ds) {
		this.ds = ds;
	}
	
	@Override
	public void run() {
		//ѭ����ȡ
		while(true) {
			//����һ���ֽ�����
			byte[] buf = new byte[1024];
			//�������ݰ�����������
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			//��������
			try {
				ds.receive(dp);//����
				int port = dp.getPort();
				String ip = dp.getAddress().getHostAddress();
				String text = new String(dp.getData(),0,dp.getLength());
				if("quit".equals(text)) {
					System.out.println(ip + "�뿪�����ҡ�������");
					break;
				}
				System.out.println(text);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	} 
	
}

