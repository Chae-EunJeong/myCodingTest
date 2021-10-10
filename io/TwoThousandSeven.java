/* 1924. 2007년
- 요구사항 : 정수 X와 Y를 공백으로 구분하여 입력받은 후, 해당 X월 Y일이 2007년의 무슨 요일인지를 출력해라
- 함수 
    - input : 정수 X, Y
    - restriction : 1 <= X <= 12
                    1 <= Y <= 31
                    1,3,5,7,8,10,12월은 31일까지
                    4,6,9,11월은 30일까지,
                    2월은 28일까지 있다.
                    2007년 1월 1일은 월요일이다.
    - output : SUN,MON,TUE,WED,THU,FRI,SAT 중 하나 출력
- 손코딩
    - (X-1)월까지 해당하는 일 수 다 더하고, Y를 더한 후 7로 나눈 나머지가
    - 0이면 SUN, 1이면 MON, ..., 6이면 SAT 출력
- switch나 if문으로 날짜를 더하거나 요일을 출력해도 되지만
- 배열로 설정해놓고 인덱스로 접근하면 깔끔하다.
*/

package BOJ.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoThousandSeven {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);
        int[] daysOfMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] daysOfWeeks = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int sum = y;

        for(int i = 0; i < x-1; i++) {
            sum += daysOfMonths[i];
        }

        System.out.println(daysOfWeeks[(sum%7)]);

    }
}
