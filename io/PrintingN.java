/* 2741. N 찍기
- 요구사항 : 정수 N를 입력받은 후, 1부터 N까지 차례로 출력해라.
- 함수 
    - input : 자연수 N
    - restriction : N <= 100000
                    N은 자연수
    - output : 첫번째 줄부터 N번째 줄까지 출력
- 간단한 거라 Scanner로 해서 통과됐지만
- 역시나 BufferedReader가 메모리 용량을 조금 잡아먹기 때문에 BufferedReader 사용함
*/

package BOJ.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PrintingN {
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