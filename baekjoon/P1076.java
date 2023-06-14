import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1076 {
    static enum Color {
        black, brown, red, orange, yellow, green, blue, violet, grey, white
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = "";
        tmp += getV(br.readLine());
        tmp += getV(br.readLine());

        long impedence = Integer.parseInt(tmp) * (long) Math.pow(10, getV(br.readLine()));

        System.out.println(impedence);
    }

    static int getV(String str) {
        return Color.valueOf(str).ordinal();
    }
}