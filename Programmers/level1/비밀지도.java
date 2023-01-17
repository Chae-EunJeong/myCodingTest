import java.util.*;

class Solution {
    private static int N;
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        int[] temp1 = new int[n];
        int[] temp2 = new int[n];
        N = n;
        answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            // arr1[i] 이진법
            for (int j = n - 1; j >= 0; j--) {
                temp1 = toBinary(arr1[i]);
            }
            
            // arr2[i] 이진법
            for (int j = n - 1; j >= 0; j--) {
                temp2 = toBinary(arr2[i]);
            }
            
            // arr1[i]와 arr2[i]를 합쳐 벽인지 공백인지 구분하기
            for (int j = 0; j < N; j++) {
                if (temp1[j] == 0 && temp2[j] == 0) {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }
            
            answer[i] = sb.toString();           
        }
        
        return answer;
    }
    
    // 십진수를 이진수로 바꾸어 n크기의 배열에 담는 함수
    private int[] toBinary(int decimal) {
        int[] arr = new int[N];

        int i = N - 1;
        for (i = N - 1; decimal >= 2; i--) {
            arr[i] = decimal % 2;
            decimal /= 2;
        }
        arr[i] = decimal;
        
        return arr;
    }
}
