import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class Uva120 {
	
	public class Pair<L,R> {

		  private final L left;
		  private final R right;

		  public Pair(L left, R right) {
		    this.left = left;
		    this.right = right;
		  }

		  public L getKey() { return left; }
		  public R getValue() { return right; }
	}
	
	public static byte[] pancakesG;

	public static void main(String[] args) {
		
        if (!new Object(){}.getClass().getName().contains("Main"))
            try {   // redirect System.in and System.out to in/out text files
                System.setIn (new FileInputStream("data/uva0102.in.txt" ));
                System.setOut(new     PrintStream("data/uva0102.out.txt") );
            } catch (Exception e) {System.out.println("Erro");}        
        ///////////////////////////////////////////////////////////////
         
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] values = line.split(" ");
            pancakesG = new byte[values.length];
            for(int i = 0; i < pancakesG.length; i++) {
            	pancakesG[i] = Byte.parseByte(values[i]);
            }
            System.out.println(showStack());
            String res = sequenceOfFlips(pancakesG, pancakesG.length - 1);
            System.out.println(res.substring(0, res.length() - 1));
        }
        sc.close();
	}


	private static String sequenceOfFlips(byte[] ps, int j) {
		if(j == 0) {
			return "0 ";
		}
		
		Pair<Integer, Byte> res = max(ps, j);
		if(res.getValue() == ps[j]) {
			return sequenceOfFlips(ps, j - 1);
		}
		
		String sequence = "";
		int indexBiggest = res.getKey();
		// Im placing the biggest number of ps in the frst index
		byte[] psFrstBiggest = ps;
		if(indexBiggest > 0) {
			psFrstBiggest = flip(ps, indexBiggest);
			sequence = probIndex(res.getKey());
		}
		// Im placing the biggest number of ps in the last index in scope
		byte[] psLastBiggest = flip(psFrstBiggest, j);
		
		return sequence + probIndex(j) + sequenceOfFlips(psLastBiggest, j - 1);
	}

	private static byte[] flip(byte[] ps, int n) {
		int half = Math.floorDiv(n, 2);
		byte aux;
		for(int i = 0; i <= half; i++) {
			int mirrorIndex = n - i;
			aux = ps[i];
			ps[i] = ps[mirrorIndex];
			ps[mirrorIndex] = aux;
		}
		return ps;
	}

	private static String probIndex(int i) {
		return Integer.toString(pancakesG.length - i) + " ";
	}


	private static Pair<Integer, Byte> max(byte[] ps, int j) {
		byte max = ps[0];
		int index = 0;
		for(int i = 1; i <= j; i++) {
			if(max < ps[i]) {
				max = ps[i];
				index = i;
			}
		}
		return (new Uva120()).new Pair<Integer,Byte>(index, max);
		// sem (new Uva120()). isto n funciona
	}

	private static String showStack() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < pancakesG.length; i++) {
			sb.append(pancakesG[i] + " ");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}