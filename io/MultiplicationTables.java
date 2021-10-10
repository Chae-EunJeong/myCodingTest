/* 2739. 구구단
- 요구사항 : 정수 N를 입력받은 후, 구구단 N단을 출력해라.
- 함수 
    - input : 자연수 N
    - restriction : 1 <= N <= 9
    - output : N*1부터 N*9까지 차례로 출력
*/

package BOJ.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplicationTables {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(br.readLine());

        for(int i = 1; i < 10; i++) {
            System.out.println(times + " * " + i + " = " + times*i);
        }
    
    }
}
