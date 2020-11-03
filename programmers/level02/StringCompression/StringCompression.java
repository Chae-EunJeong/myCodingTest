/*
- 요구사항 : 문자열에서 같은 값이 연속해서 나타나면, 반복되는 만큼의 수로 표현하여 최대한 짧은 문자열로 줄여서 표현하라.
- 함수
    input : 문자열 String
    restriction : 입력된 문자열 길이는 1이상 1,000이하
                  입력된 문자열은 모두 소문자
    output : 압축된 문자열의 길이 int
- 손코딩
    1부터 문자열의 길이만큼 비교하는 문자 수 늘려가면서 반복
        처음 문자열을 1씩 잘라 뒷 문자와 비교
            같으면 임의 count 변수 +1
            다르면,
                count가 0이면 그냥 문자 그대로 추가
                count가 1 이상이면 count, 문자 추가
- 다른 풀이
*/
public class StringCompression {
    public String stringCompression(int n) {
        
    }

    public static void main(String[] args) {

    }
}
