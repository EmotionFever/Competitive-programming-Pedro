import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class XRay {
	
	public static int nCases;
	public static int boneLength; 
	public static int[] radiationByCm;

	public static void main(String[] args) {
        if (!new Object(){}.getClass().getName().contains("Main"))
            try {   // redirect System.in and System.out to in/out text files
                System.setIn (new FileInputStream("data/uva0102.in.txt" ));
                System.setOut(new     PrintStream("data/uva0102.out.txt") );
            } catch (Exception e) {System.out.println("Erro");}        
        ///////////////////////////////////////////////////////////////
        
        Scanner sc = new Scanner(System.in);
        nCases = Integer.parseInt(sc.nextLine());
        for(int k = 0; k < nCases; k++) {
        	
        	boneLength = sc.nextInt();
        	radiationByCm = new int[boneLength];
        	for(int h = 0; h < boneLength; h++) {
        		radiationByCm[h] = sc.nextInt();
        	}
        	
        	int res = numberOfRads(radiationByCm, 0, boneLength - 1);
        	System.out.print("Case #" + (k + 1) + ": ");
        	System.out.println(res);
        }
        
        sc.close();
	}
	
	public static int numberOfRads(int[] rs, int i, int j) {
		
		if(j - i < 0) {
			return 0;
		}
		
		//case to increase Performance
		if(j == i) {
			return rs[i];
		}
		
		if(!hasZeros(rs, i, j)) {
			int min = min(rs, i, j);
			subtract(rs, i, j, min);
			return min + numberOfRads(rs, i, j);
		}
		
		int sum = 0;
		int beggining = i;
		for(int k = i; k <= j; k++) {
			if(rs[k] == 0) {
				sum += numberOfRads(rs, beggining, k - 1);
				beggining = k + 1;
			}
		}
		
		sum += numberOfRads(rs, beggining, j);
		
		return sum;
	}

	private static void subtract(int[] xs, int i, int j, int n) {
		for(int k = i; k <= j; k++) {
			xs[k] -= n;
		}
	}

	private static int min(int[] xs, int i, int j) {
		int res = xs[i];
		for(int k = i + 1; k <= j; k++) {
			res = res > xs[k] ? xs[k] : res;
		}
		return res;
	}

	private static boolean hasZeros(int[] xs, int i, int j) {
		for(int k = i; k <= j; k++) {
			if(xs[k] == 0) {
				return true;
			}
		}
		return false;
	}
}
