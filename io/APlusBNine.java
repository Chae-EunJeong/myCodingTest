/* 15740. A + B - 9
- 자바의 BigInteger 자료형을 아는가에 관한 문제
    - int(4byte), long(8byte)가 표현할 수 있는 범위를 넘어섰을 때,
    - 무한의 정수가 들어갈 수 있는 BigInteger 클래스를 이용한다.
    - method로는 add, subtract, multiply, divide, equals 등이 있다.
- BigInteger의 메소드에는 add가 있기 때문에 int를 더하듯 a+b 하면 안된다는 것에 주의
- BigInteger는 클래스이기 때문에 정의할 때 new로 생성해줘야한다.
*/

package BOJ.io;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.io.IOException;

public class APlusBNine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sTokens;
        sTokens = new StringTokenizer(br.readLine(), " ");
        BigInteger a = new BigInteger(sTokens.nextToken());
        BigInteger b = new BigInteger(sTokens.nextToken());

        System.out.println(a.add(b));

    }
}
