/* 11721. 열 개씩 끊어 출력하기
- 요구사항 : 알파벳으로 이루어진 단어를 입력받아 10글자씩 끊어서 출력하라.
- 함수
    - input : String str
    - restriction : 0 < str <= 100
    - output : str1(len : 10)
               str2(len : 10)
               ... (len <= 10)
- 손코딩
    - 단어를 입력 받아 단어의 길이를 10으로 나누고, 
    - 나머지가 있으면 몫+1 만큼, 나머지가 없으면 몫만큼의 수를 저장한다.(반복문)
    - 저장한 수만큼 반복문을 돌면서
        - 10, 20..번째에서 문자열을 끊어 출력하고
        - 마지막 반복문을 돌 때는 남은 문자열을 출력한다.
- 내가 한 방법 : 받은 문자열을 substring으로 인덱스 지정해서 끊어버리기
- 다른 풀이 : charAt으로 문자 하나씩 출력하다가 10개마다 개행 해주기
    - 0일때 개행하면 안되므로 i%10==9조건을 썼다.

*/

package BOJ.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintTenByCutting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int count = len / 10; 
        if(len%10 != 0) {
            count += 1;
        }

        for(int i = 0; i < count; i++) {
            if(i == count-1) {
                System.out.println(str.substring(i*10));
                break;
            }
            System.out.println(str.substring(i*10, (i*10)+10));
        }
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        for(int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
            if(i%10 == 9) {
                System.out.println("\n");
            }
        }*/
    }
}
