import java.util.Scanner;

public class Scanner {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println ("First number? ");
		int x = sc.nextInt ();
		System.out.println  ("Second number? ");
		int y = sc.nextInt ();
		System.out.println ("Sum = " + (x + y));
		sc.close ();
	}
}