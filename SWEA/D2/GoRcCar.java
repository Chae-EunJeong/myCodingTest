import java.util.Scanner;

public class GoRcCar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();       // 총 테케 수
        int[] results = new int[T+1];
        int command = 0;
        int a = 0; 
        int speed = 0;
        int distance = 0;
         
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            for(int i = 0; i < N; i++) {
                command = sc.nextInt();
                if (command == 1) {
                    a = sc.nextInt();
                    speed += a;
                    distance += speed;
                } else if (command == 2){
                    a = sc.nextInt();
                    if(a <= speed) {
                        speed -= a;
                        distance += speed;                      
                    } else {
                        speed = 0;                      
                    }
                } else {
                    distance += speed;
                }
            }
            results[t] = distance;
            distance = 0; 
            speed = 0;
        }
         
        for (int t = 1; t <= T; t++) {
            System.out.printf("#%d %d%n", t, results[t]);
        }
        sc.close();
    }
}
