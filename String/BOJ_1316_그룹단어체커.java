import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1316_그룹단어체커 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < N; i++) {
            boolean[] alphabets = new boolean[26];
            char[] input = br.readLine().toCharArray();
            int curIndex = -1;
            int j;
            for (j = 0; j < input.length; j++) {
                int index = input[j] - 'a';

                if (index == curIndex && alphabets[index]) {
                    continue;
                } else if (alphabets[index]) {
                    break;
                }else {
                    alphabets[index] = true;
                }
                // 현재 인덱스 (같은 알파벳 끝날 때까지)
                curIndex = input[j] - 'a';
            }
            if (j == input.length) answer++;

        }
        System.out.println(answer);

    }
}
