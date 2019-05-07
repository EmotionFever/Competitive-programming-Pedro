import java.io.*;
import java.util.*;

public class Uva574 {

	public static int sum;
	public static int nNumbers;
	public static int[] numbers;
	public static List<String> ls;
	public static void main(String[] args) {

		if (!new Object(){}.getClass().getName().contains("Main"))
			try {   // redirect System.in and System.out to in/out text files
				System.setIn (new FileInputStream("data/uva0102.in.txt" ));
				System.setOut(new     PrintStream("data/uva0102.out.txt") );
			} catch (Exception e) {System.out.println("Erro");}        
		///////////////////////////////////////////////////////////////

		Scanner sc = new Scanner(System.in);
		while(true) {
			sum = sc.nextInt();
			nNumbers = sc.nextInt();
			if(nNumbers == 0) break;
			numbers = new int[nNumbers];
			for(int i = 0; i < nNumbers; i++) {
				numbers[i] = sc.nextInt();
			}
			sc.nextLine();
			System.out.println("Sums of " + sum + ":");
			ls = new ArrayList<>();
			backtracking(0, 0, "");
			if(ls.size() == 0) {
				System.out.println("NONE");
			} else {
				ls.forEach(x -> System.out.println(x));
			}
		}
		sc.close();
	}
	private static void backtracking(int n, int acc, String ext) {
		if(acc == sum) {
			String res = ext.substring(0, ext.length() - 1);
			if(!ls.contains(res))
				ls.add(res);
			return;
		}
		if(n == nNumbers) {
			return;
		}
		int num = numbers[n];
		if(num + acc <= sum)
			backtracking(n+1,acc+num,ext+Integer.toString(num)+"+");
		backtracking(n+1,acc,ext);
	}
}