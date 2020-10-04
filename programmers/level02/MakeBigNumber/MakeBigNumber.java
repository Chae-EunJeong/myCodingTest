/*
- 요구사항 : 주어진 배열의 숫자들을 이어붙여 만들 수 있는 가장 큰 수를 구해라
- 함수
    input : int[] 배열
    restriction : input 배열의 길이는 1이상 100,000 이하
                input 배열의 원소는 0이상 1000이하
                정답이 너무 커질 수 있기 때문에 문자열로 변환해서 반환
    output : String 문자열
- 손코딩
    정수형 배열을 문자열 배열로 변환
    문자열의 원소를 합친 것 끼리의 크기를 비교해서 내림차순으로 정렬
    반환한 문자열에 정렬된 문자열 원소들을 합치기
    입력된 배열의 모든 원소값이 0일 때는 "00000"이 아니라 "0"이 반환되도록 함
- 사용한 메서드 : compareTo()
    (o1+o2).compareTo(o2+o1)으로 하면 오름차순 정렬
    (o2+o1).compareTo(o1+o2)으로 하면 내림차순 정렬
- 정렬 조건을 달리 하려면 sort 메서드 호출시 구현한 조건을 명시
    정렬 기준을 compareTo()로 재정의하여 내림차순으로 정렬해주었음
- 문자열 비교 == vs equals()
    문자열 비교에는 ==를 이용하면 안됨. equals() 메소드를 이용하자!
*/

package programmers.level02.StackPrice.MakeBigNumber;
import java.util.Arrays;

public class MakeBigNumber {
    public String makeBigNumber(int[] numbers) {
        String answer = "";
        String[] starr = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++)
            starr[i] = String.valueOf(numbers[i]);
        
        Arrays.sort(starr, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        
        for(String a : starr)
            answer += a;
        
        if(starr[0].equals("0"))
            answer = "0";
        
        return answer;
    }

    public static void main(String[] args) {
        MakeBigNumber mbn = new MakeBigNumber();
        int[] numbers = {6, 10, 5, 30, 33};

        System.out.println(mbn.makeBigNumber(numbers));
    }
}
