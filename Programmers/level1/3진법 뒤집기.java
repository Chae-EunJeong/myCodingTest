class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n >= 3) {
            sb.append(n % 3);
            n = n/3;
        }
        
        sb.append(n);
        sb.reverse();
        

        // 3진법을 다시 10진법으로 변환
        char[] sbToChar = sb.toString().toCharArray();
        for (int i = 0; i < sbToChar.length; i++) {
            answer += (Math.pow(3, i) * (sbToChar[i] - '0'));
            
        }
                
        return answer;
    }
}
