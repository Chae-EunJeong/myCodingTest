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
    
- 다른 풀이
    - 
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
