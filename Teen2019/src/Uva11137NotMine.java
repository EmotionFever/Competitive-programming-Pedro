import java.io.*;
import java.util.*;

public class Uva11137NotMine {

	public static final int MAX_POT = 21;
	public static final int EXP = 3;
	public static long[] nWays;
	public static int[] coins;
	public static int total;

	public static void main(String[] args) {

		if (!new Object(){}.getClass().getName().contains("Main"))
			try {   // redirect System.in and System.out to in/out text files
				System.setIn (new FileInputStream("data/uva0102.in.txt" ));
				System.setOut(new     PrintStream("data/uva0102.out.txt") );
			} catch (Exception e) {System.out.println("Erro");}        
		///////////////////////////////////////////////////////////////
		coins = new int[MAX_POT + 1];
		fillCoins();
		nWays = new long [10000];
		nWays[0] = 1;
		for(int i = 1; i < coins.length; i++) {
			for(int j = coins[i]; j < nWays.length; j++) {
				nWays[j] += nWays[j - coins[i]];
			}
		}
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			total = sc.nextInt();
			sc.nextLine();
			
			System.out.println(nWays[total]);
		}
		sc.close();
	}

	private static void fillZeros() {
		for(int i = 1; i < nWays.length; i++) {
			nWays[i] = 0;
		}
		
	}

	private static void fillCoins() {
		for(int i = 1; i < coins.length; i++) {
			coins[i] = i*i*i;
		}
	}
}