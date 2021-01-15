/* 11719. 그대로 출력하기 2
- 11718과 똑같은데 엔터를 쳐도 그대로 출력이 되게 해야함
- isEmpty 조건을 없애면 끝
*/

package BOJ.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintAsItIsTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        
        while((str = br.readLine()) != null) {
            System.out.println(str);
        }
        br.close();
    }
}
