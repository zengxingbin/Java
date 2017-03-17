package demo2;

public class NameThread extends Thread{
	public NameThread() {
		super("Сǿ");
	}
	@Override
	public void run() {
		System.out.println("NameThread" + getName());
	}
	

}
