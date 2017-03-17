package demo;
//程序中的主线程 “main”
public class Demo {
	public static void main(String[] args) {
		System.out.println(0/0);
		function();
		System.out.println();
	}

	private static void function() {
		for(int i = 0; i < 10; i++)
			System.out.println(i);
		
	}
}

