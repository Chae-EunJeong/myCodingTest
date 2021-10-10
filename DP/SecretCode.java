/* 2011. 암호코드
- 요구사항 : A를 1, B를 2, ..., Z를 26으로 하는 암호화 방법을 사용하여,
            암호코드가 주어지면 해석하는 방법의 수를 구해라.
- 함수 
    - input : 숫자 N
    - restriction : N은 5000자리 이하의 암호
                    결과는 클 수 있으므로 %1000000을 한 결과를 출력
    - output : 나올 수 있는 해석의 가짓수
ㅣ- 점화식
    코드의 마지막 숫자와, 마지막 이전의 숫자를 'code'라 했을 때, 
        (1) code가 10이상 26이하이면서 마지막 숫자가 0이 아닐 때는 dp[i] = dp[i-1] + dp[i-2]
        (2) code가 10이거나 20일 때는 dp[i] = dp[i-2]
        (3) 그 외에 한자리수들은 dp[i] = dp[i-1]
*/

//package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class SecretCode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        //Scanner sc = new Scanner(System.in);
        //String input = sc.nextLine();
        int code;
        int[] dp = new int[input.length()+1];

        if(input.charAt(0) == '0' || input.isEmpty() || input.charAt(0) == ' ') {
            System.out.println(0);
            return ;
        }

        dp[0] = dp[1] = 1;

        //i가 문자열의 각 문자의 index. 0부터 시작
        for(int i = 2; i <= input.length(); i++) {
            code = (input.charAt(i-2) - '0') * 10 + input.charAt(i-1) - '0';
            
            if((code >= 11 && code <= 26) && (input.charAt(i-1) > '0')) {
                dp[i] = (dp[i-1] + dp[i-2]) % 1000000;
            } else if (code == 10 || code == 20 ) {
                dp[i] = dp[i-2] % 1000000;
            } else if (input.charAt(i-1) > '0'){
                dp[i] = dp[i-1] % 1000000;
            }
        }

        System.out.println(dp[input.length()]);
    }
    
}
