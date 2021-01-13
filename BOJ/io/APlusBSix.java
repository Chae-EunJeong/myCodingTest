/* 10953. A + B - 6
- A + B - 5의 주석에 쓴 것 처럼 Scanner보다 빠른 BufferReader를 써봤다.
- StringTokenizer : 지정한 구분자로 문자열을 분리하고, 쪼개진 문자열들을 token이라고 한다.
*/

package BOJ.io;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class APlusBSix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());   //IOException을 꼭 지정해줘야 에러가 안남
        StringTokenizer sTokens;

        int a = 0, b = 0;

        for(int i = 0; i < tc; i++) {
            sTokens = new StringTokenizer(br.readLine(), ",");  //br문자열을 ","단위로 분리
            a = Integer.parseInt(sTokens.nextToken());          //쪼개진 토큰도 문자열의 형태이기 때문에
            b = Integer.parseInt(sTokens.nextToken());          //int로 변환 필요
            System.out.println(a+b);
            //Stringbuilder가 굳이 필요 없어서 뺐음
            //sb.setLength(0);    //StringBuilder 초기화
        }
    }
}
