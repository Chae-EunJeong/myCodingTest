/*
- 요구사항 : 길이 n을 입력받아, 그 길이 만큼의 "수박수박수..." 패턴을 유지하는 문자열을 출력하라
- 함수
    input : int n
    restriction : n은 10000이하의 자연수
    output : 길이가 n인 String
- 손코딩
    반복변수 1부터 길이 n만큼 반복하는 반복문 안에서
        반복 변수가 홀수번째이면
            문자열에 "수"를 추가
        반복 변수가 짝수번째이면
            문자열에 "박"을 추가
    최종 문자열을 반환
- 다른 풀이
    1.n이 최대 10000이라는 걸 이용해 처음에 길이 10000만큼의 패턴을 저장시키고,
    substring을 통해 n만큼 잘라서 쓰는 풀이가 인상깊었다.
    2.StringBuffer(StringBuilder)에 append로 추가하기
    python에 익숙한 상태여서 append를 쓰려다 괜히 StringBuffer를 쓰는 걸까봐 안 썼는데..
    다음부턴 자바로 짤 때는 자바의 특징을 살려서 코딩하는 연습 해야겠다.
    3.substring을 이용, 홀짝을 이용해 빈공간일 때 "수박"으로 교체 - replace("\0","수박").substring
*/

public class Watermelon {
    public String watermelon(int n) {
        String waterMelonPattern = "";
        for(int i = 1; i <= n; i++) {
            if (i % 2 != 0)
                waterMelonPattern = waterMelonPattern + "수";
            else
                waterMelonPattern = waterMelonPattern + "박";
        }
        return waterMelonPattern;
    }

    public static void main(String[] args) {
        Watermelon wm = new Watermelon();
        System.out.println("when n is 3 : " + wm.watermelon(3));
    }
}