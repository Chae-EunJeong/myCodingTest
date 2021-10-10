/* 10952. A + B - 5
- 종료 시점이 입력을 통해 정해지는 예제
- 이전 문제들처럼 scanner를 썼지만 BufferedReader로 입력받으면 더 빠름
    - BufferedReader.readLine() : 문자열 한 줄을 한 번에 입력
    - 이 문제에선 공백을 기준으로 분리할 필요 
    - 분리 방법 : String.split(), StringTokenizer
    - 다만 문자열을 분리한 후 문자열을 반환하므로 Integer.parseInt()로 변환해야함
*/
package BOJ.io;
import java.util.Scanner;

public class APlusBFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 0;

        while(true){
            
            a = sc.nextInt();
            b = sc.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            System.out.println(a+b);
        }
    }
}
