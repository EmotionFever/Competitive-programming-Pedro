import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// Antes de entregar mudar o nome da class para Main
public class Uva729 {

	public static int nCases;

	public static void main(String[] args) {

		if (!new Object(){}.getClass().getName().contains("Main"))
			try {   // redirect System.in and System.out to in/out text files
				System.setIn (new FileInputStream("data/uva0102.in.txt" ));
				System.setOut(new     PrintStream("data/uva0102.out.txt") );
			} catch (Exception e) {}        
		///////////////////////////////////////////////////////////////

		Scanner sc = new Scanner(System.in);
		nCases = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < nCases; i++) {
			sc.nextLine();
			int length = sc.nextInt();
			int distance = sc.nextInt();

			int arr = (int) Math.floor(Math.pow(2, length));
			for(int k = 0; k < arr; k++) {
				String x = String.format("%" + length + "s", Integer.toBinaryString(k)).replace(' ', '0');
				if(hDistance(x) == distance) {
					System.out.println(x);
				}
			}
			if(i != nCases - 1)
				System.out.println();
		}
		sc.close();
	}

	private static int hDistance(String x) {
		int acc = 0;
		for(int i = 0; i < x.length(); i++) {
			if(x.charAt(i) == '1') {
				acc++;
			}
		}
		return acc;
	}
}
