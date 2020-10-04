/*
- 요구사항 : 전화번호부에 적힌 전화번호 중에서 한 번호가 다른 번호의 접두어인 경우가 있으면 true, 없으면 false를 반환해라
- 함수
    input : (전화번호가 적힌) 전화번호부 String[]
    restriction : 전화번호부의 길이는 1 이상 1,000,000 이하
                각 전화번호의 길이는 1 이상 20 이하
    output : true or false
- 손코딩
    전화번호부 배열의 한 원소가 다른 원소들과 모두 비교되어야 하므로 이중 반복문
        같은 인덱스의 원소는 비교할 필요가 없음
        한 원소가 다른 원소의 접두사가 된다면
            바로 false를 반환
    반복문이 모두 끝났는데도 접두사인 경우가 없다면 그대로 true를 반환
- Java의 문자열 함수 startsWith()
    ex) "computer".startsWith("co")
    - 문자열이 지정한 문자열로 시작하는지를 판단해주며 같으면 true, 아니면 false를 반환함
    - 유사하게 endsWith()도 있음
- 다른 풀이
    1. 나도 continue를 쓰기 싫었지만 생각이 안 나서 일단 썼음. 
    - 해결 방법은 p[i].startsWith(p[j])도 하고, 
        바로 또 다른 if문에 p[j].startsWith(p[i])도 해주면 됨. 단순하잖아..?
    2. Arrays.sort를 하고 앞쪽의 인덱스가 뒤쪽의 인덱스에 포함됐는지 확인
    - 처음에 전화번호부를 sort하면 접두어가 될 수 있는 문자열은 앞쪽으로 오기 때문에 자기 뒤의 원소만 비교하면 됨
    - 그 다음 1번과 같이 이중 반복문에 하나의 if문만 써서 확인 가능
    3. 원래는 이 문제가 해시 카테고리에 있음..왜 해시인지는..모르겠음
*/

package programmers.level02.Printer;

public class Printer {
    public boolean printer() {
        
    }

    public static void main(String[] args) {
        
    }
}
