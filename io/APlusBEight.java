/* 15740. A + B - 9
- 이것도 역시 6,7번 문제와 거의 같은 알고리즘이고 출력 형식만 다르다.
- Scanner로는 nextInt()로 공백이나 엔터를 기준으로 계속 변수를 받아 똑같이 처리하면 된다.
*/

package BOJ.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class APlusBEight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer sTokens;
        int a = 0, b = 0;

        for(int i = 0; i < tc; i++) {
            sTokens = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(sTokens.nextToken());
            b = Integer.parseInt(sTokens.nextToken());

            System.out.println("Case #" + (i+1) + ": " + a + " + " + b + " = " + (a+b));
        }
    
    }
}
