import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double totalGPA = 0;
        int subjects = 0;
        for (int i = 0; i < 20; i++) {
            String[] cols = br.readLine().split(" ");
            String rank = cols[2];
            double score = Double.parseDouble(cols[1]);
            if (rank.equals("P")) {
                continue;
            }
            totalGPA += GPA(rank, score);
            subjects += score;
        }

        System.out.printf("%.6f", totalGPA / subjects);
        br.close();
    }

    static double GPA(String rank, double score) {
        double gpa = 0;
        switch (rank) {
            case "A+": {
                gpa = 4.5;
                break;
            }
            case "A0": {
                gpa = 4.0;
                break;
            }
            case "B+": {
                gpa = 3.5;
                break;
            }
            case "B0": {
                gpa = 3.0;
                break;
            }
            case "C+": {
                gpa = 2.5;
                break;
            }
            case "C0": {
                gpa = 2.0;
                break;
            }
            case "D+": {
                gpa = 1.5;
                break;
            }
            case "D0": {
                gpa = 1.0;
                break;
            }
            case "F": {
                gpa = 0.0;
                break;
            }
        }
        return gpa * score;
    }
}
