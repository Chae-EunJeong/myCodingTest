class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] sArr = s.toCharArray();
    

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            
            if (s.charAt(i) == ' ') {
                answer += s.charAt(i);
                continue;
            }
            
            temp += n;
            
            if (temp > 90 && s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                temp -= 26;
            } else if (temp > 122) {
                temp -= 26;
            }
            answer += temp;

        }        
       
        return answer;
    }
}
