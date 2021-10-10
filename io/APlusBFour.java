/* 10951. A + B - 4
- 어떤 때 종료해야하는지를 아는가에 관한 문제
- 더이상 데이터를 읽을 것이 없을 때
    - 다른 타입의 입력 시 InputMismatchException : 정수가 아닌 문자열이 입력될 때 등
- Scanner의 메소드
    - hasNext()/hasNextInt() : 받는 입력이 존재하지 않을 때 예외 처리
- 아니면 try-catch로 예외가 발생했을 때 처리하는 방법도 있다.
*/

package BOJ;
import java.util.Scanner;

public class APlusBFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 0;

        while(sc.hasNext()) {
            a = sc.nextInt();
            b = sc.nextInt();

            System.out.println(a+b);
        }
        sc.close();
    }
}
