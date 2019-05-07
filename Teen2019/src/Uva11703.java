import java.io.*;
import java.util.*;

public class Uva11703 {
	public static final int STOP = -1;
	public static final int CONST = 1000000;
	public static int num;
	public static int[] memorization;
	public static void main(String[] args) {

		if (!new Object(){}.getClass().getName().contains("Main"))
			try {   // redirect System.in and System.out to in/out text files
				System.setIn (new FileInputStream("data/uva0102.in.txt" ));
				System.setOut(new     PrintStream("data/uva0102.out.txt") );
			} catch (Exception e) {System.out.println("Erro");}        
		///////////////////////////////////////////////////////////////

		Scanner sc = new Scanner(System.in);
		memorization = new int[1000005];
		memorization[0] = 1;
		while(true) {
			num = sc.nextInt();
			sc.nextLine();
			if(num == STOP) break;
			System.out.println(recursion(num));
		}
		sc.close();
	}

	private static int recursion(int n) {
		int value = memorization[n];
		if(value != 0) {
			return value;
		}
		
		int res = recursion((int)Math.floor(n - Math.sqrt(n)))
				+ recursion((int)Math.floor(Math.log(n)))
				+ recursion((int)Math.floor(n * Math.pow(Math.sin(n), 2)));
		res %= CONST;
		memorization[n] = res;
		return res;
	}
}