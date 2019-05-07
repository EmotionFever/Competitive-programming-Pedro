import java.io.*;
import java.util.*;

public class Uva410 {
	public static int set;
	public static int nChambers;
	public static List<Integer>[] chambers; 
	public static int nSpecimens;
	public static int[] specimens;
	public static int sumSpecimens;
	public static void main(String[] args) {

		if (!new Object(){}.getClass().getName().contains("Main"))
			try {   // redirect System.in and System.out to in/out text files
				System.setIn (new FileInputStream("data/uva0102.in.txt" ));
				System.setOut(new     PrintStream("data/uva0102.out.txt") );
			} catch (Exception e) {System.out.println("Erro");}        
		///////////////////////////////////////////////////////////////

		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()) {
			set++;
			sumSpecimens = 0;
			nChambers = in.nextInt();
			chambers = new List[nChambers];
			for(int i = 0; i < nChambers; i++) {
				chambers[i] = new ArrayList<>(2);
			}
			nSpecimens = in.nextInt();
			in.nextLine();
			specimens = new int[nSpecimens];
			int aux;
			for(int i = 0; i < nSpecimens; i++) {
				aux = in.nextInt();
				specimens[i] = aux;
				sumSpecimens += aux;
			}
			Arrays.sort(specimens);
			in.nextLine();
			greedy(0, 0);
			// Float or Double ????????
			float am = sumSpecimens / nChambers;
			float imbalance = 0;
			int sumChamber;
			System.out.println("Set #" + set);
			for(int i = 0; i < nChambers; i++) {
				System.out.print(" " + (i + 1) + ":");
				sumChamber = 0;
				for(int s : chambers[i]) {
					System.out.print(" " + s);
					sumChamber += s;
				}
				System.out.println();
				imbalance += Math.abs(sumChamber - am);
			}
			System.out.format(Locale.US,"IMBALANCE: = %5f\n", imbalance);
		}
		in.close();
	}
	private static void greedy(int s, int c) {
		if(s == nSpecimens) {
			return;
		}
		int cc = c;
		if(c == nChambers) {
			cc = 0;
		}
		chambers[cc].add(specimens[s]);
		greedy(s + 1, cc + 1);
	}
}