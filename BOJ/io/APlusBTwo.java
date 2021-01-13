/* 2558. A + B - 2
- 1000번 문제와 동일한 풀이임
- nextInt()는 해당 자료형을 입력받을때, space나 enter로 숫자 구분하기 때문
*/

package BOJ.io;
import java.util.Scanner;

public class APlusBTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a+b);
    }
    
}
