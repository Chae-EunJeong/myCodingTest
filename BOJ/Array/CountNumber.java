/* 2577. 숫자의 개수
- 요구사항 : 세 개의 자연수가 주어지면, 세 자연수를 모두 곱한 숫자에서 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구해라.
- 함수
    - 입력 : 한 줄에 자연수 하나씩 입력받기(세 줄)
    - 제약 : 각 자연수는 100보다 크거나 같고, 1000보다 작은 자연수
    - 출력 : 첫째줄부터 열번째줄까지 각각 0~9가 쓰인 횟수를 출력
- 손코딩
    엔터를 기준으로 세 개의 자연수를 입력받는다.
    세 개의 자연수를 곱한다.
    곱해진 수의 길이만큼 0부터 9까지의 인덱스에 집어넣는다.
    0부터 9까지 저장된 각각의 숫자를 엔터를 기준으로 출력한다.
- 다른 방법
    - String으로 받아 charAt 이용해보기
*/
import java.util.Scanner;
public class CountNumber {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[11];
        int num = 1;
        int t = 0;
        for(int i = 0; i < 3; i++) {
            num *= sc.nextInt();
        }
        while(num > 0) {
            t = num % 10;
            arr[t]++;
            num = (num - (num % 10)) / 10;
        }
        
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        
    }
    
}
