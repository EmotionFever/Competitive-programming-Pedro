import java.io.*;
import java.util.*;

public class Uva1053 {

	public static int spaces;
	public static int sizePieces;
	public static List<Integer> pieces;
	public static boolean hasSolution;
	public static void main(String[] args) {

		if (!new Object(){}.getClass().getName().contains("Main"))
			try {   // redirect System.in and System.out to in/out text files
				System.setIn (new FileInputStream("data/uva0102.in.txt" ));
				System.setOut(new     PrintStream("data/uva0102.out.txt") );
			} catch (Exception e) {System.out.println("Erro");}        
		///////////////////////////////////////////////////////////////

		Scanner sc = new Scanner(System.in);
		while(true) {
			spaces = sc.nextInt();
			sc.nextLine();
			if(spaces == 0) break;
			int nPieces = sc.nextInt();
			sc.nextLine();
			sizePieces = nPieces * 2;
			//1st initial piece TO right
			sc.nextInt();
			int pieceLeft=sc.nextInt();
			sc.nextLine();
			//2nd initial piece TO left
			int pieceRight=sc.nextInt();
			//sc.nextInt();
			sc.nextLine();
			pieces = new ArrayList<Integer>(sizePieces);
			for(int i = 0; i < sizePieces; i+=2) {
				pieces.add(sc.nextInt());
				pieces.add(sc.nextInt());
				sc.nextLine();
			}
			hasSolution = backtracking(pieces, spaces, pieceLeft, pieceRight);
			System.out.println(hasSolution ? "YES" : "NO");
		}
		sc.close();
	}
	private static boolean backtracking(List<Integer> piecesLeft, int spacesLeft, int pieceLeft, int pieceRight) {
		boolean res = false;
		if(spacesLeft == 1) {
			List<Integer> pieces = piecesThatMatch(pieceLeft, pieceRight, piecesLeft);
			if(!pieces.isEmpty()) {
				return true;
			}
			return false;
		}
		List<Integer> pieceToLeft = piecesThatMatch(pieceLeft, -1, piecesLeft);
		for(int i = 0; i < pieceToLeft.size() && !res; i+=2) {
			List<Integer> newPiecesLeft = new ArrayList<Integer>(piecesLeft);
			deletePiece(pieceToLeft.get(i), pieceToLeft.get(i+1), newPiecesLeft);
			int otherSideLeft = pieceToLeft.get(i) == pieceLeft ? pieceToLeft.get(i+1) : pieceToLeft.get(i);
			res = backtracking(newPiecesLeft, spacesLeft - 1, otherSideLeft, pieceRight);
		}
		return res;
	}
	private static void deletePiece(int sideL, int sideR, List<Integer> ls) {
		int side1;
		int side2;
		for(int i = 0; i < ls.size(); i+=2) {
			side1 = ls.get(i);
			side2 = ls.get(i + 1);
			if(side1 == sideL && side2 == sideR) {
				ls.remove(i);
				ls.remove(i);
			}
		}
	}
	private static List<Integer> piecesThatMatch(int side, int sideX, List<Integer> newPiecesLeft) {
		int side1;
		int side2;
		List<Integer> ls = new ArrayList<>();
		if(sideX == -1) {
			for(int i = 0; i < newPiecesLeft.size(); i+=2) {
				side1 = newPiecesLeft.get(i);
				side2 = newPiecesLeft.get(i + 1);
				if(side1 == side || side2 == side) {
					ls.add(side1);
					ls.add(side2);
				}
			}
		} else {
			for(int i = 0; i < newPiecesLeft.size(); i+=2) {
				side1 = newPiecesLeft.get(i);
				side2 = newPiecesLeft.get(i + 1);
				if((side1 == side && side2 == sideX) || (side1 == sideX && side2 == side)) {
					ls.add(side1);
					ls.add(side2);
				}
			}
		}
		return ls;
	}

}