package programmers.level02.TargetNumber;

/*
- 요구사항 : 입력된 자연수로 이루어진 배열의 숫자들을 적절히 빼고 더해서, 
            타겟 넘버를 만들 수 있는 방법의 수를 반환해라.
- 함수
    input : 사용할 수 있는 숫자가 담긴 int 배열, 타겟 넘버 int
    restriction : 입력된 정수형 배열의 원소의 개수는 2개 이상 20개 이하
                  각 원소는 1이상 50이하인 자연수
                  타겟 넘버는 1이상 1000이하인 자연수
    output : 타겟 넘버를 만드는 방법의 수 int
- 손코딩
    모든 경우의 수 구하기    
        입력받은 정수형 배열의 첫번째 원소에 다음 인덱스의 수를 더하고 뺀 결과를 각각
        그 다음 인덱스의 수와 더하고 빼야 하므로 재귀 함수를 사용한다.
        첫번째 원소에 -를 붙인 경우도 똑같이 계산해준다.
    가리키는 인덱스가 입력받은 배열의 길이와 같아졌을 때
        결과가 target과 같으면 경우의 수 1을 추가
        같지 않으면 경우의 수 0을 추가
- 모든 경우의 수를 따져보면 트리와 같은 모양이 나온다. 
- 각 깊이에 대해 모두 탐색하는 깊이 우선 탐색(DFS)개념을 사용하며 재귀함수나 Stack으로 풀이가 가능하다.
- 다른 풀이
~~~
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }
}
~~~
    - 두 개로 굳이 작성 안 해도 이렇게 깔끔하게 되는구나..
*/

public class TargetNumber {
    public int dfs(int current, int index, int[] numbers, int target) {
        if(index >= numbers.length){
            if(current == target)
                return 1;
            else 
                return 0;
        }
        int ans = 0; 
        ans += dfs(current + numbers[index], index + 1, numbers, target);
        ans += dfs(current - numbers[index], index + 1, numbers, target);  
        
        return ans;
    }

    public int targetNumber(int[] numbers, int target) {
        int answer = 0;
        answer += dfs(numbers[0], 1, numbers, target);
        answer += dfs(-numbers[0], 1, numbers, target);
        return answer;
    }

    public static void main(String[] args) {
        TargetNumber tn = new TargetNumber();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int answer = 0;
        answer = tn.targetNumber(numbers, target);
        System.out.println(answer);

    }
}
