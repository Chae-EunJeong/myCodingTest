/* 1463. 1로 만들기
- 요구사항 : 정수 N를 입력받은 후, 세 가지 연산을 최소로 사용해 1로 만들어라.
    - 1. N이 3으로 나누어 떨어지면 3으로 나눈다.
    - 2. N이 2로 나누어 떨어지면 2로 나눈다.
    - 3. 1을 뺀다.
- 함수 
    - input : 자연수 N
    - restriction : 1 <= N <= 10^6
                    N은 자연수
    - output : 연산 횟수의 최솟값
- Dynamic Programming(DP) : issue#7에 정리

*/

package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MakeIntoOne {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            System.out.println(i); 
        }

    }
}