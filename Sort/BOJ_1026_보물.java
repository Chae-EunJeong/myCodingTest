import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1026_보물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arrA = new int[N];
        Integer[] arrB = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB, Collections.reverseOrder());

        int S = 0;

        for (int i = 0; i < N; i++) {
            S += arrA[i] * arrB[i];
        }

        System.out.println(S);

    }
}


