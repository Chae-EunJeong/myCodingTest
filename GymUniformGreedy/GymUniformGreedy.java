
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int count = 0;
        int k = 0;
        int same = 0;
        int temp = 0;
        
        for(int i = 0; i < reserve.length; i++) {
            temp = same;
            for(int l = 0; l < lost.length; l++) {
                if(reserve[i] == lost[l]){
                    k += 1;
                    count += 1;
                    same += 1;
                    break;
                }
            }
            if (same > temp)
                break;
            for(int j = k; j < lost.length; j++) {
                if(reserve[i] - 1 == lost[j]){
                    k += 1;
                    count += 1;
                    break;
                }
                else if(reserve[i] + 1 == lost[j]){
                    k += 1;
                    count += 1;
                    break;
                }
            }
        }
        answer = n - lost.length + count;
        return answer;
    }
}