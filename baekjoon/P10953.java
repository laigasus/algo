import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		String str;
		
		int t = sc.nextInt();
		
		for (int i=0; i<t; i++) {
			str = sc.next();
			st = new StringTokenizer(str, ",");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(a+b);
		}
		sc.close();

	}

}