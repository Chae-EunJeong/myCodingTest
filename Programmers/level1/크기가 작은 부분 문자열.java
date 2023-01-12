class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long pInt = Long.parseLong(p);
        long lastInt = Long.parseLong(t.substring(t.length() - p.length()));

        for (int i = 0; i < t.length() - p.length(); i++) {
            long tInt = Long.parseLong(t.substring(i, i + p.length()));      
            if (pInt >= tInt) {
                answer++;
            }
            
        }

        if (pInt >= lastInt) answer++;
        
        return answer;
    }
}
