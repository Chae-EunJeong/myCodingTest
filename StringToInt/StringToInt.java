import java.util.Scanner;

public class StringToInt {
    public static int solution(String s) {
        int number = 0;
        
        /* condition whether the first character of the string is
        plus sign(be able to omit) or minus sign */
        /* multiply with 10 power of the order of magnitude */
        if (s.charAt(0) == '+') {       // if the first character is plus sign
            for(int i = 1; i < s.length(); i++) {
                number += (Character.getNumericValue(s.charAt(i)) * Math.pow(10, s.length() - (i+1)));
            }
        }else if (s.charAt(0) != '-') { // else if the first character is minus sign
            for(int i = 0; i < s.length(); i++) {
                number += (Character.getNumericValue(s.charAt(i)) * Math.pow(10, s.length() - (i+1)));
            }
        }else {                         // else if the first character is the number(omitted sign)
            for(int i = 1; i < s.length(); i++) {
                number += (Character.getNumericValue(s.charAt(i)) * Math.pow(10, s.length() - (i+1)));
            }
            number *= (-1);
        }

        return number;
    }
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        System.out.print("input << ");
        String s = get.nextLine();

        int ans = solution(s);
        System.out.println(ans);
    }
}