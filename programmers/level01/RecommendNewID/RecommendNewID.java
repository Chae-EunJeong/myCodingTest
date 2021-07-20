/* 2021 KAKAO BLIND RECRUITMENT 신규 아이디 추천
- 요구사항 : 아이디 규칙에 맞지 않는 아이디를 입력했을 때, 입력된 아이디와 유사하면서 규칙에 맞는 아이디로 변환하여 반환해라.
- 함수
    input : 문자열 String (사용자입력ID)
    restriction : 입력된 문자열 길이는 3자 이상 15자 이하
                  입력된 문자열은 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용 가능
                  마침표(.)는 처음과 끝에 사용할 수 없으며, 연속으로도 사용할 수 없음
    output : 추천 ID String
- ID 규칙 검사
    - 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    - 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    - 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    - 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    - 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    - 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    - 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
- 손코딩
    아이디를 입력받기
*/

public class RecommendNewID {
    public static String recommendNewId(String new_id) {
        String answer = new_id;
        String convertedId = "";
        int tmp;

        for(int i = 0; i < answer.length(); i++) {
            // 1단계: 대문자를 소문자로 치환하기
            tmp = (int)answer.charAt(i);
            if((65 <= tmp) && (tmp <= 90)) {
                convertedId += (char)(tmp + 32);
            } else {
                convertedId += (char)tmp;
            }
        }
        return convertedId;
    }
    public static void main(String[] args) {
        RecommendNewID rnid = new RecommendNewID();
        String as = rnid.recommendNewId("sdkfjWErwhABCD");
        System.out.println(as);
    }
}