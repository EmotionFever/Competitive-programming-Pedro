import java.io.*;
import java.util.*;

// Antes de entregar mudar o nome da class para Main
public class Uva264 {
	

    public static void main(String[] args) {

        if (!new Object(){}.getClass().getName().contains("Main"))
            try {   // redirect System.in and System.out to in/out text files
                System.setIn (new FileInputStream("data/uva0102.in.txt" ));
                System.setOut(new     PrintStream("data/uva0102.out.txt") );
            } catch (Exception e) {}        
        ///////////////////////////////////////////////////////////////
         
        Scanner in = new Scanner(System.in);
        
        while(in.hasNextLine()) {
            int n = in.nextInt();
            in.nextLine();

            int diagonal = (int) Math.round(Math.sqrt(2*n-1));

            int x = n-(diagonal-1)*(1+(diagonal-1))/2;
            int y = (diagonal+1)-x;

            if(diagonal % 2 != 0) {
            	int aux = x;
            	x=y;
            	y=aux;
            }
            
            System.out.printf("TERM %d IS %d/%d\n", n, x, y);
        }
        
        in.close();
	}
}
