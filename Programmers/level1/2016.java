class Solution {
    public String solution(int a, int b) {
        // 2016.01.01 -> Friday
      
        String answer = "";
        String[] week = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int temp = b;
        
        // 주어진 월의 바로 이전달까지의 모든 일 수 더하기
        for (int i = 1; i < a; i++) {
            temp += days[i];
        }
        
        answer = week[temp % 7];
 
        return answer;
    }
}
