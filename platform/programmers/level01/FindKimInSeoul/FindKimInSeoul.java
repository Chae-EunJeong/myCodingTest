/*
- 요구사항 : 배열 seoul에서 "Kim"이 몇 번째에 있는지 출력하기
- 함수
    input : 문자열 배열 seoul
    restriction : 배열 seoul의 길이는 1이상 1000이하
                  seoul의 원소의 길이는 1이상 20이하
                  "Kim"은 반드시 seoul에 포함
    output : "Kim"이 배열의 몇 번째 원소인지 출력하기
- 손코딩
    문자열 배열 seoul을 입력받기
    배열 길이만큼 for 문 반복
        만약 seoul[i]가 "Kim"이면
            반복문을 빠져나감
    Kim이 i번째에 있다는 문자열 반환

- 다른 풀이
    1. 최대한 if문을 안 쓰기 위해 배열에서 인덱스를 찾는 방법 구글링
        1)배열을 ArrayList로 생성한 뒤 indexOf를 사용해 몇 번째 인덱스인지 저장하기
        - 나는 ArrayList를 생성하고, asList로 바꾸고 거기서 indexOf를 사용했지만, 
        - Arrays.asList(seoul).indexOf("Kim") 이렇게 바로 index를 받아버리는 방법
    2. 문자열 비교는 equals() 
        - seoul[i].equals("Kim")
        - 나는 seoul[i] == "Kim" 
- 자바로 프로그래밍 할 때는 자바의 라이브러리와 특징들을 주의깊게 생각하면서 이용하도록 명심하기
*/
import java.util.ArrayList;
import java.util.Arrays;

class FindKimInSeoul {
    public String findKimInSeoul(String[] seoul) {
        String answer = "";
        int where = 0;
        ArrayList<String> seoulToList = new ArrayList<>(Arrays.asList(seoul));
        where = seoulToList.indexOf("Kim");
        answer = "김서방은 " + where + "에 있다";
        return answer;
    }
    public static void main(String[] args) {
        FindKimInSeoul findKim = new FindKimInSeoul();
        String[] test = {"Jane", "Kim"};
        String whereIsKim = findKim.findKimInSeoul(test);
        System.out.println(whereIsKim);
    }
}