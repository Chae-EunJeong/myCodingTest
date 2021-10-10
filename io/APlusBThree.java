/* 10950. A + B - 3
- 더하여 for문을 사용해서 여러개의 덧셈 수행하는 문제
- 나는 입력 먼저, 출력 따로 하는 줄 알고 for문을 두 개로 했지만
- 한 for문에서 입력 받고 출력하고를 반복하는 답안도 정답이다.
- 그런데 for문을 두개로 한 내 방법이 조금 더 빨랐다.
*/

package BOJ.io;
import java.util.Scanner;

public class APlusBThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 0;
        int tc = sc.nextInt();
        int[] fiveArr = new int[tc];

        for(int i = 0; i < tc; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            fiveArr[i] = a + b;
        }

        for(int i = 0; i < tc; i++) {
            System.out.println(fiveArr[i]);
        }
    }
}
