import java.io.*;
import java.util.*;

// Antes de entregar mudar o nome da class para Main
public class Uva624 {
	
	public static int size;
	public static int nTracks;
	public static int[] sizeTracks;
	public static String bestTracks;
	public static int bestSum;

    public static void main(String[] args) {

        if (!new Object(){}.getClass().getName().contains("Main"))
            try {   // redirect System.in and System.out to in/out text files
                System.setIn (new FileInputStream("data/uva0102.in.txt" ));
                System.setOut(new     PrintStream("data/uva0102.out.txt") );
                } catch (Exception e) {}        
        ///////////////////////////////////////////////////////////////
         
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNextLine()) {
        	size = sc.nextInt();
        	nTracks = sc.nextInt();
        	sizeTracks = new int[nTracks];
        	for(int i = 0; i < nTracks; i++) {
        		sizeTracks[i] = sc.nextInt();
        	}
        	sc.nextLine();
        	
        	bestTracks = "";
        	bestSum = 0;

        	tracksToTake(sizeTracks, 0, "", 0);
        	System.out.print(bestTracks);
        	System.out.println("sum:" + bestSum);
        }
        
        sc.close();

	}

	private static void tracksToTake(int[] xs, int sum, String tracks, int i) {
		
		if(i == xs.length || sum == size) {
			
			if(sum > bestSum) {
				bestSum = sum;
				bestTracks = tracks;
			}
			return;
		}
		
		int newSum = sum + xs[i];
		String track = Integer.toString(xs[i]) + " ";
		if(newSum == size) {
			tracksToTake(xs, newSum, tracks + track, i + 1);
			return;
		}
		
		if(newSum > size) {
			tracksToTake(xs, sum, tracks, i + 1);
			return;
		}
		
		tracksToTake(xs, newSum, tracks + track, i + 1);
		tracksToTake(xs, sum, tracks, i + 1);
	}
}
