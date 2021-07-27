/* 1940. 가랏! RC카!
- 요구사항 : N개의 command가 주어지고, 각 command마다 가속도 값이 주어질 때,
            N초 동안의 RC카 이동거리
- 함수
    - 입력 : 첫째줄 ~ 테스트 케이스 수 T
            둘째줄 ~ 각 테스트 케이스의 command 수 N
            세번째줄 ~ 각 테스트 케이스의 command와 가속도 a
    - 제약 : 2 <= N <= 30
            가속도 = 1 혹은 가속도 = 2
            현재 속도보다 감속할 속도가 더 크면 속도는 0
    - 출력 : 테스트케이스만큼의 라인에 각 테케별 이동거리
- 손코딩
    테스트 케이스 수를 입력받는다.
    테스트 케이스 수만큼 반복문을 돌면서
        테스트 케이스 command 수를 입력받아 그만큼 반복하면서
            0이면 속도유지, 1이면 가속, 2이면 감속을 하도록 조건문
    테스트 케이스 수만큼 반복하면서
        각 테스트케이스 번호와 최빈수를 출력한다.
*/

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
