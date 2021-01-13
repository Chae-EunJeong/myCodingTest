/* 1000. A + B
java의 scanner를 사용할 줄 아는지에 관한 문제
- import java.util.Scanner를 통해 외부 클래스 호출
- Scanner 객체 생성
- System.in : 입력받은 값을 바이트 단위로 읽는다.
- Scanner의 메소드
    - next() : 공백 이전까지의 문자열 입력받음
    - nextInt() / nextDouble() : 해당 자료형을 입력받음. space나 enter로 숫자 구분
    - nextLine() : 문자열 전체를 입력받음
    - example- sc.next().charAt(0) : 문자 하나를 입력받음
    - close() : Scanner가 참조하고 있는 스트림(System.in)을 닫는다. 메모리 누수 방지
*/
package BOJ.io;
import java.util.Scanner;

public class APlusB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a+b);
        
        
    }
}
