/* 2742. 기찍 N
- 요구사항 : 정수 N를 입력받은 후, N부터 1까지 차례로 출력해라.
- 함수 
    - input : 자연수 N
    - restriction : N <= 100000
                    N은 자연수
    - output : 첫번째 줄부터 N번째 줄까지 출력
- 2741과 동일한데 역순으로 출력(for문 살짝 변경)
*/
package BOJ.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DescendingPrintN {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = n; i > 0; i--) {
            System.out.println(i);
        }
    }
}
