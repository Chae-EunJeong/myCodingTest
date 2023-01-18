import java.util.*;

class Solution {
    static int N;
    static int R = 3;
    static int[] numbers;
    static int[] input;
    static boolean[] isSelected;
    static int answer = 0;
    public int solution(int[] number) {
        
        input = number;
        numbers = new int[R];
        N = number.length;
        isSelected = new boolean[N];
    
        perm(0);
        
        // 조합으로 3개 선택 시, 6개가 중복으로 나오므로 6으로 나누기
        return answer / 6;
    }
    
    private static void perm(int cnt) {
        if (cnt == R) {
 
            int sum = 0;
            for (int j = 0; j < numbers.length; j++) {
                sum += numbers[j];
            }
            
            if (sum == 0) answer++;
            return;
        }
        
        for (int i = 0; i < N; i++) {   
            
            if (isSelected[i]) continue;
            
            numbers[cnt] = input[i];
            isSelected[i] = true;
            
            perm(cnt + 1);
            isSelected[i] = false;
        }
    }
}
