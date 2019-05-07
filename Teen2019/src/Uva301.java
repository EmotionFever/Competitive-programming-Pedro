import java.io.*;
import java.util.*;

public class Uva301 {

	public static int maxPassengers;
	public static int indexOfFinalStation;
	public static int nReserv;
	public static int[] reservStart;
	public static int[] reservDest;
	public static int[] reservPass;
	public static int bestEarn;
	public static void main(String[] args) {

		if (!new Object(){}.getClass().getName().contains("Main"))
			try {   // redirect System.in and System.out to in/out text files
				System.setIn (new FileInputStream("data/uva0102.in.txt" ));
				System.setOut(new     PrintStream("data/uva0102.out.txt") );
			} catch (Exception e) {System.out.println("Erro");}        
		///////////////////////////////////////////////////////////////

		Scanner sc = new Scanner(System.in);
		while(true) {

			maxPassengers = sc.nextInt();
			indexOfFinalStation = sc.nextInt();
			nReserv = sc.nextInt();
			sc.nextLine();

			if(maxPassengers == indexOfFinalStation && indexOfFinalStation == nReserv && nReserv == 0) {
				break;
			}

			reservStart = new int[nReserv];
			reservDest = new int[nReserv];
			reservPass = new int[nReserv];
			for(int i = 0; i < nReserv; i++) {
				reservStart[i] = sc.nextInt();
				reservDest[i] = sc.nextInt();
				reservPass[i] = sc.nextInt();
				sc.nextLine();
			}
			bestEarn = 0;

			int[] nPassStation = new int[indexOfFinalStation];
			backtracking(0, 0, nPassStation);
			System.out.println(bestEarn);
		}

		sc.close();
	}
	private static void backtracking(int n, int earning, int[] nPassStation) {
		if(n == nReserv) {
			bestEarn = Math.max(bestEarn, earning);
			return;
		}
		backtracking(n+1,earning,nPassStation);
		int begin = reservStart[n];
		int end = reservDest[n];
		int pass = reservPass[n];
		int[] copy = Arrays.copyOf(nPassStation, nPassStation.length);
		for(int i = begin; i < end; i++) {
			if(nPassStation[i] + pass > maxPassengers) {
				return;
			}
			copy[i] += reservPass[n];
		}
		backtracking(n+1,earning+earningReserv(n),copy);
	}

	private static int earningReserv(int i) {
		return reservPass[i] * (reservDest[i] - reservStart[i]);
	}
}