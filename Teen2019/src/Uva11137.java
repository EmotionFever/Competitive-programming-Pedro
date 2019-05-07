import java.io.*;
import java.util.*;

public class Uva11137 {
	
	public static final int MAX_POT = 21;
	public static final int EXP = 3;
	public static int nWays;
	public static int total;

	public static void main(String[] args) {

		if (!new Object(){}.getClass().getName().contains("Main"))
			try {   // redirect System.in and System.out to in/out text files
				System.setIn (new FileInputStream("data/uva0102.in.txt" ));
				System.setOut(new     PrintStream("data/uva0102.out.txt") );
			} catch (Exception e) {System.out.println("Erro");}        
		///////////////////////////////////////////////////////////////

		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			nWays = 0;
			total = sc.nextInt();
			sc.nextLine();
			backtracking(total, 1);
			System.out.println(nWays);
		}
		sc.close();
	}

	private static void backtracking(int left, int pot) {
		if(left == 0) {
			nWays++;
			return;
		}
		
		for(int i = pot, value = (int) Math.pow(pot, 3); i <= MAX_POT && value <= left; i++, value = i*i*i) {
			backtracking(left - value, i);
		}
	}
}