import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class BOJ_11047_동전0 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[] arrA = new int[N];
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(br.readLine());
        }

        int num = N - 1;
        while(true) {
            //더이상 나눌 수 없을 때 종료
            if (K < arrA[0])
                break;
            //가장 큰 단위부터, 나눴을 때 몫이 있으면 그 몫만큼을 필요한 동전 개수에 추가
            if(K / arrA[num] != 0) {
                answer += (K / arrA[num]);
                K %= arrA[num];
            }
            num--;
        }
        System.out.println(answer);
    }
}
