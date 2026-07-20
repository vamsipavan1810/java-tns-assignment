package sample;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println(isOkay(7));
	}
	public static boolean isOkay(int n) {
		return n % 2 == 0;
	}
}
