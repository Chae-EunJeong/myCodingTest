/* 2446. 별 찍기 - 9
- 요구사항 : 정수 N을 입력받아 각 줄의 별이 2*N-1개인 모래시계 모양을 출력해라
- 함수
    - input : int N - 별 몇 개까지 출력할건지
    - restriction : 1 <= N <= 100
    - output : 첫째줄부터 2*N-1번째 줄까지 차례로, 대칭, 모래시계 모양으로 별 출력
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintStarNine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int line = 2 * n - 1;

        for(int i = 0; i <= line; i++) {
            if(i <= n) {
                sb.append(" ".repeat(i));
                sb.append("*".repeat(2*(n-i)-1));
                sb.append("\n");
            }
            else {
                sb.append(" ".repeat(line-i-1));
                sb.append("*".repeat(2*(i-n+2)-1));
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
