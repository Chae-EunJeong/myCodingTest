/* 11021. A + B - 7
- 이것도 역시 6번 문제처럼 BufferedReader로 입력받고 StringTokenizer로 분리했다.
- BufferedReader와 StringTokenizer를 정의하는 부분을 잘 기억하자
*/

package BOJ.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class APlusBSeven {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sTokens;
        int a = 0, b = 0;
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++) {
            sTokens = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(sTokens.nextToken());
            b = Integer.parseInt(sTokens.nextToken());
            System.out.println("Case #" + (i+1) + ": " + (a+b));
        }
    }
}
