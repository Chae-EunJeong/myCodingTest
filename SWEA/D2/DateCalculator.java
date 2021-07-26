import java.util.Scanner;

public class DateCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int aMon, aDay, bMon, bDay;
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int diff = 0;
         
        for(int t = 1; t <= T; t++) {
            aMon = sc.nextInt(); aDay = sc.nextInt();
            bMon = sc.nextInt(); bDay = sc.nextInt();
             
            if (aMon == bMon) {
                diff = bDay - aDay + 1;
            } else {
                diff = daysInMonth[aMon] - aDay + 1;
                for(int i = aMon + 1; i < bMon; i++) {
                    diff += daysInMonth[i];
                }
                diff += bDay;
            }
             
            System.out.printf("#%d %d%n", t, diff);
        }
    }
}
