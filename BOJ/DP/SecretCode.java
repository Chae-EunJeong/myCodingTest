package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecretCode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int code;
        int[] dp = new int[input.length()+1];

        if(input.charAt(0) == '0' || Integer.parseInt(input) == 0) {
            System.out.println(0);
            return ;
        }

        dp[0] = dp[1] =  1;

        //i가 문자열의 각 문자의 index. 0부터 시작
        for(int i = 1; i < input.length(); i++) {
            code = (input.charAt(i-1) - '0') * 10 + input.charAt(i) - '0';

            if (code > 26 && input.charAt(i) == '0') {
                dp[i+1] = dp[i] % 1000000;
            }
            if(code >= 11 && code <= 26 ) {
                dp[i+1] = (dp[i] + dp[i-1]) % 1000000;
            }
        }
            
        System.out.println(dp[input.length()]);
    }
    
}
