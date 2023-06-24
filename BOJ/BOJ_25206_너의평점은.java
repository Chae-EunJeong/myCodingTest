package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 요구사항 : 전공평점을 계산해라 (전공평점 = 전공과목별(학점 * 과목평점)의 합 / 학점의 총합)
 * 입력 : 과목명, 학점, 등급이 20줄 주어짐
 * 출력 : 전공평점
 * 제약 : 학점은 1.0,2.0,3.0,4.0중 하나이다.
 *      등급은 A+,A0,B+,B0,C+,C0,D+,D0,F,P중 하나이다.
 */
public class BOJ_25206_너의평점은 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);

        double scoreSum = 0;
        double gradeSum = 0;
        double answer = 0;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double score = Double.parseDouble(st.nextToken());  // 학점
            String grade = st.nextToken();                      // 등급
            if (map.containsKey(grade)) {
                // 전공과목별(학점 * 과목평점)의 합 / 학점의 총합
                scoreSum += (score * map.get(grade));   // 전공과목별(학점 * 과목평점)의 합
                gradeSum += score;             // 학점의 총합
            }
        }
        if (gradeSum != 0)
            answer = scoreSum/gradeSum;
        System.out.println(String.format("%.6f", answer));
    }
}
