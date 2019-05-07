import java.io.*;
import java.util.*;

public class Uva11263 {
	
	public static int nCases;
	public static int nCoins;
	public static int coins[];

	public static void main(String[] args) {

		if (!new Object(){}.getClass().getName().contains("Main"))
			try {   // redirect System.in and System.out to in/out text files
				System.setIn (new FileInputStream("data/uva0102.in.txt" ));
				System.setOut(new     PrintStream("data/uva0102.out.txt") );
			} catch (Exception e) {System.out.println("Erro");}        
		///////////////////////////////////////////////////////////////

		Scanner sc = new Scanner(System.in);
		nCases = sc.nextInt();
		sc.nextLine();
		for(int k = 0; k < nCases; k++) {
			nCoins = sc.nextInt();
			sc.nextLine();
			coins = new int[nCoins];
			for(int i = 0; i < nCoins; i++) {
				coins[i] = sc.nextInt();
			}
			int n = 1;
			int sum = coins[0];
			for(int i = 1; i < nCoins - 1; i++) {
				if(sum+coins[i]<coins[i+1]) {
					sum += coins[i];
					n++;
				}
			}
			sc.nextLine();
			System.out.println(n + 1);
		}
		sc.close();
	}
}