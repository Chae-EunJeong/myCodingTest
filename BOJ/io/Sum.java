/* 8393. 합
- 요구사항 : 정수 N을 입력받으면 1부터 N까지의 합을 계산해서 출력해라
- 함수 
    - input : 정수 N
    - restriction : 1 <= n <= 10000
    - output : 1부터 N까지의 합
*/


package BOJ.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        for(int i = 1; i <= n; i++) {
            sum += i;
        }

        System.out.println(sum);
    }
}
