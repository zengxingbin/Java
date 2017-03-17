package demo2;

public class ThreadDemo {
	public static void main(String[] args) {
		NameThread nt = new NameThread();
		NameThread nt2 = new NameThread();
		nt.setName("Ð¡¶«");
		nt.start();
		nt2.start();
		System.out.println(Thread.currentThread().getName());
	}
}
