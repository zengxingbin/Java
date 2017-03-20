package chat_with_udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//实现一个简单的群聊程序，当前应用程序既是接收端，又是发送端,既能接收，又能发送，所以要用到多线程的技术
public class Chat {
	public static void main(String[] args) throws IOException {
		// 创建接收端和发送端
		DatagramSocket sendDs = new DatagramSocket();
		DatagramSocket receiveDs = new DatagramSocket(10000);
		// 创建两个线程任务，一个用于发送，另一个用于接收
		SendSocket ss = new SendSocket(sendDs);
		ReceiveSocket rs = new ReceiveSocket(receiveDs);
		
		//创建两个线程对象
		Thread t1 = new Thread(ss);
		Thread t2 = new Thread(rs);
		//开启线程
		t1.start();
		t2.start();
		
	}
}
//发送端线程任务对象
class SendSocket implements Runnable {
	private DatagramSocket ds;

	public SendSocket(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		//创建缓冲字符输入流
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//从键盘循环读取
		String line = null;
		try{
			while((line = br.readLine()) != null) {
				//获取字节数组
				byte[] buf = line.getBytes();
				//创建数据包封装字节数组，明确接收端主机地址和端口号
				DatagramPacket dp = new DatagramPacket(buf, buf.length,InetAddress.getLocalHost(),10000);
				//发送数据包
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
//接收端线程任务对象
class ReceiveSocket implements Runnable {
	private DatagramSocket ds;
	public  ReceiveSocket(DatagramSocket ds) {
		this.ds = ds;
	}
	
	@Override
	public void run() {
		//循环读取
		while(true) {
			//创建一个字节数组
			byte[] buf = new byte[1024];
			//创建数据包，接受数据
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			//接受数据
			try {
				ds.receive(dp);//阻塞
				int port = dp.getPort();
				String ip = dp.getAddress().getHostAddress();
				String text = new String(dp.getData(),0,dp.getLength());
				if("quit".equals(text)) {
					System.out.println(ip + "离开聊天室。。。。");
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

