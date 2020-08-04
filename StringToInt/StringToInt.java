import java.util.Scanner;

public class StringToInt {
    public static int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(0) == '+') {
                
            }else if (s.charAt(0) != '-') {

            }else {

            }
        }
        
        
        return answer;
    }
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        String s = get.nextLine();

        int ans = solution(s);
        System.out.println(ans);
    }
}