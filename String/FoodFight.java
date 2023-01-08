class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb1 = new StringBuilder("");
        
        for (int i = 1; i < food.length; i++) {
            // 음식의 양이 홀수이면 사용 안 함
            if (food[i] % 2 != 0) {
                food[i] -= 1;
            } 
            
            // 한 선수가 먹을 i번째 음식 배치
            for (int j = 0; j < food[i] / 2; j++) {
                sb1.append(i);
            }
        }
        
        answer = sb1.toString();
        answer += "0";
        answer += sb1.reverse().toString();
        
        return answer;
    }
}
