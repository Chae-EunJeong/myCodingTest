/* 11720. 숫자의 합
- 요구사항 : 숫자의 개수 N를 입력받은 후, 공백없이 숫자 N개를 입력받으면, 그 숫자들의 합을 구해라.
- 함수 
    - input : 정수 N 그리고 공백없는 N개의 연속된 숫자
    - restriction : 1 <= N <= 100
                    각 숫자는 0부터 9까지의 숫자
    - output : 숫자 N개의 합
- 손코딩 
    - 처음 입력된 라인을 읽어 숫자를 저장한다.(이 숫자는 반복문에 쓰임)
    - 두번째로 입력된 라인을 읽어 한글자씩 나누고, integer로 바꾸어 더해나간다.
    - 숫자를 모두 더한 값을 출력한다.
- char를 선언할 때는 ''로 선언하면 안되고 공백을 두고 선언해줘야함
- char를 int형으로 바꿀 때에는 
    - char - '0' 을 해주거나
    - Character.getNumericValue(char)를 한다.
*/

package BOJ.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        char ch = ' ';
        int sum = 0;
        String str = br.readLine();

        for(int i = 0; i < tc; i++) {
            ch = str.charAt(i);
            sum += Character.getNumericValue(ch);
            //sum += str.charAt(i) - '0'
        }
        System.out.println(sum);
    }
}
