/* 11718. 그대로 출력하기
- 조건에서 빈 줄은 주어지지 않는다고 했으므로 String이 비어있으면 중단했다.isEmpty()
- while문의 조건 확인할 때 br.readLine()이 null이 아니면 while문을 돌도록 했는데,
    - 그 때 내가 print할 문자열에 저장을 안 해주면 첫 문장은 출력이 안된다.
    - 그래서 while문에 바로 str에 대입을 해줘야 한다.
- String이 비어있는지 확인할 때 
    - isEmpty() : 문자열이 빈 값인지 확인("")
    - == null : 객체가 null이라 값이 존재하지 않는 상태. null값을 isEmpty로 확인하면 NullPointerException 발생
    - isBlank() : 문자열이 빈 값("")이거나 whitespace인지 확인
*/

package BOJ.io;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintAsItIs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        
        while((str = br.readLine()) != null) {
            if(str.isEmpty()) {
                break;
            }

            System.out.println(str);
        }
        br.close();
    }
}
