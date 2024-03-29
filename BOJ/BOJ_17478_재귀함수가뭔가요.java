package BOJ;

import java.util.Scanner;

/**
 * 요구사항 : 재귀함수가 무엇인지에 대한 자동 응답 챗봇을 만들어라
 * 입력 : 출력을 원하는 재귀 횟수(1 <= N <= 50)
 */
public class BOJ_17478_재귀함수가뭔가요 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
        solve(0, "");
        System.out.println(sb.toString());
    }

    private static void solve(int cnt, String underBar) {

        if (cnt == N) {
            sb.append(underBar + "\"재귀함수가 뭔가요?\"\n");
            sb.append(underBar + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            sb.append(underBar + "라고 답변하였지.\n");
            return;
        }

        sb.append(underBar + "\"재귀함수가 뭔가요?\"\n");
        sb.append(underBar + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
        sb.append(underBar + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
        sb.append(underBar + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");

        solve(cnt + 1, underBar + "____");
        sb.append(underBar + "라고 답변하였지.\n");

    }

}
