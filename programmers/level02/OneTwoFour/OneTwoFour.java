/*
- 요구사항 : 입력받은 10진수의 자연수를 1, 2, 4 세 숫자로 표현하라.
- 함수
    input : 10진수의 자연수. int n
    restriction : n은 500,000,000 이하의 자연수
    output : 문자열 String
- 손코딩
    n이 0보다 클 때 계속 반복
        n을 3으로 나눈 나머지가 0일 때는 
            124나라의 수 4로 바꾸고, 
            n(몫)은 1을 빼준다.
        반환할 문자열의 앞에 n을 3으로 나눈 나머지를 채운다.
        다음 반복문에서는 n을 3으로 나눈 몫이 n이 된다.
- 내가 고민, 실수했던 부분들
    - 1. 나머지가 0이되면 4인것은 캐치했지만, 몫에서 1을 뺄 생각은 한참 걸렸다.
    - 2. n%3을 문자열에 추가해야 하기도 하고, 조건 검색에 필요하기도 해서 변수로 만들어야 적당했지만, 그러지 못했다.
    - 3. 그냥 String 변수에 문자열을 + 해서 추가하면 효율성 테스트에서 실패한다. StringBuilder의 insert를 사용!!
- 다른 풀이
    ~~~
    class Solution {
    public String solution(int n) {
        String[] num = {"4","1","2"};
        String answer = "";

        while(n > 0){
            answer = num[n % 3] + answer;
            n = (n - 1) / 3;
        }
        return answer;
        }
    }
    ~~~
    - 나머지가 0, 1, 2일때 배열의 4, 1, 2 로 아주 간결하고 스마트하게 바꾸는 방법이다.
    - 어떻게 이런 생각을,,,
*/

public class OneTwoFour {
    public String oneTwoFour(int n) {
        StringBuilder sb = new StringBuilder();
        int num = 0;

        while(n > 0) {            
            num = n % 3;

            if(num == 0) {
                num = 4;
                n -= 1;
            }

            sb = sb.insert(0, num);
            n /= 3;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        OneTwoFour otf = new OneTwoFour();
        System.out.println(otf.oneTwoFour(6));
    }
}
