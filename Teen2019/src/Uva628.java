import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// Antes de entregar mudar o nome da class para Main
public class Uva628 {

	public static int nWords;
	public static int nRules;
	public static String[] words;
	public static List<String> passwords;
	
	public static void main(String[] args) {

		if (!new Object(){}.getClass().getName().contains("Main"))
			try {   // redirect System.in and System.out to in/out text files
				System.setIn (new FileInputStream("data/uva0102.in.txt" ));
				System.setOut(new     PrintStream("data/uva0102.out.txt") );
			} catch (Exception e) {}
		///////////////////////////////////////////////////////////////

		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			passwords = new ArrayList<>();
			System.out.println("--");
			nWords = sc.nextInt();
			sc.nextLine();
			words = new String[nWords];
			for(int i = 0; i < nWords; i++) {
				words[i] = sc.nextLine();
			}
			nRules = sc.nextInt();
			sc.nextLine();
			for(int i = 0; i < nRules; i++) {
				String rule = sc.nextLine();

				generatePasswords(rule, "");
			}
			passwords.forEach(x -> System.out.println(x));
		}

		sc.close();

	}
	private static void generatePasswords(String rule, String acc) {
		if(rule.isEmpty()) {
			passwords.add(acc);
			return;
		}
		if(rule.charAt(0) == '0') {
			for(int n = 0; n < 10; n++) {
				generatePasswords(rule.substring(1), acc + Integer.toString(n));
			}
		}
		if(rule.charAt(0) == '#') {
			for(int w = 0; w < nWords; w++) {
				generatePasswords(rule.substring(1), acc + words[w]);
			}
		}
	}
}
